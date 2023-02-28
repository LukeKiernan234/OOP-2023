<<<<<<< HEAD
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
=======
package ie.tudublin;

import ddf.minim.AudioBuffer;
// import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet{

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

    FFT fft;

    public void settings()
    {
        size(1024, 1024);
    }

    public void setup()
    {
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        lerpedBuffer = new float[width];

        fft = new FFT(width, 44100);
    }

    float[] lerpedBuffer;
    public void draw()
    {
        background(0);
        colorMode(HSB);
        stroke(255);
        float half = height / 2;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
            float f = abs(lerpedBuffer[i] * half * 2.0f);
            line(i, half + f, i, half - f);
        }

        fft.forward(ab);
        stroke(255);

        int highestIndex = 0;
        for(int i = 0 ;i < fft.specSize() / 2 ; i ++)
        {
            line(i * 2.0f, height, i * 2.0f, height - fft.getBand(i) * 5.0f);

            if (fft.getBand(i) > fft.getBand(highestIndex))
            {
                highestIndex = i;
            }
        }

        float freq = fft.indexToFreq(highestIndex);
        fill(255);
        textSize(20);
        text("Freq: " + freq, 100, 100);

        float y = map(freq, 1000.0f, 2500.0f, height, 0);
        lerpedY = lerp(lerpedY, y, 0.1f);
        circle(200, y, 50);
        circle(300, lerpedY, 50);
        



        //println(map(5, 2, 10, 1000, 2000));
        //println(map1(5, 2, 10, 1000, 2000));
    }

    float lerpedY = 0;
    
    float map1(float a, float b, float c, float d, float e)
    {
        float range1 = c - b;
        float range2 = e - d;
        float howFar = a - b;

        return d + (howFar / range1) * range2;
    }
}
>>>>>>> 1b0b7d094e77630e4e1deee0f8d4242acb390c31
