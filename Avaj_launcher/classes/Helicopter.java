package classes;
import methods.Flyable;
import methods.WeatherTower;

public class Helicopter extends Aircrafts implements Flyable{

    private WeatherTower weatherObj;

    public void helicopter(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }
    public void updateConditions() {
        String weather = weatherObj.getWeather(this.coordinates);
        int tempLong = this.coordinates.getLongitude();
        int tempLat = this.coordinates.getLatitude();
        int tempHeight = this.coordinates.getHeight();

        if (weather == "RAIN") {
            tempLong += 5;
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
        }
        else if (weather == "FOG") {
            tempLong += 1;
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
        }
        else if (weather == "SUN") {
            tempLong += 10;
            tempHeight += 2;
            if (tempHeight > 100) {
                tempHeight = 100;
            }
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
        }
        else if (weather == "SNOW") {
            tempHeight -= 12;
            if (tempHeight < 1){
                tempHeight = 0;
            }
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
        }

    }
    public void registerTower(WeatherTower weatherObj) {
        this.weatherObj = weatherObj;
    }
}