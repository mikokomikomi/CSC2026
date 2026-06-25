
/**
 * Priority queue constructor
 *
 * @author Miko Peszynski
 * @version V4 - 19/06/2026
 */
public class PriorityQueue
{
    // instance variables - replace the example below with your own
    private Queue lowP;
    private Queue highP;

    /**
     * Constructor for objects of class PriorityQueue
     */
    public PriorityQueue()
    {
        lowP = new Queue();
        highP= new Queue();
    }

    void enqueue(int currentTime, boolean teacher){
        if (teacher)
            highP.enqueue(new Node(currentTime));
        else
            lowP.enqueue(new Node(currentTime));

    }

    int dequeue(){ //dequeueing constructor
        if(highP.emptyQueue()){
            return lowP.dequeue();
        }else
            return highP.dequeue();
    }

    boolean emptyQueue(){// Checks if there is an empty Queue
        if(highP.emptyQueue() && lowP.emptyQueue())
            return true;
        else
            return false;
    }
    

}
