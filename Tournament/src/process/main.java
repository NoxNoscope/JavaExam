package process;
import processing.core.PApplet;

public class main extends PApplet {

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("process.main");
    }

    // method used only for setting the size of the window
    public void settings(){
    	size(500,5000);
        
    }


    // identical use to setup in Processing IDE except for size()
    public void setup(){
        background(0);
        stroke(255);
        strokeWeight(10);
    }

    // identical use to draw in Prcessing IDE
    public void draw(){
        line(0, 0, 500, 500);
    }
}