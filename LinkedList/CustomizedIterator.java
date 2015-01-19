package LinkedList;
import java.util.Iterator;

public interface CustomizedIterator<T1> extends Iterator<T1> {
	/**
	 * @param n
	 *            iterates the iterator by n positions
	 */
	public void iterate(int n);

	/**
	 * @return T1 is the value stored in the node pointed by iterator
	 */
	public T1 getValue();
}
