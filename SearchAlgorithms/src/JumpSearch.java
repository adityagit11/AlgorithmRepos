/*
 * Jump search is the most awesome searching algorithm out there, 
 * The basic logic is simple consider an array given below
 * 
 *  0  1  2  3   4   5   6   7   8   9   10  11  12  13  14   15   16   17
 * [1, 4, 9, 13, 17, 21, 34, 45, 67, 89, 90, 92, 94, 99, 100, 144, 189, 198]
 * 
 * Now suppose you wanna search 45. So start from a[0] and keep hoping the array till you either find the element
 * or find an element greater than the search element. So suppose you hop at 4 blocks so a[0*4] -> a[1*4] -> a[2*4]...
 * At a[2*4] is 67 which is greater than 45. So now move back to previous hop +1. i.e. move to a[1*4+1] which is 21
 * Now apply linear search from there on. So total 6 comparisons are applied. Linear search would have needed 8. 
 * 
 * So what is the best hop? 
 * What is the optimal block size to be skipped? 
 * In the worst case, we have to do n/m jumps and if the last checked value is greater than the element to be searched for,
 * we perform m-1 comparisons more for linear search. 
 * Therefore the total number of comparisons in the worst case will be ((n/m) + m-1). 
 * The value of the function ((n/m) + m-1) will be minimum when m = sqrt(n). 
 * Therefore, the best step size is m = sqrt(n).
 * 
 * Time complexity is O(sqrt(n))
 * The time complexity of block / jump search is between linear and binary search algorithms
 * 
 * But sometime it is better than binary search.
 * See take an example where the size of the array is 10000. and you have to search for an element let's say x. 
 * This element x happens to be first element. So in:
 * Binary Search - log(10^4) = 4 comparisons
 * Jump Search - sqrt(10^4) = 100, that means you reached array[100]. 
 * Now the element to be searched is not on array[100], so apply linear search and you reach 
 * 1st element. Comparisons req. is 2.*/

//import Scanner Class
import java.util.Scanner;

public class JumpSearch
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
		int size = input.nextInt();
		
		int[] ar = new int[size];
		System.out.println("Enter the elements in the array");
		for(int i =0 ;i<size;i++)
		{
			ar[i]=input.nextInt();
		}
		
		System.out.println("Enter the element you want to search");
		int searchElement = input.nextInt();
		
		if(whetherPresent(ar, searchElement)!=-1)
			System.out.println("Found at "+whetherPresent(ar, searchElement));
		else
			System.out.println("Not Found");
		input.close();
	}
	public static int whetherPresent(int[] a,int x)
	{
		int hop = (int)Math.sqrt(a.length);
		int index = 0;
		int temp = a[index];
		while(temp<=x)
		{
			if(temp==x)
				return index;
			index = index + hop;
			temp = a[index];
		}
		int high = index;
		index = index - hop+1;
		for(;index<high;index++)
		{
			if(a[index]==x)
				return index;
		}
		return -1;
	}
}
