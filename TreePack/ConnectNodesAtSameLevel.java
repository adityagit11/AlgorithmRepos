package TreePack;

class Node1
{
	int data;
	Node1 next;
	Node1 left;
	Node1 right;
	public Node1(int data)
	{
		this.data = data;
		next = null;
		left = null;
		right = null;
	}
	/*
	 * 	  1
        /   \
       2     3
     /  \   /  \
    4    5 9    8 
               /  \
              6    7
              	 /   \
                10    11*/
}

public class ConnectNodesAtSameLevel
{
	public static void main(String args[])
	{
		Node1 one = new Node1(1);
		Node1 two = new Node1(2);
		Node1 three = new Node1(3);
		Node1 four = new Node1(4);
		Node1 five = new Node1(5);
		Node1 six = new Node1(6);
		Node1 seven = new Node1(7);
		Node1 eight = new Node1(8);
		Node1 nine = new Node1(9);
		Node1 ten = new Node1(10);
		Node1 eleven = new Node1(11);
		one.left = two; one.right = three; two.left = four;two.right = five; three.left = nine; three.right = eight;
		eight.left = six; eight.right = seven; seven.left = ten; seven.right = eleven;
		
		connectNodeToRight(one);
	}
	public static int index = 0; //common index variable for all nodes at same level
	public static void connectNodeToRight(Node1 root)
	{
		int h = height(root);
		Node1[] ar = new Node1[10];
		for(int i = 0;i<=h;i++)
		{
			retrieveNodes(root,i,ar);
			
			for(int j = 0;j<index;j++)
			{
				ar[j].next = ar[j+1];
			}
			for(int j = 0;j<index;j++)
			{
				System.out.print(ar[j].data+" ");
			}
			System.out.println();
			/*
			 * Put index = 0, so that the filling of array 
			 * starts again from ar[0]*/
			index = 0;
		}
		whetherConnected(root);
	}
	public static void whetherConnected(Node1 root)
	{
		if(root==null)
			return;
		else
		{
			whetherConnected(root.left);
			whetherConnected(root.right);
			if(root!=null&&root.next!=null)
			{
				System.out.print(root.data+" -> "+root.next.data);
			}
			System.out.println();
		}
	}
	public static void retrieveNodes(Node1 root, int level,Node1[] ar)
	{
		if(root==null)
			return;
		if(level==0)
		{
			ar[index]=root;
			index++;
		}
		else
		{
			retrieveNodes(root.left,level-1,ar);
			retrieveNodes(root.right,level-1,ar);
		}
	}
	public static int height(Node1 root)
	{
		if(root==null)
		{
			return -1;
		}
		else
		{
			int lHeight = height(root.left);
			int rHeight = height(root.right);
			return Math.max(lHeight, rHeight)+1;
		}
	}
}
