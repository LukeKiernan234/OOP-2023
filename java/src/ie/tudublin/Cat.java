package ie.tudublin;

public class Cat {
    int numlives = 9;
    String name;
    public void setName(String name)
	{
		this.name = name;
	}
	
	public Cat()
	{
        
	}

	public void kill()
	{
		numlives--;
        System.out.println("cat live = " + numlives );
        if (numlives == 0)
        {
            System.out.println("dead");
        }
	}

	public Cat(String name)
	{
	}
	
	public void speak()
	{
		System.out.println("meow");
	}
}
