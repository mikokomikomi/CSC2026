
/**
 * Queue constructor class
 * 
 * @author Miko Peszynski
 * @version V3 - 11/06/2026
 */
public class Queue
{
    // instance variables - replace the example below with your own
    private Node back;
    private Node front;
    public Queue()
    {

    }

    public boolean emptyQueue(){
        if(this.front==null){
            return(true);
        }else{
            return(false);
        } 
    }

    public void enqueue(Node node){
        if (this.emptyQueue()){
            this.front = node;
            this.back = node;
        }else{
            back.setNextNode(node);
            this.back = node;
        }

    }

    public int dequeue(){
        if(emptyQueue()){
            return 0;
        }else{
            int frontInt = front.getData();
            front = front.getNextNode();
            return frontInt;
        }
        
    }

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
    
    public void addAtFront (Node node){
        
    }
    
    public Node getBack(){
        return(this.back);
    }

    public Node getFront(){
        return(this.front);
    }
}
