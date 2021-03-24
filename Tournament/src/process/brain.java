package process;
import processing.core.PApplet;

import process.client;

public class brain extends PApplet {
	

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("process.brain");
        
    }

    // method used only for setting the size of the window
    public void settings(){
    	size(500,500);
    	//diegoSettings();
    }


    // identical use to setup in Processing IDE except for size()
    public void setup(){
        strokeWeight(5);
    }

    // identical use to draw in Processing IDE
    public void draw(){
        
    }
    
}