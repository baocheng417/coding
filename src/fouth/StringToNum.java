package fouth;

public class StringToNum
{
	public int num1(String str)
	{
		if(str == null || str.equals(""))
		{
			return 0;
		}
		char[] c = str.toCharArray();
		
		return process(c, 0);
		
	}
	public int process(char[] c, int i)
	{
		if(i == c.length)
		{
			return 0;
		}
		if(c[i] == 0)
		{
			return 0;
		}
		
		int res = process(c, i+1);
		if(i+1 < c.length && (c[i] - '0')*10+c[i+1]-'0' < 27)
		{
			res += process(c, i+2);
		}
		return res;
	}
	
	public int num2(String str)
	{
		if(str == null || str.equals(""))
		{
			return 0;
		}
		
		char[] chs = str.toCharArray();
		int cur = chs[chs.length-1] == '0' ? 0 : 1;
		int next = 1;
		int temp = 0;
		
		for(int i = chs.length-2; i >= 0 ; i++)
		{
			if(chs[i] == '0')
			{
				next = cur;
				cur = 0;
			}
			else
			{
				temp = cur;
				if((chs[i] - '0') * 10 + chs[i+1]-'0' <27)
				{
					cur += next;
				}
				next = temp;
			}
		}
		return cur;
	}
}
