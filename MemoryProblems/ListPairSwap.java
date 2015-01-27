package MemoryProblems;

/**
 * @author SESA366034
 *
 * @param <T>
 *            is the data type of the linked list
 */
public class ListPairSwap<T> {
	InsecureLinkedListHelper<T> list;

	/**
	 * @param _list
	 *            is the reference of the list which has to be swapped pair wise
	 */
	/**
	 * ALGORITHM: Maintain four pointers p1, p2, p3, p4 to 4 consecutive
	 * elements in the list. Point p1 to p4, p2 to p1 and iterate all pointers
	 * to the next alternative element in the list. Handle the exceptions in
	 * case if the list has less than 3 elements
	 **/
	public void process(InsecureLinkedListHelper<T> _list) {
		list = _list;
		/** 4 pointers to manipulate the links in the list **/
		InsecureLinkedListHelper<T>.Node p1, p2, p3, p4;
		/** p1 p2 p3 p4 point to four consecutive elements in the list **/
		p1 = list.getHead();
		p2 = p1.getNext();
		/** if list has one element, make other pointers as null and return **/
		if (p2 == null) {
			p3 = p4 = null;
			return;
		} else {
			p3 = p2.getNext();
			/**
			 * if list has two elements, set the next node of second element as
			 * first, change head to second element and return
			 **/
			if (p3 == null) {
				p4 = null;
				p2.setNode(p1);
				p1.setNode(null);
				list.setHead(p2);
				return;
			} else {
				p4 = p3.getNext();
			}
		}
		/**
		 * is the list has three or more elements, set the initial reference of
		 * p2 to head
		 **/
		list.setHead(p2);
		while (true) {
			/** if there are odd number of elements in the list, make p4=p3 **/
			if (p3 != null && p4 == null) {
				p4 = p3;
			}
			/** point p1 to p4 and p2 to p1 **/
			p1.setNode(p4);
			p2.setNode(p1);
			/**
			 * if there are even number of elements, set next of p4 to p3 and
			 * set next of p3 to null
			 **/
			if (p4.getNext() == null) {
				p4.setNode(p3);
				p3.setNode(null);
				break;
			} else {
				/**
				 * iterate all pointers to the next alternate element in the
				 * list
				 **/
				p1 = p3;
				p2 = p4;
				p3 = p2.getNext();
				p4 = p3.getNext();
			}
		}
	}
}
