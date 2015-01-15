public class Stack<T1> extends LinkedListHelper<T1>{
	
	/**
	 * @param element is the element to be pushed into the stack
	 */
	private int count;
	LinkedListHelper<T1> list;
	CustomizedIterator<T1> ite;
	Stack(){
		list=new LinkedListHelper<T1>();
		count=0;
	}
	public void push(T1 element){ //to push element to top of the stack   
		list.InsertAtLast(element);
		++count;
	}
	public void pop(){  // to remove top element from stack
		if(list.isEmpty()){
			System.out.println("List is empty");
		}
		else{
		list.DeleteAtLast();
		}
		--count;
	}
	
	public void printStack(){
		list.printElements();
	}
	public T1 getTop(){
		if(list.isEmpty()){
			return null;
		}
		else{
		ite=list.iterator();
		while(ite.hasNext()){
			ite.next();
		}
		return ite.getValue();
		}
	}
	
	public int numElements(){
		return count;
	}
}