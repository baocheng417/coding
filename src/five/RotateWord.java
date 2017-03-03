package five;

public class RotateWord
{
	public void rotateWord(char[] chas)
	{
		if(chas == null || chas.length == 0)
		{
			return;
		}
		reverse(chas, 0, chas.length-1);
		
		int l = -1;
		int r = -1;
		for(int i = 0; i < chas.length; i++)
		{
			if(chas[i] != ' ')
			{
				l = i == 0 || chas[i-1] == ' ' ? i : l;
				r = i == chas.length-1 || chas[i+1] == ' ' ? i : r;
			}
			
			if(l != -1 && r != -1)
			{
				reverse(chas, l , r);
				l = -1;
				r = -1;
			}
		}
		
	}
	
	public void reverse(char[] chas, int begin, int end)
	{
		char temp = 0;
		while(begin < end)
		{
			temp = chas[begin];
			chas[begin] = chas[end];
			chas[end] = temp;
			begin++;
			end--;
		}
	}
	
	public void rotate1(char[] chas, int size)
	{
		if(chas == null || chas.length == 0 || size >= chas.length || size < 0)
		{
			return;
		}
		
		reverse(chas, 0, size-1);
		reverse(chas, size, chas.length-1);
		reverse(chas, 0, chas.length-1);
	}
	
	public void rotate2(char[] chas, int size)
	{
		if(chas == null || chas.length == 0 || size >= chas.length || size < 0)
		{
			return;
		}
		
		int start = 0;
		int end = chas.length - 1;
		int lpart = size;
		int rpart = chas.length - size;
		int s = Math.min(lpart, rpart);
		int d = lpart - rpart;
		
		while(true)
		{
			exchange(chas, start, end, size);
			if(d == 0)
			{
				break;
			}
			else if(d > 0)
			{
				start += s;
				lpart  = d;
			}
			else
			{
				end -= s;
				rpart = -d;
			}
			
			s = Math.min(lpart, rpart);
			d = lpart - rpart; 
		}
		
		
	}
	
	public void exchange(char[] chas, int start, int end, int size)
	{
		char temp = 0;
		int i = end - size + 1;
		while(size-- > 0)
		{
			temp = chas[start];
			chas[start] = chas[i];
			chas[i] = temp;
			start++;
			i++;
		}
	}
}
