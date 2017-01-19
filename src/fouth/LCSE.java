package fouth;

public class LCSE
{
	public String lcse(String str1, String str2)
	{
		if(str1 == null || str2 == null || str1.equals("") || str2.equals(""))
		{
			return "";
		}
		
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		
		int[][] dp = getDp(c1, c2);
		char[] res = new char[dp[dp.length-1][dp[0].length-1]];
		int index = res.length - 1;
		
		for(int i = dp.length-1; i >= 0; i--)
		{
			for(int j = dp[0].length-1; j >= 0; j--)
			{
				if(i != 0 && dp[i][j] == dp[i-1][j])
				{
					i--;
				}
				if(j != 0 && dp[i][j] == dp[i][j-1])
				{
					j--;
				}
				else
				{
					res[index--] = c1[i];
					i--;
					j--;
				}
			}
		}
		return String.valueOf(res);
	}
	
	public int[][] getDp(char[] c1, char[] c2)
	{
		int[][] dp = new int[c1.length][c2.length];
		dp[0][0] = c1[0] == c2[0] ? 1 : 0;
		
		for(int i = 1; i < c1.length; i++)
		{
			dp[i][0] = Math.max(dp[i-1][0], c1[i] == c2[0] ? 1 : 0);
		}
		
		for(int j = 1; j < c2.length; j++)
		{
			dp[0][j] = Math.max(dp[0][j-1], c1[0] == c2[j] ? 1 : 0);
		}
		
		for(int i = 1; i < c1.length; i++)
		{
			for(int j = 1; j < c2.length; j++)
			{
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if(c1[i] == c2[j])
				{
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
				}
			}
		}
		return dp;
	}
	
	
}
