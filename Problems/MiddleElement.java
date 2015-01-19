package Problems;
import LinkedList.*;

/**
 * @author SESA366034
 *
 * Finding middle element in a LinkedList
 */
public class MiddleElement<T1> {
	public T1 process(LinkedListHelper<T1> list){
	CustomizedIterator<T1> slow=list.iterator();
	CustomizedIterator<T1> fast=list.iterator();
	
	while(fast.hasNext())
	{
		slow.iterate(1);           //iterate the slow iterator thorough every element
		fast.iterate(2);           //iterate the fast iterator through every alternate element
	}
	return slow.getValue();        //returning slow iterator returns the middle element
}
}