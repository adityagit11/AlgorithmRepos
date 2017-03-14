package TreePack4;

public class BuildTreeInPre 
{
	private static int inIndex = 0;
	private static int preIndex = 0;
	public static void run(Node root)
	{
		//root is a root node of some given tree
		//we will store the inorder and preorder of the tree in array
		int[] inOrder = new int[20];
		int[] preOrder = new int[20];
		storeInorder(root, inOrder);
		storePreorder(root, preOrder);
		System.out.println("Inorder sequence");
		for(int i = 0;i<inIndex;i++)
			System.out.print(inOrder[i]+" ");
		System.out.println();
		System.out.println("Preorder sequence");
		for(int i = 0;i<preIndex;i++)
			System.out.print(preOrder[i]+" ");
		
	}
	private static void storePreorder(Node root, int[] ar)
	{
		if(root==null)
			return;
		else
		{
			ar[preIndex++] = root.data;
			storePreorder(root.left, ar);
			storePreorder(root.right, ar);
		}
	}
	private static void storeInorder(Node root, int[] ar)
	{
		if(root==null)
			return;
		else
		{
			storeInorder(root.left, ar);
			ar[inIndex++] = root.data;
			storeInorder(root.right, ar);
		}
	}
}
