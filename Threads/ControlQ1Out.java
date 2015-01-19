package Threads;
import LinkedList.*;
/**
 * @author SESA366034
 *
 */
/** Thread Class to dequeue the elements **/
public class ControlQ1Out extends Thread {
	private Queue<Packet> Q; 
	/**
	 * @param Q1 is reference of the queue that has to be dequeued
	 */
	public ControlQ1Out(Queue<Packet> Q1) {
		Q = Q1;
	}

	public void run() {
		
			try {
				while (true) {
					Q.dequeue();
					System.out.println("Removed a packet.");
					Q.printQueue();
					sleep(2000); // dequeue and wait for 2 seconds
				}
			} catch (InterruptedException e) {
				System.err.println("Thread Interrupted");
			
		}
	}
}
