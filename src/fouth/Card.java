package fouth;

public class Card
{
	public int win1(int[] arr)
	{
		if(arr == null || arr.length == 0)
		{
			return 0;
		}
		
		return Math.max(f(arr, 0, arr.length-1), s(arr, 0, arr.length-1));
	}
	
	public int f(int[] arr, int i, int j)
	{
		if(i == j)
			return arr[i];
		else
		{
			return Math.max(arr[i] + s(arr, i+1, j) , arr[j]+s(arr, i, j-1));
		}
	}
	
	public int s(int[] arr, int i, int j)
	{
		if(i == j)
			return arr[i];
		else
		{
			return Math.min(f(arr, i+1, j), f(arr, i, j-1));
		}
	}
	
	public int win2(int[] arr)
	{
		if(arr == null || arr.length == 0)
		{
			return 0;
		}
		
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];
		
		for(int j = 0; j < arr.length; j++)
		{
			f[j][j] = arr[j];
			for(int i = j-1; i >= 0; i--)
			{
				f[i][j] = Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
				s[i][j] = Math.min(f[i-1][j], f[i+1][j]);
			}
		}
		return Math.max(s[0][arr.length-1], f[0][arr.length-1]);
	}
}
