package third;

import java.util.Stack;

public class GetTwoErrorNodes
{
	
	public Node[] getTwoErrorNodes(Node head)
	{
		Node[] errors = new Node[2];
		
		Stack<Node> stack = new Stack<Node>();
		
		Node cur = head;
		Node pre = null;
		
		while(cur != null || !stack.isEmpty())
		{
			if(cur != null)
			{
				stack.push(cur);
				cur = cur.left;
			}
			else
			{
				cur = stack.pop();
				if(pre != null && pre.value > cur.value)
				{
					errors[0] = errors[0] == null ? pre : errors[1];
					errors[1] = cur;
				}
				pre = cur;
				cur = cur.right;
				
			}
		}
		
		return errors;
	}
}
