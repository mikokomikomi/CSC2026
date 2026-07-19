
/**
 * Priority queue constructor
 *
 * @author Miko Peszynski
 * @version V7 - 20/07/2026
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

    void enqueue(int currentTime, boolean isStudent){
        if (isStudent)
            lowP.enqueue(new Node(currentTime,isStudent));
        else
            highP.enqueue(new Node(currentTime,isStudent));

    }

    Node dequeue(){ //dequeueing constructor
        if(highP.emptyQueue()){
            return lowP.dequeue();
        }else
            return highP.dequeue();
    }

    boolean emptyQueue(){//Checks if both queues are empty
        if(highP.emptyQueue() && lowP.emptyQueue())
            return true;
        else
            return false;
    }
    

}
