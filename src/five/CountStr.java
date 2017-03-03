package five;

public class CountStr
{
	public String getCountString(String str)
	{
		if(str == null || str.equals(""))
		{
			return null;
		}
		
		char[] chas = str.toCharArray();
		
		int num = 1;
		String res = String.valueOf(chas[0]);
		
		for(int i = 1; i < chas.length; i++)
		{
			if(chas[i] == chas[i-1])
			{
				num++;
			}
			else
			{
				res = res + "_" + num + "_"+chas[i];
				num = 1;
			}
		}
		
		res = res + "_" + num;
		return res;
	}
	
	public char getCharAt(String str, int index)
	{
		if(str == null || str.equals(""))
		{
			return 0;
		}
		
		char[] chas = str.toCharArray();
		boolean stage = true;
		char cur = 0;
		int num = 0;
		int sum = 0;
		
		for(int i = 0; i < chas.length; i++)
		{
			if(chas[i] == '_') 
			{
				stage = !stage;
			}
			else if(stage)
			{
				sum += num;
				if(sum > index)
				{
					return cur;
				}
				num = 0;
				cur = chas[i];
			}
			else
			{
				num = num*10+chas[i]-'0';
			}
			
		}
		
		return sum + num > index ? cur : 0;
	}
	
	public static void main(String[] args)
	{
		String str = "aaabbccdd";
		CountStr cs = new CountStr();
		System.out.println(cs.getCharAt(cs.getCountString(str), 4));
	}
}
