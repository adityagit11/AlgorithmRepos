package TreePack4;

/*
 * Given a a Binary Tree, find the difference between the sum of nodes at odd level and the sum of nodes at even
level. Consider root as level 1, left and right children of root as level 2 and so on.
For example, in the following tree, sum of nodes at odd level is (5 + 1 + 4 + 8) which is 18. And sum of nodes at
even level is (2 + 6 + 3 + 7 + 9) which is 27. The output for following tree should be 18 – 27 which is 9.
	 5
    / \
   2  6
  / \  \
 1   4  8
/   / \
3  7   9
 */

public class OddEvenLevelDifference
{
	public static int run(Node root)
	{
		if(root==null)
			return 0;
		else
			return root.data - run(root.left) - run(root.right);
	}
	//level order traversal
	public static int run2(Node root)
	{
		int evenSum = 0;
		int oddSum = 0;
		int h = BreadthFirstTraversal.height(root);
		for(int i = 0;i<=h;i++)
		{
			if(i%2==0)
				evenSum += sumOfLevel(root, i);
			else
				oddSum += sumOfLevel(root, i);  
		}
		return evenSum - oddSum;
	}
	private static int sumOfLevel(Node root, int level)
	{
		if(root==null)
			return 0;
		if(level==0)
			return root.data;
		else
			return sumOfLevel(root.left, level-1)+sumOfLevel(root.right, level-1);
	}
}
