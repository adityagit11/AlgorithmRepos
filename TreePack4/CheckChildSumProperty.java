package TreePack4;

public class CheckChildSumProperty
{
	public static boolean run(Node root)
	{
		if(root==null)
			return false;
		else
		{
			run(root.left);
			run(root.right);
			int lNode = 0, rNode = 0;
			if(root.left!=null)
				lNode = root.left.data;
			if(root.right!=null)
				rNode = root.right.data;
			return root.data==(lNode+rNode);
		}
	}
}
