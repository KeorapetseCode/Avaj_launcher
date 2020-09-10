import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Integer;
import methods.Simulator;

//import java.util.Inte

//import classes.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("No input file");
        }
        else if (args.length == 1){
            try{
                File src = new File(args[0]);
                Scanner myReader = new Scanner(src);
                try{
                    Simulator.loop = Integer.parseInt(myReader.nextLine());
                }
                catch (Exception n){
                    System.out.println("The first line of scenario is not a number");
                }
                if (Simulator.fileValid(myReader) == false) {
                    System.out.println("Invalid File Format");
                    myReader.close();
                    System.exit(0);
                }
                else {
                    
                    //Simulator.makeVehicles(myReader);
                }
            }
            catch(FileNotFoundException err){
                System.out.println("An Error Occured!");
                err.printStackTrace();
            }
            //System.out.println();
            
        }
    }
}