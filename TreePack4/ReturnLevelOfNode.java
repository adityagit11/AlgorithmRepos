package TreePack4;

public class ReturnLevelOfNode
{
	public static int run(Node root, int key)
	{
		System.out.println("Select the method from ReturnLevelOfNode.java file");
		return returnLevel2(root, key, 0);
	}
	
	//method 1
	private static void printLevel(Node root, int key, int level)
	{
		if(root==null)
			return;
		if(root.data==key)
			System.out.println(level);
		else
		{
			printLevel(root.left, key, level+1);
			printLevel(root.right, key, level+1);
		}
	}
	
	//method 2
	private static int level = 0;
	private static void returnLevel(Node root, int key, int index)
	{
		if(root==null)
			return;
		if(root.data==key)
			level = index;
		else
		{
			returnLevel(root.left, key, index+1);
			returnLevel(root.right, key, index+1);
		}
	}
	
	//method 3
	private static int returnLevel2(Node root, int key, int index)
	{
		if(root==null)
			return 0;
		if(root.data==key)
			return index;
		else
		{
			int lData = returnLevel2(root.left, key, index+1);
			int rData = returnLevel2(root.right, key, index+1);
			if(lData!=0)
				return lData;
			if(rData!=0)
				return rData;
			return 0;
		}
	}
}
