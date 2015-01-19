package Problems;

import LinkedList.*;

/**
 * @author SESA366034 Main method for testing the problems
 */
public class Test {
	public static void main(String args[]) {
		LinkedListHelper<Integer> list = new LinkedListHelper<Integer>();
		list.InsertAtFirst(10);
		list.InsertAtFirst(20);
		list.InsertAtFirst(30);
		list.InsertAtFirst(40);
		list.InsertAtFirst(50);
		list.InsertAtFirst(60);
		/** printing the list **/
		list.printElements();
		/** testing the mid element problem **/
		MiddleElement<Integer> mid = new MiddleElement<Integer>();
		System.out.println("Mid element is: " + mid.process(list));
		/** testing the nth element from last problem **/
		nFromLast<Integer> n_from_last = new nFromLast<Integer>();
		n_from_last.process(list, 3);
		/** testing the parenthesis problem **/
		Parenthesis parenthesis_problem = new Parenthesis();
		System.out.println("Do the parenthesis balance?-"
				+ parenthesis_problem.process("(()())"));
		/** testing the circle problem **/
		CircleProblem circle_problem=new CircleProblem();
		System.out.println("The winner is:");
		circle_problem.process(8,2);
		/** testing the stack **/
		Stack<Integer> MyStack = new Stack<Integer>();
		MyStack.push(100);
		MyStack.push(200);
		MyStack.push(300);
		MyStack.push(400);
		MyStack.push(500);
		MyStack.pop();
		MyStack.pop();
		MyStack.pop();
		System.out.println("The stack elements are:");
		MyStack.printStack();
		/** testing the queue **/
		Queue<Integer> MyQueue = new Queue<Integer>();
		MyQueue.enqueue(11);
		MyQueue.enqueue(22);
		MyQueue.enqueue(33);
		MyQueue.enqueue(44);
		MyQueue.enqueue(55);
		MyQueue.enqueue(66);
		MyQueue.dequeue();
		MyQueue.dequeue();
		System.out.println("The queue elements are:");
		MyQueue.printQueue();
	}
}
