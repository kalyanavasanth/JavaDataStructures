package MemoryProblems;

public class Test {
	public static void main(String args[]) {
		InsecureLinkedListHelper<Integer> list = new InsecureLinkedListHelper<Integer>();
		InsecureLinkedListHelper<Integer> list2 = new InsecureLinkedListHelper<Integer>();
		list.InsertAtFirst(100);
		list.InsertAtFirst(200);
		list.InsertAtFirst(300);
		list.InsertAtFirst(400);
		list.InsertAtFirst(500);
		list.InsertAtFirst(600);
		list.InsertAtFirst(700);
		list.printElements();
		list2.InsertAtFirst(11);
		list2.InsertAtFirst(22);
		list2.InsertAtFirst(33);
		list2.printElements();
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
