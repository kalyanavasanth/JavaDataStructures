package Threads;
import LinkedList.*;
/**
 * @author SESA366034
 *
 *         Main class to control enqueue and dequeue threads
 */
public class ThreadsExample {
	public static void main(String args[]) {

		Queue<Packet> q1 = new Queue<Packet>(); // Create a queue that can hold
												// packets

		ControlQ1In ThreadIn = new ControlQ1In(q1); // thread instance to
													// control creation and
													// insertion
		ControlQ1Out ThreadOut = new ControlQ1Out(q1); // thread instance to
														// control dequeue

		ThreadIn.start();
		
		ThreadOut.start();
	}
}