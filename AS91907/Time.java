
/**
 * Write a description of class Time here.
 *
 * @author Miko Peszynski
 * @version V5 - 29/06/2026
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

    public int getTime(){//getter for the time of a specific time
        return this.time;
    }

    public int getStudents(){//getter for the amount of students added on a specific time
        return this.students;
    }

    public int getTeachers(){//getter for the amount of techers addedon a specific time
        return this.teachers;
    }

    public int getServed(){//getter for the amount of people served on a specific time
        return this.served;
    }
    
    public String getAll (){//getter for all of the time's values
        return String.valueOf(this.time)+","+String.valueOf(this.students)+","+String.valueOf(this.teachers)+","+String.valueOf(this.served);
    }
}