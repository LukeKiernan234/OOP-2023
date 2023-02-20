package ie.tudublin;

import com.jogamp.common.os.AndroidVersion;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {
    Minim minim;
    AudioInput ai;
    AudioBuffer ab;
    AudioPlayer ap;

    public void settings() {
        size(500, 500);
    }

    int frameize = 1024;

    public void setup() {
        colorMode(HSB);
        background(0);

        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, frameize, 44100, 16);// open the mic on computer read data and get cd quality
                                                              // samples
        ab = ai.mix;
    }

    /* (non-Javadoc)
     * @see processing.core.PApplet#draw()
     */
    public void draw() {
        background(0);
        stroke(255);
        final float half = height / 2;
        float cgap = 255 / ab.size();
        float total = 0;

        for (int i = 0; i < ab.size(); i++) {
            total += abs(ab.get(i));
            stroke(cgap * i, 255, 255);
            line(i, half, i, half + ab.get(i) * half);
        }
        float average = total / (float) ab.size();
        float r = average * 200;
        lerpedR = lerp(lerpedR, r, (float) 0.1);
        circle(100, 200, lerpedR * 2);

    }
    float lerpedR = 0;
}