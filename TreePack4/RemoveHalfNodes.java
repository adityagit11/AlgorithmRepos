package TreePack4;

public class RemoveHalfNodes
{
	public static Node run(Node root)
	{
		if(root==null)
			return root;
		else
		{
			Node lTree = run(root.left);
			Node rTree = run(root.right);
			if(lTree!=null&&lTree.left==null&&lTree.right!=null)
			{
				root.left = lTree.right;
			}
			else if(lTree!=null&&lTree.left!=null&&lTree.right==null)
			{
				root.left = lTree.left;
			}
			if(rTree!=null&&rTree.left==null&&rTree.right!=null)
			{
				root.right = rTree.right;
			}
			else if(rTree!=null&&rTree.left!=null&&rTree.right==null)
			{
				root.right = rTree.left;
			}
			return root;
		}
	}
}
