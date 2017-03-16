package TreePack4;

public class ReturnLeftLeafSum
{
	public static int run(Node root)
	{
		if(root==null)
			return 0;
		if(root.left!=null&&root.left.left==null&&root.left.right==null)
			return root.left.data + run(root.right);
		else	
		{
			return run(root.left)+run(root.right);
		}
	}
}