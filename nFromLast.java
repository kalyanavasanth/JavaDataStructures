import java.util.*;

public class nFromLast<T> {
	/**
	 * @param l
	 *            is linked list object that should be processed for nth node
	 *            from end
	 * @param n
	 *            is the nth node to be found from end
	 */
	void process(LinkedListHelper<T> l, int n) {
		CustomizedIterator<T> iterator1 = l.iterator();// 1st iterator
		CustomizedIterator<T> iterator2 = l.iterator();// 2nd iterator
		if (n > l.getCount()) { // check if n value is within the bounds
			throw new NoSuchElementException("n value is out of bounds");
		} else {
			iterator1.iterate(n - 1);
			while (iterator1.hasNext()) {
				iterator1.next();
				iterator2.next();
			}
			System.out.println("nth element from last:"+iterator2.getValue());// print nth element from
														// last
		}
	}
}
