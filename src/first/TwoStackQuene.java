package first;

import java.util.Stack;

public class TwoStackQuene
{
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	
	public TwoStackQuene()
	{
		this.stackPop = new Stack<Integer>();
		this.stackPush = new Stack<Integer>();
	}
	
	public void add(int pushInt)
	{
		stackPush.push(pushInt);
	}
	
	public int poll()
	{
		if(stackPop.empty() && stackPush.empty())
		{
			throw new RuntimeException("Quene is null!");
		}
		else
		{
			while(!stackPush.empty())
			{
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	
	public int peek()
	{
		if(stackPop.empty() && stackPush.empty())
		{
			throw new RuntimeException("Quene is null!");
		}
		else
		{
			while(!stackPush.empty())
			{
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
}
