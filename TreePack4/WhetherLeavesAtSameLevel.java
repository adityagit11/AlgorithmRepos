package TreePack4;

public class WhetherLeavesAtSameLevel
{
	public static boolean run(Node root)
	{
		/*
		 * alpha variable stores the height of the leftmost leaf node*/
		int alpha = heightOfLeftMostLeafNode(root);
		return compareLeafNode(root, 0, alpha);
	}
	private static boolean compareLeafNode(Node root, int level, int alpha)
	{
		if(root==null)
			return true;
		if(root.left==null&&root.right==null)
			return level==alpha;
		else
			return compareLeafNode(root.left, level+1, alpha)&&compareLeafNode(root.right, level+1, alpha);
	}
	private static int heightOfLeftMostLeafNode(Node root)
	{
		if(root==null)
			return -1;
		else
		{
			return heightOfLeftMostLeafNode(root.left)+1;
		}
	}
}