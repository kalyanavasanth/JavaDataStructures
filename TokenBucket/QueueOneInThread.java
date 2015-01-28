package TokenBucket;

import LinkedList.*;

/**
 * @author kalyan Thread that controls the QueueOne where packets arrive
 */
public class QueueOneInThread extends Thread {
	/* variable that holds the rate of packet arrival */
	private int LAMBDA = 0;
	private Queue<Packet> QueueOne;

	/**
	 * @param _Q1
	 *            Reference of queue that has to be used as Q1 for packet
	 *            arrival
	 * @param _rate
	 *            Rate of arrival of packets to the queue Q1
	 */
	public QueueOneInThread(Queue<Packet> _Q1, int _rate) {
		QueueOne = _Q1;
		LAMBDA = _rate;
	}

	public void run() {
		try {
			while (true) {
				Packet NewPacket = new Packet();
				NewPacket.SetEligibleTokens(5);
				QueueOne.enqueue(NewPacket);
				System.out.println("New packet added to Q1");
				QueueOne.printQueue();
				sleep(LAMBDA);
			}
		} catch (InterruptedException e) {
			System.err.println("QueueOneThread Interrupted");
		}
	}

}
