package TreePack2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node
{
	int data;
	Node left, right;
	Node(int data)
	{
		this.data = data;
		left = right = null;
	}
}

public class Main
{
	public static void main(String args[])
	{
		Node twenty = new Node(20);
		Node twentyTwo = new Node(22);
		Node eight = new Node(8);
		Node four = new Node(4);
		Node twelve = new Node(12);
		Node ten = new Node(10);
		Node fourteen = new Node(14);
		
		twenty.left = eight; twenty.right = twentyTwo; eight.left = four; eight.right = twelve; twelve.left = ten; twelve.right = fourteen;
		
		whetherCompleteTree(twenty);
		
	}
	public static void whetherCompleteTree(Node root)
	{
		/*
		 * Simple problem.
		 * Enqueue whole tree in a queue and the absent nodes must be filled with 0.
		 * Now check whether queue should not contain any 0's and if it contains they should be in the right
		 * [1,2,3,4,5,0,0,0]*/
		Queue<Node> myQ = new LinkedList<Node>();
		Stack<Integer> myStack = new Stack<Integer>();
		whetherCompleteTree_child(root,myQ,myStack);
		
		while(!myStack.isEmpty())
			System.out.print(myStack.pop()+" ");
		/*
		 * Check the ouput of complete binary tree: 0 0 14 0 0 10 0 0 12 0 0 4 22 8 20 
		 * Check the output of non complete binary tree: 0 0 14 0 0 10 12 0 0 4 0 0 22 8 20 */
	}
	public static void whetherCompleteTree_child(Node root, Queue<Node> myQ, Stack<Integer> myStack)
	{
		if(root==null)
		{
			return;
		}
		else
		{
			myStack.push(root.data);
			if(root.left!=null)
				myQ.add(root.left);
			else
				myStack.push(0);
			if(root.right!=null)
				myQ.add(root.right);
			else
				myStack.push(0);
			if(!myQ.isEmpty())
			{
				root = myQ.remove();
				whetherCompleteTree_child(root, myQ, myStack);
			}
		}
	}
	public static void searchRightNode(Node root, int data)
	{
		Queue<Node> myQ = new LinkedList<Node>();
		searchRightNode_child(root,data,myQ);
	}
	public static void searchRightNode_child(Node root, int data, Queue<Node> myQ)
	{
		if(root==null)
			return;
		else
		{
			if(root.left!=null)
				myQ.add(root.left);
			if(root.right!=null)
				myQ.add(root.right);
			if(!myQ.isEmpty())
			{
				if(root.data==data)
				{
					System.out.println(myQ.remove().data);
					return;
				}
				root = myQ.remove();
				searchRightNode_child(root, data, myQ);
			}
		}
	}
	public static void levelOrderTraversalQueue(Node root)
	{
		//this alorithm works in O(n) time
		Queue<Node> myQ = new LinkedList<Node>();
		levelOrderTraversalQ_child(root,myQ);
	}
	public static void levelOrderTraversalQ_child(Node root, Queue<Node> myQ)
	{
		if(root==null)
			return;
		else
		{
			System.out.print(root.data+" ");
			if(root.left!=null)
				myQ.add(root.left);
			if(root.right!=null)
				myQ.add(root.right);
			if(!myQ.isEmpty())
			{
				root = myQ.remove();
				levelOrderTraversalQ_child(root,myQ);
			}
		}
	}
	public static boolean whetherLeafSameLevel(Node root)
	{
		int h = height(root);
		if(countNodesAtLevel(root,h)==countLeafNodes(root))
			return true;
		else
			return false;
	}
	public static int countNodesAtLevel(Node root, int level)
	{
		if(root==null)
			return 0;
		if(level==0&&root.left==null&&root.right==null)
		{
			return 1;
		}
		else
		{
			int lTree = countNodesAtLevel(root.left, level-1);
			int rTree = countNodesAtLevel(root.right, level-1);
			return lTree+rTree;
		}
	}
	public static int countLeafNodes(Node root)
	{
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return 1;
		else
		{
			int lTree = countLeafNodes(root.left);
			int rTree = countLeafNodes(root.right);
			return lTree + rTree;
		}
	}
	public static void inOrderTraversal(Node root)
	{
		if(root==null)
		{
			return;
		}
		else
		{
			inOrderTraversal(root.left);
			System.out.print(root.data+" ");
			inOrderTraversal(root.right);
		}
	}
	public static void whetherSubtree(Node root1, Node root2)
	{
		//to find whether root2 is subtree of root1
		Node startNode = findNode(root1, root2.data);
		if(startNode!=null&&compareTree(startNode, root2))
		{
			System.out.println("Yes it's a subtree");
		}
		else
		{
			System.out.println("Not a subtree");
		}
	}
	public static boolean compareTree(Node root1, Node root2)
	{
		if(root1==root2)
			return true;
		else
		{
			return compareTree(root1.left,root2.left)&&compareTree(root1.right, root2.right);
		}
	}
	public static Node findNode(Node root, int data)
	{
		//returns the first data
		if(root==null)
			return null;
		if(root.data==data)
			return root;
		else
		{
			Node left = findNode(root.left, data);
			Node right = findNode(root.right, data);
			if(left!=null)
				return left;
			if(right!=null)
				return right;
			return null;
		}
	}
	public static void printLevelFrom(Node root, int low, int high)
	{
		for(int i = low;i<=high;i++)
		{
			printGivenLevel(root,(i-1));
			System.out.println();
		}
	}
	public static void printGivenLevel(Node root, int level)
	{
		if(root==null)
			return;
		if(level==0)
		{
			System.out.print(root.data+" ");
		}
		else
		{
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}
	public static int height(Node root)
	{
		if(root==null)
			return -1;
		else
		{
			int lHeight = height(root.left);
			int rHeight = height(root.right);
			return Math.max(lHeight,rHeight)+1;
		}
	}
}
