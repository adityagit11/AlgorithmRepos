package TreePack;

class HNode
{
	int data, child;
	HNode left, right, next;
	HNode(int data)
	{
		this.data = data;
		left = right = next = null;
	}
}

public class HoffmannTree
{
	public static void main(String args[])
	{
		
	}
	
	/*
	public static HNode returnNode(HNode root, int lData, int rData)
	{
		root = new HNode(lData+rData);
		HNode lChild = new HNode(lData);
		HNode rChild = new HNode(rData);
		root.left = lChild;
		root.right = rChild;
		return root;
	}
	public static void levelOrderTraversal(HNode root)
	{
		int h = height(root);
		for(int i = 0;i<=h;i++)
		{
			printLevel(root,i);
			System.out.println();
		}
	}
	public static void printLevel(HNode root, int level)
	{
		if(root==null)
			return;
		if(level==0)
		{
			System.out.print(root.data+" ");
		}
		else
		{
			printLevel(root.left, level-1);
			printLevel(root.right, level-1);
		}
	}
	public static int height(HNode root)
	{
		if(root==null)
		{
			return -1;
		}
		else
		{
			int lHeight = height(root.left);
			int rHeight = height(root.right);
			return Math.max(lHeight, rHeight)+1;
		}
	}
	*/
}