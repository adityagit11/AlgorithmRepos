package TreePack4;

public class PrintLeftView
{
	public static void run(Node root)
	{
		int h = BreadthFirstTraversal.height(root);
		for(int i = 0;i<=h;i++)
			printFirstNode(root, i, 0);
	}
	private static void printFirstNode(Node root, int level, int count)
	{
		if(root==null)
			return;
		if(level==0&&count==0)
		{
			System.out.println(root.data);
			count++;
		}
		else
		{
			printFirstNode(root.left, level-1, 0);
			printFirstNode(root.right, level-1, 0);
		}
	}
}
