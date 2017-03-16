package TreePack4;

public class TreeDriver
{
	public static void main(String args[])
	{
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
		
		/*
		//isomorphic trees
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		five.left = seven;
		five.right = eight;
		
		Node one2 = new Node(1);
		Node two2 = new Node(2);
		Node three2 = new Node(3);
		Node four2 = new Node(4);
		Node five2 = new Node(5);
		Node six2 = new Node(6);
		Node seven2 = new Node(7);
		Node eight2 = new Node(8);
		
		one2.left = three2;
		one2.right = two2;
		three.right = six2;
		two2.left = four2;
		two2.right = five2;
		five2.left = eight2;
		five2.right = seven2;
		*/
		
		/*
		//removing half nodes
		Node root = new Node(2);
		Node seven = new Node(7);
		Node five = new Node(5);
		Node six = new Node(6);
		Node nine = new Node(9);
		Node one = new Node(1);
		Node eleven = new Node(11);
		Node four = new Node(4);
		
		root.left = seven;
		root.right = five;
		seven.right = six;
		five.right = nine;
		six.left = one;
		six.right = eleven;
		nine.left = four;
		*/
		
		/*
		//nodes at same level
		Node root = new Node(12);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node five = new Node(5);
		Node nine = new Node(9);
		
		root.left = five;
		five.left = three;
		five.right = nine;
		three.left = one;
		nine.left = two;
		*/
		
		/*
		Node root = new Node(20);
		Node nine = new Node(9);
		Node fortyNine = new Node(49);
		Node five = new Node(5);
		Node twelve = new Node(12);
		Node fifteen = new Node(15);
		Node twentyThree = new Node(23);
		Node fiftyTwo = new Node(52);
		Node fifty = new Node(50);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node six = new Node(6);
		Node seven = new Node(7);
		
		root.left = nine;
		root.right = fortyNine;
		fortyNine.left = twentyThree;
		fortyNine.right = fiftyTwo;
		nine.left = five;
		nine.right = twelve;
		twelve.right = fifteen;
		fiftyTwo.left = fifty;
		five.left = one;
		five.right = two;
		twelve.left = three;
		twentyThree.left = four;
		twentyThree.right = six;
		fiftyTwo.right = seven;
		*/
		
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
		
		System.out.println(MaxSumRootLeafPath.run(root));
	}
}
