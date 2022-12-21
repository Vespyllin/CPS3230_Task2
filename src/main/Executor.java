package main;

import java.io.IOException;

public class Executor {
	 	private EbayScraper scraper;
	    private API_Handler apiInterface;
	    private ItemData[] results;

	    public Executor(EbayScraper scraper, API_Handler apiInterface) {
	        this.scraper = scraper;
	        this.apiInterface = apiInterface;
	    }

	    public boolean scrape() {
	        if (!scraper.setup())
	            return false;

	        results = scraper.getResults();
	        
	        scraper.quit();

	        return true;
	    }

	    public ItemData[] getResults() {
	        return results;
	    }

	    public int uploadResults() throws IOException {
	        int validResponses = 0;
	        for (ItemData result : results) {
	            if (apiInterface.postAlert(result, AlertEnum.Electronics.ordinal())) {
	                validResponses++;
	            }
	        }

	        return validResponses;
	    }
}
