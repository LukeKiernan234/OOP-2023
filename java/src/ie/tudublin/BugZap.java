package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
  int playerX = width/2;
  int playerY = height + 350;
  int playerSize = 50;

  int bugX = width/2;
  int bugY = 0;
  int bugSize = 50;
  int bugSpeed = 5;

  boolean shooting = false;

  public void settings()
  {
    size(500, 500);
  }

  public void keyPressed()
  {
    if (keyCode == LEFT)
    {
      playerX -= 10;
    }
    if (keyCode == RIGHT)
    {
      playerX += 10;
    }
    if (key == ' ')
    {
      shooting = true;
    }
  }

  public void setup() 
  {
    size(500, 500);
  }

  public void draw()
  {
    background(255);

    // Update the bug position
    bugY += bugSpeed;

    // Draw the bug
    fill(255, 0, 0);
    ellipse(bugX, bugY, bugSize, bugSize);
    fill(0, 255, 0);
    ellipse(bugX - bugSize/4, bugY - bugSize/4, bugSize/2, bugSize/2);
    fill(0);
    ellipse(bugX - bugSize/4 + bugSize/8, bugY - bugSize/4, bugSize/8, bugSize/8);
    ellipse(bugX - bugSize/4 - bugSize/8, bugY - bugSize/4, bugSize/8, bugSize/8);
    stroke(0);
    line(bugX - bugSize/4, bugY + bugSize/4, bugX - bugSize/2, bugY + bugSize);
    line(bugX + bugSize/4, bugY + bugSize/4, bugX + bugSize/2, bugY + bugSize);

    // Draw the player
    fill(100, 0, 255);
    rect(playerX, playerY, playerSize, playerSize/2);

    if (shooting)
    {
	  line(playerX + playerSize/2, playerY, playerX + playerSize/2, 0);

      shooting = false;
    }
  }
}
