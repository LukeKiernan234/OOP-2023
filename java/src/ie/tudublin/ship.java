package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class ship {
    private PVector pos;
    private PApplet p;

    public ship(float x, float y, float size, int c, PApplet p) {
        pos = new PVector(x, y);
        this.size = size;
        this.c = c;
        this.p = p;
    }

    public PVector getPos() {
        return pos;
    }
    public void setPos(PVector pos) {
        this.pos = pos;
    }
    public float getRotation() {
        return rotation;
    }
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
    public int getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }
    public float getSize() {
        return size;
    }
    public void setSize(float size) {
        this.size = size;
    }
    private float rotation;
    private int c;
    private float size;

    public void render() {
        p.pushMatrix();
        p.translate(pos.x, pos.y);
        p.rotate(rotation);
        p.fill(c);
        p.triangle(-size, size, size, size, 0, -size);
        p.popMatrix();
    }

}
