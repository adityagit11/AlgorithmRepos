/*
 * The Great Tree-List Recursion Problem.
 * Construct Tree from given Inorder and Preorder traversals
 * Check if a binary tree is subtree of another binary tree
 * 
 * Symmetric Tree (Mirror Image of itself)
 * Maximum Path Sum in a Binary Tree
 * Expression Tree
 * Check whether a binary tree is a complete tree or not | Set 2 (Recursive Solution)
 * Iterative Search for a key ‘x’ in Binary Tree
 * */

package TreePack;

import java.util.LinkedList;
import java.util.Queue;

class Node
{
	int data;
	Node left;
	Node right;
	Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}

class Node2
{
	char data;
	Node2 left;
	Node2 right;
	Node2(char data)
	{
		this.data=data;
		left=null;
		right=null;
	}
}

class huff
{
	char data;
	int freq;
	huff(char data,int freq)
	{
		this.data = data;
		this.freq = freq;
	}
}

public class MainClass
{
	public static void main(String args[])
	{
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		Node ten = new Node(10);
		Node eleven = new Node(11);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = nine;
		three.right=eight;
		eight.left=six;
		eight.right=seven;
		seven.left = ten;
		seven.right = eleven;
		
		/*
		  1
        /   \
       2     3
     /  \   /  \
    4    5 9    8 
               /  \
              6    7
              	 /   \
                10    11*/
		
		Node oneS = new Node(1);
		Node twoS = new Node(2);
		Node threeS = new Node(3);
		Node fourS = new Node(4);
		Node fiveS = new Node(5);
		oneS.left = twoS;
		oneS.right = threeS;
		threeS.left = fourS;
		threeS.right = fiveS;
		
		Node2 a = new Node2('a');
		Node2 b = new Node2('b');
		Node2 c = new Node2('c');
		Node2 d = new Node2('d');
		Node2 e = new Node2('e');
		Node2 f = new Node2('f');
		Node2 g = new Node2('g');
		Node2 h = new Node2('h');
		Node2 i = new Node2('i');
		Node2 j = new Node2('j');
		Node2 k = new Node2('k');
		Node2 l = new Node2('l');
		Node2 m = new Node2('m');
		Node2 n = new Node2('n');
		Node2 o = new Node2('o');
		Node2 p = new Node2('p');
		Node2 q = new Node2('q');
		a.left=b;a.right=c;b.left=d;b.right=e;c.left=i;c.right=f;d.left=j;d.right=k;j.left=n;j.right=o;f.left=g;f.right=h;g.left=l;g.right=m;l.left=p;l.right=q;
		
		//huffman code starts
		
		/*
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of characters you want to enter");
		int size = input.nextInt();
		System.out.println("Enter the characters in form of string: e.g. abc");
		String inputCharacters = input.next();
		huff[] code = new huff[size];
		System.out.println("Enter the "+size+" frequencies");
		for(int z = 0;z<size;z++)
		{
			int temp = input.nextInt();
			code[z] = new huff(inputCharacters.charAt(z),temp);
		}
		for(int z = 0;z<size;z++)
		{
			System.out.println(code[z].data+" "+code[z].freq);
		}
		*/
		
		/*
		 * FOR predefined values*/

		System.out.println(minDepth(one));
		
		//huffman code ends
	}
	
	public static int minDepth(Node root)
	{
		if(root==null)
			return -1;
		else
		{
			int lMinDepth = minDepth(root.left);
			int rMinDepth = minDepth(root.right);
			return Math.min(lMinDepth, rMinDepth)+1;
		}
	}
	public static int addLeft(Node root)
	{
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return root.data;
		else
		{
			int lTree = addLeft(root.left);
			addLeft(root.right);
			root.data = root.data + lTree;
			return root.data;
		}
	}
	public static int returnMin(Node root)
	{
		/*
		1
      /   \
     2     3
   /  \   /  \
  4    5 9    8 
             /  \
            6    7*/
		if(root==null)
			return -1;
		if(root.left==null&&root.right==null)
			return root.data;
		else
		{
			int lTreeData = returnMin(root.left);
			int rTreeData = returnMin(root.right);
			return Math.min(lTreeData, Math.min(rTreeData,root.data));
		}
	}
	public static int returnMax(Node root)
	{
		/*
		1
      /   \
     2     3
   /  \   /  \
  4    5 9    8 
             /  \
            6    7*/
		if(root==null)
			return -1;
		if(root.left==null&&root.right==null)
			return root.data;
		else
		{
			int lTreeData = returnMax(root.left);
			int rTreeData = returnMax(root.right);
			return Math.max(lTreeData, Math.max(rTreeData, root.data));
		}
	}
	public static int whetherSumTree(Node root)
	{
		/*
		 *
		Node thirty = new Node(30);
		Node twelve = new Node(12);
		Node three2 = new Node(3);
		Node five2 = new Node(5);
		Node seven2 = new Node(7);
		Node one2 = new Node(1);
		Node two2 = new Node(2);
		thirty.left=twelve;
		thirty.right=three2;
		twelve.left=five2;
		twelve.right=seven2;
		three2.left=one2;
		three2.right=two2;
		
		if(whetherSumTree(thirty)/2==thirty.data)
			System.out.println("True");
		else
			System.out.println("False");
		*/
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return root.data;
		else
		{
			System.out.println("a "+root.data);
			int lSum = whetherSumTree(root.left);
			int rSum = whetherSumTree(root.right);
			System.out.println(root.data);
			System.out.println(lSum+" "+rSum);
			if((lSum+rSum)==root.data)
				return root.data*2;
			else
				return (lSum+rSum)*2;
		}
	}
	public static void printAncestors(Node root)
	{
		/*
		 *
		 1
       /  \
      2    3
    /  \     \
   4    5     8 
             /  \
            6    7
            	  \
            	   6 */
		int[] ar = new int[10]; //assuming at most root-to-leaf paths
		int index = 0;
		int key = 6;
		searchNodeToPrintAncestors(root, ar, index, key);
	}
	public static void searchNodeToPrintAncestors(Node root, int[] ar, int index, int key)
	{
		if(root==null)
			return;
		if(root.data==key)
		{
			for(int i = 0;i<index;i++)
			{
				System.out.print(ar[i]+" ");
			}
			/*
			 * the 3 lines of code below this comment will 
			 * ensure that any other node which matches key
			 * will also get the priviledge of getting its ancestors printed*/
			System.out.println(); 
			ar[index]=root.data;
			index++;
		}
		else
		{
			ar[index]=root.data;
			index++;
			searchNodeToPrintAncestors(root.left, ar, index, key);
			searchNodeToPrintAncestors(root.right, ar, index, key);
		}
	}
	
	/////////////////////////////////////////
	
	public static void getLevelFromNode(Node root, int k)
	{
		/*
		 *
		  1
        /  \
       2    3
     /  \     \
    4    5     8 
              /  \
             6    7*/
		int h = heightOfTree(root);
		int flag = 0;
		for(int i = 0;i<=h;i++)
		{
			if(searchGivenLevel(root,i,k))
			{
				System.out.println(i);
				flag = 1;
				break;
			}
		}
		if(flag==0)
			System.out.println("-1");
	}
	public static boolean searchGivenLevel(Node root, int level, int data)
	{
		if(root==null)
			return false;
		if(level==0)
		{
			if(root.data==data)
				return true;
		}
		else
		{
			return searchGivenLevel(root.left, level-1, data)||searchGivenLevel(root.right, level-1, data);
		}
		return false;
	}
	public static void printNodeAtGivenDistanceFromRoot(Node root, int k)
	{
		if(root==null)
			return;
		if(k==0)
			System.out.println(root.data);
		else
		{
			printNodeAtGivenDistanceFromRoot(root.left, k-1);
			printNodeAtGivenDistanceFromRoot(root.right, k-1);
		}
	}
	public static void convertToMirror(Node root)
	{
		/*
	    1
      /  \
     2    3
   /  \     \
  4    5     8 
            /  \
           6    7*/
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
			return;
		else
		{
			convertToMirror(root.left);
			convertToMirror(root.right);
			Node temp = root.left;
			root.left = root.right;
			root.right= temp;
		}
	}
	public static void thiefProblem(Node root)
	{
		/*
	 	1
      /  \
     2    3
   /  \     \
  4    5     8 
            /  \
           6    7*/
		int heightOfTree = heightOfTree(root);
		int evenSum = 0; //0,2,4
		int oddSum = 0; //1,3,5
		for(int i = 0;i<=heightOfTree;i++)
		{
			int temp = calculateSumAtGivenLevel(root, i);
			if(i%2==0)
				evenSum = evenSum + temp;
			else
				oddSum = oddSum + temp;
		}
		System.out.println(evenSum+" "+oddSum);
		if(evenSum==oddSum)
		{
			System.out.println("The thief can choose any of the given levels");
		}
		else if(oddSum>evenSum)
		{
			System.out.println("The thief should choose odd levels");
		}
		else
		{
			System.out.println("The thief shoudl choose even levels");
		}
	}
	public static int calculateSumAtGivenLevel(Node root,int level)
	{
		if(root==null)
			return 0;
		if(level==0)
			return root.data;
		else
		{
			int lSum = calculateSumAtGivenLevel(root.left, level-1);
			int rSum = calculateSumAtGivenLevel(root.right, level-1);
			return lSum + rSum;
		}
	}
	public static Node returnParent(Node root, int x)
	{
		/*
		 * Node x = returnParent(one, 6);
		if(x!=null)
			System.out.println(x.data);
		else
			System.out.println("null");*/
		/*
		1
      /  \
     2    3
   /  \     \
  4    5     8 
            /  \
           6    7*/
		if(root==null)
			return null;
		if((root.left!=null&&root.left.data==x)||(root.right!=null&&root.right.data==x))
			return root;
		else
		{
			Node lParent = returnParent(root.left, x);
			Node rParent = returnParent(root.right, x);
			if(lParent!=null)
				return lParent;
			else return rParent;
		}
	}
	public static void maxWidth(Node root)
	{
		int heightOfTree = heightOfTree(root);
		int prevMax = 0;
		for(int i = 0;i<=heightOfTree;i++)
		{
			int temp = countNodeAtAGivenLevel(root,i);
			System.out.println("At level "+i+" no. of nodes are "+temp);
			if(temp>prevMax)
				prevMax = temp;
		}
		System.out.println(prevMax);
	}
	public static int countNodeAtAGivenLevel(Node root,int level)
	{
		if(root==null)
		{
			return 0;
		}
		if(level==0)
		{
			return 1;
		}
		else
		{
			int lCount = countNodeAtAGivenLevel(root.left, level-1);
			int rCount= countNodeAtAGivenLevel(root.right, level-1);
			return lCount + rCount;
		}
	}
	public static void doubleTreeViaPre(Node root)
	{
		/*
		 * 
		Node d2 = new Node(2);
		Node d1 = new Node(1);
		Node d3 = new Node(3);
		d2.left=d1;
		d2.right=d3;
		doubleTreeViaPre(d2);
		postOrderTraversal(d2);*/
		if(root==null)
		{
			return;
		}
		else
		{
			Node newNode = new Node(root.data);
			newNode.left = root.left;
			root.left=newNode;
			doubleTreeViaPre(newNode.left);
			doubleTreeViaPre(root.right);
		}
	}
	public static void doubleTreeViaPost(Node root)
	{
		/*
		 * Node d2 = new Node(2);
		Node d1 = new Node(1);
		Node d3 = new Node(3);
		d2.left=d1;
		d2.right=d3;
		doubleTree(d2);
		postOrderTraversal(d2);*/
		
		if(root==null)
			return;
		else
		{
			doubleTreeViaPost(root.left);
			doubleTreeViaPost(root.right);
			Node newNode = new Node(root.data);
			newNode.left=root.left;
			root.left=newNode;
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean checkSumRootPathLeaf(Node root, int[] ar, int index, int inputSum)
	{
		/*
		 * int[] ar = new int[10]; //assuming number of paths <=10
		int index = 0;
		int inputSum = 1;
		System.out.println(checkSumRootPathLeaf(one, ar, index, inputSum));*/
		if(root.left==null&&root.right==null)
		{
			ar[index]=root.data;
			index++;
			int sum = 0;
			for(int i = 0;i<index;i++)
			{
				sum+=ar[i];
			}
			if(sum==inputSum)
			{
				for(int i =0 ;i<index;i++)
				{
					System.out.print(ar[i]+" ");
				}
				return true;
			}
		}
		else
		{
			ar[index]=root.data;
			index++;
			return checkSumRootPathLeaf(root.left, ar, index, inputSum) || checkSumRootPathLeaf(root.right, ar, index, inputSum);
		}
		return false;
	}
	public static boolean heightBalanced(Node root)
	{
		/*
		 * /*
		   1
      	 /  \     
        /    \
       2      3
      / \      
     /   \    
    4     5    
   / \      
  /   \    
 6     7 
		 Node six = new Node(6);
		 Node seven = new Node(7);
		 four.left = six;
		 four.right = seven;*/
		if(root.left!=null&&root.right!=null)
		{
			//not a leaf node
			int lHeight = heightOfTree(root.left);
			int rHeight = heightOfTree(root.right);
			if((Math.abs(lHeight-rHeight))<=1)
				return true;
			else
				return false;
		}
		else
		{
			return heightBalanced(root.left)&&heightBalanced(root.right);
		}
	}
	public static int diameter(Node root,Node maxDiameter)
	{
		
		/*
		 * Node maxDiameter = new Node(0);
		diameter(a, maxDiameter);
		System.out.println(maxDiameter.data);*/
		if(root.left==null&&root.right==null)
			return 0;
		else
		{
			int lHeight = diameter(root.left,maxDiameter);
			int rHeight = diameter(root.right,maxDiameter);
			int sum = lHeight+rHeight+2;
			if(sum>maxDiameter.data)
			{
				maxDiameter.data=sum;
			}
			return Math.max(lHeight, rHeight) + 1;
		}
	}
	public static int checkChildSumProperty(Node root)
	{
		/*
		 * Node fifty = new Node(50);
		Node seven = new Node(7);
		Node two2 = new Node(2);
		Node three2 = new Node(3);
		Node five2 = new Node(5);
		Node one2 = new Node(1);
		Node thirty = new Node(30);
		fifty.left=seven;
		fifty.right=two2;
		seven.left=three2;
		seven.right=five2;
		two2.left=one2;
		two2.right=thirty;*/
		
		/*
		 * if(checkChildSumProperty(fifty)==-1)
			System.out.println("false;");
		else
			System.out.println("true;");*/
		
		if(root.left==null&&root.right==null)
		{
			//leaf node
			return root.data;
		}
		else
		{
			int lSum = checkChildSumProperty(root.left);
			int rSum = checkChildSumProperty(root.right);
			if(root.data==(lSum+rSum))
			{
				return root.data;
			}
			else
				return -1;
		}
	}
	public static int increment(Node root)
	{
		//this method converts any arbitary binary tree to a tree which satifies the child sum property. How?
		if(root.left==null&&root.right==null)
		{
			return root.data;
		}
		else
		{
			int lSum = increment(root.left);
			int rSum = increment(root.right);
			int totalSum = lSum+rSum;
			int diff = totalSum - root.data;
			if(diff>0)
			{
				root.data = root.data + diff;
			}
			else if(diff<0)
			{
				root.left.data=root.left.data+Math.abs(diff);
				increment(root.left);
			}
			return root.data;
		}
	}
	public static void printLevelForSpiral(Node2 root)
	{
		/*
		 * class Node2
{
	char data;
	Node2 left;
	Node2 right;
	Node2(char data)
	{
		this.data=data;
		left=null;
		right=null;
	}
		
		/*
		 * Node2 a = new Node2('a');
		Node2 b = new Node2('b');
		Node2 c = new Node2('c');
		Node2 d = new Node2('d');
		Node2 e = new Node2('e');
		Node2 f = new Node2('f');
		Node2 g = new Node2('g');
		Node2 h = new Node2('h');
		Node2 i = new Node2('i');
		Node2 j = new Node2('j');
		Node2 k = new Node2('k');
		Node2 l = new Node2('l');
		Node2 m = new Node2('m');
		Node2 n = new Node2('n');
		Node2 o = new Node2('o');
		Node2 p = new Node2('p');
		Node2 q = new Node2('q');
		a.left=b;a.right=c;b.left=d;b.right=e;c.left=i;c.right=f;d.left=j;d.right=k;j.left=n;j.right=o;f.left=g;f.right=h;g.left=l;g.right=m;l.left=p;l.right=q;
		
		System.out.println(countLeafNode(a));*/
		int height = treeHeightForSpiral(root);
		for(int i = 0;i<=height;i++)
		{
			if(i%2==0)
			{
				printGivenLevelForSpiral(root,i,true);
			}
			else
			{
				printGivenLevelForSpiral(root, i,false);
			}
			System.out.println();
		}
	}
	public static void printGivenLevelForSpiral(Node2 root,int level,boolean itr)
	{
		if(root==null)
			return;
		if(level==0)
		{
			System.out.print(root.data+" ");
		}
		else
		{
			if(itr==false)
			{
				printGivenLevelForSpiral(root.left, level-1,itr);
				printGivenLevelForSpiral(root.right, level-1,itr);
			}
			else
			{
				printGivenLevelForSpiral(root.right, level-1,itr);
				printGivenLevelForSpiral(root.left, level-1,itr);
			}
		}
	}
	public static int treeHeightForSpiral(Node2 root)
	{
		if(root.left==null&&root.right==null)
			return 0;
		else
		{
			int lHeight = treeHeightForSpiral(root.left);
			int rHeight = treeHeightForSpiral(root.right);
			return Math.max(lHeight, rHeight)+1;
		}
	}
	public static int countLeafNode(Node root)
	{		
		if(root.left==null&&root.right==null)
		{
			return 1;
		}
		else
		{
			int lCount = countLeafNode(root.left);
			int rCount = countLeafNode(root.right);
			return lCount+rCount;
		}
	}
	public static void printAllNodes(Node root, int[] path, int index)
	{
		/*
		 * int[] path = new int[10]; //at most 10 paths assumption
		 * int index = 0;
		 * printAllNodes(one,path,index);*/
		
		if(root.left==null&&root.right==null)
		{
			//when you hit the leaf node print all of the array contents
			path[index]=root.data;
			index++;
			for(int i = 0;i<index;i++)
			{
				System.out.print(path[i]+" ");
			}
			System.out.println();
			return;
		}
		else
		{
			path[index]=root.data;
			index++;
			printAllNodes(root.left, path, index);
			printAllNodes(root.right, path, index);
		}
	}
	public static void mirrorOfTree(Node root)
	{
		if(root.left==null&&root.right==null)
			return;
		else
		{
			mirrorOfTree(root.left);
			mirrorOfTree(root.right);
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
	}
	public static void postOrderTraversal(Node root)
	{
		if(root==null)
		{
			return;
		}
		else
		{
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data+" ");
		}
	}
	public static void deleteTreeByTraversal(Node root)
	{
		if(root.left==null&&root.right==null)
		{
			//leaf node only be printed
			System.out.println("leaf node"+root.data+" removed");
			root = null;
			return;
		}
		else
		{
			deleteTreeByTraversal(root.left);
			deleteTreeByTraversal(root.right);
			System.out.println("no-leaf node"+root.data+" removed");
			root=null;
		}
	}
	public static boolean areTheyIdentical(Node root1,Node root2)
	{
		/*
		if(areTheyIdentical(one, oneS))
			System.out.println("Identical");
		else
			System.out.println("Not identical");
		*/
		if(root1==null&&root2==null)
			return true;
		else if((root1==null&&root2!=null)||(root1!=null&&root2==null))
			return false;
		else
			return (root1.data==root2.data)&&(areTheyIdentical(root1.left, root2.left))&&(areTheyIdentical(root1.right, root2.right));
	}
	public static int size(Node root)
	{
		//size of a tree is equal = size of left subtree + 1 + right
		if(root.left==null&&root.right==null)
		{
			return 1;
		}
		else
		{
			return size(root.left) + 1 + size(root.right);
		}
	}
	public static void InOrder(Node root)
	{
		if(root==null)
		{
			return;
		}
		else
		{
			InOrder(root.left);
			System.out.println(root.data);
			InOrder(root.right);
		}
	}
	public static void printLevelOrder(Node root)
	{
		int h = heightOfTree(root);
		for(int i = 0;i<=h;i++)
		{
			printGivenLevel(root,i);
			System.out.println();
		}
	}
	public static void printGivenLevel(Node root,int level)
	{
		if(root==null)
		{
			return;
		}
		if(level==0)
		{
			System.out.print(root.data+" ");
			return;
		}
		else
		{
			printGivenLevel(root.left,level-1);
			printGivenLevel(root.right,level-1);
		}
	}
	public static int heightOfTree(Node root)
	{
		if(root==null)
		{
			return -1;
		}
		else
		{
			int lHeight = heightOfTree(root.left);
			int rHeight = heightOfTree(root.right);
			return Math.max(lHeight,rHeight)+1;
		}
	}
	public static void levelOrderTraversalQueue(Node root)
	{
		Queue<Node> queue = new LinkedList<Node>();
		Node temp = root;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			queue.add(temp.left);
			queue.add(temp.right);
			temp = queue.remove();
		}
	}
	/*
	public static void printLevelOrder(Node root)
	{
		int h = findHeight(root);
		for(int i = 0;i<=h;i++) //each level of tree. root is 0 leaf is 2
		{
			printGivenLevel(root,i);
			System.out.println();
		}
	}
	public static void printGivenLevel(Node root,int level)
	{
		if(root==null)
		{
			return;
		}
		if(level==0)
		{
			System.out.print(root.data+" ");
			return;
		}
		else if(level>0)
		{
			printGivenLevel(root.left,level-1);
			printGivenLevel(root.right,level-1);
		}
	}
	*/
	public static int findHeight(Node root)
	{
		if(root.left==null&&root.right==null)
		{
			return 0;
		}
		else
		{
			int lTree = findHeight(root.left);
			int rTree = findHeight(root.right);
			return Math.max(lTree, rTree)+1;
		}
	}
}
