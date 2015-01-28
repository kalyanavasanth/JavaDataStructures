package TokenBucket;

import LinkedList.*;

/**
 * @author kalyan This class creates a thread for server to serve the packets
 *         from Q2
 */
public class QueueTwoOutThread extends Thread {
	private int MU_RATE = 0; //rate at which packets are to be served
	private Queue<Packet> Q2; //queue from which server serves packets
	private Server server; //server reference
	private boolean waiting; //variable to know the thread wait state

	public QueueTwoOutThread(Queue<Packet> _Q2, Server _server, int _rate) {
		Q2 = _Q2;
		server = _server;
		MU_RATE = _rate;
		waiting = false;
	}
	
	/* function to find if the thread is in waiting state */
	public boolean isWaiting() {
		return waiting;
	}

	public void run() {
		try {
			while (true) {
				/* if queue size is 0, wait for the packets to arrive
				 * serve the packets when notified*/
				synchronized (Q2) {
					if (Q2.getSize() == 0) {
						waiting = true;
						System.out.println("Server thread went to wait state");
						Q2.wait();
					}
				}
				server.serve(Q2);
				System.out.println("Packet served by server");
				sleep(MU_RATE);
			}
		} catch (InterruptedException e) {
			System.err.println("Q2 Thread Interrupted");
		}
	}
}
