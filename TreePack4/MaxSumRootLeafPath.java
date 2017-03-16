package TreePack4;

public class MaxSumRootLeafPath
{
	public static int run(Node root)
	{
		int[] ar = new int[10];
		getSum(root, ar, 0);
		return maxSum;
	}
	private static int maxSum = Integer.MIN_VALUE;
	private static void getSum(Node root, int[] ar, int index)
	{
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
		{
			ar[index++] = root.data;
			int sum = 0;
			for(int i = 0;i<index;i++)
				sum += ar[i];
			if(sum>maxSum)
				maxSum = sum;
		}
		else
		{
			ar[index++] = root.data;
			getSum(root.left, ar, index);
			getSum(root.right, ar, index);
		}
	}
}
