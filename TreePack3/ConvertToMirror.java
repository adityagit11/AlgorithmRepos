package TreePack3;

public class ConvertToMirror 
{
	public static void run(Node root)
	{
		if(root==null)
			return;
		else
		{
			run(root.left);
			run(root.right);
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
	}
}
