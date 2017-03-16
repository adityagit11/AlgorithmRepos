package TreePack4;

public class ReturnMaximum
{
	public static int run(Node root)
	{
		if(root==null)
			return Integer.MIN_VALUE;
		else
		{
			int lData = run(root.left);
			int rData = run(root.right);
			return Math.max(root.data, Math.max(lData, rData));
		}
	}
}
