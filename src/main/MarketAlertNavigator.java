package main;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MarketAlertNavigator {
    WebDriver driver;
    
    final String marketUrl = "https://www.marketalertum.com/";
    final String validUniqueId = "51b41f93-16e7-4def-b348-lc97b0d6a8b25";

    public MarketAlertNavigator() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Mystech//Desktop//chromedriver.exe");
    }

    public void teardown() {
        if (driver != null)
            driver.quit();
    }

    private void login(String uniqueID) {
        WebElement logInNav = driver.findElement(By.linkText("Log In"));
        logInNav.click();
        WebElement idField = driver.findElement(By.id("UserId"));
        idField.sendKeys(uniqueID);

        WebElement submitButton = driver
                .findElement(By.className("pb-3"))
                .findElements(By.tagName("input"))
                .get(1);

        submitButton.click();
    }

    public void goToSite() {
        driver = new ChromeDriver();
        driver.get(marketUrl);
    }

    public void logInValid() {
        login(validUniqueId);
    }

    public void logInInvalid() {
        login("BAD-USER-CREDENTIAL");
    }

    public void goToAlerts() {
//    	if (driver.getCurrentUrl() == marketUrl + "Alerts/List")
//    		return;
//    	    	
        WebElement alertsNav = driver.findElement(By.linkText("My Alerts"));
        alertsNav.click();
    }

    public void logout() {
        WebElement logOutButton = driver.findElement(By.linkText("Log Out"));
        logOutButton.click();
    }
}
