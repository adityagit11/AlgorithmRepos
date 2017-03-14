package TreePack4;

public class ConvertToChildSumTree
{
	public static void run(Node root)
	{
		if(root==null)
			return;
		else
		{
			run(root.left);
			run(root.right);
			if(root.left==null&&root.right==null)
				return;
			int lNode = 0, rNode = 0;
			if(root.left!=null)
				lNode = root.left.data;
			if(root.right!=null)
				rNode = root.right.data;
			int sum = lNode + rNode;
			if(sum>root.data)
			{
				int diff = sum - root.data;
				root.data += diff;
			}
			else if(sum<root.data)
			{
				int diff = root.data - sum;
				if(root.left!=null)
				{
					root.left.data += diff;
					run(root.left);
				}
				else if(root.left==null)
				{
					root.right.data += diff;
					run(root.right);
				}
			}
		}
	}
}
