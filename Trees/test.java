package Trees;

public class test {
	public static void main(String args[]){
		TreeHelper<Integer> tree=new TreeHelper<Integer>();
		TreeHelper<Integer>.Node root=tree.CreateNode(1);
		tree.SetRoot(root);
		root.SetLeft(tree.CreateNode(2));
		root.SetRight(tree.CreateNode(3));
		root.GetLeft().SetLeft(tree.CreateNode(4));
		root.GetLeft().SetRight(tree.CreateNode(5));
		root.GetRight().SetLeft(tree.CreateNode(6));
		root.GetRight().SetRight(tree.CreateNode(7));
		//System.out.println(tree.MaxElement());
		//System.out.println(tree.MaxRecursive(root));
		//tree.PreOrder();
		System.out.println(tree.TreeSize());
	}
}