package fouth;

public class First
{
	public int f1(int n)
	{
		if(n < 1)
			return 0;
		if(n == 1 || n == 2)
			return 1;
		return f1(n-1) + f1(n-2);
	}
	
	public int f2(int n)
	{
		if(n < 1)
			return 0;
		if( n == 1 || n == 2)
			return 1;
		int res = 1;
		int temp = 0;
		int pre = 1;
		
		for(int i = 3; i <= n; i++)
		{
			temp = res;
			res = res + pre;
			pre = temp;
		}
		return res;
	}
	
	public int f3(int n)
	{
		if(n < 1)
			return 0;
		if(n == 1 || n == 2)
			return 1;
		int[][] base = {{1,1},{1,0}};
		int[][] res = matrixPower(base, n-2);
		return res[0][0] + res[1][0];
		
	}
	
	public int[][] muliMatrix(int[][] m1, int[][] m2)
	{
		if(m1[0].length != m2.length)
			throw new RuntimeException("矩阵不能相乘");
		int[][] res = new int[m1.length][m2[0].length];
		for(int i = 0; i < res.length; i++)
		{
			for(int j = 0; j < res[0].length; j++)
			{
				 for(int k = 0; k < m2.length; k++)
				 {
					 res[i][j] += m1[i][k]*m2[k][j]; 
				 }
			}
		}
		return res;
	}
	
	public int[][] matrixPower(int[][] m ,int p)
	{
		int[][] res = new int[m.length][m[0].length];
		for(int i = 0; i < res.length; i++)
		{
			res[i][i] = 1;
		}
		int[][] temp =m;
		for(; p != 0; p >>= 1)
		{
			if((p & 1) != 0)
			{
				res = muliMatrix(res, temp);
			}
			temp = muliMatrix(temp, temp);
		}
		return res;
	}
	
	public int s1(int n)
	{
		if(n < 1)
		{
			return 0;
		}
		
		if(n == 1 || n == 2)
		{
			return n;
		}
		
		return s1(n-1) + s1(n-2);
	}
	
	public int s2(int n)
	{
		if(n < 1)
		{
			return 0;
		}
		
		if(n == 1 || n == 2)
		{
			return n;
		}
		
		int res = 2; //所求当前值
		int pre = 1; //n-2的值
		int temp = 0; //暂存n-1的值
		
		for(int i = 3; i <= n; i++)
		{
			temp = res;
			res += pre;
			pre = temp;
		}
		
		return res;
	}
	
	public int s3(int n)
	{
		if(n < 1)
			return 0;
		if(n == 1 || n == 2)
			return n;
		
		int[][] m = {{1,1},{1,0}};
		int[][] res = matrixPower(m,n-2);
		int[][] m1= {{2,1}};
		res = muliMatrix(m1,res);
		return res[0][0];	
	}
	
	public int c1(int n)
	{
		if(n < 1)
			return 0;
		if(n == 1 || n == 2 || n == 3)
			return n;
		return c1(n-1) + c1(n-3);
	}
	
	public int c2(int n)
	{
		if(n < 1)
			return 0;
		if(n == 1 || n ==2 || n == 3)
			return n;
		
		int res = 3;
		int pre = 2;
		int temp = 0;
		int temp2 = 0;
		int prepre = 1;
		
		for(int i = 3; i <= n; i++)
		{
			temp = res;
			temp2 = pre;
			res = res + prepre;
			pre = temp;
			prepre = temp2;
		}
		return res;
	}
	
	public int c3(int n)
	{
		int[][] base = {{1,1,0},{0,0,1},{1,0,0}};
		int[][] res = matrixPower(base,n-3);
		res = muliMatrix(new int[][]{{3,2,1}},res);
		return res[0][0];
	}
	public static void main(String[] args)
	{
		System.out.println(new First().c1(4));
		System.out.println(new First().c3(4));
	}
	
}
