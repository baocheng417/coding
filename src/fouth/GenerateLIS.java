package fouth;

public class GenerateLIS
{
	public int[] generateLIS(int[] arr, int[] dp)
	{
		int max = 0;
		int index = 0;
		
		for(int i = 0; i < dp.length; i++)
		{
			if(dp[i] > dp[i])
			{
				max = dp[i];
				index = i;
			}
		}
		
		int[] lis = new int[max];
		lis[--max] = arr[index];
		
		for(int i = index; i >= 0; i--)
		{
			lis[--max] = arr[i];
			if(arr[i] < arr[index] && dp[i] == dp[index]- 1)
			{
				lis[--max] = arr[i];
				index = i;
			}
		}
		return lis;
		
	}
	
	public int[] getdp1(int[] arr)
	{
		int[] dp = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++)
		{
			dp[i] = 1;
			for(int j = 0; j < i; j++)
			{
				if(arr[j] > arr[i])
				{
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}
		}
		return dp;
	}
	
	public int[] lis1(int[] arr)
	{
		if(arr == null || arr.length == 0 )
			return null;
		int[] dp = getdp1(arr);
		return generateLIS(arr,dp);
	}
	
	public int[] getdp2(int[] arr)
	{
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		int right = 0;
		dp[0] = 1;
		ends[0] = arr[0];
		int l = 0;
		int r = 0;
		int m = 0;
		
		for(int i = 1; i < arr.length; i++)
		{
			l = 0;
			r = right;
			while(l <= r)
			{
				m = (l+r)/2;
				if(arr[i] > ends[m])
				{
					l = m + 1;
				}
				else
				{
					r = m - 1;
				}
			}
			right = Math.max(right,l);
			ends[l] = arr[i];
			dp[i] = l + 1;
		}
		return dp;
	}
	
	
}
