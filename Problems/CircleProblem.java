package Problems;

import LinkedList.*;

/**
 * @author SESA366034 ALGORITHM: dequeue step_size-1 elements from queue and
 *         enqueue them back in the same queue. Dequeue the (step_size)th
 *         element from the queue. Repeat the process till one element is left.
 */
public class CircleProblem {
	Queue<Integer> qu = new Queue<Integer>();

	/**
	 * @param number_of_elements
	 *            is the number of elements that have to be filled in the queue.
	 *            Ex: 7, fills the queue with elements from 0 to 6
	 * @param step_size
	 *            is the number of steps after which an element has to be
	 *            dequeued
	 */
	public void process(int number_of_elements, int step_size) {
// fill the queue with number of elements as passed through the arguments
		for (int i = 0; i < number_of_elements; ++i) {
			qu.enqueue(i);
		}
//until queue size!=1 repeat the algorithm as stated above
		while (qu.getSize() != 1) {
			for (int i = 1; i < step_size; ++i) {
				int DequeueAndEnqueue = qu.dequeueGet();
				qu.enqueue(DequeueAndEnqueue);
			}
			qu.dequeue();
		}
		qu.printQueue();
	}
}
