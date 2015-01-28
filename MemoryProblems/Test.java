package MemoryProblems;

public class Test {
	public static void main(String args[]) {
		InsecureLinkedListHelper<Integer> list = new InsecureLinkedListHelper<Integer>();
		InsecureLinkedListHelper<Integer> list2 = new InsecureLinkedListHelper<Integer>();
		list.InsertAtFirst(1);
		list.InsertAtLast(2);
		list.InsertAtLast(3);
		list.InsertAtLast(4);
		list.InsertAtLast(5);
		list.InsertAtLast(6);
		list.InsertAtLast(7);
		list.printElements();
		list2.InsertAtFirst(11);
		list2.InsertAtFirst(22);
		list2.InsertAtFirst(33);
		//list2.printElements();
		//MergedList<Integer> mergedList=new MergedList<Integer>();
		//mergedList.process(list,list2, 2);
		//ReverseListIteratively reverse=new ReverseListIteratively(list);
		//reverse.process(list.getHead());
		//ReverseListRecursively recursive=new ReverseListRecursively(list);
		//recursive.process(list.getHead());
		//list.printElements();
		//list2.printElements();
		//MergePoint<Integer> mergePoint=new MergePoint<Integer>();
		//mergePoint.process(mergedList);
		ListPairSwap<Integer> swap=new ListPairSwap<Integer>();
		swap.process(list);
		list.printElements();
	}
}
