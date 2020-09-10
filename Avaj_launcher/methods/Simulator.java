package methods;
import classes.*;
import java.util.Scanner;

public class Simulator {
    public static int loop;
    public String vehicles;
    public String[] vehiclesID;
    
    public static void makeVehicles(Scanner input) {
        while (input.hasNext()) {
            System.out.println(input.nextLine());
        }
    }

    public static Boolean fileValid(Scanner input) {
        
        return true;
    }
}