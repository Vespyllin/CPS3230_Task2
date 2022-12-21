package main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayScraper {
	 	public WebDriver driver;

	    private final int maxAlertCount = 5;

	    private final String ebayUrl = "https://www.ebay.com/";

	    public EbayScraper() {
	        System.setProperty("webdriver.chrome.driver", "C://Users//Mystech//Desktop//chromedriver.exe");

	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.manage().window().maximize();
	    }

	    public boolean loadEbay() {
	        try {
	            driver.get(ebayUrl);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public void quit() {
	        driver.quit();
	    }

	    public boolean lookupTerm() {
	        try {
	            WebElement searchField = driver.findElement(By.name("_nkw"));
	            WebElement searchButton = driver.findElement(By.id("gh-btn"));

	            searchField.sendKeys("laptop");
	            searchButton.submit();
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public boolean setFilters() {
	        final String conditionXPath = "//div[@id='x-refine__group__2']/ul[@class='x-refine__main__value']/li[@class='x-refine__main__list--value']/div/a/div/span/input | //div[@id='x-refine__group__3']/ul[@class='x-refine__main__value']/li[@class='x-refine__main__list--value']/div/a/div/span/input";
	        final String buyingFormatXPath = "//div[@id='x-refine__group__4']/ul[@class='x-refine__main__value']/li[@class='x-refine__main__list--value'][4]/div/a/div/span/input";

	        try {
	            // Condition dropdown under x-refine__group__2 or 3 randomly
	            WebElement condition = driver.findElement(By.xpath(conditionXPath));

	            // Reload page with updated results
	            condition.click();

	            // Find buying format dropdown
	            WebElement buyingFormat = driver.findElement(By.xpath(buyingFormatXPath));

	            // Reload page with updated results
	            buyingFormat.click();
	            return true;
	        } catch (Exception e) {
	            // In case elements are not found
	            return false;
	        }
	    }

	    public boolean setup() {
	        if (!loadEbay() || !lookupTerm() || !setFilters())
	            return false;

	        return true;
	    }

	    private ItemData formatItemData(WebElement item) {
	        final String itemWrapperClass = "s-item__wrapper";
	        final String nonAsciiRegex = "[^\\x00-\\x7F]";
	        final String escapedQuote = "\\\\\""; // I love RegEx :)

	        String itemImageUrl = item.findElement(By.className(itemWrapperClass))
	                .findElement(By.className("s-item__image-section"))
	                .findElement(By.className("s-item__image"))
	                .findElement(By.className("s-item__image-wrapper"))
	                .findElement(By.tagName("img"))
	                .getAttribute("src")
	                .toString();

	        WebElement itemInfo = item
	                .findElement(By.className(itemWrapperClass))
	                .findElement(By.className("s-item__info"));

	        WebElement itemTitleAndUrl = itemInfo.findElement(By.className("s-item__link"));
	        String itemUrl = itemTitleAndUrl
	                .getAttribute("href")
	                .toString();
	        String itemTitle = itemTitleAndUrl
	                .getText()
	                .replaceFirst("\nOpens in a new window or tab", "")
	                .replaceAll(nonAsciiRegex, "")
	                .replaceAll("\"", escapedQuote);

	        String itemDescription = itemInfo
	                .findElement(By.className("s-item__subtitle"))
	                .getText()
	                .replaceAll(nonAsciiRegex, "")
	                .replaceAll("\"", escapedQuote);

	        String price = itemInfo
	                .findElement(By.className("s-item__details"))
	                .findElements(By.className("s-item__detail"))
	                .get(0)
	                .findElement(By.className("s-item__price"))
	                .getText();

	        // Remove initial currency symbol
	        // then remove the comma-separated whole currency amount
	        // then do the same for the decimal point
	        int priceInCents = Integer.parseInt(price
	                .substring(1)
	                .replaceAll(" to (.+)", "")
	                .replaceAll("[,]", "")
	                .replaceAll("[.]", ""));

	        return new ItemData(itemTitle, itemDescription, itemUrl, itemImageUrl, priceInCents);
	    }

	    public ItemData[] getResults() {

	        String itemClass = "s-item__pl-on-bottom";
	        List<WebElement> items = driver.findElements(By.className(itemClass));
	        items.remove(0); // 1st element is not an item

	        ItemData[] returnData = new ItemData[maxAlertCount];
	        for (int i = 0; i < maxAlertCount; i++)
	            returnData[i] = formatItemData(items.get(i));

	        return returnData;
	    }

}
