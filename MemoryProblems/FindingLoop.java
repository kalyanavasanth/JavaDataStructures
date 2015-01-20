package MemoryProblems;

/**
 * @author SESA366034 This class implements a logic to find if a linked list has
 *         a loop
 */
public class FindingLoop<T1> {
	InsecureLinkedListHelper<T1> list;

	/**
	 * @param position
	 *            specifies the position at which the loop has to be created
	 * @param _list
	 *            passes the reference of the list in which loop has to be
	 *            created
	 */
	public void CreateLoopAt(InsecureLinkedListHelper<T1> _list, int position) {
		list = _list;
		InsecureLinkedListHelper<T1>.Node IndexPointer = list.getHead(); // get
																			// access
																			// to
																			// head
																			// element
		InsecureLinkedListHelper<T1>.Node EndPointer = IndexPointer;
		for (int current_pos = 0; current_pos < position; ++current_pos) {
			IndexPointer = IndexPointer.getNext(); // traverse IndexPointer to
													// specified index
		}
		while (EndPointer.getNext() != null) {
			EndPointer = EndPointer.getNext(); // traverse EndPointer till end
		}
		EndPointer.setNode(IndexPointer); // Set next of EndPointer to
											// IndexPointer to create the loop
	}

	public boolean CheckForLoop(InsecureLinkedListHelper<T1> _list) {
		list = _list;
		CustomizedIterator<T1> FastIterator = list.iterator();
		CustomizedIterator<T1> SlowIterator = list.iterator();

		while (FastIterator.hasNext()) {
			FastIterator.iterate(2);
			SlowIterator.iterate(1);
			if (FastIterator.getCurrent() != null) {
				if (FastIterator.getCurrent().hashCode() == SlowIterator
						.getCurrent().hashCode()) {
					return true;
				}
			}
		}
		return false;
	}
}
