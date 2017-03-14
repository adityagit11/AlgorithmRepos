package TreePack4;

public class WhetherFoldable
{
	public static boolean run(Node root)
	{
		Node lTree = root.left;
		Node rTree = root.right;
		
		//algorithm is to convert the lTree to it's mirror tree
		lTree = convertToMirrorTree(lTree);
		return whetherSame(lTree, rTree);
	}
	private static boolean whetherSame(Node root1, Node root2)
	{
		if(root1==null&&root2==null)
			return true;
		else
		{
			return root1!=null&&root2!=null&&whetherSame(root1.left, root2.left)&&whetherSame(root1.right, root2.right);
		}
	}
	private static Node convertToMirrorTree(Node root)
	{
		if(root==null)
			return root;
		else
		{
			convertToMirrorTree(root.left);
			convertToMirrorTree(root.right);
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
			return root;
		}
	}	
}
