package fouth;

public class NQueen
{
	public int num1(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		
		int[] record = new int[n];
		return process1(0, record, n);
	}
	
	public int process1(int i, int[] record, int n)
	{
		if(i == n)
			return 1;
		int res = 0;
		for(int j = i; j < n; j++)
		{
			if(isValid(record, i, j))
			{
				record[i] = j;
				res += process1(i+1, record, n);
			}
		}
		return res;
	}
	
	public boolean isValid(int[] record, int i, int j)
	{
		for(int k = 0; k < i; k++)
		{
			if(j == record[k] || Math.abs(record[k]-j) == Math.abs(i-k))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public int num2(int n)
	{
		if(n < 1 || n > 32)
		{
			return 0;
		}
		
		int upperLim = n == 32 ? -1 : (1 << n)-1;
		return process2(upperLim, 0, 0, 0);
	}
	
	public int process2(int upperLim,  int colLim, int leftDiaLim, int rightDiaLim)
	{
		if(colLim == upperLim)
			return 1;
		int pos = 0;
		int mostRightOne = 0;
		pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
		
		int res = 0;
		while(pos != 0)
		{
			mostRightOne = pos & (~pos+1);
			pos = pos - mostRightOne;
			res += process2(upperLim, colLim | mostRightOne,
					(leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
		}
		
		return res;
	}
}
