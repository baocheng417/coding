package five;

public class NumSum
{
	public int numSum(String str)
	{
		if(str == null)
		{
			return 0;
		}
		
		int res = 0;
		int num = 0;
		boolean posi = true;
		int cur = 0;
		
		char[] c1 = str.toCharArray();
		
		for(int i = 0; i < c1.length; i++)
		{
			cur = c1[i]-'0';
			if(num < 0 || num > 9)
			{
				res += num;
				num = 0;
				if(c1[i] == '-')
				{
					if(i-1 > -1 && c1[i-1] == '-')
					{
						posi = !posi;
					}
					else
					{
						posi = false;
					}
				}
				else
				{
					posi = true;
				}
			}
			else
			{
				num = num * 10 + (posi ? cur : -cur);
			}
		}
		
		res += num;
		return res; 
	}
}
