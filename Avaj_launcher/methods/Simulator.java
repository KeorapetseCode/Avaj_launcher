package methods;
import classes.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.System;
import java.util.List;
import java.util.Iterator;

public class Simulator {
    public static int loop;
    public static List<String> vehiclesID = new ArrayList<String>();
    public static String[] vehicleTypes = {"Baloon", "Helicopter", "JetPlane"};

    public static void makeVehicles(Scanner input) {
        while (input.hasNext()) {
            System.out.println(input.nextLine());
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
        System.out.println("Array Ends");
        while (a < len) {
            System.out.println(Simulator.vehiclesID.get(a));
            a++;
        }
        //String line = id.get(2);
        return true;
    }

    public static Boolean fileValid(Scanner input) {
        //String[] vehicleType;
        List<String> id_s = new ArrayList<String>();
        String[] data = null;
        String[] coord_height = null;
        String line = null;
        int i = 0;

        while (input.hasNext()) {
            line = input.nextLine();
            data = line.split(" ", 3);

           if (Simulator.checkName(data[0], Simulator.vehicleTypes) == false){
               System.out.println("Invalid Transport " + data[0]);
               return false;
           }
           id_s.add(data[1]);
        }
        if (Simulator.checkIdRepl(id_s) == false){
            System.out.println("There is ID replication");
             return false;
        }
        return true;
    }
}