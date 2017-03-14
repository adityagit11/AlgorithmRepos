package TreePack4;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal
{
	public static void bfs_queue(Node root)
	{
		Queue<Node> myQ = new LinkedList<Node>();
		myQ.add(root);
		while(!myQ.isEmpty())
		{
			Node temp = myQ.remove();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
				myQ.add(temp.left);
			if(temp.right!=null)
				myQ.add(temp.right);
		}
		System.out.println();
	}
	public static void bfs_foo(Node root)
	{
		int h = height(root);
		for(int i = 0;i<=h;i++)
		{
			printLevel(root,i);
			System.out.println();
		}
		System.out.println();
	}
	public static void printLevel(Node root, int level)
	{
		if(root==null)
			return;
		if(level==0)
			System.out.print(root.data+" ");
		else
		{
			printLevel(root.left,level-1);
			printLevel(root.right,level-1);
		}
	}
	public static int height(Node root)
	{
		if(root==null)
			return -1;
		else
		{
			int lHeight = height(root.left);
			int rHeight = height(root.right);
			return Math.max(lHeight, rHeight)+1;
		}
	}
}