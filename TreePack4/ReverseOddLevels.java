package TreePack4;

/*
 * Given a Perfect Binary Tree, reverse the alternate level nodes of the binary tree.
			Given tree:
			 a
		   /   \
		  b      c
		 / \    /  \
	    d  e    f   g
      / \ / \  / \  / \
     h  i j  k l  m n  o
			
			Modified tree:
			a
			/ \
			c b     -----> Reversed
			/ \ / \
			d e f g
			/ \ / \ / \ / \
			o n m l k j i h ---------------> Reversed

*/

public class ReverseOddLevels
{
	public static void run(Node root)
	{
		int h = BreadthFirstTraversal.height(root);
		int[] ar = new int[10];
		for(int i = 0;i<=h;i++)
		{
			if(i%2!=0)
			{
				index = 0;
				storeLevel(root, i, ar);
				for(int j = 0,k=index-1;j<=k;j++,k--)
				{
					int temp = ar[j];
					ar[j] = ar[k];
					ar[k] = temp;
				}
				index = 0;
				restoreLevel(root, i, ar);
			}
		}
	}
	private static int index = 0;
	private static void storeLevel(Node root, int level, int[] ar)
	{
		if(root==null)
			return;
		if(level==0)
			ar[index++] = root.data;
		else
		{
			storeLevel(root.left, level-1, ar);
			storeLevel(root.right, level-1, ar);
		}
	}
	private static void restoreLevel(Node root, int level, int[] ar)
	{
		if(root==null)
			return;
		if(level==0)
			root.data= ar[index++];
		else
		{
			restoreLevel(root.left, level-1, ar);
			restoreLevel(root.right, level-1, ar);
		}
	}
}