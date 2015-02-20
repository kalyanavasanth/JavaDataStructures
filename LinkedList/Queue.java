package LinkedList;

/**
 * @author SESA366034
 *
 * Queue implementation of Linked List
 */
public class Queue<T1> extends LinkedListHelper<T1>{
	
	
	LinkedListHelper<T1> list=new LinkedListHelper<T1>();
	CustomizedIterator<T1> iterator;

	/**
	 * @param element is the element to be added to the queue
	 */
	public void enqueue(T1 element)
	{
		list.InsertAtLast(element);
	}
	public void dequeue()        //remove element from first(Dequeue)
	{
		if(list.isEmpty()){
			System.out.println("Queue is empty");
		}
		list.DeleteAtFirst();
	}
	
	public int getSize(){        //returns queue size
		return list.getCount();
	}
	
	public void printQueue(){  //prints the queue elements
		list.printElements();
	}
		
	
	public T1 dequeueGet()
	{
		iterator=list.iterator();
		if(list.isEmpty()){
			System.out.println("Queue is empty");
			return null;
		}
		else{
		T1 temp=iterator.getValue();
		list.DeleteAtFirst();
		return temp;
		}
	}
	
	public boolean isEmpty(){
		if(list.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	
}
