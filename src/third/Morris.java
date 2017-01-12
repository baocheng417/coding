package third;

public class Morris
{
	public void morrisIn(Node head)
	{
		if(head == null)
			return;
		Node cur1 = head;
		Node cur2 = null;
		
		while(cur1 != null)
		{
			cur2 = cur1.left;
			if(cur2 != null)
			{
				while(cur2.right != null && cur2.right != cur1)
				{
					cur2 = cur2.right;
				}
				if(cur2.right == null)
				{
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				}
				else
				{
					cur2.right = null;
				}
			}
			System.out.print(cur1.value + " ");
			cur1 = cur1.right;
		}
		System.out.println();
	}
	
	public void morrisPre(Node head)
	{
		if(head == null)
			return;
		Node cur1 = head;
		Node cur2 = null;
		while(cur1 != null)
		{
			cur2 = cur1.left;
			if(cur2 != null)
			{
				while(cur2.right != null && cur2.right != cur1)
				{
					cur2 = cur2.right;
				}
				if(cur2.right == null)
				{
					cur2.right = cur1;
					System.out.print(cur1.value+" ");
					cur1 = cur1.left;
					continue;
				}
				else
				{
					cur2.right = null;
				}
			}
			else
			{
				System.out.print(cur1.value+" ");
			}
			cur1 = cur1.right;
		}
		System.out.println();
	}
	
	public void morrisPos(Node head)
	{
		if(head == null)
			return;
		Node cur1 = head;
		Node cur2 = null;
		while(cur1 != null)
		{
			cur2 = cur1.left;
			if(cur2 != null)
			{
				while(cur2.right != null && cur2.right != cur1)
				{
					cur2 = cur2.right;
				}
				if(cur2.right == null)
				{
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				}
				else
				{
					cur2.right = null;
					printEdge(cur1.left);
				}
			}
			cur1 = cur1.right;
		}
		printEdge(head);
		System.out.println();
	}
	
	public void printEdge(Node head)
	{
		Node tail = reverseEdge(head);
		Node cur = tail;
		while(cur != null)
		{
			System.out.print(cur.value+" ");
			cur = cur.right;
		}
		reverseEdge(tail);
	}
	
	public Node reverseEdge(Node from)
	{
		Node pre = null;
		Node next = null;
		
		while(from != null)
		{
			next = from.right;
			from.right = pre;
			pre = from;
			from = next;
		}
		return next;
	}
}
