package MemoryProblems;

/**
 * @author SESA366034
 *This class creates an object, that reverses a linked list iteratively
 */
public class ReverseListIteratively {
	InsecureLinkedListHelper<Integer> list;
	InsecureLinkedListHelper<Integer>.Node OldHead,first,second,third,NewHead;
	
	/**
	 * @param _list is the reference of the list to be reversed
	 */
	public ReverseListIteratively(InsecureLinkedListHelper<Integer> _list){
		list=_list;
		/** traverse till the last element and set it as new head **/
		NewHead=list.getHead();
		while(NewHead.getNext()!=null){
			NewHead=NewHead.getNext();
		}
	}
	/**
	 * @param _head is the head(OldHead) of the list which is not reversed
	 */
	public void process(InsecureLinkedListHelper<Integer>.Node _head){
		OldHead=_head;
		first=OldHead;
		second=first.getNext();
		
		while(true){
			if(second==null){
				break;
			}
			third=second.getNext();
			if(third==null){
				second.setNode(first);
				break;
			}
			if(third.getNext()==null){
				second.setNode(first);
				third.setNode(second);
				break;
			}
			second.setNode(first);
			first=second;
			second=third;			
		}
		OldHead.setNode(null);
		list.setHead(NewHead);
	}
}
