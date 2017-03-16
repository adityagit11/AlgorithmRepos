package TreePack4;

/*
Given a binary tree, print boundary nodes of the binary tree AntiClockwise
starting from the root. For example,
boundary traversal of the following tree is “20 8 4 10 14 25 22”
		20
	  /    \
	 8     22
	/ \      \
   4  12     25
     /  \
   10   14

*/
public class BoundaryTraversal
{
	public static void run(Node root)
	{
		// step one printing all left side node without leftmost leaf node
		printLeftSide(root);
		printLeaf(root);
		printRightSide(root);
	}
	private static void printLeftSide(Node root)
	{
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
			return;
		else
		{
			System.out.print(root.data+" ");
			printLeftSide(root.left);
		}
	}
	private static void printLeaf(Node root)
	{
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
			System.out.print(root.data+" ");
		else
		{
			printLeaf(root.left);
			printLeaf(root.right);
		}
	}
	private static void printRightSide(Node root)
	{
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
			return;
		else
		{
			printRightSide(root.right);
			System.out.print(root.data+" ");
		}
	}
}
