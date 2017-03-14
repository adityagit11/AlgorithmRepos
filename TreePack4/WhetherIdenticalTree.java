package TreePack4;

public class WhetherIdenticalTree
{
	public static boolean run(Node root1, Node root2)
	{
		if(root1==null&&root2==null)
		{
			return true;
		}
		if((root1!=null&&root2==null)||(root1==null&&root2!=null))
		{
			return false;
		}
		else
		{
			return root1.data==root2.data&&run(root1.left,root2.left)&&run(root1.right,root2.right);
		}
	}
}
