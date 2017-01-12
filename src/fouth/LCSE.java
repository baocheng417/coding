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

		int max = 0;
		int end = 0;
		
		for(int i = dp.length-1; i >= 0; i--)
		{
			for(int j = dp[0].length-1; j >= 0; j--)
			{
				if(dp[i][j] > max)
				{
					end = i;
					max= dp[i][j];
				}
			}
		}
		return str1.substring(end-max+1, end+1);
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
	
	public String lcse2(String str1, String str2)
	{
		if(str1 == null || str2 == null || str1.equals("") || str2.equals(""))
		{
			return "";
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		
		int row = 0;
		int col = chs2.length - 1;
		int max = 0;
		int end = 0;
		
		while(row < chs1.length)
		{
			int i = row;
			int j = col;
			int len = 0;
			
			while(i < chs1.length && j < chs2.length)
			{
				if(chs1[i] != chs2[j])
				{
					len = 0;
				}
				else
				{
					len++;
				}
				
				if(len > max)
				{
					end = i;
					max = len;
				}
				i++;
				j++;
			}
			if(col > 0)
			{
				col--;
			}
			else
			{
				row++;
			}
		}
		return str1.substring(end-max+1, end+1);
	}
}
