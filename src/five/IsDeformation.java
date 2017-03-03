package five;

public class IsDeformation
{
	public boolean isDeformation(String str1, String str2)
	{
		if(str1 == null || str2 == null || str1.length() != str2.length())
		{
			return false;
		}
		
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		
		int[] map = new int[255];
		
		for(int i = 0; i < ch1.length; i++)
		{
			map[ch1[i]]++;
		}
		
		for(int j = 0; j < ch2.length; j++)
		{
			
			if(map[ch2[j]]-- == 0)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		String str1 = "1234";
		String str2 = "3221";
		
		System.out.println(new IsDeformation().isDeformation(str1, str2));
	}
}
