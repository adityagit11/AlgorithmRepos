package TreePack4;

public class DepthFirstTraversal
{
	public static void main(String args[])
	{
		Node root = new Node(11);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node sixteen = new Node(16);
		Node two = new Node(2);
		Node nine = new Node(9);
		Node five = new Node(5);
		Node eight = new Node(8);
		
		root.left = six;
		root.right = seven;
		six.left = sixteen;
		sixteen.left = two;
		sixteen.right = nine;
		seven.left = five;
		five.right = eight;
		
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
	}
	public static void preOrder(Node root)
	{
		if(root==null)
			return;
		else
		{
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public static void inOrder(Node root)
	{
		if(root==null)
			return;
		else
		{
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	public static void postOrder(Node root)
	{
		if(root==null)
			return;
		else
		{
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
		}
	}
}
