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
		//FindingLoop<Integer> LoopProb = new FindingLoop<Integer>();
		//LoopProb.CreateLoopAt(list, 2);
		//System.out.println(LoopProb.CheckForLoop(list));
		list.printElements();
		ReverseListIteratively reverse=new ReverseListIteratively();
		reverse.process(list);
	}
}
