import java.util.Scanner;
public class LongestCommonSubsequenceNormal
{
	public static void main(String args[])
	{
		//given two strings you have to find the longest common subsequence between them and it's length
		//example: abcdaf and acbcf has abcf as LCS.
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first string");
		String s1 = input.next();
		System.out.println("Enter the second string");
		String s2 = input.next();
		input.close();
		char[] ar = new char[Math.min(s1.length(), s2.length())]; //define an char array to store the matching sequence
		int count = 0; //length of string
		int pos = 0; //variable to store the char index upto which the matching has been achieved
		for(int i = 0;i<s1.length();i++)
		{
			for(int j = pos;j<s2.length();j++)
			{
				if(s1.charAt(i)==s2.charAt(j))
				{
					ar[count]=s1.charAt(i);
					count++;
					pos = j;
				}
			}
		}
		for(int i = 0;i<count;i++)
		{
			System.out.print(ar[i]);
		}
	}
}