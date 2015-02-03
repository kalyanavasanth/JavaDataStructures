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

	public void PreOrderTraversal(Node _root) {
		if (_root == null) {
			return;
		}
		System.out.println(_root.GetData());
		PreOrderTraversal(_root.GetLeft());
		PreOrderTraversal(_root.GetRight());
	}

	public void InOrderTraversal(Node _root) {
		if (_root == null) {
			return;
		}
		InOrderTraversal(_root.GetLeft());
		System.out.println(_root.GetData());
		InOrderTraversal(_root.GetRight());
	}

	public void PostOrderTraversal(Node _root) {
		if (_root == null) {
			return;
		}
		PostOrderTraversal(_root.GetLeft());
		PostOrderTraversal(_root.GetRight());
		System.out.println(_root.GetData());
	}
	
	public int TreeHeight(Node _root){
		if(_root==null){
			return 0;
		}
		int LeftHeight=TreeHeight(_root.GetLeft());
		int RightHeight=TreeHeight(_root.GetRight());
		if(LeftHeight>RightHeight){
			return (LeftHeight+1);
		}
		else{
			return (RightHeight+1);
		}
	}
	
	public void PrintLevel(Node _root,int _level){
		if(_root==null){
			return;
		}
		else if(_level==1){
			System.out.println(_root.GetData());
		}
		else{
			PrintLevel(_root.GetLeft(), _level-1);
			PrintLevel(_root.GetRight(), _level-1);
		}
	}
	
	public void LevelOrderTraversal(){
		int height=TreeHeight(root);
		for(int level=1;level<=height;++level){
			PrintLevel(root,level);
		}
	}
}