package main;

public class EventTrace {

    public class StateTrace{
        public String userId;
        public boolean loggedIn;
        public AlertTrace[] alerts;
    }

    public class AlertTrace{
    	public String heading;
    	public String description;
    	public String url;
    	public String imageUrl;
    	public int price;
    	public String postedDate;
    }


    public String id;
    public String timestamp;
    public int eventLogType;
    public String userId;
    public StateTrace systemState;
}