
package process;
import processing.core.PApplet;

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
        String teams = "The Fuckknuckles, Diengos, Salty Mercenaries, DimitriTryhard, DaddyTorben, Poop, Bish Boi";
        String[] list = split(teams, ',');
        saveStrings("teams.txt",list);
        
        String[] Poop = loadStrings("teams.txt");
        println(Poop);
    }

    // identical use to draw in Processing IDE
    public void draw(){
        
    }
    
}