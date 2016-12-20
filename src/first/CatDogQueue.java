package first;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue
{
	private Queue<PetEnterQueue> dogQ;
	private Queue<PetEnterQueue> catQ;
	private long number;
	
	public CatDogQueue()
	{
		this.dogQ = new LinkedList<PetEnterQueue>();
		this.catQ = new LinkedList<PetEnterQueue>();
		this.number = 0;
	}
	
	public void add(Pet pet)
	{
		if(pet.getPetType().equals("dog"))
		{
			this.dogQ.add(new PetEnterQueue(pet, this.number++));
		}
		else if(pet.getPetType().equals("cat"))
		{
			this.catQ.add(new PetEnterQueue(pet, this.number++));
		}
		else
		{
			throw new RuntimeException("error: no cat or dog!");
		}
	}
	
	public Pet pollAll()
	{
		if(this.catQ.isEmpty() && this.dogQ.isEmpty())
		{
			throw new RuntimeException("error : queue is empty!");
		}
		else if(!this.catQ.isEmpty() && !this.dogQ.isEmpty())
		{
			if(this.dogQ.peek().getNumber() < this.catQ.peek().getNumber())
			{
				return this.dogQ.poll().getPet();
			}
			else
			{
				return this.catQ.poll().getPet();
			}
		}
		else if(this.catQ.isEmpty())
		{
			return this.dogQ.poll().getPet();
		}
		else
		{
			return this.dogQ.poll().getPet();
		}
	}
	
	public Dog pollDog()
	{
		if(!this.dogQ.isEmpty())
		{
			return (Dog)this.dogQ.poll().getPet();
		}
		else
		{
			throw new RuntimeException("dog queue is empty");
		}
	}
	
	public Cat pollCat()
	{
		if(!this.catQ.isEmpty())
		{
			return (Cat)this.catQ.poll().getPet();
		}
		else
		{
			throw new RuntimeException("cat queue is empty");
		}
	}
	
	public boolean isEmpty()
	{
		return this.dogQ.isEmpty() && this.catQ.isEmpty();
	}
	
	public boolean isDogQueueEmpty()
	{
		return this.dogQ.isEmpty();
	}
	
	public boolean isCatQueueEmpty()
	{
		return this.catQ.isEmpty();
	}
}
