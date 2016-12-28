package fouth;

public class Coins
{
	public int coins1(int[] arr, int aim)
	{
		if(arr == null || arr.length == 0 || aim < 0)
			return -1;
		return process1(arr,0,aim);
	}
	
	public int process1(int[] arr,int index, int aim)
	{
		int res = 0;
		
		if(index == arr.length)
		{
			res = aim == 0 ? 1 : 0;
		}
		else
		{
			for(int i = 0; arr[index] * i <= aim; i++)
			{
				res += process1(arr,index+1,aim - arr[index]*i);
			}
		}
		return res;
	}
	
	public int coins2(int[] arr, int aim)
	{
		if(arr == null || arr.length == 0 || aim < 0)
			return 0;
		int[][] map = new int[arr.length+1][aim+1];
		return process2(arr,0,aim,map);
	}
	
	public int process2(int[] arr, int index, int aim, int[][] map)
	{
		int res = 0;
		
		if(index == arr.length)
			return aim == 0 ? 1 : 0;
		else
		{
			int mapValue = 0;
			for(int i = 0; arr[index] * i <= aim; i++)
			{
				mapValue = map[index+1][aim - arr[index]*i];
				if(mapValue != 0)
				{
					res += mapValue == -1 ? 0 : mapValue;
				}
				else
				{
					res += process2(arr, index+1, aim-arr[index]*i,map);
				}
			}
		}
		map[index][aim] = res == 0 ? -1 : res;
		return res;
		
	}
	
	public int coins3(int[] arr , int aim)
	{
		if(arr == null || arr.length == 0 || aim < 0)
		{
			return 0;
		}
		
		int[][] dp = new int[arr.length][aim+1];
		int n = arr.length;
		
		for(int i = 0; i < n; i++)
		{
			dp[i][0] = 1;
		}
		
		for(int j = 0; j*arr[0] <= aim; j++)
		{
			dp[0][arr[0]*j] = 1;
		}
		
		int num = 0;
		for(int i = 1; i < n; i++)
		{
			for(int j = 1; j <= aim; j++)
			{
				num = 0;
				for(int k = 0; k*arr[i] <= aim; k++)
				{
					num += dp[i-1][j-arr[i]*k];
				}
				dp[i][j] = num;
			}
		}
		return dp[n-1][aim];
	}
	
	public int coins4(int[] arr, int aim)
	{
		if(arr == null || arr.length == 0 || aim < 0)
		{
			return 0;
		}
		
		int[] dp = new int[aim+1];
		
		for(int i = 0; i*arr[0] <= aim; i++)
		{
			dp[i*arr[0]] = 1; 
		}
		 
		for(int i = 1; i < arr.length; i++)
		{
			for(int j = 1; j <= aim; j++)
			{
				dp[j] += j - arr[i] >= 0 ? dp[j-arr[i]] : 0;
			}
		}
		return dp[aim];
	}
}
