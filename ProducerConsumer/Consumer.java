package ProducerConsumer;

/**
 * @author SESA366034 Thread to control consumer. This thread gets wakened when
 *         producer notifies after filling the buffer.
 */
public class Consumer extends Thread {
	private Buffer resource;

	/**
	 * @param _resource
	 *            is the reference the the resource which is consumed by the
	 *            consumer
	 */
	public Consumer(Buffer _resource) {
		resource = _resource;
	}

	public void run() {
		/* synchronizing resource to prevent concurrent access */
		synchronized (resource) {
			try {
				while (true) {
					/* if resource has content, it is consumed(Dequeued) */
					if (resource.hasContent()) {
						resource.ConsumeBuffer();
						System.out.println("Buffer Consumed");
					}
					if (!resource.hasContent()) {
						/*
						 * if resource is empty, notify producer and wait for
						 * notification from producer
						 */
						resource.notifyAll();
						System.out.println("Consumer in wait mode");
						/*
						 * sleep 1s for making the output readable. Else the
						 * output prints too fast
						 */
						sleep(1000);
						resource.wait();
					}
				}
			} catch (InterruptedException e) {
				System.err.println("Thread Interrupted");
			}
		}
	}
}
