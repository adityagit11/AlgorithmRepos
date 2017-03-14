package TreePack4;

public class WhetherHeightBalanced
{
	public static boolean run(Node root)
	{
		if(root==null)
			return true;
		else
		{
			int diff = Math.abs(height(root.left)-height(root.right));
			return run(root.left)&&run(root.right)&&(diff<=1);
		}
	}
	private static int height(Node root)
	{
		if(root==null)
			return -1;
		else
		{
			return Math.max(height(root.left), height(root.right))+1;
		}
	}
}
