package methods;

//import methods.Tower;
//import classes.Aircrafts;
//import methods.Simulator;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Iterator;

public class LogOutput{

    public static String msgReg(String planeName, String planeID) {
        String ret = null;
        ret = "Tower Says: " + planeName + "#" + planeID + " has registered to the weather tower" + "\n";
        return ret;
    }
    public static String msgUnReg(String planeName, String planeID) {
        String ret = null;
        ret = "Tower Says: " + planeName + planeID + "is landing";
        return ret;
    }

    public static void txtOutput(Tower towerObj) {
        Iterator<String> namePlane = Simulator.vehicleNames.iterator();
        Iterator<String> idPlane = Simulator.vehiclesID.iterator();
    //    Flyable flyObj;
        
        try{
            FileWriter msgFile = new FileWriter("simulation.txt");
            while (namePlane.hasNext()) {
                msgFile.write(msgReg(namePlane.next(), idPlane.next()));
            }/*
            while (Simulator.loop > 0) {
                towerObj.
                Simulator.loop--;
            }*/
            msgFile.close();
        }
        catch(IOException err) {
            System.out.println("Cannot create simulation file");
            err.printStackTrace();
        }
    }
    
}