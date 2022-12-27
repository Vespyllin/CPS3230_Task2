package main;

public class MonitoredRunner {
	public static void main(String[] args) {
		final ApiHandler handler = new ApiHandler();
		final EbayScraper scraper = new EbayScraper();
		final Executor ex = new Executor(scraper, handler);
		final MarketAlertNavigator navigator = new MarketAlertNavigator();
	

		try{
			ex.scrape();
			ex.uploadResults();
			
			navigator.goToSite();
			navigator.logInValid();
			navigator.goToAlerts();
			navigator.logout();
			
	    } catch (Exception e) {
	    	System.out.println("CRASHED");
	    } finally {	    	
	    	navigator.teardown();
	    	try{	    		
	    		ex.cleanAlerts();
	    	} catch (Exception e) {
	    		System.out.println("failed to purge alerts");
	    	}
	    }
		
	}
}
