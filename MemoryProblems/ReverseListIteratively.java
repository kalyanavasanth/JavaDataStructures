package MemoryProblems;

/**
 * @author SESA366034 This class is used to reverse a linked list using
 *         iteration
 */
public class ReverseListIteratively {
	private InsecureLinkedListHelper<Integer> list;
	private InsecureLinkedListHelper<Integer>.Node OldHead, Newhead, traverser,
			EndPointer, OldEnd;

	public void process(InsecureLinkedListHelper<Integer> _list) {
		list = _list;
		OldHead = list.getHead();
		traverser=list.getHead();
		EndPointer=list.getHead();
		OldEnd=list.getHead();
		while(OldEnd.getNext()!=null){
			OldEnd=OldEnd.getNext();
		}
		while (true) {
			traverser=OldHead;
			EndPointer=OldHead;
			if(traverser.getNext().getNext()==null){
				break;
			}
			while (EndPointer.getNext() != null) {
				EndPointer = EndPointer.getNext();
			}
			while (traverser.getNext() != EndPointer) {
				traverser = traverser.getNext();
			}
			if (traverser.getNext().hashCode() == OldEnd.hashCode()) {
				Newhead = EndPointer;
			}
			EndPointer.setNode(traverser);
			traverser.setNode(null);
		}
		EndPointer=EndPointer.getNext();
		EndPointer.setNode(OldHead);
		traverser.setNode(null);
		list.setHead(Newhead);
		list.printElements();
	}

}
