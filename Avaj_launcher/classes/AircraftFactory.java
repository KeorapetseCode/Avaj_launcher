package classes;
//import classes.Coordinates;
import methods.Flyable;
//import classes.Helicopter;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates();
        Flyable flyable = null;

        coordinates.coordinates(longitude, latitude, height);
        if (type.equals("Helicopter")){
            flyable = new Helicopter(name, coordinates);
            return flyable;
        }
        return flyable;
    }
}
