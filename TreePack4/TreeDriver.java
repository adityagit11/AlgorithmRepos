package TreePack4;

public class TreeDriver
{
	public static void main(String args[])
	{
		Node root = new Node(11);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node sixteen = new Node(16);
		Node two = new Node(2);
		Node nine = new Node(9);
		Node five = new Node(5);
		Node eight = new Node(8);
		
		root.left = six;
		root.right = seven;
		six.left = sixteen;
		sixteen.left = two;
		sixteen.right = nine;
		seven.left = five;
		five.right = eight;
		
		/*
		//foldable tree
		Node root = new Node(10);
		Node seven = new Node(7);
		Node fifteen = new Node(15);
		Node nine = new Node(9);
		Node eleven = new Node(11);
		
		root.left = seven;
		root.right = fifteen;
		seven.right = nine;
		fifteen.left = eleven;
		*/
		
		/*
		//diameter tree
		Node root = new Node(1);
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
		Node twelve = new Node(12);
		Node thirteen = new Node(13);
		Node fourteen = new Node(14);
		Node fifteen = new Node(15);
		
		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		four.left = seven;
		four.right = eight;
		three.right = six;
		five.right = nine;
		nine.left = eleven;
		nine.right = twelve;
		twelve.right = fifteen;
		eight.left = ten;
		ten.left = thirteen;
		ten.right = fourteen;
		*/
		
		/*
		//sum tree
		Node root = new Node(10);
		Node twoN = new Node(-2);
		Node six = new Node(6);
		Node eight = new Node(8);
		Node fourN = new Node(-4);
		Node seven = new Node(7);
		Node five = new Node(5);
		
		root.left = twoN;
		root.right = six;
		twoN.left = eight;
		twoN.right = fourN;
		six.left = seven;
		six.right = five;
		*/
		
	}
}
