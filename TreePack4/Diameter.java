package TreePack4;

public class Diameter
{
	public static int maxCount = Integer.MIN_VALUE;
	public static int run(Node root)
	{
		if(root==null)
			return -1;
		else
		{
			run(root.left);
			run(root.right);
			int lHeight = height(root.left);
			int rHeight = height(root.right);
			if(lHeight==-1)
				lHeight = 0;
			if(rHeight == -1)
				rHeight = 0;
			if((lHeight+rHeight+3)>maxCount)
				maxCount = lHeight+rHeight+3;
			return maxCount;
		}
	}
	private static int height(Node root)
	{
		if(root==null)
			return -1;
		else
		{
			int lTree = height(root.left);
			int rTree = height(root.right);
			return Math.max(lTree, rTree)+1;
		}
	}
}
