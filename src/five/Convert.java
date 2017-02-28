package five;

public class Convert
{
	public int convert(String str)
	{
		if(str == null || str.equals(""))
		{
			return 0;  //不能转
		}
		
		char[] cs = str.toCharArray();
		
		if(!isValid(cs))
		{
			return 0;   //不能转
		}
		
		boolean posi = cs[0] == '-' ? false : true;
		int minq = Integer.MIN_VALUE / 10;
		int minr = Integer.MIN_VALUE % 10;
		
		int res = 0;
		int cur = 0;
		
		for(int i = posi ? 0 : 1; i < cs.length; i++)
		{
			cur = '0' - cs[i];
			if((res < minq) || (res == minq && cur < minr))
			{
				return 0;  //不能转
			}
			res = res * 10 + cur;
		}
		
		if(posi && res == Integer.MIN_VALUE)
		{
			return 0;   //不能转
		}
		
		return posi ? -res : res;
	}
	
	public boolean isValid(char[] cs)
	{
		if(cs[0] != '-' || (cs[0] < '0' || cs[0] > '9'))
		{
			return false;
		}
		
		if(cs[0] == '-' && (cs.length == 1 || cs[1] == '0'))
		{
			return false;
		}
		
		if(cs[0] == '0' && cs.length > 1)
		{
			return false;
		}
		
		for(int i = 1; i < cs.length; i++)
		{
			if(cs[i] < '0' || cs[i] > '9')
			{
				return false;
			}
		}
		
		return true;
	}
}
