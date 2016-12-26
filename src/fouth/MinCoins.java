package fouth;

public class MinCoins
{
	public int minCoins1(int[] arr, int aim)
	{
		if(arr == null || arr.length == 0 || aim < 0)
			return -1;
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][aim+1];
		for(int j = 1; j < dp[0].length; j++)
		{
			
		}
	}
}
