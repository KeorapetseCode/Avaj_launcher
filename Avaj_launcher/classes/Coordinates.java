package classes;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    
    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }
    
    public int getLongitude() {
        return this.longitude;   
    }
    public int getAltitude() {
        return this.latitude;
    }
    public int getHeight() {
        return this.height;   
    }
}