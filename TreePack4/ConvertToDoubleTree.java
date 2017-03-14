package TreePack4;

public class ConvertToDoubleTree
{
	public static void run(Node root)
	{
		if(root==null)
			return;
		else
		{
			Node lTree = root.left;
			Node newNode = new Node(root.data);
			newNode.left = lTree;
			root.left = newNode;
			run(newNode.left);
			run(root.right);
		}
	}
}
