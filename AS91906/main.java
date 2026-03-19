import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Has the main class and Handles user input and the User Interface
 *
 * @author Miko Peszynski
 * @version V2 - 20/03/2026
 */
public class main
{
    private Scanner keyboard = new Scanner(System.in);
    AccountLibrary myAccountLibrary = new AccountLibrary(true);
    public main(){
        System.out.println("You are Creating an Account");
        System.out.println("What is the Customer's name?");
        String tempName = keyboard.nextLine();
        System.out.println("What is the Account's Account Number?");
        String tempAccountNumber = keyboard.nextLine();
        System.out.println("What is the Customer's address");
        String tempAddress = keyboard.nextLine();
        System.out.println("What type of account is it (EveryDay, Savings, or Current)?");
        String tempAccountType = keyboard.nextLine();
        System.out.println("What is the account's current balance?");
        double tempBalance = keyboard.nextDouble();
        keyboard.nextLine();

        BankAccount tempAccount = new BankAccount(tempName,tempAccountNumber,tempAddress,tempAccountType,tempBalance);
        myAccountLibrary.addAccount(tempAccount);
        myAccountLibrary.displayAll(); 
    }
}
