package LinkedList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author SESA366034
 *
 * @param <T1>
 */
/**
 * @author SESA366034
 *
 * @param <T1>
 */
public class LinkedListHelper<T1> {
	private class Node {
		private T1 data; // Data of a node. It can be of any data type.
		private Node next; // Reference to next node

		Node() {
			next = null; // Initiate reference to null
		}

		/**
		 * @param _data
		 *            is the data to be set in the node
		 * @param _Node
		 *            is the reference of the node whose data is to be set
		 */
		public void setData(T1 _data) { // used to set the data and
													// link to next node

			data = _data;
		}

		/**
		 * @param _node
		 *            is reference of node that has to be added as next node
		 */
		public void setNode(Node _node) { // setter of next node
			next = _node;
		}

		public Node getNext() { // getter that returns next node

			return next;
		}

		public T1 getData() { // getter of data of present node
			return data;
		}

	}

	/**
	 * @author SESA366034
	 *
	 * @param <T>
	 */
	private class LinkListHelperIterator<T> implements CustomizedIterator<T> {

		private Node Ref;

		public LinkListHelperIterator() {
			Ref = getHead();
		}

		@Override
		public boolean hasNext() {
			if (Ref.getNext() != null)
				return true;
			else
				return false;
		}

		@Override
		public T next() {
			T ob = (T) Ref.getData();
			Ref = Ref.getNext();

			return ob;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		@Override
		public void iterate(int n) {
			for (int i = 0; i < n; ++i) {
				Ref = Ref.getNext();
			}
		}

		@Override
		public T getValue() {
			// TODO Auto-generated method stub
			return (T) Ref.getData();
		}

	}


	public CustomizedIterator<T1> iterator() {
		return new LinkListHelperIterator<T1>();
	}

	/**count maintains the count of the LinkedList
	 * 
	 */
	private int count = 0;
	 /** ref is the temporary reference to which head is copied to manipulate the list 
	  * for every operation
	  */
	private Node ref;
	
	/** head reference
	 * Maintains reference to head
	 */
	private Node head;
	/**temporary reference is used to process input from a file into a LinkedList
	 * 
	 */
	private Node temporary;

	public LinkedListHelper() {
		count = 0;
		head = null;
	}

	/**
	 * @param _path is used to specify path of input file
	 * 
	 **/
	public Object[] getFromFile(String _path) throws IOException {
		String filename = _path;
		String content = "";
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader textreader = new BufferedReader(fr);
			content = textreader.readLine();         
			textreader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] inputSplitted = content.split(" "); //split the elements that on either sides of a SPACE
		return inputSplitted;
	}

	/**
	 * @param a is an array of elements read from a file
	 */
	public void processInput(T1[] a) {
		if (head == null) {
			temporary = new Node();
			head = temporary;
		} else {
			temporary = new Node();
		}
		T1[] temp = a;
		count = temp.length;
		for (int i = 0; i < count; ++i) {  //set the node and data of every node
			temporary.setData(temp[i]);
			temporary.setNode(new Node());
			temporary = temporary.getNext();
		}
	}

	public Node getHead() {  //return head element
		return head;
	}

	public int getCount() { //return count of list
		return count;
	}

	public int getCount(Node _head) {
		count = 0;
		ref = _head;
		while (ref.getNext() != null) {
			++count;
			ref = ref.getNext();
		}
		return count;
	}


	public void printElements() { //prints all elements in the list
		ref = head;
		if (ref == null) {
			System.out.println("List is Empty");
		} else {
			while (ref != null) {
				System.out.print("-" + ref.getData());
				ref = ref.getNext();
			}
			System.out.println("");
		}
	}

	public boolean isEmpty() {  //checks if the list is empty
		if (head == null) {
			return true;
		}
		return false;
	}

	/**
	 * @param _data is the data that is held by the node that is to be inserted at first
	 */
	public void InsertAtFirst(T1 _data) {
		if (isEmpty()) {
			head = new Node();
			head.setData(_data);
			head.setNode(null);
		} else {
			ref = head;
			Node tempFirst = new Node();
			tempFirst.setData(_data);
			tempFirst.setNode(head);
			head = tempFirst;
		}
		++count;
	}

	/**
	 * @param _data is the data that is held by the node that is to be inserted at last
	 */
	public void InsertAtLast(T1 _data) {
		if (isEmpty()) {
			head = new Node();
			head.setData(_data);
			head.setNode(null);
		} else {
			ref = head;
			Node tempLast = new Node();
			tempLast.setData(_data);
			tempLast.setNode(null);
			while (ref.getNext() != null) {
				ref = ref.getNext();
			}
			ref.setNode(tempLast);
			;
		}
		++count;
	}

	
	/**
	 * @param _data  is the data that is held by the node that is to be inserted at a given position
	 * @param position is the position number where data is to be inserted
	 */
	public void InsertAtPos(T1 _data, int position) {
		ref = head;
		for (int i = 1; i < position; ++i) {
			ref = ref.getNext();
		}
		Node ref2 = ref.getNext();
		Node tempNode = new Node();
		tempNode.setData(_data);
		tempNode.setNode(ref2);
		ref.setNode(tempNode);
		++count;
	}

	public void DeleteAtFirst() {  //remove element at first
		if (isEmpty()) {
			System.out.println("Nothing to delete as list is empty");
		} else {
			ref = head;
			head = ref.getNext();
		}
		--count;
	}

	public void DeleteAtLast() { //remove element at last
		if (isEmpty()) {
			System.out.println("Nothing to delete as list is empty");
		}
		else if(count==1){
			head=null;
		}
		else {
			ref = head;
			while (ref.getNext().getNext() != null) {
				ref = ref.getNext();
			}
			ref.setNode(null);
		}
		--count;
	}

	/**
	 * @param pos is the position at which element should be deleted
	 */
	public void DeleteAtPos(int pos) { 
		ref = head;
		for (int i = 1; i < pos; ++i) {
			ref = ref.getNext();
		}
		Node ref2 = ref.getNext().getNext();
		ref.setNode(ref2);
		--count;
	}

	public void DeleteAll() {  //deletes all elements in the list
		head = null;
		count = 0;
	}

}