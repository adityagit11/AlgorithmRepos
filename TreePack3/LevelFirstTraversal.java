package TreePack3;

import java.util.LinkedList;
import java.util.Queue;

public class LevelFirstTraversal 
{
	public static void recursive(Node root)
	{
		int h = Height.run(root);
		for(int i = 0;i<=h;i++)
		{
			printGivenLevel(root, i);
			System.out.println();
		}
	}
	private static void printGivenLevel(Node root, int level)
	{
		if(root==null)
			return;
		if(level==0)
			System.out.print(root.data+" ");
		else
		{
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}
	
	public static void nonRecursiveUsingQueue(Node root)
	{
		Queue<Node> myQ = new LinkedList<Node>();
		myQ.add(root);
		while(!myQ.isEmpty())
		{
			Node extract = myQ.remove();
			System.out.print(extract.data+" ");
			if(extract.left!=null)
				myQ.add(extract.left);
			if(extract.right!=null)
				myQ.add(extract.right);
		}
		System.out.println();
	}
}
