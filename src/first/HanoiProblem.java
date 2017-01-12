package first;

import java.util.Stack;

public class HanoiProblem
{
	public int hanoiProblem1(int num, String left, String mid, String right)
	{
		if(num < 1)
			return 0;
		return process(num, left, mid ,right, left, right);
	}
	
	public int process(int num, String left,  String mid, String right, String from, String to)
	{
		if(num == 1)
		{
			if(from.equals(mid) || to.equals(mid))
			{
				System.out.println("Move 1 from "+ from + " to "+ to);
				return 1;
			}
			else
			{
				System.out.println("Move 1 from "+ from + " to "+ mid);
				System.out.println("Move 1 from "+ mid + " to "+ to);
				return 2;
			}
		}
		else
		{
			if(from.equals(mid) || to.equals(mid))
			{
				String another = (from.equals(left) || to.equals(right)) ? right : left;
				int part1 = process(num-1, left, mid, right, from, another);
				int part2 = 1;
				System.out.println("Move "+num+" from "+from+" to "+to );
				int part3 = process(num-1,left, mid, right, another, to);
				return part1+part2+part3;
			}
			else
			{
				int part1 = process(num-1, left, mid, right,from, to);
				int part2 = 1;
				System.out.println("Move "+num+" from "+from+" to "+mid);
				int part3 = process(num-1, left, mid, right, to, from);
				int part4 = 1;
				System.out.println("Move "+num+" from"+mid+" to "+to);
				int part5 = process(num-1, left, mid, right, from, to);
				return part1+part2+part3+part4+part5;
				
			}
		}
	}
	public int hanoiProblem2(int num, String left, String mid, String right, String from, String to)
	{
		Stack<Integer> ls = new Stack<Integer>();
		Stack<Integer> ms = new Stack<Integer>();
		Stack<Integer> rs = new Stack<Integer>();
		
		ls.push(Integer.MAX_VALUE);
		ms.push(Integer.MAX_VALUE);
		rs.push(Integer.MAX_VALUE);
		
		for(int i = num; i>0; i--)
		{
			ls.push(i);
		}
		
		Action[] record = {Action.No};
		
		int step = 0;
		
		while(rs.size() != num+1)
		{
			step += fStackToStack(record, Action.MToL, Action.LToM, ls, ms, left, mid);
			step += fStackToStack(record, Action.LToM, Action.MToL, ms, ls, mid, left);
			step += fStackToStack(record, Action.RToM, Action.MToR, rs, ms, right, mid);
			step += fStackToStack(record, Action.MToR, Action.RToM, ms, rs, mid, right);
		}
		return step;
	}
	
	public static int fStackToStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fStack,
			Stack<Integer> tStack, String from, String to)
	{
		if(record[0] != preNoAct && fStack.peek() < tStack.peek())
		{
			tStack.push(fStack.pop());
			System.out.println("Move "+tStack.peek()+" from "+from+" to "+to);
			record[0] = nowAct;
			return 1;
		}
		return 0;
	}
	public static void main(String[] args)
	{
		HanoiProblem han = new HanoiProblem();
		han.hanoiProblem1(2, "left", "mid", "right");
		System.out.println("--------------");
		System.out.println(han.hanoiProblem2(2, "left", "mid", "right", "left", "right"));
	}
}

enum Action
{
	No,LToM,MToL,MToR,RToM
}
