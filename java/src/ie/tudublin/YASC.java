package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class YASC extends PApplet
{
	Ship ship;
	Ship ship1;
	
	
	
	//Generic arraylist of type Bullet (they must be class objects not ints or Floats)
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();


	public void settings()
	{
		size(500, 500);
		
	}

	public void setup() {
		ship = new Ship(width / 2, height / 2, 50, 70, this);
		ship1 = new Ship(100, 50, 80, 6, this);
		colorMode(HSB);
	}

	public void draw()
	{	background(0);
		ship.render();
		ship.move();

		ship1.render();
		ship1.move();

		for(int i = 0 ; i < bullets.size() ; i ++)
		{
			Bullet b = bullets.get(i);
			b.render();
			b.move();
		}
		for(Bullet b:bullets)//fo
		fill(255);
		p.txt("bullets: " + bullets.size(), 50, 50);

		}
	}
