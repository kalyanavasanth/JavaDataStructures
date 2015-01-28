package TokenBucket;
import LinkedList.*;
/**
 * @author kalyan
 *This class serves packet from Q2
 */
public class Server {
	Queue<Packet> Q2;
	/**
	 * @param _Q2
	 * Reference of the queue to be served
	 */
	public void serve(Queue<Packet> _Q2){
		Q2=_Q2;
		Q2.dequeue();
	}
}
