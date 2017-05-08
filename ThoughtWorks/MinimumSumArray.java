package ThoughtWorks;

import java.util.Arrays;

/*

Minimum sum of two numbers formed from digits of an array
Given an array of digits (values are from 0 to 9), find the minimum possible sum of two numbers formed from digits of the array. All digits of given array must be used to form the two numbers.

Input: [6, 8, 4, 5, 2, 3]
Output: 604
The minimum sum is formed by numbers 
358 and 246

Input: [5, 3, 0, 7, 4]
Output: 82
The minimum sum is formed by numbers 
35 and 047

*/

import java.util.Scanner;

public class MinimumSumArray 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of digits in array:");
		int n = input.nextInt();
		int[] ar = new int[n];
		System.out.println("Enter the digits:");
		for(int i = 0;i<ar.length;i++)
		{
			ar[i] = input.nextInt();
		}
		input.close();
		
		Arrays.sort(ar);
		
		String alpha = "";
		String beta = "";
		
		for(int i = 0;i<ar.length;i++)
		{
			if(i%2==0)
				alpha = alpha + ar[i];
			else
				beta = beta + ar[i];
		}
		
		System.out.println(alpha+" "+beta);
		System.out.println("Sum : "+(Integer.parseInt(alpha)+Integer.parseInt(beta)));
	}
}
