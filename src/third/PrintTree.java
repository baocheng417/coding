package third;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree
{
	public void printByLevel(Node head)
	{
		if(head == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		int level = 1;
		
		Node last = head;
		Node nlast = null;
		
		System.out.print("Level"+(level++)+ " : ");
		while(!queue.isEmpty())
		{
			head = queue.poll();
			System.out.print(head.value + " ");
			if(head.left != null)
			{
				queue.offer(head.left);
				nlast = head.left;
			}
			if(head.right != null)
			{
				queue.add(head.right);
				nlast = head.right;
			}
			if(head == last && !queue.isEmpty())
			{
				System.out.print("\nLevel"+(level++)+" : ");
				last = nlast;
			}
		}
		System.out.println();
	}
	
	public void printByZiZag(Node head)
	{
		if(head == null)
		{
			return ;
		}
		
		Deque<Node> deque = new LinkedList<Node>();
		Node last = head;
		Node nlast = null;
		int level = 1;
		boolean lr = true;
		
		deque.addFirst(head);
		while(!deque.isEmpty())
		{
			if(lr)
			{
				head = deque.pollFirst();
				if(head.left != null)
				{
					nlast = nlast == null ? head.left : nlast;
					deque.addLast(head.left);
				}
				if(head.right != null)
				{
					nlast = nlast == null ? head.right : nlast;
					deque.addLast(head.right);
				}
			}
			else
			{
				head = deque.pollLast();
				if(head.right != null)
				{
					nlast = nlast == null ? head.right : nlast;
					deque.addFirst(head.right);
				}
				if(head.left != null)
				{
					nlast = nlast == null ? head.left : nlast;
					deque.addFirst(head.left);
				}
			}
			System.out.print(head.value+" ");
			if(head == last && !deque.isEmpty())
			{
				lr = !lr;
				last = nlast;
				nlast = null;
				System.out.println();
				 
			}
		}
	}
}
