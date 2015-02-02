package Trees;
import Trees.TreeHelper.Node;

public class test {
	public static void main(String args[]){
		TreeHelper<Integer> tree=new TreeHelper<Integer>();
		TreeHelper<Integer>.Node root=tree.CreateNode(1);
		root.SetLeft(tree.CreateNode(2));
		root.SetRight(tree.CreateNode(3));
		tree.PostOrder(root);
	}
}
