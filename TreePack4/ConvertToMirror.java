package TreePack4;

public class ConvertToMirror
{
	public static Node run(Node root)
	{
		if(root==null)
			return root;
		else
		{
			run(root.left);
			run(root.right);
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
			return root;
		}
	}
}
