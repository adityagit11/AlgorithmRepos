package TreePack4;

public class CountLeaf
{
	//method 2
	public static int count_var = 0;
	public static int run_withGlobalVar(Node root)
	{
		countLeaf(root);
		return count_var;
	}
	private static void countLeaf(Node root)
	{
		//used by run_usingGlobalVar() method
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
			count_var++;
		else
		{
			countLeaf(root.left);
			countLeaf(root.right);
		}
	}
	
	
	//method 2 - without global variable
	public static int run_withoutGlobalVar(Node root)
	{
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return 1;
		else
		{
			int lCount = run_withoutGlobalVar(root.left);
			int rCount = run_withoutGlobalVar(root.right);
			return lCount+rCount;
		}
	}
}
