package first;

public class PetEnterQueue
{
	private Pet pet;
	private long number;
	
	public PetEnterQueue(Pet pet, long number)
	{
		this.pet = pet;
		this.number = number;
	}
	
	public Pet getPet()
	{
		return this.pet;
	}
	
	public long getNumber()
	{
		return this.number;
	}
	
	public String getEnterPetType()
	{
		return this.pet.getPetType();
	}
}
