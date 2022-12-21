package main;

public class ItemData {
    private String heading;
    private String description;
    private String url;
    private String imageUrl;
    private int price;

    public ItemData(String heading, String description, String url, String imageUrl, int price) {
        this.heading = heading;
        this.description = description;
        this.url = url;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public String getHeading() {
        return heading;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }
}