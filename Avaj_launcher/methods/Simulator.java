package methods;
import classes.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.System;
import java.util.List;

public class Simulator {
    public static int loop;
    public static String[] vehiclesID;
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

    public static Boolean checkIdRepl(List<?> id){
        int i = 0;
        int a = 0;
        int res = 0;
        while (id.get(i)) {
            
        }
        //String line = id.get(2);

        return false;
    }

    public static Boolean fileValid(Scanner input) {
        //String[] vehicleType;
        List<String> id_s = new ArrayList<String>();
        String[] data = null;
        String[] coord_height;
        String line = null;
        int i = 0;

        while (input.hasNext()) {
            line = input.nextLine();
            data = line.split(" ", 3);

           if (Simulator.checkName(data[0], Simulator.vehicleTypes) == false){
               System.out.println("Invalid Transport " + data[0]);
               return false;
           }
           else {
               id_s.add(data[1]);
               if (Simulator.checkIdRepl(id_s)){
                   System.out.println("There is ID replication");
                    return false;
                }
               i++;

           }
            //break ;
        }
        System.out.println("Printing ID's");
        for (int a = 0; a < i; a++) {
            System.out.println(id_s.get(a));
        }
        return true;
    }
}