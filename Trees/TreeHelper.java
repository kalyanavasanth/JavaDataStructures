package Trees;

import LinkedList.*;
import MemoryProblems.*;

/**
 * @author Kalyana Vasanth Akondi
 *
 * @param <T>
 *            is the type of variable that the tree holds
 */
public class TreeHelper<T> {
	public class Node {
		private T data; // Data held by node
		private Node left; // Link to left child
		private Node right; // Link to right child

		/**
		 * Constructor initializes the left and right children and the data to
		 * null
		 */
		public Node() {
			data = null;
			left = right = null;
		}

		/**
		 * @return left child
		 */
		public Node GetLeft() {
			return left;
		}

		/**
		 * @return right child
		 */
		public Node GetRight() {
			return right;
		}

		/**
		 * @param _left
		 *            is the reference to left child
		 */
		public void SetLeft(Node _left) {
			left = _left;
		}

		/**
		 * @param _right
		 *            is the reference to right child
		 */
		public void SetRight(Node _right) {
			right = _right;
		}

		/**
		 * @return true if the node has a left child
		 */
		public boolean HasLeft() {
			if (left != null) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @return true if the node has a right child
		 */
		public boolean HasRight() {
			if (right != null) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @return data held by the node
		 */
		public T GetData() {
			return data;
		}

		/**
		 * @param _data
		 *            sets the data held by node
		 */
		public void SetData(T _data) {
			data = _data;
		}
	}

	private Node root;

	/**
	 * constructor initializes tree to null
	 */
	public TreeHelper() {
		root = null;
	}

	/**
	 * Method to create a new node, set it's data and return the created node
	 * 
	 * @param _data
	 *            is the data to be held by the new node
	 * @return created node
	 */
	public Node CreateNode(T _data) {
		Node NewNode = new Node();
		NewNode.SetData(_data);
		return NewNode;
	}

	/**
	 * @return root element
	 */
	public Node GetRoot() {
		return root;
	}

	/**
	 * @param _root
	 *            is reference to root element
	 */
	public void SetRoot(Node _root) {
		root = _root;
	}

	/**
	 * @param _root
	 *            is the reference to the root element with respect to which,
	 *            pre-order traversal has to be computed
	 */
	public void PreOrderTraversal(Node _root) {
		if (_root == null) {
			return;
		}
		/*
		 * Print root elementRecursively compute pre-order of left sub-tree
		 * Recursively compute Pre-order of right sub-tree
		 */
		System.out.println(_root.GetData());
		PreOrderTraversal(_root.GetLeft());
		PreOrderTraversal(_root.GetRight());
	}

	public void InOrderTraversal(Node _root) {
		if (_root == null) {
			return;
		}
		/*
		 * Recursively compute In-order of left sub-treePrint root element
		 * Recursively compute In-order of right sub-tree
		 */
		InOrderTraversal(_root.GetLeft());
		System.out.println(_root.GetData());
		InOrderTraversal(_root.GetRight());
	}

	public void PostOrderTraversal(Node _root) {
		if (_root == null) {
			return;
		}
		/*
		 * Recursively compute Post-order of left sub-treeRecursively compute
		 * Post-order of right sub-treePrint root element
		 */
		PostOrderTraversal(_root.GetLeft());
		PostOrderTraversal(_root.GetRight());
		System.out.println(_root.GetData());
	}

	/**
	 * @param _root
	 *            is reference of the root element with respect to which tree's
	 *            height has to be computed
	 * @return height of the tree.
	 */
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

	public int TreeSize() {
		InsecureStack<Node> stack = new InsecureStack<Node>();
		stack.push(root);
		int size = 0;
		if (root == null) {
			return 0;
		}
		size = 1;
		if (root.GetRight() == null && root.GetLeft() == null) {
			return size;
		}
		InsecureLinkedListHelper<Node>.Node current = stack.getBottom();
		while (true) {
			if (current.getData().GetLeft() != null) {
				stack.push(current.getData().GetLeft());
			}
			if (current.getData().GetRight() != null) {
				stack.push(current.getData().GetRight());
			}
			if (current.getNext() != null) {
				current = current.getNext();
				++size;
			} else {
				break;
			}
		}
		return size;
	}

	public int RecursiveTreeSize(Node _root) {
		if (_root == null) {
			return 0;
		} else if (_root.GetLeft() == null && _root.GetRight() == null) {
			return 1;
		} else {
			int LeftSize = RecursiveTreeSize(_root.GetLeft());
			int RightSize = RecursiveTreeSize(_root.GetRight());
			return (LeftSize + RightSize) + 1;
		}
	}

	public int LevelWidth(Node _root, int _level) {
		if (_root == null) {
			return 0;
		}
		if (_level == 1) {
			return 1;
		}
		int LeftCount = LevelWidth(_root.GetLeft(), _level - 1);
		int RightCount = LevelWidth(_root.GetRight(), _level - 1);
		return (LeftCount + RightCount);
	}

	public int TreeMaxWidth() {
		Node _root = root;
		int MaxCount = 0;
		int height = TreeHeight(_root);
		int LevelCount = 0;
		for (int level = 1; level <= height; ++level) {
			LevelCount = LevelWidth(_root, level);
			if (LevelCount > MaxCount) {
				MaxCount = LevelCount;
			}
		}
		return MaxCount;
	}

	public void GenerateMirrorTree(Node _root) {
		if (_root == null) {
			return;
		}
		Node LeftNode = _root.GetLeft();
		Node RightNode = _root.GetRight();
		Node Temp = null;
		GenerateMirrorTree(LeftNode);
		GenerateMirrorTree(RightNode);
		Temp = LeftNode;
		LeftNode = RightNode;
		RightNode = Temp;
		_root.SetLeft(LeftNode);
		_root.SetRight(RightNode);
	}

	public void NodeInfo() {
		Node _root = root;
		int HalfNodes = 0, FullNodes = 0, LeafNodes = 0;
		Queue<Node> queue = new Queue<Node>();
		if (_root == null) {
			return;
		}
		queue.enqueue(root);
		while (true) {
			int flag = 0;
			Node temp = queue.dequeueGet();
			if (temp.GetLeft() != null) {
				queue.enqueue(temp.GetLeft());
				++flag;
			}
			if (temp.GetRight() != null) {
				queue.enqueue(temp.GetRight());
				++flag;
			}
			if (flag == 0) {
				++LeafNodes;
			}
			if (flag == 1) {
				++HalfNodes;
			}
			if (flag == 2) {
				++FullNodes;
			}
			if (queue.isEmpty()) {
				break;
			}
		}
		System.out.println("Leaf Nodes:" + LeafNodes);
		System.out.println("Full Nodes:" + FullNodes);
		System.out.println("Half Nodes:" + HalfNodes);
	}

	public int TreeDiameter(Node _root) {
		if (_root == null) {
			return 0;
		}
		int LeftHeight = TreeHeight(_root.GetLeft());
		int RightHeight = TreeHeight(_root.GetRight());
		int LeftDiameter = TreeDiameter(_root.GetLeft());
		int RightDiameter = TreeDiameter(_root.GetRight());
		int MaxHeight = LeftHeight + RightHeight + 1;
		int MaxDiameter = (LeftDiameter > RightDiameter) ? LeftDiameter
				: RightDiameter;
		return (MaxHeight > MaxDiameter) ? MaxHeight : MaxDiameter;
	}

	public boolean HasIdenticalStructure(Node _root1, Node _root2) {
		if (_root1 == null && _root2 == null) {
			return true;
		}
		if (_root1 == null || _root2 == null) {
			return false;
		}
		boolean left = HasIdenticalStructure(_root1.GetLeft(), _root2.GetLeft());
		boolean right = HasIdenticalStructure(_root1.GetRight(),
				_root2.GetRight());

		return (left && right);
	}

	public boolean IsFoldable(Node _root) {
		if (_root == null) {
			return true;
		}
		GenerateMirrorTree(_root.GetLeft());
		if (HasIdenticalStructure(_root.GetLeft(), _root.GetRight())) {
			GenerateMirrorTree(_root.GetLeft());
			return true;
		} else {
			return false;
		}
	}
	
	
}