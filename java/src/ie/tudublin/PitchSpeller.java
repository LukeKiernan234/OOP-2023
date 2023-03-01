package ie.tudublin;
import processing.core.PApplet;

public class PitchSpeller extends PApplet {
    public void settings() {
        size(500, 500);
    }

    public void setup() {
        colorMode(HSB);
    }

    public String spell(float frequency){
        float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f
			, 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f};
	    String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B","c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"};
        //take frequency and return the parameter closests to a frequency in the array
        //return the spelling of the closest  frequency
        float min = abs(frequencies[0] - frequency);
        int index = 0;
        for (int i = 0; i < frequencies.length; i++){
            if (abs(frequencies[i] - frequency) < min){
                min = abs(frequencies[i] - frequency);
                index = i;
            }
        }
        return spellings[index];
        
    }

    public void draw() {
        
    }
}	