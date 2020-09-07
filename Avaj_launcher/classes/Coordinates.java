package classes;

public class Coordinates {
    private int longitude;
    private int altitude;
    private int height;
    
    public Coordinates(int longitude, int altitude, int height) {
        this.longitude = longitude;
        this.altitude = altitude;
        this.height = height;
    }
    
    public int getLongitude() {
        return this.longitude;   
    }
    public int getAltitude() {
        return this.altitude;
    }

    public int getHeight() {
        return this.height;   
    }
}