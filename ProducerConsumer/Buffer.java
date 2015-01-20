package ProducerConsumer;

import LinkedList.*;

/**
 * @author SESA366034 Buffer is the resource for producer and consumer
 */
public class Buffer {
	/* flag to check if the buffer has content */
	private boolean hasContent = false;
	private int BUFFER_SIZE = 3; // constant buffer size
	private Queue<Integer> resource = new Queue<Integer>();

	public void FillBuffer() {
		/*
		 * This method enqueues until buffer(queue) is full and sets
		 * "hasContent" flag to 'true' if the buffer is full
		 */
		if (!hasContent) {
			resource.enqueue(1);
			if (resource.getSize() == BUFFER_SIZE) {
				hasContent = true;
			}
		}
	}

	public boolean hasContent() {
		/* This method returns whether or not the buffer has content */
		return hasContent;
	}

	public void ConsumeBuffer() {
		/*
		 * This method dequeues until buffer(queue) is empty and sets
		 * "hasContent" flag to 'false' if the buffer is empty
		 */
		if (hasContent) {
			resource.dequeue();
			if (resource.getSize() == 0) {
				hasContent = false;
			}
		}
	}
}
