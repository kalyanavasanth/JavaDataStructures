package TokenBucket;

import LinkedList.*;

/**
 * @author SESA366034 This thread
 */
public class QueueOneOutThread extends Thread {
	private Queue<Packet> QueueOne, QueueTwo;
	private Bucket bucket;
	private Packet packet;
	private int LAMBDA;
	private QueueTwoOutThread ServerThread;

	/**
	 * @param _Q1
	 *            holds the reference of Queue where packets arrive
	 * @param _Q2
	 *            holds the reference of Queue where packets eligible for
	 *            transmission are sent
	 * @param _bucket
	 *            holds the reference of token bucket
	 */
	public QueueOneOutThread(Queue<Packet> _Q1, Queue<Packet> _Q2,
			QueueTwoOutThread _ServerThread, Bucket _bucket, int _rate) {
		QueueOne = _Q1;
		QueueTwo = _Q2;
		bucket = _bucket;
		ServerThread = _ServerThread;
		LAMBDA = _rate;
	}

	public void run() {
		try {
			while (true) {
				synchronized (QueueTwo) {
					if (QueueTwo.getSize() == 1) {

						if (ServerThread.isWaiting()) {
							System.out.println("Server thread wakened");
							QueueTwo.notify();
						}
					}
				}
				/* dequeue the packet and check for following conditions */

				packet = QueueOne.dequeueGet();

				/*
				 * if there are insufficient tokens for transmission, add the
				 * packet back to Q1
				 */
				if (bucket.TokensCount() < packet.GetEligibleTokens()) {
					QueueOne.enqueue(packet);
					System.out.println("Packet" + packet.GetID()
							+ " added back to Q1 due to insufficient tokens");

				}

				/*
				 * If there are sufficient tokens for transmission, transfer
				 * tokens from bucket and transmit packet to Q2
				 */
				if (bucket.TokensCount() >= packet.GetEligibleTokens()) {
					for (int NumOfTokens = 1; NumOfTokens <= packet
							.GetEligibleTokens(); ++NumOfTokens) {
						bucket.TransferToken();
					}
					QueueTwo.enqueue(packet);
					System.out.println("Packet " + packet.GetID()
							+ " added to Q2");
				}

				/*
				 * if the tokens required for transmission are greater than
				 * bucket depth, drop the packets from queue
				 */
				if (bucket.GetDepth() < packet.GetEligibleTokens()) {
					System.out.println("Packet " + packet.GetID()
							+ " dropped from Q1");
					packet = null;
				}
				sleep(LAMBDA);
			}
		} catch (Exception e) {
			System.err.println("QueueOneOut Thread Interrupted");
			e.printStackTrace();
		}
	}
}
