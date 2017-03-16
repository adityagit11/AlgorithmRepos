package TreePack4;

/*
 * Given a Binary Tree, change the value in each node to sum of all the values in the nodes in the left subtree
including its own.
Example
Input :
    1
   / \
  2   3
Output :
    3
   / \
  2   3
 */

public class StoreLeftTreeSum
{
	public static int run(Node root)
	{
		if(root==null)
			return 0;
		else
		{
			int lData = run(root.left);
			int rData = run(root.right);
			root.data += lData;
			return root.data+rData;
		}
	}
}
