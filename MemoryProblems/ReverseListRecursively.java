package MemoryProblems;

/**
 * @author SESA366034 This class reverses linked list recursively
 */
public class ReverseListRecursively {
	InsecureLinkedListHelper<Integer> list;
	InsecureLinkedListHelper<Integer>.Node remaining, NewHead;

	/**
	 * @param _list
	 *            is the reference to the list that has to be reversed
	 *            recursively
	 */
	public ReverseListRecursively(InsecureLinkedListHelper<Integer> _list) {
		list = _list;
	}

	/**
	 * @param _head
	 *            is the reference that is passed into the function recursively
	 *            till the end of list is reached
	 */
	public void process(InsecureLinkedListHelper<Integer>.Node _head) {
		InsecureLinkedListHelper<Integer>.Node head = _head;

		/** If head is null, stop the function execution and return **/
		if (head == null) {
			return;
		}

		/**
		 * If head is the last element or the list has only one element, stop
		 * the function execution and return
		 **/
		if (head.getNext() == null) {
			list.setHead(head);
			return;
		}

		/**
		 * Pass the next element of head recursively, until second last element
		 * is reached
		 **/
		process(head.getNext());
		/**
		 * set the next element's next value to the current element being
		 * processed. And set the current element's next value to null
		 **/
		head.getNext().setNode(head);
		head.setNode(null);
	}
}