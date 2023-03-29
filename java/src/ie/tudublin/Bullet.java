package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Bullet {
    PVector pos;
    float speed;
    float rot;
    PVector forward;
    PApplet p;
    int c;

    public Bullet(float x, float y, PApplet p, float rotation, int c)
    {
        pos = new PVector(x, y);
        forward = new PVector(0, -1);//makes bullet go straight up
        speed = 5;
        this.p = p;
        this.rot = rot;
        this.c = c;

    }

    void render(){
        p.pushMatrix();
        p.stroke(c);
        p.translate(pos.x, pos.y);
        p.rotate(rot);
        p.line(0,-5,0,5);
        p.popMatrix();
    }
    void move(){
        forward.x = PApplet.sin(rot);
        forward.y = - PApplet.cos(rot);
        pos.add(PVector.mult(forward, speed));

        if(pos.x > p.width || pos.x < 0 || pos.y > p.height || pos.y < 0){
            ((YASC)p).bullets.remove(this);
        }
    }
}
