package ie.tudublin;

import processing.core.PApplet;

public class Cube {
    public float x, y;
    public float size3;
    public float c;
    public float rot;

    public void render(PApplet p) {
        p.stroke(c);
        p.strokeWeight(5);

        p. noFill();
        p.translate(width / 2, height / 2);
        p.rotateY(rot);
        p.rotateX(rot);
    }
    
}
