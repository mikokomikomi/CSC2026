import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Has the main class which is where the program runs from and Handles user input and the User Interface
 *
 * @author Miko Peszynski
 * @version V8 - 03/04/2026
 */
public class main
{
    private Scanner keyboard = new Scanner(System.in);
    private AccountLibrary myAccountLibrary = new AccountLibrary(true);
    public main(){
        boolean ongoing = true;
        /*
         * block of final ints for actions the user can do
         */
        final int PRINTACTION = 1; //Prints the library along with the referral number which the user needs when referencing a specific account
        final int CREATEACTION = 2;//Creates an account
        final int CLOSEACTION = 3;//Closes an account
        final int GETACTION = 4;//Gets the balance of an account
        final int DEPOSITACTION = 5;//Adds money to the account
        final int WITHDRAWACTION = 6;//Withdraws money to the account
        final int ENDACTION = 7;//ends the program
        System.out.println("Welcome to this bank account managing software");
        /*
         * While loop for whether the code is ongoing
         */
        while(ongoing){
            int action;//the int for controlling which action is being done
            int tempReferralNumber;// This is the number which is typed in to refer to a specific account. Which account has which number is decided by its place in the arraylist
            double tempBalanceChange;// temp variable used when changing balance (withdraw or deposit)
            String prompt;
            System.out.println("-----");
            System.out.println("What do you want to do?");
            System.out.println("-----");
            System.out.println("1 - Print the whole library");
            System.out.println("2 - Create an account");
            System.out.println("3 - Close an account");
            System.out.println("4 - Get an account's balance and type");
            System.out.println("5 - Deposit into an account");
            System.out.println("6 - Withdraw from an account");
            System.out.println("7 - End the program");
            System.out.println("-----");
            action = readAction();
            /*
             * Switch statement for every action the user can do
             */
            switch (action){
                case PRINTACTION:
                    myAccountLibrary.displayAll();
                    break;
                case CREATEACTION://Account creating action, asks the user the specifications of the account they're making
                    System.out.println("You are creating an Account. Please use no semicolons when entering the data.");
                    System.out.println("-----");
                    prompt = "What is the Customer's name?";
                    String tempName = readString(prompt);
                    prompt = "What is the Account's Account Number?";
                    String tempAccountNumber = readAccountNumber(prompt);
                    prompt = "What is the Customer's address";
                    String tempAddress = readString(prompt);
                    prompt = "What type of account is it (EveryDay, Savings, or Current)?";
                    String tempAccountType = readTypeString(prompt);
                    prompt = "What is the account's current balance in NZD?";
                    double tempBalance = readFirstBalance(prompt);
                    keyboard.nextLine();

                    BankAccount tempAccount = new BankAccount(tempName,tempAccountNumber,tempAddress,tempAccountType,tempBalance);//creates the account object
                    myAccountLibrary.addAccount(tempAccount);
                    System.out.println(tempAccount.getName()+"'s account was successfully added!");
                    System.out.println("-----");
                    break;
                case CLOSEACTION://Account closing action, asks the user for a referral number then deletes the account associated with it
                    myAccountLibrary.displayAll();//displays so the user can see all of the referral numbers
                    System.out.println("-----");
                    prompt = "Type in the account which you want to delete's referral number (The ordered number which is on the far left)";
                    myAccountLibrary.deleteAccount(readReferralNum(prompt));
                    System.out.println("This account was deleted");
                    System.out.println("-----");
                    break;
                case GETACTION://Balance and type getting action, asks the user for a referral number then prints the balance and account type of the account associated with it
                    myAccountLibrary.displayAll();//displays so the user can see all of the referral numbers
                    System.out.println("-----");
                    prompt = "Type in the account which balance your getting's referral number (The ordered number which is on the far left)";
                    myAccountLibrary.viewAccountBalance(readReferralNum(prompt));
                    System.out.println("-----");
                    break;
                case DEPOSITACTION://Balance increasing action (depositing), asks the user for a referral number then increases the balance of the account associated with it by an amount dictated by the user
                    myAccountLibrary.displayAll();//displays so the user can see all of the referral numbers
                    System.out.println("-----");
                    prompt = "Type in the account which you're depositing into's referral number (The ordered number which is on the far left)";
                    tempReferralNumber = readReferralNum(prompt);
                    myAccountLibrary.viewAccountBalance(tempReferralNumber);//Shows the user how much money is currently in the account prior to the deposit
                    System.out.println("-----");
                    prompt = "How much do you want to deposit (NZD) (no negatives)";
                    tempBalanceChange = balanceChange(prompt,true);//deposits when the boolean says true and withdraws when false
                    myAccountLibrary.changeAccountBalance(tempReferralNumber,tempBalanceChange,true);
                    break;
                case WITHDRAWACTION://Balance decreasing action (withdrawing), asks the user for a referral number then decreases the balance of the account associated with it by an amount dictated by the user
                    boolean asking = true;//boolean for repeatedly asking when inputting the amount to be withdrawn
                    myAccountLibrary.displayAll();//displays so the user can see all of the referral numbers
                    System.out.println("-----");
                    prompt = "Type in the account which you're withdrawing from's referral number (The ordered number which is on the far left)";
                    tempReferralNumber = readReferralNum(prompt);
                    myAccountLibrary.viewAccountBalance(tempReferralNumber);//Shows the user how much money is currently in the account prior to the deposit
                    System.out.println("-----");
                    while (asking){//acts to combine the reliable inputs in both classes and makes it repeatedly ask if outside boundaries
                        asking = false;
                        prompt = "How much do you want to withdraw (NZD)(Max of 5000 - no negatives)";
                        tempBalanceChange = balanceChange(prompt,false);//deposits when the boolean says true and withdraws when false
                        asking = myAccountLibrary.changeAccountBalance(tempReferralNumber,tempBalanceChange,false);
                    }
                    break;
                case ENDACTION://Shows the total amount of money in the bank, ends the program and writes it to the txt file
                    System.out.println("Here is the total amount of money in this bank");
                    myAccountLibrary.displayTotalMoney();
                    System.out.println("Ending and Writing to file");
                    ongoing = false;
                    myAccountLibrary.writeLibrary();
                    break;
            }
        }
    }

    /*
     * reliable input checker method for referral numbers
     */
    private int readReferralNum(String prompt){
        System.out.println(prompt);
        int amountOfReferral = myAccountLibrary.amountOfAccount();//int with the amount of referral numbers
        int answer = 0;//int holding the users answer
        boolean asking = true;//boolean controlling whether the user is being asked
        while (asking == true){
            while (!keyboard.hasNextInt()){//checks if the input was a string and if so asks again
                keyboard.nextLine();
                System.out.println("INVALID. Please "+prompt);

            }
            answer = keyboard.nextInt();
            if (amountOfReferral >= answer && 1 <= answer){//checks whether the answer is within the boundaries and if so stops asking
                asking = false;
            }else{
                System.out.println("INVALID. Please "+prompt);
            }
            keyboard.nextLine();
        }
        return answer-1;
    }

    /*
     * reliable input checker method for action numbers
     */
    private int readAction(){
        final int ACTCOUNT = 7;// final int with the total amount of different actions which can be done 
        int answer = 0;//int holding the users answer
        boolean asking = true;//boolean controlling whether the user is being asked
        while (asking == true){
            while (!keyboard.hasNextInt()){//checks if the input was a string and if so asks again
                keyboard.nextLine();
                System.out.println("INVALID. Please type a number from 1 to 7.");

            }
            answer = keyboard.nextInt();
            if (ACTCOUNT >= answer && 1 <= answer){//checks whether the answer is within the boundaries and if so stops asking
                asking = false;
            }else{
                System.out.println("INVALID. Please type a number from 1 to 7.");
            }
            keyboard.nextLine();
        }
        return answer;
    }

    /*
     * reliable input checker method for entering balance when adding an account to make sure it's not in the negative
     */
    private double readFirstBalance(String prompt){
        System.out.println(prompt);
        double answer = 0;//double holding the users answer
        boolean asking = true;//boolean controlling whether the user is being asked
        while (asking == true){
            while (!keyboard.hasNextDouble()){//checks if the input was a string and if so asks again
                keyboard.nextLine();
                System.out.println("INVALID. Please "+prompt);

            }
            answer = keyboard.nextDouble();
            if (0 <= answer){//checks whether the answer is within the boundaries and if so stops asking (no negatives even if a current account when adding as it doesn't make much sense to me for an accounts first balance to be in the negatives)
                asking = false;
            }else{
                System.out.println("INVALID. Please "+prompt);
            }
        }
        return answer;
    }

    private double balanceChange(String prompt,boolean depositing){
        System.out.println(prompt);
        final int MAXWITHDRAWAL = 5000;// final int with the Max you can withdraw from an account at once
        double answer = 0;//double holding the users answer
        boolean asking = true;//boolean controlling whether the user is being asked
        while (asking == true){
            while (!keyboard.hasNextDouble()){//checks if the input was a string and if so asks again
                keyboard.nextLine();
                System.out.println("INVALID. Please try again. "+prompt);

            }
            answer = keyboard.nextDouble();
            if (depositing){
                if (0 <= answer){//checks whether the answer is within the boundaries and if so stops asking
                    asking = false;
                }else{
                    System.out.println("INVALID. Please try again. "+prompt);
                }
                keyboard.nextLine();
            }else{
                if (0 <= answer  && answer<=MAXWITHDRAWAL){//checks whether the answer is within the boundaries and if so stops asking
                    asking = false;
                }else{
                    System.out.println("INVALID. Please try again. "+prompt);
                }
                keyboard.nextLine();

            }
        }
        return answer;
    }

    /*
     * reliable input checker method for Strings, makes sure that they don't have any semicolons so the data can be read properly
     */
    private String readString(String prompt){
        System.out.println(prompt);
        String answer = keyboard.nextLine();//int holding the users answer
        boolean asking = true;//boolean controlling whether the user is being asked
        while (asking == true){//will ask repeatedly for a string until one without a semicolon is written
            if (answer.contains(";")){
                System.out.println("INVALID, Please type an answer without a semicolon.");
                answer = keyboard.nextLine();
            }else {
                asking = false;
            }
        }
        return answer;
    }

    /*
     * reliable input checker method for Account number, making sure whats inputted is in fact a number, whilst keeping it a string
     */
    private String readAccountNumber(String prompt){
        System.out.println(prompt);
        int answer = 0;//int holding the users answer
        boolean asking = true;//boolean controlling whether the user is being asked
        while (asking == true){
            while (!keyboard.hasNextInt()){//checks if the input was a string and if so asks again
                keyboard.nextLine();
                System.out.println("INVALID. Please "+ prompt);

            }
            asking = false;
            answer = keyboard.nextInt();
            keyboard.nextLine();
        }
        return String.valueOf(answer);
    }

    /*
     * reliable input checker method for The Type string which you need to answer when creating an account, it ensures you create an account of 1 of those 3 types
     */
    private String readTypeString(String prompt){
        System.out.println(prompt);
        String answer = keyboard.nextLine();//int holding the users answer
        boolean asking = true;//boolean controlling whether the user is being asked
        while (asking == true){//will ask repeatedly for a string until one of the categories is inputted
            if (answer.toLowerCase().equals( "savings")|| answer.toLowerCase().equals( "current") || answer.toLowerCase().equals( "everyday") ){
                asking = false;
            }else{
                answer = keyboard.nextLine();
            }
        }
        return answer;
    }
}

