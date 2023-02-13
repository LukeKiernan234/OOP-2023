package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;
	int x = 10;
	int y = 10;
	int diameter = 50;
	int gap = 10;

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

	public void setup() {
		colourmode(HSB);
	}


	public void keyPressed() {
		mode = key - '0';
		println(mode);
	}

	float off = 0;

	public void draw() {
    background(0);
    fill(255);
	noStroke();

    switch (mode) {
      case 0:
	  	int no_of_circles = 10;
		float d = width / (float) no_of_circles;
		for (int j = 0; j < no_of_circles; j++) {

        for (int i = 0; i < no_of_circles; i++) {
			float x = (d * 0.5f) + (d * i);
			float y = (d * 0.5f) + (d * j);
			float c = (i+j) / ((no_of_circles -1) * 2.0f) * 255.0f;	
			fill(c, 255, 255);
			circle(x, y, d);
        }
	}
		x =0;

		  y=0;
        break;

      case 1:
        break;

      default:
        break;
    }
  }
}
