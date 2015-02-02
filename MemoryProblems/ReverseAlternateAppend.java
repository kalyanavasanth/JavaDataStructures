package MemoryProblems;
/**
 * @author SESA366034
 *This class reverses the alternate elements of a list and appends them at the end of the list
 */
public class ReverseAlternateAppend {
	private InsecureLinkedListHelper<Integer> list;
	private InsecureLinkedListHelper<Integer>.Node Pointer1,Pointer2,Pointer3, Pointer4, TempHead1, TempHead2, TempEnd1, TempEnd2;
	/**
	 * @param _list is the reference to the list to be manipulated
	 */
	public void process(InsecureLinkedListHelper<Integer> _list){
		list=_list;
		ReverseListIteratively reverse=new ReverseListIteratively(list);
		/* Initialize pointers at first 3 elements */
		Pointer1=list.getHead();
		TempHead1=Pointer1;
		Pointer2=Pointer1.getNext();
		TempHead2=Pointer2;
		TempEnd1=Pointer1;
		TempEnd2=Pointer2;
		while(true){
			if(Pointer1.getNext()==null || Pointer2.getNext()==null){
				break;
			}
			Pointer3=Pointer2.getNext();
			if(Pointer3.getNext()!=null){
			Pointer4=Pointer2.getNext().getNext();
			}
			else{
				Pointer4=null;
			}
			/* First element is attached to third element */
			Pointer1.setNode(Pointer3);
			/* Set Pointer2 next to Pointer4 */
			Pointer2.setNode(Pointer4);
			if(Pointer3!=null){
			TempEnd1=Pointer3;
			}
			if(Pointer4!=null){
				TempEnd2=Pointer4;
				}
			Pointer1=Pointer3;
			Pointer2=Pointer4;
		}
		TempEnd2.setNode(TempEnd1);
		reverse.process(TempHead2);
		list.setHead(TempHead1);
	}
}
