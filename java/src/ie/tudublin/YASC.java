package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet
{
	Ship Ship;
	Ship Ship1;

	public void settings()
	{
		size(500, 500);
		
	}

	public void setup() {
		Ship = new Ship(width/2, height/2, 50, 70, this);
		colorMode(HSB);
		
	}

	public void draw()
	{	background(0);
		Ship.render();
		Ship.move();

		Ship1.render();
		Ship1.move();
	}
}
