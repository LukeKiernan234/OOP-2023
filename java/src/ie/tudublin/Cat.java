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

        for (int i = 0; i < numlives; i++)
        {

            System.out.println("cat live = " + i );
            if (i == 8)
            {
                System.out.println("dead");
            }
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
