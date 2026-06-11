
/**
 *Node constructor
 *
 * @author Miko Peszynski
 * @version V3 - 05/06/2026
 */
public class Node
{
    // instance variables - replace the example below with your own
    private int data;
    private Node next;
    
    
    public Node()
    {
        this.data = 0;
    }
    
    public Node(int data){
        this.data = data;
    }
    
    public void setData(int data){
        this.data = data;
    }
    
    public void setNextNode(Node n){
        this.next = n;
    }
    
    public int getData(){
        return(this.data);
    }
    
        public Node getNextNode(){
        return(this.next);
    }
}
