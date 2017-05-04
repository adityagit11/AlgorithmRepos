package TreePack3;

public class WhetherIdentical 
{
	public static boolean run(Node root1, Node root2)
	{
		if(root1==null&&root2==null)
			return true;
		else if((root1==null&&root2!=null)||(root1!=null&&root2==null))
			return false;
		else
			return root1!=null&&root2!=null&&root1.data==root2.data&&run(root1.left, root2.left)&&run(root1.right, root2.right);
	}
}
