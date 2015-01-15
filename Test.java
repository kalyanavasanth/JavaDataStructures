import java.io.IOException;

public class Test {
public static void main(String args[]) throws IOException
{
	LinkedListHelper<Integer> l=new LinkedListHelper<Integer>();
	/*l.processInput(l.getFromFile("C:/Users/SESA366034/Documents/input.txt"));
	System.out.println("Head Element:"+l.getHead().getData());
	System.out.println("Number of elements:"+l.getCount(l.getHead()));
	l.printElements(l.getHead());*/
	/*l.DeleteAtFirst(l.getHead());
	l.printElements(l.getHead());
	l.DeleteAtLast(l.getHead());
	l.printElements(l.getHead());*/
	l.InsertAtFirst(100);
	l.InsertAtFirst(110);
	l.InsertAtFirst(120);
	l.InsertAtFirst(130);
	l.InsertAtFirst(140);
	l.InsertAtLast(144);
	l.InsertAtFirst(50);
	l.printElements();
	Stack<Integer> st=new Stack<Integer>();
	st.push(44);
	st.push(55);
	st.push(66);
	st.pop();
	st.pop();
	st.pop();
	st.push(1000);
	st.printStack();
	Queue<Integer> qu=new Queue<Integer>();
	qu.enqueue(11);
	qu.enqueue(12);
	qu.enqueue(13);
	qu.dequeue();
	//st.printElements(st.getHead());
	//qu.printElements(qu.getHead());	
	MiddleElement<Integer> prob=new MiddleElement<Integer>();
	System.out.println("Mid Element:"+ prob.process(l));
	nFromLast<Integer> prob1=new nFromLast<Integer>();
	prob1.process(l, 3);
	Parenthesis prob2=new Parenthesis();
	System.out.println("Parenthesis balance?: "+prob2.process(")((())"));
}
}
