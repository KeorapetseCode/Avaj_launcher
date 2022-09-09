import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Integer;
import methods.Simulator;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
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
                    System.out.println("The first line of scenario file is not a number");
                    myReader.close();
                    System.exit(0);
                }
                if (Simulator.loop <= 0){
                    System.out.println("Iteration Number Not Valid");
                    myReader.close();
                    System.exit(0);
                }
                if (Simulator.fileValid(myReader) == false) {
                    System.out.println("Invalid File Format");
                    myReader.close();
                    System.exit(0);
                }
                else {
                    Simulator.startSim();
                    myReader.close();
                }
            }
            catch(FileNotFoundException err){
                System.out.println("An Error Occured!" + "\n" + "Scenario File Error");
            }
        }
        else{
            System.out.println("Error Please Check Input File");
        }
    }
}