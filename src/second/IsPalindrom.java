package second;

import java.util.Stack;

public class IsPalindrom
{
	public boolean isPalindrom1(Node head)
	{
		Stack<Node> stack = new Stack<Node>();
		Node curNode = head;
		while(curNode != null)
		{
			stack.push(curNode);
			curNode = curNode.next;
		}
		
		while(head != null)
		{
			if(head.value != stack.pop().value)
			{
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	public boolean isPalindrom2(Node head)
	{
		if(head == null || head.next == null)
		{
			return true;
		}
		Stack<Node> stack = new Stack<Node>();
		Node right = head.next;
		Node cur = head;
		while(cur.next != null && cur.next.next != null)
		{
			right = right.next;
			cur = cur.next.next;
		}
		while(right != null)
		{
			stack.push(right);
			right = right.next; 
		}
		while(!stack.isEmpty())
		{
			if(head.value != stack.pop().value)
			{
				return false;
			}
			head =head.next;
		}
		return true;
	}
	
	public boolean isPalindrom3(Node head)
	{
		if(head == null || head.next == null)
		{
			return true;
		}
		Node n1 = head;
		Node n2 = head;
		while(n2.next != null && n2.next.next != null)
		{
			n1 = n1.next;
			n2 = n2.next.next;
		}
		n2 = n1.next;
		n1.next = null;
		Node n3 = null;
		while(n2 != null)
		{
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		n3 = n1;
		n2 = head;
		boolean res = true;
		while(n1 != null && n2 != null)
		{
			if(n1.value != n2.value)
			{
				res = false;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		n1 = n3.next;
		n3.next = null;
		while(n1 != null)
		{
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}
}
