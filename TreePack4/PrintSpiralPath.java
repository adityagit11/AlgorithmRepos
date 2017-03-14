package TreePack4;

public class PrintSpiralPath
{
	public static void run2(Node root)
	{
		//this method is without the use of array
		int h = BreadthFirstTraversal.height(root);
		int flag = 0;
		for(int i = 0;i<=h;i++)
		{
			if(i%2==0)
				flag = 1;
			else
				flag = 0;
			printLevel(root, i, flag);
		}
	}
	private static void printLevel(Node root, int level, int flag)
	{
		if(root==null)
			return;
		if(level==0)
			System.out.print(root.data+" ");
		else
		{
			if(flag==1)
			{
				printLevel(root.left, level-1, flag);
				printLevel(root.right, level-1, flag);
			}
			else
			{
				printLevel(root.right, level-1, flag);
				printLevel(root.left, level-1, flag);
			}
		}
	}
}
