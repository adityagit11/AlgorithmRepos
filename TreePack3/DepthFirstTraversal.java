package TreePack3;

public class DepthFirstTraversal 
{
	public static void preOrder(Node root)
	{
		if(root==null)
			return;
		else
		{
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void inOrder(Node root)
	{
		if(root==null)
			return;
		else
		{
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
	public static void postOrder(Node root)
	{
		if(root==null)
			return;
		else
		{
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
		}
	}
}
