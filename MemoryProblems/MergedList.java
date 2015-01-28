package MemoryProblems;

/**
 * @author SESA366034 This classes merges two lists
 * @param <T>
 *            is the datatype that the linked list holds
 */
public class MergedList<T> {
	private InsecureLinkedListHelper<T> ListOne, ListTwo;
	private InsecureLinkedListHelper<T>.Node ListOneHead, ListTwoHead;
	private int position;

	/**
	 * ALGORITHM: Iterate a pointer till end of second list. Iterate another
	 * pointer till the index specified in first list. Refer the end pointer of
	 * the second list to the index specified in the first list
	 **/

	/**
	 * @param _ListOne
	 *            reference of first list
	 * @param _ListTwo
	 *            reference of second list
	 * @param _position
	 *            index of a first list element to which the second list has to
	 *            be merged
	 */
	public void process(InsecureLinkedListHelper<T> _ListOne,
			InsecureLinkedListHelper<T> _ListTwo, int _position) {
		InsecureLinkedListHelper<T>.Node TempRef1, TempRef2;
		ListOne = _ListOne; 
		ListTwo = _ListTwo;
		position = _position;
		ListOneHead = ListOne.getHead();
		ListTwoHead = ListTwo.getHead();
		TempRef1 = ListOneHead;
		for (int index = 0; index < position; ++index) {
			TempRef1 = TempRef1.getNext(); //move index pointer to specified index
		}
		TempRef2 = ListTwoHead; 
		while (TempRef2.getNext() != null) {
			TempRef2 = TempRef2.getNext(); //move another pointer in list two till end
		}
		TempRef2.setNode(TempRef1); //refer the end pointer of second list to index pointer
	}

	public InsecureLinkedListHelper<T>.Node GetHeadOne() {
		return ListOneHead;
	}

	public InsecureLinkedListHelper<T>.Node GetHeadTwo() {
		return ListTwoHead;
	}

}
