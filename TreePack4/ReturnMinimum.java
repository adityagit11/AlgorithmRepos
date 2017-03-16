package TreePack4;

public class ReturnMinimum
{
	public static int run(Node root)
	{
		if(root==null)
			return Integer.MAX_VALUE;
		else
		{
			int lData = run(root.left);
			int rData = run(root.right);
			return Math.min(root.data, Math.min(lData, rData));
		}
	}
}
