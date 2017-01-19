package fouth;

public class IsCorss
{
	public boolean isCross1(String str1, String str2, String aim)
	{
		if(str1 == null || str2 == null || aim == null)
		{
			return false;
		}
		
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		char[] chaim = aim.toCharArray();
		
		if(chaim.length != c1.length+c2.length)
		{
			return false;
		}
		
		boolean[][] dp = new boolean[c1.length+1][c2.length+1];
		
		for(int i = 1; i < c1.length; i++)
		{
			if(c1[i-1] != chaim[i-1])
			{
				break;
			}
			dp[i][0] = true;
		}
		
		for(int j = 1; j < c2.length; j++)
		{
			if(c2[j-1] != chaim[j-1])
			{
				break;
			}
			dp[0][j] = true;
		}
		
		for(int i = 1; i <= c1.length; i++)
		{
			for(int j = 1; j <= c2.length; j++)
			{
				if((c1[i-1] == chaim[i+j-1] && dp[i-1][j]) || (c2[j-1] == chaim[i+j-1] && dp[i][j-1]))
				{
					dp[i][j] = true;
				}
			}
		}
		return dp[c1.length][c2.length];
	}
}
