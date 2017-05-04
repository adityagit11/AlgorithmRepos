package TreePack3;

public class RootToLeafPath 
{
	public static void run(Node root)
	{
		Node[] ar = new Node[10];
		int index = 0;
		printPath(root, ar, index);
	}
	
	private static void printPath(Node root, Node[] ar, int index)
	{
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
		{
			ar[index++] = root;
			for(int i = 0;i<index;i++)
				System.out.print(ar[i].data+" ");
			System.out.println();
		}
		else
		{
			ar[index++] = root;
			printPath(root.left, ar, index);
			printPath(root.right, ar, index);
		}
	}

}
