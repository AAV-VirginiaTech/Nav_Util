package sample;

public class Product {
    private String label;
    private double lat;
    private int longitude;
    private int height;
    private String type;
    private String primary;
    public Product(){
        this.label = "";
        this.lat = 0;
        this.longitude = 0;
        this.height = 0;
        this.type = "";
        this.primary = "";

    }
    public Product(String label, double lat, int longitude) {
        this.label = label;
        this.lat = lat;
        this.longitude = longitude;
        this.height = height;
        this.type = type;
        this.primary = primary;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public int getLongitude() {
        return longitude;
    }
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setHeight(int height) { this.height = height;}

    public void setType(String type) {this.type = type;}

    public void setPrimary(String primary) { this.primary = primary;}
    }

