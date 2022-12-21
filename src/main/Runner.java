package main;

public class Runner {
	public static void main(String[] args) {
		final API_Handler handler = new API_Handler();
		final EbayScraper scraper = new EbayScraper();
		final Executor ex = new Executor(scraper, handler);
		
		try{
			ex.scrape();
			ex.uploadResults();
	    } catch (Exception e) {
	    	System.out.println("GARBAGE");
	    }
	}
}
