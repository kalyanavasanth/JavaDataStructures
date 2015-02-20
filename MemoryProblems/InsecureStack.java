package MemoryProblems;
public class InsecureStack<T1> extends InsecureLinkedListHelper<T1>{
	
	/**
	 * @param element is the element to be pushed into the stack
	 */
	private int count;
	InsecureLinkedListHelper<T1> list;
	CustomizedIterator<T1> ite;
	public InsecureStack(){
		list=new InsecureLinkedListHelper<T1>();
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
	
	public void printStack(){ //prints stack elements
		list.printElements();
	}
	public T1 getTop(){         // print top element of stack
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
	
	public int numElements(){  //return number of elements in stack
		return count;
	}
	
	
	public InsecureLinkedListHelper<T1>.Node getBottom(){
		if(list.isEmpty()){
			return null;
		}
		else{
			return list.getHead();
		}
	}
	
	public boolean Empty(){
		if(list.isEmpty()){
		return true;
		}
		else{
			return false;
		}
	}
}