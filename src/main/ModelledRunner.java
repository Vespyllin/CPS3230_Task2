package main;

import java.io.IOException;

import java.util.Random;

import org.junit.Test;

import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import junit.framework.Assert;

public class ModelledRunner implements FsmModel{
	public enum ExecutorStates {
		STANDBY,
		SCRAPING,
		UPLOADING,
		LOGGINGIN,
		VIEWING,
		LOGGINGOUT
	}
	
	private ApiHandler apiHandler = new ApiHandler();
	private EbayScraper ebayScraper = new EbayScraper();
	private Executor sut1 = new Executor(ebayScraper, apiHandler);
	private MarketAlertNavigator sut2 = new MarketAlertNavigator(); 
	
	private ExecutorStates modelState = ExecutorStates.STANDBY;
	private ItemData[] modelData = new ItemData[0];
	int alertsUp = 0;
	
	public ExecutorStates getState() {
		return modelState;
	}
	
	public void reset(final boolean var1) {
		System.out.println("RESET");
		if (var1) {
			apiHandler = new ApiHandler();
			ebayScraper = new EbayScraper();			
			sut1 = new Executor(ebayScraper, apiHandler);
			sut2 = new MarketAlertNavigator();
		}
		
		sut2.teardown();
		try {
			apiHandler.purgeAlerts();
		} catch (IOException e) {
			e.printStackTrace();
		}
		alertsUp = 0;
		modelState = ExecutorStates.STANDBY;
	}
	
	public boolean scrapeGuard() {
		return getState().equals(ExecutorStates.STANDBY);
	}
	public @Action void scrape(){
		System.out.println("SCRAPE");
		sut1.scrape();
		
		modelState = ExecutorStates.SCRAPING;
		modelData = new ItemData[5];
		
		Assert.assertEquals("Scraper did not return the 5 results as expected by the model", modelData.length, sut1.getResults().length);
	}
	
	public boolean uploadGuard() {
		return getState().equals(ExecutorStates.SCRAPING);
	}
	public @Action void upload(){
		System.out.println("UPLOAD");
		try {
			sut1.uploadResults();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		modelState = ExecutorStates.UPLOADING;
		
		alertsUp += 5;
		alertsUp = alertsUp > 50? 50: alertsUp; 
		
		EventTrace[] traces = apiHandler.getTraces(); 
		
		Assert.assertTrue("Traces are empty after uploading results", traces.length != 0);
		Assert.assertTrue("There are no results to upload.", modelData.length != 0);
		Assert.assertEquals("API handler did not upload 5 alerts as expected by the model", alertsUp, traces[traces.length-1].systemState.alerts.length);
	}
	
	public boolean loginGuard() {
		return getState().equals(ExecutorStates.UPLOADING);
	}
	public @Action void login(){
		System.out.println("LOGIN");
		
		modelState = ExecutorStates.LOGGINGIN;
		
		sut2.goToSite();
		sut2.logInValid();
		
		EventTrace[] traces = apiHandler.getTraces(); 
		
		int offset = 1 + (traces.length == 2? 1:0);
			
		Assert.assertEquals("User did not log in", 5, traces[traces.length-offset].eventLogType);
		Assert.assertTrue("User is not logged in", traces[traces.length-offset].systemState.loggedIn);
		
	}
	
	public boolean viewGuard() {
		return getState().equals(ExecutorStates.LOGGINGIN);
	}
	public @Action void view(){
		System.out.println("VIEWING ALERTS");
		
		modelState = ExecutorStates.VIEWING;
		
		sut2.goToAlerts();
		
		EventTrace[] traces = apiHandler.getTraces(); 
		
		Assert.assertEquals("User not on alerts page", 7, traces[traces.length-1].eventLogType);
	}
	
	public boolean logoutGuard() {
		return getState().equals(ExecutorStates.VIEWING);
	}
	public @Action void logout(){
		System.out.println("LOG OUT");
		
		modelState = ExecutorStates.LOGGINGOUT;
		
		sut2.logout();

		EventTrace[] traces = apiHandler.getTraces(); 
		
		Assert.assertFalse("User did not log out (no traces)", traces.length == 0);
		Assert.assertEquals("User did not log out ( event: " + traces[traces.length-1].eventLogType + ")", 6, traces[traces.length-1].eventLogType);
		Assert.assertFalse("User is not logged out", traces[traces.length-1].systemState.loggedIn);
	}
	
	public boolean teardownGuard() {
		return getState().equals(ExecutorStates.LOGGINGOUT);
	}
	public @Action void teardown(){
		System.out.println("TEARDOWN");
		sut2.teardown();
		try {
			sut1.cleanAlerts();
		} catch (Exception e) {
			System.out.println("FAILED TEARDOWN");
		}
		
		modelState = ExecutorStates.STANDBY;
		alertsUp = 0;
		
		EventTrace[] traces = apiHandler.getTraces(); 
		
		Assert.assertTrue("Traces are empty after purging alerts", traces.length != 0);
		Assert.assertEquals("API handler did not erase alerts as expected by the model", alertsUp, traces[traces.length-1].systemState.alerts.length);
	}
	
	@Test
	public void ModelRunner() {
		final GreedyTester tester = new GreedyTester(new ModelledRunner());
		
		tester.setRandom(new Random()); 
		tester.buildGraph(); 
		tester.addListener(new StopOnFailureListener()); 
		tester.addListener("verbose"); 
		tester.addCoverageMetric(new TransitionPairCoverage()); 
		tester.addCoverageMetric(new StateCoverage()); 
		tester.addCoverageMetric(new ActionCoverage()); 
		tester.generate(12);
		tester.printCoverage(); 
	}
}
