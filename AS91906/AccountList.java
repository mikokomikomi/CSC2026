import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
/**
 * Class which reads and writes the bank accounts to the 
 *
 * @author Miko Peszynski
 * @version V1 - 19/03/2026
 */
public class AccountList
{
    private ArrayList <BankAccount> bankAccountArray = new ArrayList <BankAccount>();
    public AccountList(boolean reading){
        try {
            File myFile = new File ("myDiskCollection.csv");//open file
            Scanner myReader = new Scanner(myFile);

            while(myReader.hasNextLine()){
                String line = myReader.nextLine();
                String[] tempAccount = line.split(",");              
                bankAccountArray.add(new BankAccount(tempAccount[0],tempAccount[1],tempAccount[2],tempAccount[3],Double.parseDouble(tempAccount[4])));
            }

        } catch(IOException e){
            System.out.println("Error: could not read from file");
        }
    }
}
