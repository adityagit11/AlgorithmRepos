import java.util.Scanner;

/*
 * Read the Jump Search algorithm in the same default package.
 * Jump search has time complexity of O(sqrt(n))
 * Binary Search has time complexity of O(Logn)
 * Linear Search has time complexity of O(n)
 * 
 * But we can further improve the jump search by implementing the binary search in the later part*/

public class JumpSearchImproved
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
		return whetherPresent(a,x,index-hop+1,index);
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
