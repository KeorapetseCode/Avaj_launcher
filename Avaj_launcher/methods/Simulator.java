package methods;
import classes.Tower;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.System;
import java.util.List;
import java.util.Iterator;

public class Simulator {
    public static int loop;//This is how many times the iteration of the entire program is gonna run.
    public static List<String> vehiclesID = new ArrayList<String>();
    public static List<String> vehicleNames = new ArrayList<String>();
    public static List<String> vehicleCoord = new ArrayList<String>();
    public static String[] vehicleTypes = {"Baloon", "Helicopter", "JetPlane"};

    public static void startSim() {
        System.out.println("Coordinates List________");
        Iterator<String> coordLst = Simulator.vehicleCoord.iterator();
        Iterator<String> namList = Simulator.vehicleNames.iterator();
        Iterator<String> idList = Simulator.vehiclesID.iterator();
        while (coordLst.hasNext()) {
            System.out.println(coordLst.next());
        }
        System.out.println("Names List_________");
        while (namList.hasNext()) {
            System.out.println(namList.next());
        }
        System.out.println("ID List______________");
        while (idList.hasNext()) {
            System.out.println(idList.next());
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