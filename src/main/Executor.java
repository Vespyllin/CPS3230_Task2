package main;

import java.io.IOException;

public class Executor {
	 	private EbayScraper scraper;
	    private ApiHandler apiInterface;
	    private ItemData[] results;

	    public Executor(EbayScraper scraper, ApiHandler apiInterface) {
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

	    public boolean uploadResults() throws IOException {
	        for (ItemData result : results) {
	            if (!apiInterface.postAlert(result, AlertEnum.Electronics.ordinal())) return false;
	        }

	        return true;
	    }

	    public boolean cleanAlerts() throws IOException {
	        return apiInterface.purgeAlerts();
	    }
}
