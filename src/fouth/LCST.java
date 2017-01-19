package fouth;

public class LCST
{
	public int[][] getDp(char[] c1, char[] c2)
	{
		int[][] dp = new int[c1.length][c2.length];
		
		dp[0][0] = c1[0] == c2[0] ? 1 : 0;
		
		for(int i = 1; i < c1.length; i++)
		{
			if(c1[i] == c2[0])
				dp[i][0] = 1;
		}
		
		for(int j = 1; j < c2.length; j++)
		{
			if(c1[j] == c1[0])
				dp[0][j] = 1;
		}
		
		for(int i = 1; i < c1.length; i++)
		{
			for(int j = 1; j < c2.length; j++)
			{
				if(c1[i] == c2[j])
				{
					dp[i][j] = dp[i-1][j-1]+1;
				}
			}
		}
		return dp;
	}
	
	public String lcst(String str1, String str2)
	{
		if(str1 == null || str2 == null || str1.equals("") ||str2.equals(""))
		{
			return "";
		}
		
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		
		int[][] dp = getDp(c1, c2);
		int max = 0;
		int index = 0;
		for(int i = 0; i < c1.length; i++)
		{
			for(int j = 0; j < c2.length; j++)
			{
				if(dp[i][j] > max)
				{
					max = dp[i][j];
					index = i;
				}
			}
		}
		
		return str1.substring(index-max+1,index+1);
	}
	
	public static void main(String[] args)
	{
		String str = "1234567890";
		
		System.out.println(str.substring(1,5));
	}
}
