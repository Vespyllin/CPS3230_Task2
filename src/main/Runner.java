package main;

public class Runner {
	public static void main(String[] args) {
		final ApiHandler handler = new ApiHandler();
		final EbayScraper scraper = new EbayScraper();
		final Executor ex = new Executor(scraper, handler);
		
		try{
			ex.scrape();
			ex.uploadResults();
			ex.cleanAlerts();
	    } catch (Exception e) {
	    	System.out.println("GARBAGE");
	    }
	}
}
