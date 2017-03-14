package TreePack4;

public class ThreadedBinaryTree
{
	public static void main(String args[])
	{
		ThreadNode root = new ThreadNode(6);
		ThreadNode three = new ThreadNode(3);
		ThreadNode eight = new ThreadNode(8);
		ThreadNode one = new ThreadNode(1);
		ThreadNode five = new ThreadNode(5);
		ThreadNode seven = new ThreadNode(7);
		ThreadNode eleven = new ThreadNode(11);
		ThreadNode nine = new ThreadNode(9);
		ThreadNode twelve = new ThreadNode(12);
		
		root.left = three;
		root.right = eight;
		three.left = one;
		three.right = five;
		eight.left = seven;
		eight.right = eleven;
		eleven.left = nine;
		eleven.right = twelve;
		
		//regular inorder traversal

		regularInorder(root);
		System.out.println();
		
		//start threading
		one.right = three; one.rightThread = true;
		five.right = root; five.rightThread = true;
		seven.right = eight; seven.rightThread = true;
		nine.right = eleven; nine.rightThread = true;
		
		inOrderTraversal(root);
	}
	public static void inOrderTraversal(ThreadNode root)
	{
		ThreadNode temp = returnLeftMost(root);
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			if(temp.rightThread)
				temp = temp.right;
			else
				temp = returnLeftMost(temp.right);
		}
	}
	public static ThreadNode returnLeftMost(ThreadNode root)
	{
		if(root==null)
			return root;
		ThreadNode temp = root;
		while(temp.left!=null)
		{
			temp = temp.left;
		}
		return temp;
	}
	public static void regularInorder(ThreadNode root)
	{
		if(root==null)
			return;
		else
		{
			regularInorder(root.left);
			System.out.print(root.data+" ");
			regularInorder(root.right);
		}
	}
}
