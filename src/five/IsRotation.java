package five;

import sun.applet.Main;

public class IsRotation
{
	public boolean isRotation(String str1, String str2)
	{
		if(str1 == null || str2 == null || str1.length() != str2.length())
		{
			return false;
		}
		
		String temp = str2 + str2;
		char[] c1 = temp.toCharArray();
		
		for(int i = 0; i < c1.length/2; i++)
		{
			if(c1[i] != str1.charAt(0))
			{
				continue;
			}
			
			String str3 = String.copyValueOf(c1, i, i+str1.length());
			if(str3.equals(str1))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		String str1 = "1234";
		String str2 = "4331";
		System.out.println(new IsDeformation().isDeformation(str1, str2));
	}
}
