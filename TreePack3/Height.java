package TreePack3;

public class Height 
{
	public static int run(Node root)
	{
		if(root==null)
			return -1;
		else
		{
			int lHeight = run(root.left);
			int rHeight = run(root.right);
			return Math.max(lHeight, rHeight)+1;
		}
	}
}
