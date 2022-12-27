package main;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import com.google.gson.Gson;

public class ApiHandler {
	private final String apiUrl = "https://api.marketalertum.com";
    private final String uniqueId = "51b41f93-16e7-4def-b348-lc97b0d6a8b25";
    String lastResponse;
    
    
    public boolean postAlert(ItemData itemData, int alertType) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(apiUrl + "/Alert");

        String jsonString = "{" +
                "\"alertType\": " + alertType + "," +
                "\"heading\": \"" + itemData.getHeading() + "\"," +
                "\"description\": \"" + itemData.getDescription() + "\"," +
                "\"url\":\"" + itemData.getUrl() + "\"," +
                "\"imageUrl\" :\"" + itemData.getImageUrl() + "\"," +
                "\"postedBy\": \"" + uniqueId + "\"," +
                "\"priceInCents\": " + itemData.getPrice() +
                "}";

        try {
            httpPost.setEntity(new StringEntity(jsonString));
        } catch (Exception e) {
            System.out.println(jsonString); // Print invalid JSON before crashing
            throw e;
        }
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        try {
//            CloseableHttpResponse response = client.execute(httpPost);
//            return (response.getCode() == 201);
        	return true;
        } catch (Exception e) {
            System.out.println(jsonString);
            return false;
        } finally {
        	client.close();        	
        }

    }

    public boolean purgeAlerts() throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(apiUrl + "/Alert?userId=" + uniqueId);

        try {
            CloseableHttpResponse response = client.execute(httpDelete);
            return response.getCode() == 200;
        } catch (Exception e) {
            return false;
        } finally {
        	client.close();        	
        }

    }
    
    public EventTrace[] getTraces() {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl + "/EventsLog/" + uniqueId);
        
        EventTrace[] emptyTrace = new EventTrace[0];
        Gson gson = new Gson();
        
        
        try {
        	CloseableHttpResponse response = client.execute(httpGet);
            
            if(response.getCode() != 200) 
            	return emptyTrace;            
            
            return gson.fromJson(EntityUtils.toString(response.getEntity()), EventTrace[].class);
        } catch (Exception e) {
            return emptyTrace;
        } finally {
            try{
            	client.close();        	
            }
            catch(Exception e) {
            
            }
                
        }

    }
}
