package TreePack4;

class CNALNode
{
	int data;
	CNALNode left;
	CNALNode right;
	CNALNode next;
	CNALNode(int data)
	{
		this.data = data;
		this.left = this.right = this.next = null;
	}
}

public class ConnectNodeAtLevel
{
	public static void main(String args[])
	{
		CNALNode root = new CNALNode(1);
		CNALNode two = new CNALNode(2);
		CNALNode three = new CNALNode(3);
		CNALNode four = new CNALNode(4);
		CNALNode five = new CNALNode(5);
		CNALNode six = new CNALNode(6);
		CNALNode seven = new CNALNode(7);
		
		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		
		run(root);
		checkTree(root);
	}
	public static void checkTree(CNALNode root)
	{
		int h = height(root);
		for(int i = 0;i<=h;i++)
		{
			CNALNode temp = getFirstNode(root, i);
			while(temp!=null)
			{
				System.out.print(temp.data+" -> ");
				temp = temp.next;
			}
			System.out.println();
		}
	}
	public static CNALNode getFirstNode(CNALNode root, int level)
	{
		if(root==null)
			return root;
		if(level==0)
			return root;
		else
		{
			CNALNode lTree = getFirstNode(root.left, level-1);
			CNALNode rTree = getFirstNode(root.right, level-1);
			if(lTree!=null)
				return lTree;
			if(rTree!=null)
				return rTree;
			return root;
		}
	}
	private static int index = 0;
	public static void run(CNALNode root)
	{
		int h = height(root);
		CNALNode[] ar = new CNALNode[10];
		for(int i = 0;i<=h;i++)
		{
			index = 0;
			getLevelIntoArray(root, i, ar);
			for(int j = 0;j<index;j++)
			{
				ar[j].next = ar[j+1];
			}
		}
	}
	private static void getLevelIntoArray(CNALNode root, int level, CNALNode[] ar)
	{
		if(root==null)
			return;
		if(level==0)
			ar[index++] = root;
		else
		{
			getLevelIntoArray(root.left, level-1, ar);
			getLevelIntoArray(root.right, level-1, ar);
		}
	}
	private static int height(CNALNode root)
	{
		if(root==null)
			return -1;
		else
		{
			return Math.max(height(root.left), height(root.right))+1;
		}
	}
}