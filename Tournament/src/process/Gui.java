package process;
import processing.core.PApplet;

import process.client;

public class Gui extends PApplet {
	

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("process.Gui");
        
    }


public void settings() {
  size(500, 800);
}

// identical use to setup in Processing IDE except for size()
public void setup() {
  gen(8);
}

// identical use to draw in Prcessing IDE
public void draw() {
  
  
  
}

void gen(int x){
        for (int i = 0; i < x; i++) {
        rect(30, (i)*60, 55, 55, 7);
        
}


}
    
    
    
    
    
}