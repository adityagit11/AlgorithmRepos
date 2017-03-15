package TreePack4;

/*
 * Question is to extract all of the leaves of the tree to a doubly linked list.
 */

class ELTLNode
{
	int data;
	ELTLNode left, right, next, prev;
	ELTLNode(int data)
	{
		this.data = data;
		this.left = this.right = this.next = this.prev = null;
	}
}

public class ExtractLeavesToList
{
	public static void main(String args[])
	{
		ELTLNode root = new ELTLNode(1);
		ELTLNode two = new ELTLNode(2);
		ELTLNode three = new ELTLNode(3);
		ELTLNode four = new ELTLNode(4);
		ELTLNode five = new ELTLNode(5);
		ELTLNode six = new ELTLNode(6);
		ELTLNode seven = new ELTLNode(7);
		ELTLNode eight = new ELTLNode(8);
		ELTLNode nine = new ELTLNode(9);
		ELTLNode ten = new ELTLNode(10);
		
		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		three.right = six;
		four.left = seven;
		four.right = eight;
		six.left = nine;
		six.right = ten;
		
		LevelOrderTraversal(root);
		System.out.println();
		
		run(root);
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
		System.out.println();
		LevelOrderTraversal(root);
	}
	private static int height(ELTLNode root)
	{
		if(root==null)
			return -1;
		else
		{
			return Math.max(height(root.left), height(root.right))+1;
		}
	}
	private static void LevelOrderTraversal(ELTLNode root)
	{
		int h = height(root);
		for(int i = 0;i<=h;i++)
		{
			printLevel(root,i);
			System.out.println();
		}
	}
	private static void printLevel(ELTLNode root, int level)
	{
		if(root==null)
			return;
		if(level==0)
			System.out.print(root.data+" ");
		else
		{
			printLevel(root.left, level-1);
			printLevel(root.right, level-1);
		}
	}
	
	private static ELTLNode head;
	private static void run(ELTLNode root)
	{
		/*
		 * Order should be maintained*/
		if(root==null)
			return;
		else
		{
			if(root.right!=null&&root.right.left==null&&root.right.right==null)
			{
				root.right.next = head;
				head = root.right;
				root.right = null;
			}
			if(root.left!=null&&root.left.left==null&&root.left.right==null)
			{
				root.left.next = head;
				head = root.left;
				root.left=null;
			}
			run(root.right);
			run(root.left);
		}
	}
}