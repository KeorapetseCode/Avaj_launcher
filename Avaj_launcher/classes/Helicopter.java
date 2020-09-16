package classes;
import methods.Flyable;
import methods.LogOutput;
import methods.WeatherTower;

public class Helicopter extends Aircrafts implements Flyable{

    private WeatherTower weatherObj;

    public Helicopter(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

//    @Override
    public void updateConditions() {
        //System.out.println("dsdfdsfsdf");
        String weather = weatherObj.getWeather(this.coordinates);
        int tempLong = this.coordinates.getLongitude();
        int tempLat = this.coordinates.getLatitude();
        int tempHeight = this.coordinates.getHeight();

        if (weather.equals("RAIN")) {
            tempLong += 5;
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
            LogOutput.logMesg.add("It is raining for the Heli " + this.id);
        }
        else if (weather.equals("FOG")) {
            tempLong += 1;
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
        }
        else if (weather.equals("SUN")) {
            tempLong += 10;
            tempHeight += 2;
            if (tempHeight > 100) {
                tempHeight = 100;
            }
            this.coordinates.coordinates(tempLong, tempLat, tempHeight);
        }
        else if (weather.equals("SNOW")) {
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