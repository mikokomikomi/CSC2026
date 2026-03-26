import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
/**
 * Class which reads and writes the bank accounts to the 
 *
 * @author Miko Peszynski
 * @version V3 - 23/03/2026
 */
public class AccountLibrary
{
    private ArrayList <BankAccount> bankAccountLibrary = new ArrayList <BankAccount>();
    public AccountLibrary(boolean reading){
        try {
            File myFile = new File ("accounts.txt");//open file
            Scanner myReader = new Scanner(myFile);

            while(myReader.hasNextLine()){
                String line = myReader.nextLine();
                String[] tempAccount = line.split(",");              
                bankAccountLibrary.add(new BankAccount(tempAccount[0],tempAccount[1],tempAccount[2],tempAccount[3],Double.parseDouble(tempAccount[4])));
            }

        } catch(IOException e){
            System.out.println("Error: could not read from file");
        }
    }

    public void writeLibrary(){
        File myFile = new File("accounts.txt");

        try {
            FileWriter myWriter = new FileWriter(myFile);
            for (BankAccount newAccount : this.bankAccountLibrary){
                myWriter.write(newAccount.getAll()+"\n");
            }
            myWriter.flush();
            myWriter.close();
        }catch(IOException e){
            System.out.println("Error: could not write to file");
        }
    }

    /*
     * This method deletes an account to the library
     */
    public void addAccount(BankAccount newAccount){
        bankAccountLibrary.add(newAccount);
    }

    /*
     * This method adds an account to the library
     */
    public void deleteAccount(int currentAccount){
        bankAccountLibrary.remove(currentAccount);
    }

    /*
     * This method prints every account's Customer name and Account number along with their referall number
     */
    public void displayAll(){
        int numberLabel = 0;
        for (BankAccount currentAccount : bankAccountLibrary){
            numberLabel += 1;
            System.out.println(numberLabel+". "+currentAccount.getName()+" - "+currentAccount.getAccountNumber());
        }
    }

    /*
     * This method prints the total amount of money in the online bank - used when ending by typing 7
     */
    public void displayTotalMoney(){
        int totalMoney = 0;
        for (BankAccount currentAccount : bankAccountLibrary){
            totalMoney += currentAccount.getBalance();

        }
        System.out.println(totalMoney);
    }

    /*
     * This method prints a specific account's balance dictated by the user - used when getting account balance when typing 4, 5, or 6 
     */
    public void viewAccountBalance(int whichAccount){
        System.out.println("This account's balance is $" + bankAccountLibrary.get(whichAccount).getBalance());//

    }

    /*
     * This method changes a specific account's balance both the amount and which acount 
     *  dictated by the user - used when depositing and withdrawing money from an account by typing 5 and 6 respectively 
     */
    public void changeAccountBalance(int whichAccount, double amountChange,boolean depositing){
        double newBalance = bankAccountLibrary.get(whichAccount).getBalance(); 
        if (depositing == true){//if statement controlling whether you are depositing or withdrawing money
            newBalance += amountChange;
        }else{
            newBalance -= amountChange;
        }
        System.out.println("This account's balance is $" + bankAccountLibrary.get(whichAccount).setBalance(newBalance));//Sets the new balance and prints it

    }
}
