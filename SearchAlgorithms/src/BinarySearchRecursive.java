/*
 * Binary Search: Search a sorted array by repeatedly dividing the search interval in half.
 * Begin with an interval covering the whole array. If the value of the search key is 
 * less than the item in the middle of the interval, narrow the interval to the lower half. 
 * Otherwise narrow it to the upper half. 
 * Repeatedly check until the value is found or the interval is empty.
 * Binary Search Time complexity is O(Log n)
 * Tip: The array must already be sorted hence right balance between sorting and search algorithm is a must*/

//import Scanner Class
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursive
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
		
		//sort the array
		Arrays.sort(ar);
		
		if(whetherPresent(ar, searchElement,0,ar.length-1)!=-1)
			System.out.println("Found at "+whetherPresent(ar, searchElement,0,ar.length-1)+" (0-based indexing)");
		else
			System.out.println("Not Found");
		
		input.close();
	}
	public static int whetherPresent(int[] a,int x,int low,int high)
	{
		if(low<=high)
		{
			if(a[(low+high)/2]==x)
				return (low+high)/2;
			else if(a[(low+high)/2]<x)
				return whetherPresent(a, x, ((low+high)/2)+1, high);
			else if(a[(low+high)/2]>x)
				return whetherPresent(a, x, low, ((low+high)/2)-1);
		}
		return -1;
	}
}
