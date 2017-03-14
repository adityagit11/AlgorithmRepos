package TreePack4;

import java.util.Stack;

public class InOrderStack
{
	public static void run(Node root)
	{
		if(root==null)
			return;
		Stack<Node> myStack = new Stack<Node>();
		Node temp = root;
		temp = pushLeftInStack(temp, myStack);
		while(!myStack.isEmpty())
		{
			temp = myStack.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
			{
				temp = temp.right;
				temp = pushLeftInStack(temp, myStack);
			}
		}
	}
	private static Node pushLeftInStack(Node root, Stack<Node> myStack)
	{
		if(root==null)
			return root;
		Node temp = root;
		while(temp!=null)
		{
			myStack.push(temp);
			temp = temp.left;
		}
		return temp;
	}
}
