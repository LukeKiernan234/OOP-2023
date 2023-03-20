package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet
{
	ship ship;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		ship = new ship(width/2, height/2, size:50, 70, this);
		colorMode(HSB);
		
	}

	
	
	public void draw()
	{	
		
	}
}
