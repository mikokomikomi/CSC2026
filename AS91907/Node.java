
/**
 *Node constructor
 *
 * @author Miko Peszynski
 * @version V5 - 29/06/2026
 */
public class Node
{
    // instance variables - replace the example below with your own
    private int data;
    private Node next;
    
    
    public Node() //node constructor
    {
        this.data = 0;
    }
    
    public Node(int data) // node which holds data constructor
    {
        this.data = data;
    }
    
    public void setData(int data)// method which sets the data of a node to something different
    {
        this.data = data;
    }
    
    public void setNextNode(Node n){// method which sets the data of the next node
        this.next = n;
    }
    
    public int getData(){// getter method which allows other classes to get the data of a node
        return(this.data);
    }
    
        public Node getNextNode(){// getter method which allows other classes to get the data of the next node
        return(this.next);
    }
}
