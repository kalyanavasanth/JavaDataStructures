package MemoryProblems;

public class Test {
	public static void main(String args[]) {
		InsecureLinkedListHelper<Integer> list = new InsecureLinkedListHelper<Integer>();
		list.InsertAtFirst(100);
		list.InsertAtFirst(200);
		list.InsertAtFirst(300);
		list.InsertAtFirst(400);
		list.InsertAtFirst(500);
		list.InsertAtFirst(600);
		list.printElements();
		ReverseListIteratively reverse=new ReverseListIteratively(list);
		reverse.process(list.getHead());
		//ReverseListRecursively recursive=new ReverseListRecursively(list);
		//recursive.process(list.getHead());
		list.printElements();
	}
}
