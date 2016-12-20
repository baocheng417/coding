package third;

import java.util.Stack;

public class OrderRecur
{
	public void preOrderRecur(Node head)
	{
		if(head == null)
			return ;
		System.out.println(head.value);
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	
	public void inOrderRecur(Node head)
	{
		if(head == null)
			return;
		inOrderRecur(head.left);
		System.out.println(head.left);
		inOrderRecur(head.right);
	}
	
	public void posOrderRecur(Node head)
	{
		if(head == null)
			return;
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.println(head.value);
	}
	
	public void preOrderUnRecur(Node head)
	{
		Stack<Node> stack = new Stack<Node>();
		if(head == null)
			return;
		stack.push(head);
		while(!stack.isEmpty())
		{
			head = stack.pop();
			System.out.println(head.value);
			if(head.right != null)
			{
				stack.push(head.left);
			}
			if(head.left != null)
			{
				stack.push(head.left);
			}
		}
	}
	
	public void inOrderUnRecur(Node head)
	{
		if(head != null)
		{
			Stack<Node> stack = new Stack<Node>();
			while(!stack.isEmpty() || head != null)
			{
				if(head != null)
				{
					stack.push(head);
					head = head.left;
				}
				else
				{
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
		System.out.println();
	}
	
	public void posOrderUnRecur1(Node head)
	{
		if(head != null)
		{
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while(!s1.isEmpty())
			{
				head = s1.pop();
				s2.push(head);
				if(head.left != null)
				{
					s1.push(head.left);
				}
				if(head.right != null)
				{
					s1.push(head.right);
				}
			}
			while(!s2.isEmpty())
			{
				System.out.print(s2.pop().value+" ");
			}
			System.out.println();
		}
	}
	
	public void posOrderUnRecur2(Node head)
	{
		if(head != null)
		{
			Stack<Node> stack = new Stack<Node>();
			stack.push(head);
			Node c = null;
			while(!stack.isEmpty())
			{ 
				c = stack.peek();
				if(c.left != null && head != c.left && head != c.right)
				{
					stack.push(c.left);
				}
				else if(c.right != null && head != c.right)
				{
					stack.push(c.right);
				}
				else
				{
					System.out.print(stack.pop().value+" ");
					head = c;
				}
			}
		}
		System.out.println();
	}
}
