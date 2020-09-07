package classes;
import methods.Flyable;
import methods.WeatherTower;

public class Helicopter extends Aircrafts implements Flyable{
    protected void helicopter(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }
    public void updateConditions() {

    }
    public void registerTower(WeatherTower weatherTower) {
        
    }
}