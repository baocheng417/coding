package second;

public class RemoveLastKthNode
{
	public Node removeLastKthNode(Node head, int lastKth)
	{
		if(head == null && lastKth < 1)
		{
			return head;
		}
		Node cur = head;
		
		while(cur != null)
		{
			lastKth--;
			cur = cur.next;
		}
		if(lastKth == 0)
		{
			head = head.next;
		}
		if(lastKth < 0)
		{
			cur = head;
			while(cur != null)
			{
				lastKth++;
				if(lastKth == 0)
				{
					cur.next = cur.next.next;
					break;
				}
				cur = cur.next;
			}
		}
		return head;
	}
	
	public DoubleNode removeLastKthNode(DoubleNode head, int lastKth)
	{
		if(head == null && lastKth < 1)
		{
			return head;
		}
		
		DoubleNode cur = head;
		while(cur != null)
		{
			lastKth--;
			cur = cur.next;
		}
		
		if(lastKth == 0)
		{
			head = head.next;
			head.last = null;
		}
		if(lastKth < 0)
		{
			cur = head;
			while(++lastKth != 0)
			{
				cur = cur.next;
			}
			DoubleNode newNext = cur.next.next;
			cur.next = newNext;
			if(newNext != null)
			{
				newNext.last = cur;
			}	
		}
		return head;
	} 
}

class DoubleNode
{
	public int value;
	public DoubleNode last;
	public DoubleNode next;
	
	public DoubleNode(int data)
	{
		this.value = data;
	}
}
