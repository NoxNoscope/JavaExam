package process;
import processing.core.PApplet;

import process.client;

public class Gui extends PApplet {
	

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("process.Gui");
        
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

    // identical use to draw in Prcessing IDE
    public void draw(){
        line(0, 0, 500, 500);
    }
    
    
    private void diegoSettings() {
    	client startClient = new client("127.0.0.1");
    	startClient.startClient();
    }
    
}