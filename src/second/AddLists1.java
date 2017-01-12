package second;

import java.util.Stack;

public class AddLists1
{
	public Node addLists(Node head1, Node head2)
	{
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		
		while(head1 != null)
		{
			stack1.push(head1);
			head1 = head1.next;
		}
		
		while(head2 != null)
		{
			stack2.push(head2);
			head2 = head2.next;
		}
		
		int ca = 0;
		int n = 0;
		
		Node node = null;
		Node pre = null;
		
		while(!stack1.isEmpty() || !stack2.isEmpty())
		{
			n = ca + (stack1.isEmpty() ? 0 : stack1.pop().value) + (stack2.isEmpty() ? 0 : stack2.pop().value);  
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			ca = n / 10;
		}
		
		if(ca == 1)
		{
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		
		return node;
	}
	
	public Node addLists2(Node head1, Node head2)
	{
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		int n1 = 0;
		int n2 = 0;
		int ca = 0;
		int n = 0;
		
		Node pre = null;
		Node node = null;
		
		while(head1 != null || head2 != null)
		{
			n1 = head1 == null ? 0 : head1.value;
			n2 = head2 == null ? 0 : head2.value;
			n = n1 + n2 + ca;
			
			pre = node;
			node = new Node(n % 10);
			ca = n / 10;
			
			head1 = head1 == null ? null : head1.next;
			head2 = head2 == null ? null : head2.next;	
		}
		if(ca == 1)
		{
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		reverseList(head1);
		reverseList(head2);
		return node;
	}
	
	public Node reverseList(Node head)
	{
		Node next = null;
		Node pre = null;
		Node node = head;
		while(node != null)
		{
			next = node.next;
			node.next = pre;
			pre = node;
			node = next;
		}
		return pre;
	}
}
