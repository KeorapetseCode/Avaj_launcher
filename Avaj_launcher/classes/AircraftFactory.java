package classes;
import classes.Coordinates;
import methods.Flyable;
import classes.Helicopter;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        Flyable flyable;
        if (type == "Helicopter"){
            //Helicopter objHeli = new Helicopter();
            flyable.helicopter(name, coordinates);
            
        }
        else{
            System.out.println("Vehicle not recognised");
        }
        return flyable;
    }
}
