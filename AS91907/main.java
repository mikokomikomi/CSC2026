import java.util.Scanner;
/**
 * Main class
 *
 * @author Miko Peszynski
 * @version V7 - 20/07/2026
 */
public class main
{
    // instance variables - replace the example below with your own
    private Data nodeData;
    private Scanner keyboard = new Scanner(System.in);
    private boolean ongoing = true;
    private int action;
    private String dataset;
    public main()
    {
        System.out.println("Which dataset do you want to use?");
        System.out.println("Make sure the dataset file is inside the folder for this program.");
        System.out.println("Make sure the file is a CSV file or a TXT seperated by commas.");
        System.out.println("Make sure you write it like you would a file e.g. SchoolQueue.csv");
        nodeData = new Data(true);
        ///*
        while (ongoing){
            System.out.println("--");
            System.out.println("Type 1 to display all the data");
            System.out.println("--");
            System.out.println("Type 2 to run the process");
            System.out.println("--");
            System.out.println("Type 3 to switch dataset");
            System.out.println("--");
            System.out.println("type 0 to quit");
            System.out.println("--");
            action = readAction();
            switch (action){
                case 1:
                    nodeData.displayAll();
                    System.out.println("Done!");
                    break;
                case 2:
                    nodeData.runProcess();
                    System.out.println("Done!");
                    break;
                case 0:
                    ongoing = false;
                    System.out.println("End");
                    break;
                case 3:
                    System.out.println("Which dataset do you want to use?");
                    System.out.println("Make sure the dataset file is inside the folder for this program.");
                    System.out.println("Make sure the file is a CSV file or a TXT seperated by commas.");
                    System.out.println("Make sure you write it like you would a file e.g. SchoolQueue.csv");

                    nodeData = new Data(true);
                    break;
            }
        }
        //*/
        /*
               while (ongoing){
            System.out.println("There are four actions");
            System.out.println("type process to run the process");
            System.out.println("type display to display the data");
            System.out.println("type change to change the dataset");
            System.out.println("type end to close the program");
            action = readAction();
            switch (action){
                case 1:
                    nodeData.displayAll();
                    System.out.println("Done!");
                    break;
                case 2:
                    nodeData.runProcess();
                    System.out.println("Done!");
                    break;
                case 3:
                    ongoing = false;
                    System.out.println("End");
                    break;
                case 4:
                    System.out.println("Which dataset do you want to use?");
                    System.out.println("Make sure the dataset file is inside the folder for this program.");
                    System.out.println("Make sure the file is a CSV file or a TXT seperated by commas.");
                    System.out.println("Make sure you write it like you would a file e.g. SchoolQueue.csv");

                    nodeData = new Data(true);
                    break;
            }
        }
        */
    }

    private int readAction(){
        final int ACTCOUNT = 3;// final int for the action using the highest number
        int answer = 0;//int holding the users answer
        boolean asking = true;//boolean controlling whether the user is being asked
        while (asking == true){
            while (!keyboard.hasNextInt()){//checks if the input was a string and if so asks again
                keyboard.nextLine();
                System.out.println("INVALID. Please type a number from 0 to 3.");

            }
            answer = keyboard.nextInt();
            if (ACTCOUNT >= answer && 0 <= answer){//checks whether the answer is within the boundaries and if so stops asking
                asking = false;
            }else{
                System.out.println("INVALID. Please type a number from 0 to 3.");
            }
            keyboard.nextLine();
        }
        return answer;
    }
}
