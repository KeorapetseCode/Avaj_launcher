package methods;

import classes.Tower;
import classes.Aircrafts;
import methods.Simulator;
import java.io.FileWriter;
import java.io.IOException;

public class LogOutput{

    public static String msgReg(String planeName, String planeID) {
        String ret = null;
        ret = "Tower Says: " + planeName + planeID + "has registered to the weather tower";
        return ret;
    }
    public static String msgUnReg(String planeName, String planeID) {
        String ret = null;
        ret = "Tower Says: " + planeName + planeID + "is landing";
        return ret;
    }

    public static void txtOutput() {
        try{
            FileWriter msgFile = new FileWriter("simulation.txt");
        }
        catch(IOException err) {
            System.out.println("Cannot create simulation file");
            err.printStackTrace();
        }
        


    }
    
}