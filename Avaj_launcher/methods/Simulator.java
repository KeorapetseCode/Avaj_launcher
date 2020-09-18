package methods;

import java.lang.Character;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.System;
import java.util.List;
import java.util.Iterator;
import java.lang.Integer;
import java.io.FileWriter;
import java.io.IOException;

public class Simulator {
    public static int loop;//This is how many times the iteration of the entire program is gonna run.
    public static List<String> vehiclesID = new ArrayList<String>();
    public static List<String> vehicleNames = new ArrayList<String>();
    public static List<String> vehicleCoord = new ArrayList<String>();
    public static Flyable unReg = null;

    public static String[] vehicleTypes = {"Baloon", "Helicopter", "JetPlane"};

    public static void startSim() {
        Flyable vehicleObj = null;
        int i = 0;
        String line = null;
        String name = null;
        String id_s = null;
        String[] coords;
        Iterator<String> objNames = Simulator.vehicleNames.iterator();
        Iterator<String> objIDs = Simulator.vehiclesID.iterator();
        WeatherTower objCoords = new WeatherTower();
        Tower mainObj = new Tower();

        while (objNames.hasNext()) {

            line = Simulator.vehicleCoord.get(i);
            coords = line.split(" ", 3);
            name = objNames.next();
            id_s = objIDs.next();
    
            if (Integer.parseInt(coords[2]) > 0){ //Height of an aircraft has to be greater than 0 for an aircraft to be considered
                if (name.equals("Helicopter")){
                    name = "#" + id_s;
                    id_s = Integer.toString(i+1);
                }
                else if (name.equals("JetPlane")){
                    name = "#" + id_s;
                    id_s = Integer.toString(i+1);
                }
                else if (name.equals("Baloon")){
                    name = "#" + id_s;
                    id_s = Integer.toString(i+1);
                }
                vehicleObj = AircraftFactory.newAircraft(name, id_s, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2]));
                vehicleObj.registerTower(objCoords); //Cant tell where objCoords ends up
                mainObj.register(vehicleObj);
            }
            else {
                Simulator.vehicleNames.remove(name);
                Simulator.vehiclesID.remove(id_s);
                Simulator.vehicleCoord.remove(line);
            }
            i++;
        }        
        Iterator<String> namePlane = Simulator.vehicleNames.iterator();
        Iterator<String> idPlane = Simulator.vehiclesID.iterator();

        try{
            FileWriter msgFile = new FileWriter("simulation.txt");
            while (namePlane.hasNext()) {
                msgFile.write(LogOutput.msgReg(namePlane.next(), idPlane.next()));
            }
            
            while (Simulator.loop > 0) {
                mainObj.conditionsChange();
                Simulator.loop--;
            }
            //System.out.println("After 2nd loop");
            Iterator<String> strOut = LogOutput.logMesg.iterator();
            while (strOut.hasNext()) {
                msgFile.write(strOut.next());
            }
            msgFile.close();
        }
        catch(IOException err) {
            System.out.println("Cannot create simulation file");
            err.printStackTrace();
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
            data = line.split(" ", 5);
            if (data.length != 5){
                System.out.println("There's an Erorr with the input file");
                //System.out.println("length is " + data.length);
                System.out.println("0 " + data[0] + " 1 " + data[1] + " 2 " + data[2] + " 3 " + data[3] + " 4 " + data[4] + " \n");
                return false;
            }   
            System.out.println("0 " + data[0] + " 1 " + data[1] + " 2 " + data[2] + " 3 " + data[3] + " 4 " + data[4] + " \n");
            int a = 0;
            while (a < data[1].length()){
                if (data[1].charAt(a) == ' '){
                    System.out.println("Invalid ID");
                    return false;
                }
                a++;
            }
            if (data[1].length() < 2){
                System.out.println("Invalid ID");
                return false;
            }

            int i = 2;
            a = 0;
            while (i < 5) {
                while (a < data[i].length()) {
                    Boolean flag = Character.isDigit(data[i].charAt(a));
                    if (flag){
                        a++;
                    }
                    else{
                        System.out.println("Input Not a Number");
                        return false;
                    }
                }
                if (data[i].length() == 0){
                    System.out.println("Input Not a Number");
                    return false;
                }
                a = 0;
                i++;
            }
           if (Simulator.checkName(data[0], Simulator.vehicleTypes) == false){
               System.out.println("Invalid Transport " + data[0]);
               return false;
           }
           Simulator.vehicleNames.add(data[0]); //Directly Adding to Global variable
           Simulator.vehicleCoord.add(data[2] + " " + data[3] + " " + data[4]); //Directly Adding to Global variable
           id_s.add(data[1]);
        }
        if (Simulator.checkIdRepl(id_s) == false){
            System.out.println("There is an ID duplicate");
             return false;
        }
        return true;
    }
}