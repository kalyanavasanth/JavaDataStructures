package Trees;

public class test {
	public static void main(String args[]){
		TreeHelper<Integer> tree=new TreeHelper<Integer>();
		TreeHelper<Integer> tree2=new TreeHelper<Integer>();
		
		TreeHelper<Integer>.Node root=tree.CreateNode(5);
		tree.SetRoot(root);
		
		TreeHelper<Integer>.Node root2=tree.CreateNode(1);
		tree2.SetRoot(root2);
		
		root.SetLeft(tree.CreateNode(2));
		root.SetRight(tree.CreateNode(3));
		/*root.GetLeft().SetLeft(tree.CreateNode(4));
		root.GetLeft().SetRight(tree.CreateNode(5));
		root.GetRight().SetLeft(tree.CreateNode(6));
		root.GetRight().SetRight(tree.CreateNode(7));*/
		
		root2.SetLeft(tree2.CreateNode(2));
		root2.SetRight(tree2.CreateNode(3));
		root2.GetLeft().SetLeft(tree2.CreateNode(4));
		root2.GetLeft().SetRight(tree2.CreateNode(5));
		root2.GetRight().SetLeft(tree2.CreateNode(6));
		root2.GetRight().SetRight(tree2.CreateNode(7));
		//System.out.println(tree.MaxElement());
		//System.out.println(tree.MaxRecursive(root));
		//tree.PreOrder();
		//System.out.println(tree.TreeHeight(tree.GetRoot()));
		//System.out.println(tree.TreeMaxWidth());
		//tree.PreOrder();
		//tree.GenerateMirrorTree(tree.GetRoot());
		//tree.PreOrder();
		//System.out.println(tree2.sumSelectedLevels(tree2.GetRoot(),1,2)-tree2.sumSelectedLevels(tree2.GetRoot(),2,2));
		tree2.leftView(root2);
	}
}