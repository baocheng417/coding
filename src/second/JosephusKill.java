package second;

public class JosephusKill
{
	public Node josephusKill(Node head, int m)
	{
		if(head == null || head.next == head || m < 1)
		{
			return head;
		}
		Node last = head;
		while(last.next != head)
		{
			last = last.next;
		}
		int count = 0;
		while(head != last)
		{
			if(++count == m)
			{
				last.next = head.next;
				count = 0;
			}
			else
			{
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}
	
	public Node josrphusKill2(Node head, int m)
	{
		if(head == null || head.next == head || m < 1)
		{
			return head;
		}
		
		Node cur = head.next;
		int temp = 1;
		while(cur != head) 
		{
			temp++;
			cur = cur.next; 
		}
		temp = getLive(temp, m);
		while(--temp != 0)
		{
			head = head.next;
		}
		head.next = head;
		return head;
	}
	
	public int getLive(int i, int m)
	{
		if(i == 1)
		{
			return 1;
		}
		return (getLive(i - 1, m) + m - 1);
	}
}
