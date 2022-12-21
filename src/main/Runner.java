package main;

import java.time.Duration;
import java.util.Random;
import java.io.IOException;

import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Runner {
	
	public void badLogin() {
		System.out.println("Bad login at: " + System.currentTimeMillis());
	}
	
	public void goodLogin() {
		System.out.println("Good login at: " + System.currentTimeMillis());
	}

	public void run(final Account account) {
		final Random rand = new Random();
		while(true){
			final int randomNumber = rand.nextInt(10);
			
			if (randomNumber < 7){
				this.badLogin();
				account.setBadLogins(account.getBadLogins() + 1);
				if(account.getBadLogins() >= 3){
					account.setLocked(true);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					account.setBadLogins(0);
					account.setLocked(false);
				}
			} else {
				this.goodLogin();
				account.setBadLogins(0);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	
	
	public static void main(String[] args) {
		final Runner m = new Runner();
//		final Account account = m.new Account(false, 0);
//		m.run(account);
		
		System.setProperty("webdriver.chrome.driver", "C://Users//Mystech//Desktop//chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.youtube.com/");  
		driver.manage().window().maximize();  

        try{
        	
        	Thread.sleep(10000);
        } catch (Exception e) {
        	System.out.println("GARBAGE");
        }
        
        
		
//		System.out.println("BEFORE");
//		final ApiHandler a = m.new ApiHandler();
//		System.out.println("INIT");
//		try{
//			System.out.println(a.purgeAlerts());
//		} catch (Exception e) {
//			System.out.println("CRASH");
//		}
	}
	
	public class ApiHandler {
	    private final String apiUrl = "https://api.marketalertum.com/Alert";
	    private final String uniqueId = "51b41f93-16e7-4def-b348-lc97b0d6a8b25";
	    String lastResponse;

	    public String purgeAlerts() throws IOException {

	        CloseableHttpClient client = HttpClients.createDefault();
	        HttpGet httpGet = new HttpGet("https://dummyjson.com/products/1");

	        try {
	            CloseableHttpResponse response = client.execute(httpGet);
	            client.close();

	            return "" + response.getCode();
//	            return (response.getStatusLine().getStatusCode() == 200);
	        } catch (Exception e) {
	            client.close();
	            return "";
	        }

	    }
	}
	
	public class Account{
		private boolean locked;
		private Integer badLogins;
		
		public Account(final boolean locked, final Integer badLogins) {
			super();
			this.locked = locked;
			this.badLogins = badLogins;
		}

		public boolean isLocked() {
			return locked;
		}

		public void setLocked(boolean locked) {
			if(locked){
				System.out.println("Account locked!");
			} else {
				System.out.println("Account unlocked!");
			}
			this.locked = locked;
		}

		public Integer getBadLogins() {
			return badLogins;
		}

		public void setBadLogins(Integer badLogins) {
			this.badLogins = badLogins;
		}
	}
}
