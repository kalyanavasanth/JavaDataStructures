
public class MiddleElement<T1> {
	public T1 process(LinkedListHelper<T1> list){
	CustomizedIterator<T1> slow=list.iterator();
	CustomizedIterator<T1> fast=list.iterator();
	
	while(fast.hasNext())
	{
		slow.iterate(1);
		fast.iterate(2);
	}
	return slow.getValue();
}
}