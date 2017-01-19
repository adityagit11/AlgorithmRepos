import java.util.Scanner;

/*
 * Linear Search finds the element in O(n) time, Jump Search takes O(sqrt(n)) time and Binary Search take O(Log n) time. 
 * The Interpolation Search is an improvement over Binary Search for instances, 
 * where the values in a sorted array are uniformly distributed. Binary Search always goes to middle element to check. 
 * On the other hand interpolation search may go to different locations according the value of key being searched. 
 * For example if the value of key is closer to the last element, interpolation search is likely to start search toward 
 * the end side.
 * 
 * Time complexity :  If elements are uniformly distributed, then O (log log n)). In worst case it can take upto O(n).
 * which is still as good as linear search*/

public class InterpolationSearch
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
		int lo = 0;
		int hi = a.length-1;
		while(lo<=hi)
		{
			int midPos = (int) (lo + (((double)(hi-lo) / (a[hi]-a[lo]))*(x - a[lo])));
			if(a[midPos]==x)
				return midPos;
			else if(a[midPos]<x)
				lo = midPos + 1;
			else
				hi = midPos - 1;
		}
		return -1;
	}
}
