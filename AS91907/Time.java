
/**
 * Write a description of class Time here.
 *
 * @author Miko Peszynski
 * @version V3 - 11/06/2026
 */
public class Time
{
    private int time;
    private int students;
    private int teachers;
    private int served;
    public Time(int time,int students,int teachers,int served)
    {
        this.time = time;
        this.students = students;
        this.teachers = teachers;
        this.served = served;
    }

    public int getTime(){
        return this.time;
    }

    public int getStudents(){
        return this.students;
    }

    public int getTeachers(){
        return this.teachers;
    }

    public int getServed(){
        return this.served;
    }
    
    public String getAll (){//getter for all of the time's values
        return String.valueOf(this.time)+","+String.valueOf(this.students)+","+String.valueOf(this.teachers)+","+String.valueOf(this.served);
    }
}