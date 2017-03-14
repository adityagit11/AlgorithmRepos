package TreePack4;

public class MaxWidth 
{
	//method 1
	private static int count = 0;
	public static int run(Node root)
	{
		int h = BreadthFirstTraversal.height(root);
		int maxCount = 0;
		for(int i = 0;i<=h;i++)
		{
			count = 0;
			countNode(root, i);
			if(count>maxCount)
				maxCount = count;
		}
		return maxCount;
	}
	private static void countNode(Node root, int level)
	{
		if(root==null)
			return;
		if(level==0)
		{
			count++;
		}
		else
		{
			countNode(root.left, level-1);
			countNode(root.right, level-1);
		}
	}
	
	//method 2
	public static int run2(Node root)
	{
		int h = BreadthFirstTraversal.height(root);
		int maxCount = 0;
		for(int i = 0;i<=h;i++)
		{
			int count = countNode2(root,i);
			if(count>maxCount)
			{
				maxCount = count;
			}
		}
		return maxCount;
	}
	private static int countNode2(Node root, int level)
	{
		if(root==null)
			return 0;
		if(level==0)
			return 1;
		else
		{
			return countNode2(root.left,level-1)+countNode2(root.right, level-1);
		}
	}
}