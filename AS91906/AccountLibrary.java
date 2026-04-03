import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
/**
 * Class which reads and writes the bank accounts to the 
 *
 * @author Miko Peszynski
 * @version V8 - 03/04/2026
 */
public class AccountLibrary
{
    private ArrayList <BankAccount> bankAccountLibrary = new ArrayList <BankAccount>();// creates the arraylist which holds all the accounts

    /*
     * reads the array from the file
     */
    public AccountLibrary(boolean reading){
        try {
            File myFile = new File ("accounts.txt");//opens file
            Scanner myReader = new Scanner(myFile);

            while(myReader.hasNextLine()){
                String line = myReader.nextLine();
                String[] tempAccount = line.split(";");              
                bankAccountLibrary.add(new BankAccount(tempAccount[0],tempAccount[1],tempAccount[2],tempAccount[3],Double.parseDouble(tempAccount[4])));
            }

        } catch(IOException e){
            System.out.println("Error: could not read from file");
        }
    }

    /*
     * writes the array to the file
     */
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
     * This method adds an account to the library
     */
    public void addAccount(BankAccount newAccount){
        bankAccountLibrary.add(newAccount);
    }

    /*
     * This method deletes an account from the library
     */
    public void deleteAccount(int currentAccount){
        bankAccountLibrary.remove(currentAccount);
    }

    /*
     * This method prints every account's Customer name, Account number and address along with their referall number, used when typing 1,3,4,5,6
     */
    public void displayAll(){
        int numberLabel = 0;
        for (BankAccount currentAccount : bankAccountLibrary){//for each loop prints the account's name, account number, and address
            numberLabel += 1;
            System.out.println(numberLabel+". "+currentAccount.getName()+" - "+currentAccount.getAccountNumber()+" - "+currentAccount.getAddress());
        }
    }

    /*
     * This method prints the total amount of money in the online bank - used when ending by typing 7
     */
    public void displayTotalMoney(){
        double totalMoney = 0;
        for (BankAccount currentAccount : bankAccountLibrary){
            totalMoney += currentAccount.getBalance();

        }
        System.out.format("%.3f",totalMoney);//Stops doubles from doing calculations strangely 
        System.out.println("");
    }

    /*
     * This method prints a specific account's balance dictated by the user - used when getting account balance when typing 4, 5, or 6 
     */
    public void viewAccountBalance(int whichAccount){
        System.out.println("This account's balance is $" + bankAccountLibrary.get(whichAccount).getBalance());//Gets and prints the accounts balance
        System.out.println("This account's Type is " + bankAccountLibrary.get(whichAccount).getAccountType());//Gets and prints the accounts type

    }

    /*
     * This method changes a specific account's balance both the amount and which acount 
     *  dictated by the user - used when depositing and withdrawing money from an account by typing 5 and 6 respectively 
     */
    public boolean changeAccountBalance(int whichAccount, double amountChange,boolean depositing){
        double newBalance = bankAccountLibrary.get(whichAccount).getBalance(); 
        boolean askAgain = false;
        final int CURRENTOVERDRAFTLIMIT = 1000;//The overdraft limit for accounts with the current type
        final int SAVINGSOVERDRAFTLIMIT = 0;//The overdraft limit for accounts with the savings type
        final int EVERYDAYOVERDRAFTLIMIT = 0;//The overdraft limit for accounts with the everyday type
        if (depositing == true){//if statement controlling whether you are depositing or withdrawing money
            newBalance += amountChange;
        }else{
            //Deals with overdraft limits for different types
            if (bankAccountLibrary.get(whichAccount).getAccountType().toLowerCase().equals( "savings") && newBalance - amountChange >= SAVINGSOVERDRAFTLIMIT){
                newBalance -= amountChange;

            } else if(bankAccountLibrary.get(whichAccount).getAccountType().toLowerCase().equals( "everyday") && newBalance - amountChange >= -EVERYDAYOVERDRAFTLIMIT){
                newBalance -= amountChange;

            }else if(bankAccountLibrary.get(whichAccount).getAccountType().toLowerCase().equals( "current") && newBalance - amountChange >= -CURRENTOVERDRAFTLIMIT){
                newBalance -= amountChange;

            }else {
                System.out.println("Sorry. You don't have enough to withdraw that amount.");
                askAgain = true;//asks again if the user tries to withdraw outside their overdraft limit
            }
        }
        System.out.println("This account's balance is $" + bankAccountLibrary.get(whichAccount).setBalance(newBalance));//Sets the new balance and prints it
        return askAgain;
    }

    public int amountOfAccount (){
        return bankAccountLibrary.size();
    }
}
