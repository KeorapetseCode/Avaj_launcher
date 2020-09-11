package methods;
import classes.Tower;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.System;
import java.util.List;
import java.util.Iterator;
import java.lang.Integer;
import classes.AircraftFactory;

public class Simulator {
    public static int loop;//This is how many times the iteration of the entire program is gonna run.
    public static List<String> vehiclesID = new ArrayList<String>();
    public static List<String> vehicleNames = new ArrayList<String>();
    public static List<String> vehicleCoord = new ArrayList<String>();
    public static String[] vehicleTypes = {"Baloon", "Helicopter", "JetPlane"};

    public static void startSim() {
        //AircraftFactory vehicleObj = new AircraftFactory();
        Flyable vehicleObj;
        int i = 0;
        String line = null;
        String name = null;
        String id_s = null;
        String[] coords;
        Iterator<String> objNames = Simulator.vehicleNames.iterator();
        Iterator<String> objIDs = Simulator.vehiclesID.iterator();

        while (objNames.hasNext()) {

            line = Simulator.vehicleCoord.get(i);
            coords = line.split(" ", 1);
            name = objNames.next();
            id_s = objIDs.next();
            System.out.println("Before Execution\n" + coords[0]);
            //vehicleObj = AircraftFactory.newAircraft(name, id_s, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2]));
            System.out.println("\nIt's looping " + i);
            i++;
        }
    }

    public static Boolean checkName(String data, String[] vehicleType) {
        if (data.equals(vehicleType[0]) || data.equals(vehicleType[1]) || data.equals(vehicleType[2])) {
            return true;
        }
        return false;
    }

    public static Boolean checkIdRepl(List<String> id){
        Iterator<String> ite = id.iterator();
        int len = 0;
        int a = 0;

        while (ite.hasNext()) {
            Simulator.vehiclesID.add(ite.next());
            len++;
        }
        int b = 0;
        int i = 0;
        String temp = null;
        while (a < len) {
            temp = Simulator.vehiclesID.get(a);
            while (b < len) {
                if (temp.equals(Simulator.vehiclesID.get(b))) {
                    i++;
                }
                b++;
            }
            if (i > 1) {
                return false;
            }
            b = 0;
            i = 0;
            a++;
        }
        return true;
    }

    public static Boolean fileValid(Scanner input) {
        List<String> id_s = new ArrayList<String>();
        String[] data = null;
        String line = null;

        while (input.hasNext()) {
            line = input.nextLine();
            data = line.split(" ", 3);

           if (Simulator.checkName(data[0], Simulator.vehicleTypes) == false){
               System.out.println("Invalid Transport " + data[0]);
               return false;
           }
           Simulator.vehicleNames.add(data[0]); //Directly Adding to Global variable
           Simulator.vehicleCoord.add(data[2]); //Directly Adding to Global variable
           id_s.add(data[1]);
        }
        if (Simulator.checkIdRepl(id_s) == false){
            System.out.println("There is an ID duplicate");
             return false;
        }
        return true;
    }
}