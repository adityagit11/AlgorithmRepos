package TreePack4;

class GTLPnode
{
	int data;
	GTLPnode left;
	GTLPnode right;
	GTLPnode next;
	GTLPnode(int data)
	{
		this.data = data;
		this.left = this.right = this.next = null;
	}
}

public class GreatTreeListProblem 
{
	/*
	 * This solution to this problem is trivial.
	 * Add another instance variable ("next") of type class Node to the class of the node of the tree
	 * Next use breadth first traversal to join the links (next) object reference*/
	public static void run_foo(GTLPnode root)
	{
		int h = height(root);
		GTLPnode[] ar = new GTLPnode[10];
		GTLPnode prevNode = null;
		for(int i = 0;i<=h;i++)
		{
			index = 0;
			linkNode(root, i, ar);
			for(int j = 0;j<index-1;j++)
				ar[j].next = ar[j+1];
			if(prevNode==null)
				prevNode = ar[index-1];
			prevNode.next = ar[0];
			prevNode = ar[index-1];
		}
	}
	private static int index = 0;
	private static void linkNode(GTLPnode root, int level, GTLPnode[] ar)
	{
		if(root==null)
			return;
		if(level==0)
		{
			ar[index++] = root;
		}
		else
		{
			linkNode(root.left, level-1, ar);
			linkNode(root.right, level-1, ar);
		}
	}
	private static int height(GTLPnode root)
	{
		if(root==null)
			return -1;
		else
		{
			int lHeigh = height(root.left);
			int rHeight = height(root.right);
			return Math.max(lHeigh, rHeight)+1;
		}
	}
}
