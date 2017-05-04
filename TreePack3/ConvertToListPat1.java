package TreePack3;

/*
 * Convert To List Pattern - 1
 * 
 *                 A ---
 *                / \
 *       ------> B   C   -------
 *              /   / \
 *      -----> D   E   F
 *      
 * Change the structure of each node to:
 * below CTLP1 class
 * Step 2: Find the front and rear node of each level
 * Step 3: Find all the nodes of each level and modify the next pointers of nodes to point to next element in the array
 * Step 4: The rear node of previous level is pointed to front node of next level.
 * */

class CTLP1
{
	int data;
	CTLP1 left;
	CTLP1 right;
	CTLP1 next;
	CTLP1(int data)
	{
		this.data = data;
		this.left = this.right = this.next = null;
	}
}

public class ConvertToListPat1 
{
	private static int index = 0;
	public static void main(String args[])
	{
		CTLP1 root = new CTLP1(1);
		CTLP1 two = new CTLP1(2);
		CTLP1 three = new CTLP1(3);
		CTLP1 four = new CTLP1(4);
		CTLP1 five = new CTLP1(5);
		CTLP1 six = new CTLP1(6);
		CTLP1 seven = new CTLP1(7);
		CTLP1 eight = new CTLP1(8);
		CTLP1 nine = new CTLP1(9);
		CTLP1 ten = new CTLP1(10);
		CTLP1 eleven = new CTLP1(11);
		
		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		four.left = eight;
		four.right = nine;
		seven.left = ten;
		seven.right = eleven;
		
		convertToList(root);
		printList(root);
	}
	
	private static void printList(CTLP1 root)
	{
		CTLP1 temp = root;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	private static void convertToList(CTLP1 root)
	{
		int h = height(root);
		CTLP1[] ar = new CTLP1[10];
		CTLP1 prev = null;
		for(int i = 0;i<=h;i++)
		{
			index = 0;
			storeArray(root, i, ar);
			for(int j = 0;j<index;j++)
			{
				if(ar[j]!=null)
				{
					ar[j].next = ar[j+1];
				}
			}
			CTLP1 front = getFrontNode(root, i);
			CTLP1 rear = getRearNode(root, i);
			if(prev==null)
				prev = rear;
			else
			{
				prev.next = front;
				prev = rear;
			}
		}
	}
	
	private static void storeArray(CTLP1 root, int level, CTLP1[] ar)
	{
		if(root==null)
			return;
		if(level==0)
			ar[index++] = root;
		else
		{
			storeArray(root.left, level-1, ar);
			storeArray(root.right, level-1, ar);
		}
	}
	
	private static CTLP1 getRearNode(CTLP1 root, int level)
	{
		if(root==null)
			return root;
		if(level==0)
			return root;
		else
		{
			CTLP1 lchild = getRearNode(root.left, level-1);
			CTLP1 rchild = getRearNode(root.right, level-1);
			if(rchild!=null)
				return rchild;
			if(lchild!=null)
				return lchild;
			return root;
		}
	}
	
	private static CTLP1 getFrontNode(CTLP1 root, int level)
	{
		if(root==null)
			return root;
		if(level==0)
			return root;
		else
		{
			CTLP1 lchild = getFrontNode(root.left, level-1);
			CTLP1 rchild = getFrontNode(root.right, level-1);
			if(lchild!=null)
				return lchild;
			if(rchild!=null)
				return rchild;
			return root;
		}
	}
	
	private static int height(CTLP1 root)
	{
		if(root==null)
			return -1;
		else
			return Math.max(height(root.left), height(root.right))+1;
	}
	
	/*
	 * The below methods are for only demonstartion purposes:
	 * Like how to get the first node of each level easily
	 * and the last node too..*/
	private static void run(Node root)
	{
		int h = Height.run(root);
		for(int i = 0;i<=h;i++)
		{
			System.out.println(getNodeFront(root, i).data);
			System.out.println(getNodeLast(root, i).data);
		}
	}
	
	private static Node getNodeFront(Node root, int level)
	{
		if(root==null)
			return root;
		if(level==0)
			return root;
		else
		{
			Node lChild = getNodeFront(root.left, level-1);
			Node rChild = getNodeFront(root.right, level-1);
			if(lChild!=null)
				return lChild;
			if(rChild!=null)
				return rChild;
			return root;
		}
	}
	
	private static Node getNodeLast(Node root, int level)
	{
		if(root==null)
			return root;
		if(level==0)
			return root;
		else
		{
			Node lChild = getNodeLast(root.left, level-1);
			Node rChild = getNodeLast(root.right, level-1);
			if(rChild!=null)
				return rChild;
			if(lChild!=null)
				return lChild;
			return root;
		}
	}
}
