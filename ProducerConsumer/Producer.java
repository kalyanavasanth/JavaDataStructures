package ProducerConsumer;

/**
 * @author SESA366034 Thread to control producer. This thread gets wakened when
 *         consumer notifies after emptying the buffer.
 */
public class Producer extends Thread {
	private Buffer resource;

	/**
	 * @param _resource
	 *            is the reference the the resource to which producer adds
	 *            content
	 */
	public Producer(Buffer _resource) {
		resource = _resource;
	}

	public void run() {
		synchronized (resource) {
			/* synchronizing resource to prevent concurrent access */
			try {
				while (true) {
					/* if resource has no content, it is filled(Enqueued) */
					if (!resource.hasContent()) {
						resource.FillBuffer();
						System.out.println("Buffer Filled");
					}
					if (resource.hasContent()) {
						/*
						 * if resource is full, notify consumer and wait for
						 * notification from consumer.
						 */
						resource.notifyAll();
						System.out.println("Producer in wait mode");
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