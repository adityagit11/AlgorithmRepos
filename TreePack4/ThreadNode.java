package TreePack4;

public class ThreadNode
{
	int data;
	ThreadNode left;
	ThreadNode right;
	boolean rightThread;
	boolean leftThread;
	ThreadNode(int data)
	{
		this.data = data;
		this.left = this.right = null;
		this.rightThread = this.leftThread = false;
	}
}