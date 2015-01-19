package Problems;
import LinkedList.*;
public class CircleProblem {
	Queue<Integer> qu = new Queue<Integer>();
	public void process(int number_of_elements, int step_size) {
		for (int i = 0; i < number_of_elements; ++i) {
			qu.enqueue(i);
		}
		while (qu.getSize() != 1) {
			for(int i=1;i<step_size;++i){
				int DequeueAndEnqueue=qu.dequeueGet();
				qu.enqueue(DequeueAndEnqueue);
			}
			qu.dequeue();
		}
		qu.printQueue();
	}
}
