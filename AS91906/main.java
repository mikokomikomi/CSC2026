import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Has the main class which is where the program runs from and Handles user input and the User Interface
 *
 * @author Miko Peszynski
 * @version V3 - 23/03/2026
 */
public class main
{
    private Scanner keyboard = new Scanner(System.in);
    AccountLibrary myAccountLibrary = new AccountLibrary(true);
    public main(){
        boolean ongoing = true;
        /*
         * block of final ints for actions the user can do
         */
        final int PRINTACTION = 1; //Prints the library along with the reference number which the user needs when referencing a specific account
        final int CREATEACTION = 2;//Creates an account
        final int CLOSEACTION = 3;//Closes an account
        final int GETACTION = 4;//Gets the balance of an account
        final int DEPOSITACTION = 5;//Adds money to the account
        final int WITHDRAWACTION = 6;//Withdraws money to the account
        final int ENDACTION = 7;//ends the program

        /*
         * While loop 
         */
        while(ongoing){
            int action;
            action = keyboard.nextInt();
            System.out.println("What do you want to do?");
            System.out.println("-----");
            System.out.println("1 - Print the whole library");
            System.out.println("2 - Create an account");
            System.out.println("3 - Close an account");
            System.out.println("4 - Get an account's balance");
            System.out.println("5 - Deposit into an account");
            System.out.println("6 - Withdraw from an account");
            System.out.println("7 - End the program");
            System.out.println("-----");
            /*
             * Switch statement for every action the user can do
             */
            switch (action){
                case PRINTACTION:
                    myAccountLibrary.displayAll();
                    break;
                case CREATEACTION:
                    System.out.println("You are creating an Account");
                    System.out.println("-----");
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
                    myAccountLibrary.writeLibrary();
                    break;
                case CLOSEACTION:
                    myAccountLibrary.displayAll();//displays so the user can see all of the reference numbers
                    break;
                case GETACTION:
                    myAccountLibrary.displayAll();//displays so the user can see all of the reference numbers
                    break;
                case DEPOSITACTION:
                    myAccountLibrary.displayAll();//displays so the user can see all of the reference numbers
                    break;
                case WITHDRAWACTION:
                    myAccountLibrary.displayAll();//displays so the user can see all of the reference numbers
                    break;
                case ENDACTION:
                    ongoing = false;
                    break;
            }
        }
    }
}
