package Problems;
import LinkedList.*;
public class CircleProblem<T1> {
	Queue<Integer> qu = new Queue<Integer>();

	CircleProblem(int m, int n) {
		int step=n;
		for (int i = 0; i < m; ++i) {
			qu.enqueue(i);
		}
		while (qu.getCount() != 1) {
			--step;
			T1 temp=qu.getHead().getData();
			qu.dequeue();
		}
	}
}
