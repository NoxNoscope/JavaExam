package process;

import processing.core.PApplet;

public class main extends PApplet {

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("main");
    }

    // method used only for setting the size of the window
    public void settings(){
    	size(1920,1080);
        
    }

    // identical use to setup in Processing IDE except for size()
    public void setup(){
        
    }

    // identical use to draw in Prcessing IDE
    public void draw(){
    	rect(500,500,250,250);
    	println("helo nib");
    }
}