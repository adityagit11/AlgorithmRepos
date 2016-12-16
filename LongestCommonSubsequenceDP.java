import java.util.Scanner;

public class LongestCommonSubsequenceDP
{
	public static void main(String args[])
	{
		//you have to find the longest common subsequence non - contiguous using DP
		//example: abcdaf and acbcf has abcf as LCS.
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first string");
		String s1 = input.next();
		System.out.println("Enter the second string");
		String s2 = input.next();
		input.close();
		
		int[][] matrix = new int[s1.length()][s2.length()]; //let's choose s1 as row and s2 as column
		for(int i = 0;i<matrix.length;i++)
		{
			for(int j = 0;j<matrix[i].length;j++)
			{
				if(i==0&&j==0)
				{
					if(s1.charAt(i)==s2.charAt(j))
						matrix[i][j]=1;
					else
						matrix[i][j]=0;
				}
				else if(i==0&&j!=0)
				{
					if(s1.charAt(i)==s2.charAt(j))
						matrix[i][j]=1;
					else
						matrix[i][j]=matrix[i][j-1];
				}
				else if(i!=0&&j==0)
				{
					if(s1.charAt(i)==s2.charAt(j))
						matrix[i][j]=1;
					else
						matrix[i][j]=matrix[i-1][j];
				}
				else
				{
					if(s1.charAt(i)==s2.charAt(j))
						matrix[i][j]=matrix[i-1][j-1]+1;
					else
						matrix[i][j]=Math.max(matrix[i-1][j],matrix[i][j-1]);
				}
			}
		}
		System.out.println(matrix[s1.length()-1][s2.length()-1]);
	}
}