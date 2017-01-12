package first;

import java.util.Stack;

public class MyStack2
{
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack2()
	{
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	
	public int getMin()
	{
		if(this.stackMin.isEmpty())
		{
			throw new RuntimeException("your stack is empty!");
		}
		
		return this.stackMin.peek();
	}
	
	public void push(int newNum)
	{
		if(this.stackMin.isEmpty())
		{
			this.stackMin.push(newNum);
		}
		else
		{
			if(newNum < this.getMin())
			{
				this.stackMin.push(newNum);
			}
			else
			{
				int value = this.stackMin.peek();
				this.stackMin.push(value);
			}
		}
		this.stackData.push(newNum);
	}
	
	public int pop()
	{
		if(this.stackData.isEmpty())
		{
			throw new RuntimeException("your stack is empty!");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}
}
