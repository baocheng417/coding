package third;

public class PrintEdge
{
	public void printEdge1(Node head)
	{
		if(head == null)
			return;
		
		int height = getHeight(head, 0);
		Node[][] edgeMap = new Node[height][2];
		
		setEdegeMap(head, 0, edgeMap);
		
		for(int i = 0; i < edgeMap.length; i++)
		{
			System.out.print(edgeMap[i][0].value+" ");
		}
		
		printLeafNotInMap(head, 0, edgeMap);
		for(int i = edgeMap.length-1; i >= 0; i--)
		{
			if(edgeMap[i][0] != edgeMap[i][1])
			{
				System.out.print(edgeMap[i][1].value+"¡¡");
			}
		}
		
		System.out.println();
	}
	
	public void setEdegeMap(Node h, int l, Node[][] edgeMap)
	{
		if(h == null)
			return ;
		edgeMap[l][0] = edgeMap[l][0] == null ? h : edgeMap[l][0];
		edgeMap[l][1] = h;
		setEdegeMap(h.left, l+1, edgeMap);
		setEdegeMap(h.right, l+1, edgeMap);
	}
	
	public int getHeight(Node head, int l)
	{
		if(head == null)
			return l;
		return Math.max(getHeight(head.left, l+1), getHeight(head.right, l+1));
	}
	
	public void printLeafNotInMap(Node h, int l, Node[][] m)
	{
		if(h == null)
			return ;
		if(h.left == null && h.right == null && h != m[l][0] && h != m[l][l])
		{
			System.out.print(h.value+"¡¡");
		}
		printLeafNotInMap(h.left, l+1, m);
		printLeafNotInMap(h.right, l+1, m);
	}
}
