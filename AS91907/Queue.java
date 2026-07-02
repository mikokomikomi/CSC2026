
/**
 * Queue constructor class
 * 
 * @author Miko Peszynski
 * @version V6 - 02/07/2026
 */
public class Queue
{
    // instance variables - replace the example below with your own
    private Node back;
    private Node front;
    public Queue()
    {

    }

    /**
     * Checks if the queue is empty
     * 
     * This is used in the emptyQueue method in the priority queue class
     * 
     * @return returns true if the queue is empty and returns false if it has items in it
     */
    public boolean emptyQueue(){
        if(this.front==null){
            return(true);
        }else{
            return(false);
        } 
    }

    /**
     * Adds a Node element to the Queue
     * 
     * If the queue is empty it will both Create a queue and add an element to said queue
     * 
     * @param Takes in a node containing an int, in this code this int is the time the node enters the queue
     */
    public void enqueue(Node node){
        if (this.emptyQueue()){
            this.front = node;
            this.back = node;
        }else{
            back.setNextNode(node);
            this.back = node;
        }

    }

    /**
     * Removes the front node element of the queue
     * 
     * 
     */
    public Node dequeue(){
        if(emptyQueue()){
            return null;
        }else{
            Node toDequeue = front;
            front = front.getNextNode();
            return toDequeue;
        }

    }

    /**
     * 
     */
    public void queueLength(int howLong,Node temp){
        if (emptyQueue()){
            System.out.println(howLong);
        }else{

            if(temp!=null){
                howLong++;
                temp = temp.getNextNode();
                queueLength(   howLong,temp);
            }else
                System.out.println(howLong);
        }
    }

}
