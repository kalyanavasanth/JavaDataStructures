
public class Queue<T1> extends LinkedListHelper<T1>{
	
	//name convention 
	LinkedListHelper<T1> ll;
	CustomizedIterator<T1> ci;

	public void enqueue(T1 element)
	{
		InsertAtLast(element);
	}
	public void dequeue()
	{
		if(isEmpty()){
			System.out.println("Queue is empty");
			//NosuchElementExceptions
		}
		DeleteAtFirst();
	}
	
	//size method
	
	
	public T1 dequeueGet()
	{
		ll=new LinkedListHelper<T1>();
		ci=ll.iterator();
		if(isEmpty()){
			System.out.println("Queue is empty");
			return temp;
		}
		else{
		T1 temp=ci.getValue();
		DeleteAtFirst();
		return temp;
		}
	} 
	
}
