import java.util.*;
public class KnapsackDP
{
	public static void main(String args[])
	{
		//Knapsack problems are pretty simple to classify.
		//Suppose you are given an object such that each object has two characteristics
		//out of which, one is given constant (bag of knapsack - W)
		//and the other has be maximized.
		Scanner input = new Scanner(System.in);
		//suppose you a bag and very many items to keep in the bag.
		//now each item has a weight and value.
		//the constraint is that the bag is of a constant weight
		//you have to fill the bag with the items to maximize the total value in the bag
		System.out.println("enter the number ofitems");
		int n = input.nextInt();
		int[] value = new int[n];
		int[] weight = new int[n];
		System.out.println("enter the values of "+n+" items");
		for(int i = 0;i<n;i++)
		{
			value[i]=input.nextInt();
		}
		System.out.println("enter the weights of "+n+" items");
		for(int i = 0;i<n;i++)
		{
			weight[i]=input.nextInt();
		}
		System.out.println("Enter the maximum weight that the bag can hold");
		int w = input.nextInt();
		input.close();
		
		//below program works out the maximum count of the elements;
		
		int[][] matrix = new int[n][w+1]; //design a matrix of rows equal to no. of items and columns equal to weight + 1
		for(int i = 0;i<matrix.length;i++)
		{
			for(int j = 0;j<matrix[i].length;j++)
			{
				if(i==0)
				{
					if(j<weight[i])
						matrix[i][j]=0;
					else
						matrix[i][j]=1;
				}
				else
				{
					if(j<weight[i])
					{
						matrix[i][j]=matrix[i-1][j];
					}
					else if(j>=weight[i])
					{
						matrix[i][j]=Math.max(matrix[i-1][j], 1+matrix[i-1][j-weight[i]]);
					}
				}
			}
		}
		for(int i = 0;i<matrix.length;i++)
		{
			for(int j = 0;j<matrix[i].length;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("maximum count "+matrix[n-1][w]);
		
		//the maximum values will be
		
		
		//overwriting the the same matrix
		for(int i = 0;i<matrix.length;i++)
		{
			for(int j = 0;j<matrix[i].length;j++)
			{
				if(i==0)
				{
					if(j<weight[i])
						matrix[i][j]=0;
					else
						matrix[i][j]=value[i];
				}
				else
				{
					if(j<weight[i])
					{
						matrix[i][j]=matrix[i-1][j];
					}
					else if(j>=weight[i])
					{
						matrix[i][j]=Math.max(matrix[i-1][j], value[i]+matrix[i-1][j-weight[i]]);
					}
				}
			}
		}
		for(int i = 0;i<matrix.length;i++)
		{
			for(int j = 0;j<matrix[i].length;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("maximum values sum "+matrix[n-1][w]);
		
	}
}