package ProducerConsumer;

/**
 * @author SESA366034
 * Main class to test the producer and consumer threads
 */
public class Test {
	public static void main(String args[]) {
		/* create a resource(buffer) */
		Buffer resource = new Buffer();
		/*
		 * Create producer and consumer threads and pass the resource reference
		 * as parameter
		 */
		Producer producer = new Producer(resource);
		Consumer consumer = new Consumer(resource);
		/* Start the threads */
		producer.start();
		consumer.start();
	}
}
