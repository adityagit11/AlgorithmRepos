package TreePack4;

public class PrintAncestors
{
	//Without extra space for array
	public static boolean run2(Node root, int key)
	{
		if(root==null)
			return false;
		if(root.data==key)
			return true;
		else
		{
			if(run2(root.left, key)||run2(root.right, key))
			{
				System.out.print(root.data+" ");
				return true;
			}
			return false;
		}
	}
	
	//With extra space for array
	public static void run(Node root, int key)
	{
		int[] ar = new int[10];
		int index = 0;
		print(root, key, ar, index);
	}
	private static void print(Node root, int key, int[] ar, int index)
	{
		if(root==null)
			return;
		if(root.data==key)
		{
			for(int i = 0;i<index;i++)
				System.out.print(ar[i]+" ");
			System.out.println();
		}
		else
		{
			ar[index++] = root.data;
			print(root.left, key, ar, index);
			print(root.right, key, ar, index);
		}
	}
}
