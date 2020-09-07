import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import classes.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Incorrect Inputs");
        }
        else if (args.length == 1){
            try{
                File src = new File(args[0]);
                Scanner myReader = new Scanner(src);
                myReader.close();
            }
            catch(FileNotFoundException err){
                System.out.println("An Error Occured!");
                err.printStackTrace();
            }
//          Program Contnues here if the input file is correct
            System.out.println("Program Continues");
            
        }
    }
}