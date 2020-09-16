package methods;
import classes.Coordinates;
//import methods.Flyable;
import classes.Helicopter;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates();
        Flyable flyable = null;

        coordinates.coordinates(longitude, latitude, height);
        if (type.equals("Helicopter")){
            type = type + " " + name;
            //System.out.println("Type is " + type + "\n");
            flyable = new Helicopter(type, coordinates);
            
            return flyable;
        }
        return flyable;
    }
}
