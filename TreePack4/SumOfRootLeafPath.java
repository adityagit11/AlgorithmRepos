package TreePack4;

public class SumOfRootLeafPath
{
	public static int run(Node root)
	{
		return getSum(root, "");
	}
	private static int getSum(Node root, String s)
	{
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
		{
			s += root.data;
			int ans = Integer.parseInt(s);
			return ans;
		}
		else
		{
			s += root.data;
			return getSum(root.left, s)+getSum(root.right, s);
		}
	}
}
