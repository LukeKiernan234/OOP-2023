package ie.tudublin;

import ddf.minim.AudioBuffer;
// import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio3 extends PApplet {

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

    FFT fft;

    public void settings() {
        size(1024, 1024);
    }

    public void keyPressed() {
        if (key == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    public void setup() {
        m = new Minim(this);
        ap = m.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        lerpedBuffer = new float[width];

    }

    float rot = 0;
    float[] lerpedBuffer;

    public void draw() {
        float total = 0;
        float lerpedaverage = 0;
        for (int i = 0; i < ab.size(); i++) {
            total += abs(ab.get(i));
        }
        float average = total / ab.size();
        lerpedaverage = lerp(lerpedaverage, average, 0.1f);
        lights();
        background(0);
        colorMode(HSB);
        float c = map(lerpedaverage, 0, 1, 0, 255);
        stroke(c);
        strokeWeight(5);
        // fill(255);
        noFill();
        translate(width / 2, height / 2);
        rot += map(lerpedaverage, 0, 1.0f, 0, 1);
        rotateY(rot);
        rotateX(rot);
        float boxSize = max(100, map(lerpedaverage, 0, 1, 100, 500));

        box(boxSize);



    }

    float lerpedY = 0;

    float map1(float a, float b, float c, float d, float e) {

        float range1 = c - b;
        float range2 = e - d;
        float howFar = a - b;

        return d + (howFar / range1) * range2;

    }
}
