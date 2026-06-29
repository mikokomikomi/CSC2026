import java.util.Scanner;
/**
 * Main class
 *
 * @author Miko Peszynski
 * @version V5 - 29/06/2026
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
        dataset = keyboard.nextLine();
        nodeData = new Data(dataset,true);
        
        while (ongoing){
            System.out.print("Type 1 to display all the data, Type 2 to run the process, type 3 to quit, Type 4 to switch dataset");
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
                    keyboard.nextLine();
                    dataset = keyboard.nextLine();
                    nodeData = new Data(dataset,true);
                    break;
            }
        }
    }
        private int readAction(){
        final int ACTCOUNT = 4;// final int with the total amount of different actions which can be done 
        int answer = 0;//int holding the users answer
        boolean asking = true;//boolean controlling whether the user is being asked
        while (asking == true){
            while (!keyboard.hasNextInt()){//checks if the input was a string and if so asks again
                keyboard.nextLine();
                System.out.println("INVALID. Please type a number from 1 to 4.");

            }
            answer = keyboard.nextInt();
            if (ACTCOUNT >= answer && 1 <= answer){//checks whether the answer is within the boundaries and if so stops asking
                asking = false;
            }else{
                System.out.println("INVALID. Please type a number from 1 to 4.");
            }
            keyboard.nextLine();
        }
        return answer;
    }
}
