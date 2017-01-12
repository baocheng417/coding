package fouth;

public class Hanoi
{
	public void hanoi(int n)
	{
		if(n > 0)
			func(n, "left", "mid", "right");
	}
	
	public void func(int n, String from, String mid, String to)
	{
		if(n == 1)
		{
			System.out.println("move from"+ from + " to" + to );
		}
		else
		{
			func(n-1, from, to, mid);
			func(1, from, mid, to);
			func(n-1, mid, from, to);
		}
	}
	
	public int step1(int[] arr)
	{
		if(arr == null || arr.length == 0)
		{
			return -1;
		}
		return process(arr, arr.length - 1, 1, 2, 3);
	}
	
	public int process(int[] arr, int i, int from, int mid, int to)
	{
		if(i == -1)
			return 0;
		if(arr[i] != from && arr[i] != to)
			return -1;
		if(arr[i] == from)
		{
			return process(arr, i-1, from, to, mid);
		}
		else
		{
			int rest = process(arr, i-1, mid, from, to);
			if(rest == -1)
				return -1;
			return (1 << i) + rest;
		}
	}
	
	public int step2(int[] arr)
	{
		if(arr == null || arr.length == 0)
			return -1;
		int from = 1;
		int mid = 2;
		int to = 3;
		
		int i = arr.length-1;
		int res = 0;
		int tmp = 0;  // 借用的那个
		
		while(i >= 0)
		{
			if(arr[i] != from && arr[i] != to)
				return -1;
			if(arr[i] == to)  //第一步和第二步已经完成
			{
				res += 1 << i;  //2的i次幂
				tmp = from;		
				from = mid;
			}
			else
			{
				tmp = to;   //第一步已经完成或者没完成
				to = mid;
			}
			mid = tmp;
			i--;
		}
		return res;
	}
}
