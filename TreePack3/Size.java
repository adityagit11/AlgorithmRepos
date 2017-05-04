package TreePack3;

public class Size 
{
	public static int run(Node root)
	{
		if(root==null)
			return 0;
		else
			return run(root.left) + run(root.right) + 1;
	}
}
