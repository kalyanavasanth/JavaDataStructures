package Trees;

public class TreeHelper<T> {
	public class Node {
		private T data;
		private Node left;
		private Node right;
		
		public Node(){
			data=null;
			left=right=null;
		}
		
		public Node GetLeft() {
			return left;
		}

		public Node GetRight() {
			return right;
		}

		public void SetLeft(Node _left) {
			left = _left;
		}

		public void SetRight(Node _right) {
			right = _right;
		}

		public T GetData() {
			return data;
		}

		public void SetData(T _data) {
			data = _data;
		}
	}
		

	private Node root;
	public TreeHelper(){
		root=null;
	}
	
	public Node CreateNode(T _data){
		Node NewNode = new Node();
		NewNode.SetData(_data);
		return NewNode;
	}
	public Node GetRoot(){
		return root;
	}
	
	public void SetRoot(Node _root){
		root=_root;
	}

	public void PreOrder(Node _root) {
		if (_root == null) {
			return;
		}
		System.out.println(_root.GetData());
		PreOrder(_root.GetLeft());
		PreOrder(_root.GetRight());
	}

	public void InOrder(Node _root) {
		if (_root == null) {
			return;
		}
		InOrder(_root.GetLeft());
		System.out.println(_root.GetData());
		InOrder(_root.GetRight());
	}

	public void PostOrder(Node _root) {
		if (_root == null) {
			return;
		}
		PostOrder(_root.GetLeft());
		PostOrder(_root.GetRight());
		System.out.println(_root.GetData());
	}
	
	
}
