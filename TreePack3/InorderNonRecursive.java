package TreePack3;

import java.util.Stack;

public class InorderNonRecursive
{
	public static void run(Node root)
	{
		Stack<Node> myS = new Stack<Node>();
		pushLeft(root, myS);
		while(!myS.isEmpty())
		{
			Node temp = myS.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
			{
				temp = temp.right;
				pushLeft(temp, myS);
			}
		}
	}
	private static void pushLeft(Node root, Stack<Node> myS)
	{
		Node temp = root;
		while(temp!=null)
		{
			myS.push(temp);
			temp = temp.left;
		}
	}
}
