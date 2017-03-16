package TreePack4;

public class FindNextRightNode
{
	public static Node run(Node root, int key)
	{
		if(root==null)
			return root;
		if(root.data==key)
			return root.right;
		else
		{
			Node lNode = run(root.left, key);
			Node rNode = run(root.right, key);
			if(lNode!=null)
				return lNode;
			if(rNode!=null)
				return rNode;
			return null;
		}
	}
}
