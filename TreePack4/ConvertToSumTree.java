package TreePack4;

public class ConvertToSumTree
{
	public static int run(Node root)
	{
		if(root==null)
			return 0;
		int old_node = root.data;
		root.data = run(root.left)+run(root.right);
		return root.data+old_node;
	}
}
