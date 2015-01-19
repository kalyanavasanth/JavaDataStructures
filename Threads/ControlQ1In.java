package Threads;

import LinkedList.*;

/**
 * @author SESA366034 Thread to control creation and insertion of packets
 */
public class ControlQ1In extends Thread {
	private Queue<Packet> Q;

	/**
	 * @param Q1
	 *            is the reference of the queue to be Enqueued
	 */
	public ControlQ1In(Queue<Packet> Q1) {
		Q = Q1;
	}

	public void run() {
		try {
			while (true) {
				Packet newPacket = new Packet();
				Q.enqueue(newPacket);
				System.out
						.println("Created a packet with ID:" + Packet.getId());
				sleep(1000); // enqueue and wait for 1 second
			}
		} catch (InterruptedException e) {
			System.err.println("Thread Interrupted");
		}
	}

}
