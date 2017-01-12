package first;

public class Pet
{
	private String type;
	
	public Pet(String type)
	{
		this.type = type;
	}
	
	public String getPetType()
	{
		return this.type;
	}
}

class Dog extends Pet
{

	public Dog(String type)
	{
		super("Dog");
	}
	
}

class Cat extends Pet
{
	public Cat(String type)
	{
		super("cat");
	}
}