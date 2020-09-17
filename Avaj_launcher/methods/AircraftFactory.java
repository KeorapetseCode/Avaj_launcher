package methods;
import classes.Coordinates;
import classes.Helicopter;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates();
        Flyable flyable = null;

        coordinates.coordinates(longitude, latitude, height);
        if (type.charAt(1) == 'H'){
            type = type + " " + name;
            flyable = new Helicopter(type, coordinates);
            return flyable;
        }
        else{
            System.out.println("Invalid ID ");
            System.exit(0);
        }
        return flyable;
    }
}
