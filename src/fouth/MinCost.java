package fouth;

public class MinCost
{
	public int minCost1(String str1, String str2, int ic, int dc, int rc)
	{
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		int m = c1.length+1;
		int n = c2.length+1;
		
		int[][] dp = new int[m][n];
		
		for(int i = 1; i < m; i++)
		{
			dp[i][0] = dc * i;
		}
		
		for(int j = 1; j < n; j++)
		{
			dp[0][j] = ic*j;
		}
		
		for(int i = 1; i < m; i++)
		{
			for(int j = 1; j < n; j++)
			{
				if(c1[i] == c2[j])
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else
				{
					dp[i][j] = dp[i-1][j-1]+rc;
				}
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+dc);
				dp[i][j] = Math.max(dp[i][j], dp[i][j-1]+ic);
			}
		}
		
		return dp[m-1][n-1];
	}
	
	public int minCoin2(String str1, String str2, int ic, int dc ,int rc)
	{
		if(str1 == null || str2 == null)
			return 0;
		
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		
		char[] longs = c1.length >= c2.length ? c1 : c2;
		char[] shorts = c1.length < c2.length ? c1 : c2;
		
		
		int[] dp = new int[shorts.length+1];
		
		for(int i = 1; i < shorts.length; i++)
		{
			dp[i] = ic*i;
		}
		
		for(int i = 1; i < longs.length; i++)
		{
			int pre = dp[0];
			dp[0] = dc *i;
			
			for(int j = 1; j < shorts.length; j++)
			{
				int tmp = dp[j]; //dp[j]没更新前先保存下来
				
				if(longs[i-1] == shorts[j-1])
				{
					dp[j] = pre;
				}
				else
				{
					dp[j] = pre + rc;
				}
				dp[j] = Math.max(dp[j], dp[j-1]+ic);
				dp[j] = Math.max(dp[j], tmp + dc);
				pre = tmp;
			} 	
		}
		return dp[shorts.length];
	}
}
