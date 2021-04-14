package process;
import processing.core.PApplet;

import process.client;

public class Model extends PApplet {
	

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("process.Model");
        
    }

    // method used only for setting the size of the window
    public String[] strat(){
    	String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
    	return cars;

    }


    // identical use to setup in Processing IDE except for size()
    public void setup(){
    	
    }

    // identical use to draw in Prcessing IDE
    
    
    

    
}