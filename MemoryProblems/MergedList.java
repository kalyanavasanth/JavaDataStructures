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

	public void process(InsecureLinkedListHelper<T> _ListOne,
			InsecureLinkedListHelper<T> _ListTwo, int _position) {
		InsecureLinkedListHelper<T>.Node TempRef1, TempRef2;
		ListOne = _ListOne;
		ListTwo = _ListTwo;
		position = _position;
		ListOneHead = ListOne.getHead();
		ListTwoHead = ListTwo.getHead();
		TempRef1=ListOneHead;
		for(int index=0;index<position;++index){
			TempRef1=TempRef1.getNext();
		}
		TempRef2=ListTwoHead;
		while(TempRef2.getNext()!=null){
			TempRef2=TempRef2.getNext();
		}
		TempRef2.setNode(TempRef1);
	}
	
	public InsecureLinkedListHelper<T>.Node GetHeadOne(){
		return ListOneHead;
	}
	
	public InsecureLinkedListHelper<T>.Node GetHeadTwo(){
		return ListTwoHead;
	}

}
