import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Scanner;
/**
 * Reads the data from the file given to the program.
 *
 * @author Miko Peszynski
 * @version V7 - 20/07/2026
 */
public class Data
{
    private ArrayList <Time> peopleData = new ArrayList <Time>();
    private PriorityQueue line = new PriorityQueue();
    private Scanner keyboard = new Scanner(System.in);
    /**
     * Constructor for objects of class Data
     */
    public Data()
    {

    }

    public Data( boolean reading){
        boolean asking = true;

        while (asking){
            String dataset = keyboard.nextLine();
            try {
                File myFile = new File (dataset);//opens file
                Scanner myReader = new Scanner(myFile);

                while(myReader.hasNextLine()){
                    String line = myReader.nextLine();
                    String[] tempTime = line.split(",");  
                    int time = Integer.parseInt(tempTime[0]);
                    int students = Integer.parseInt(tempTime[1]);
                    int teachers = Integer.parseInt(tempTime[2]);
                    int served = Integer.parseInt(tempTime[3]);
                    peopleData.add(new Time(time,students,teachers,served));
                }
                asking = false;
            } catch(IOException e){
                System.out.println("Error: could not read from file");
                System.out.println("");
                System.out.println("Which dataset do you want to use?");
                System.out.println("Make sure the dataset file is inside the folder for this program.");
                System.out.println("Make sure the file is a CSV file or a TXT seperated by commas.");
                System.out.println("Make sure you write it like you would a file e.g. SchoolQueue.csv");
            }
        }
    }

    public void displayAll(){
        int numberLabel = 0;
        for (Time  currentTime : peopleData){//for each loop prints the account's name, account number, and address
            numberLabel += 1;
            System.out.println(numberLabel+". "+currentTime.getTime()+" - "+currentTime.getStudents()+" - "+currentTime.getTeachers()+" - "+currentTime.getServed ());
        }
    }

    
    public void runProcess(){
        int numberLabel = 0;
        int howManyInLine = 0;
        int howManyStudentInLine = 0;
        int howManyTeacherInLine = 0;
        int mean = 0;
        PriorityQueue line = new PriorityQueue();
        for (Time  currentTime : peopleData){//for each loop prints the account's name, account number, and address
            numberLabel += 1;
            int nodeTime = currentTime.getTime();
            int studentCount = currentTime.getStudents();
            int teacherCount = currentTime.getTeachers();
            int amountServed = currentTime.getServed ();

            for (int i = 0;i<studentCount;i++){
                line.enqueue(nodeTime,true);
                howManyInLine++;
                howManyStudentInLine++;
            }
            for (int i = 0;i<teacherCount;i++){
                line.enqueue(nodeTime,false);  
                howManyInLine++;
                howManyTeacherInLine++;
            }
            for (int i = 0;i<amountServed;i++){
                Node tempMin = line.dequeue(); 
                mean += nodeTime - tempMin.getData();
                if (howManyInLine>0){
                    howManyInLine--;
                }
                if (tempMin.getIsStudent() == true){
                    howManyStudentInLine--;
                }
                if (tempMin.getIsStudent() == false){
                    howManyTeacherInLine--;
                }
            }
            System.out.println(" - minute " + numberLabel +" -");
            System.out.println(studentCount + " students join the line, " + teacherCount + " teachers join the line, "+ amountServed+" people leave" );
            System.out.print("There are now "+howManyInLine+" people in the line, " );
            System.out.print(howManyTeacherInLine+" of them are teachers, ");
            System.out.println(howManyStudentInLine+" of them are students");
        }

        mean = mean/numberLabel;
        System.out.println("The average wait time is "+mean);
    }

}
