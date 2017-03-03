package five;

import sun.applet.Main;

public class RemoveKZero
{
	public String removeKZero(String str, int k)
	{
		if(str == null || k < 1)
		{
			return str;
		}
		
		int count = 0;
		int start = -1;
		
		char[] chs = str.toCharArray();
		
		for(int i = 0; i < chs.length; i++)
		{
			if(chs[i] == '0')
			{
				count++;
				start = start == -1 ? i : start;
			}
			else
			{
				if(count == k)
				{
					while(count-- != 0)
					{
						chs[start++] = 0;
					}
				}
				count = 0;
				start = -1;
			}
		}
		
		if(count == k)
		{
			while(count-- != 0)
			{
				chs[start++] = 0;
			}
		}
		for(int i = 0; i < chs.length; i++)
		{
			System.out.println(chs[i]);
		}
		return String.valueOf(chs);
	}
	
	public static void main(String[] args)
	{
		String str = "122000012000";
		
		System.out.println(new RemoveKZero().removeKZero(str, 4));
	}
}
