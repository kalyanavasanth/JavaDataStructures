package Trees;

import LinkedList.*;
import MemoryProblems.*;
public class TreeHelper<T> {
	public class Node {
		private T data;
		private Node left;
		private Node right;

		public Node() {
			data = null;
			left = right = null;
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

	public TreeHelper() {
		root = null;
	}

	public Node CreateNode(T _data) {
		Node NewNode = new Node();
		NewNode.SetData(_data);
		return NewNode;
	}

	public Node GetRoot() {
		return root;
	}

	public void SetRoot(Node _root) {
		root = _root;
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

	public int TreeHeight(Node _root) {
		if (_root == null) {
			return 0;
		}
		int LeftHeight = TreeHeight(_root.GetLeft());
		int RightHeight = TreeHeight(_root.GetRight());
		if (LeftHeight > RightHeight) {
			return (LeftHeight + 1);
		} else {
			return (RightHeight + 1);
		}
	}

	public void PrintLevel(Node _root, int _level) {
		if (_root == null) {
			return;
		} else if (_level == 1) {
			System.out.println(_root.GetData());
		} else {
			PrintLevel(_root.GetLeft(), _level - 1);
			PrintLevel(_root.GetRight(), _level - 1);
		}
	}

	public void LevelOrderTraversal() {
		int height = TreeHeight(root);
		for (int level = 1; level <= height; ++level) {
			PrintLevel(root, level);
		}
	}

	public int MaxElement() {
		Queue<Node> queue = new Queue<Node>();
		Node current = root;
		Node PrintNode;
		int MaxElement;
		if (root == null) {
			return -1;
		}
		queue.enqueue(current);
		MaxElement = (int) current.GetData();
		while (true) {
			PrintNode = queue.dequeueGet();
			if (PrintNode.GetLeft() != null) {
				current = PrintNode.GetLeft();
				if ((int) current.GetData() > MaxElement) {
					MaxElement = (int) current.GetData();
				}
				queue.enqueue(current);
			}
			if (PrintNode.GetRight() != null) {
				current = PrintNode.GetRight();
				if ((int) current.GetData() > MaxElement) {
					MaxElement = (int) current.GetData();
				}
				queue.enqueue(current);
			}
			if (queue.getSize() == 0) {
				break;
			}
		}
		return MaxElement;
	}

	public int MaxRecursive(Node _root) {
		if (_root == null) {
			return 0;
		}
		int current = (int) _root.GetData();
		int left = MaxRecursive(_root.GetLeft());
		int right = MaxRecursive(_root.GetRight());
		return (left > right) ? left : ((right > current) ? right : current);
	}

	public void PreOrder() {
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (true) {
			Node temp = stack.getTop();
			System.out.println(temp.GetData());
			stack.pop();
			if (temp.GetRight() != null) {
				stack.push(temp.GetRight());
			}
			if (temp.GetLeft() != null) {
				stack.push(temp.GetLeft());
			}
			if (stack.Empty()) {
				break;
			}
		}
	}

	/**public int TreeSize() {
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		int size=0;
		if(root==null){
			return size;
		}
		size=1;
		while (true) {
			CustomizedIterator<Node> ite = stack.iterator();
			Node current = ite.getValue();
			if (ite.hasNext()) {
				ite.next();
				++size;
			}
			else{
				break;
			}
			if (current.GetLeft() != null){
			stack.push(current.GetLeft());
			}
			if (current.GetRight() != null){
			stack.push(current.GetRight());
			}
		}
		return size;
	}**/

}