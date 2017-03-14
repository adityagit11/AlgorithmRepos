package TreePack4;

public class PrintPath
{
	public static void run(Node root)
	{
		int index = 0;
		Node[] ar = new Node[10];
		printEachPath(root, ar, index);
	}
	private static void printEachPath(Node root, Node[] ar, int index)
	{
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
		{
			ar[index++] = root;
			for(int i = 0;i<index;i++)
			{
				System.out.print(ar[i].data+" ");
			}
			System.out.println();
		}
		else
		{
			ar[index++] = root;
			printEachPath(root.left, ar, index);
			printEachPath(root.right, ar, index);
		}
	}
}
