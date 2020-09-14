import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Integer;
import methods.Simulator;
import classes.Tower;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("Invalid input file");
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
                    Simulator.startSim();
                    //System.out.println("Showing all registered Aircrafts\n " + Tower.observers);
                    myReader.close();
                }
            }
            catch(FileNotFoundException err){
                System.out.println("An Error Occured!");
                err.printStackTrace();
            }
        }
    }
}