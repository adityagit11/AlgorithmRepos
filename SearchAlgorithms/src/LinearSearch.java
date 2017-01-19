/*
 * Linear Search has O(n) time complexity*/

//import Scanner Class
import java.util.Scanner;

public class LinearSearch
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
		for(int i = 0;i<a.length;i++)
		{
			if(a[i]==x)
				return i;
		}
		return -1;
	}
}
