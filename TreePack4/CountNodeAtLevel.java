package TreePack4;

public class CountNodeAtLevel
{
	public static int run(Node root, int k)
	{
		if(root==null)
			return 0;
		if(k==0)
			return 1;
		else
			return run(root.left, k-1) + run(root.right, k-1);
	}
}
