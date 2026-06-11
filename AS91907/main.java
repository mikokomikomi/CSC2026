
/**
 * Main class
 *
 * @author Miko Peszynski
 * @version V3 - 11/06/2026
 */
public class main
{
    // instance variables - replace the example below with your own
    private Data nodeData = new Data(true);
    private PriorityQueue line = new PriorityQueue();
    

    public main()
    {
        nodeData.displayAll();
        nodeData.runProcess();
    }
}
