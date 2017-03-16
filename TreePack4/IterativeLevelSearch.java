package TreePack4;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeLevelSearch 
{
	public static boolean run(Node root, int key)
	{
		if(root.data==key)
			return true;
		Queue<Node> myQ = new LinkedList<Node>();
		myQ.add(root);
		while(!myQ.isEmpty())
		{
			Node temp = myQ.remove();
			if(temp.data==key)
				return true;
			if(temp.left!=null)
				myQ.add(temp.left);
			if(temp.right!=null)
				myQ.add(temp.right);
		}
		return false;
	}
}
