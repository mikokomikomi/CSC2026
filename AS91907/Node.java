
/**
 *Node constructor
 *
 * @author Miko Peszynski
 * @version V7 - 20/07/2026
 */
public class Node
{
    // instance variables - replace the example below with your own
    private int data;
    private boolean isStudent;
    private Node next;
    
    
    public Node() //node constructor
    {
        this.data = 0;
    }
    
    public Node(int data,boolean isStudent) // node with data int and isStudent boolean constructor
    {
        this.data = data;
        this.isStudent = isStudent;
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
    
    public boolean getIsStudent(){// getter method which allows other classes to get the isStudent value of a node
        return(this.isStudent);
    }
    
        public Node getNextNode(){// getter method which allows other classes to get the data of the next node
        return(this.next);
    }
}
