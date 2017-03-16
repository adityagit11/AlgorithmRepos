package TreePack4;

public class WhetherSubTree
{
	public static boolean run(Node r1, Node r2)
	{
		//assuming the r2 != null
		if(r1==null)
			return false;
		if(r1.data==r2.data)
			return compareTree(r1, r2);
		else
			return run(r1.left, r2)||run(r1.right, r2);
	}
	private static boolean compareTree(Node root1, Node root2)
	{
		if(root1==null&&root2==null)
			return true;
		if((root1==null&&root2!=null)||(root1!=null&&root2==null))
			return false;
		if(root1.data==root2.data)
			return true;
		else
			return compareTree(root1.left, root2.left)&&compareTree(root1.right, root2.right);
	}
}
