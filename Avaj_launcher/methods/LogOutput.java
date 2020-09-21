package methods;

import java.util.List;
import java.util.ArrayList;

public class LogOutput{
    public static List<String> logMesg = new ArrayList<String>();

    public static String msgReg(String planeName, String planeID) {
        String ret = null;
        ret = "Tower Says: " + planeName + "#" + planeID + " has registered to the weather tower" + "\n";
        return ret;
    }
    public static String msgUnReg(String planeName, String planeID) {
        String ret = null;
        ret = "Tower Says: " + planeName + planeID + " is unregistering" + "\n";
        return ret;
    }
}