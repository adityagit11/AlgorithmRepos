package huffman;

import java.util.Arrays;
import java.util.Scanner;

class Node
{
	int data;
	int child;
	Node left, right, next;
	Node(int data)
	{
		this.data = data;
		left = right = next = null;
	}
}

public class Main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of entries?");
		int n = input.nextInt();
		
		int[] ar = new int[n];
		System.out.println("Enter the frequency of all "+n+" entries");
		for(int i = 0;i<n;i++)
		{
			ar[i] = input.nextInt();
		}
		input.close();
		
		//sort the array
		Arrays.sort(ar);
		
		Node head = null;
		for(int i = 0;i<n;i++)
		{
			head = insertNodeList(head,ar[i]);
		}
		
		System.out.println("Systematically printing the list");
		printList(head);
		
		while(true)
		{
			Node first = head;
			Node second = first.next;
			Node third = second.next;
			
			Node newNode = new Node(first.data+second.data);
			if(first.data<second.data)
			{
				newNode.left = first;
				newNode.right = second;
				first.child = 0;
				second.child = 1;
			}
			else
			{
				newNode.left = second;
				newNode.right = first;
				first.child = 1;
				second.child = 0;
			}
			
			Node prev = head, next = head;
			while(next.data<newNode.data)
			{
				prev = next;
				next = prev.next;
				if(next==null)
					break;
			}
			
			if(third==null)
			{
				first.next = null;
				head = newNode;
				newNode.next = third;
				
				printList(head);
				break;
			}
			else
			{
				newNode.next = next;
				prev.next = newNode;
				head = third;
				first.next = null;
				second.next = null;
			}
			
			printList(head);
		}
		
		System.out.println("Printing the huffmann tree");
		levelOrderTraversal(head);
		
		int[] array = new int[10];
		int index = 0;
		
		for(int i = 0;i<n;i++)
		{
			System.out.print("For entry "+ar[i]+" the code word generated is : ");
			printTreeCode(head,array,index,ar[i]);
			System.out.println();
		}
	}
	public static Node insertNodeList(Node head, int data)
	{
		Node newNode = new Node(data);
		if(head==null)
		{
			head = newNode;
		}
		else
		{
			Node temp = head;
			while(temp.next!=null)
			{
				temp = temp.next;
			}
			temp.next = newNode;
		}
		return head;
	}
	public static void printTreeCode(Node root, int[] ar, int index, int data)
	{
		//this function takes root of the tree, array, index counter for array and leaf data of the tree you want to search
		if(root==null)
			return;
		if(root.data == data)
		{
			ar[index] = root.child;
			index++;
			for(int i = 1;i<index;i++)
			{
				System.out.print(ar[i]);
			}
			return;
		}
		else
		{
			ar[index] = root.child;
			index++;
			printTreeCode(root.left, ar, index, data);
			printTreeCode(root.right, ar, index, data);
		}
	}
	public static void levelOrderTraversal(Node root)
	{
		int h = height(root);
		for(int i = 0;i<=h;i++)
		{
			printGivenLevel(root, i);
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
	public static void printList(Node head)
	{
		Node temp = head;
		while(temp!=null)
		{
			if(temp.next==null)
			{
				System.out.print(temp.data+" ");
			}
			else
			{
				System.out.print(temp.data+" -> ");
			}
			temp = temp.next;
		}
		System.out.println();
	}
}