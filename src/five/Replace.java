package five;

public class Replace
{
	public String replace(String str, String from, String to)
	{
		if(str == null || from == null || str.equals("") || from.equals(""))
		{
			return str;
		}
		
		char[] chas = str.toCharArray();
		char[] chaf = from.toCharArray();
		int match = 0;
		
		for(int i = 0; i < chas.length; i++)
		{
			if(chas[i] == chaf[match])
			{
				if(match == chaf.length)
				{
					while(match-->0)
					{
						chas[i-match+1] = 0;
					}
					match = 0;
				}
				else
				{
					match++;
				}
			}
			else
			{
				if(chas[i] == chaf[0])
				{
					i--;
				}
				match = 0;
			}
		}
		
		String cur = "";
		String res = "";
		
		for(int i = 0; i < chas.length; i++)
		{
			if(chas[i] != 0)
			{
				cur += String.valueOf(chas[i]);
			}
			if(chas[i] == 0 && (i == 0 || chas[i-1] != 0))
			{
				res = res + to + cur;
				cur = "";
			}
		}
		
		if(!cur.equals(""))
		{
			res += cur;
		}
		
		return res;
	}
}
