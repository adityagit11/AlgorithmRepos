package ThoughtWorks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Check whether two strings are anagram of each other
 * Write a function to check whether two given strings are anagram of each other or not. 
 * An anagram of a string is another string that contains same characters, 
 * only the order of characters can be different. 
 * For example, “abcd” and “dabc” are anagram of each other.*/

import java.util.Scanner;

public class WhetherAnagram 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		String s1 = input.next();
		String s2 = input.next();
		input.close();
		
		System.out.println(usingSorting(s1, s2));
	}
	
	public static boolean usingSorting(String s1, String s2)
	{
		char[] s1Ar = s1.toCharArray();
		char[] s2Ar = s2.toCharArray();
		
		Arrays.sort(s1Ar);
		Arrays.sort(s2Ar);
		
		for(int i = 0;i<s1Ar.length;i++)
		{
			boolean flag = false;
			for(int j = 0;j<s2Ar.length;j++)
			{
				if(s1Ar[i]==s2Ar[j])
					flag = true;
			}
			if(flag==false)
				return false;
		}
		return true;
	}
	
	public static boolean usingHashMap(String s1, String s2)
	{
		HashMap<Character, Integer> myHash1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> myHash2 = new HashMap<Character, Integer>();
		
		for(int i = 0;i<s1.length();i++)
		{
			if(myHash1.containsKey(s1.charAt(i)))
				myHash1.replace(s1.charAt(i), myHash1.get(s1.charAt(i))+1);
			else
				myHash1.put(s1.charAt(i), 1);
		}
		
		for(int i = 0;i<s2.length();i++)
		{
			if(myHash2.containsKey(s2.charAt(i)))
				myHash2.replace(s2.charAt(i), myHash2.get(s2.charAt(i))+1);
			else
				myHash2.put(s2.charAt(i), 1);
		}
		
		for(Map.Entry<Character, Integer> itr1: myHash1.entrySet())
		{
			boolean flag = false;
			for(Map.Entry<Character, Integer> itr2: myHash2.entrySet())
			{
				if(itr1.getValue()==itr2.getValue()&&itr1.getKey()==itr2.getKey())
					flag = true;
			}
			if(flag==false)
				return false;
		}
		return true;
	}
	
	public static boolean usingBrute(String s1, String s2)
	{
		for(int i = 0;i<s1.length();i++)
		{
			boolean found = false;
			for(int j = 0;j<s2.length();j++)
			{
				if(s1.charAt(i)==s2.charAt(j))
					found = true;
			}
			if(found==false)
				return false;
		}
		return true;
	}
}
