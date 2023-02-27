package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet{
    Minim m;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;
    
    FFT fft;
    public void settings(){
        size(1024, 1000, P3D);
    }

    public void setup(){
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        lerpedbuffer = new float[width];
        fft = new FFT(width, 44100);
    }
    float lerpedbuffer[];
    public void draw(){
        background(0);
        stroke (255);
        colorMode(HSB);
        float half = height / 2;
        for(int i = 0; i < ab.size(); i++){
            lerpedbuffer[i] = lerp(lerpedbuffer[i], ab.get(i), 0.1f);
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
            float f = abs(lerpedbuffer[i] * half);
            line(i, half, i, half - f);//audio buffer get at position i 
        }

        println(map1(5,0,10, 1000, 2000));
        fft.forward(ab);
        int highestindex = 0;
        for(int i =0 ; i < fft.specSize(); i++){
            line(i * 2.0f, height, i * 2.0f, height - fft.getBand(i) * 10);

            if(fft.getBand(i) > fft.getBand(highestindex)){
                highestindex = i;
            }
        }
        float freq = fft.indexToFreq(highestindex);
        fill(255, 255, 255);
        textSize(20);
        text ("freq: " + freq, 100, 100);

        float y = map(freq, 1000, 25000, height, 0);
        float lerpedy = lerp(lerpedy, y, 0.1f);
        circle(200, y, 50);
    }
    float map1(float a, float b, float c, float d, float e){
        
        float range1 = c - b;
        float range2 = e - d;
        float howfar = a - b;
        return howfar / range1 * range2 + d;
        
        //return (a - b) / (c - b) * (e - d) + d;
    }
}
