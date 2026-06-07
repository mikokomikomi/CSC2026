
/**
 * Main class
 *
 * @author Miko Peszynski
 * @version V2 - 05/06/2026
 */
public class main
{
    // instance variables - replace the example below with your own
    private Data nodeData = new Data(true);
    private PriorityQueue line = new PriorityQueue();
    

    public main()
    {
        int egg = 1;
        line.enqueue(1,true);
        nodeData.displayAll();
        nodeData.runProcess();
    }
}
