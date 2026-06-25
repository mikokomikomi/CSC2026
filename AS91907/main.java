import java.util.Scanner;
/**
 * Main class
 *
 * @author Miko Peszynski
 * @version V4 - 19/06/2026
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
            action = keyboard.nextInt();
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
}
