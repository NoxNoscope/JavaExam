package process;

import processing.core.PApplet;
import processing.net.*;

public class server extends PApplet {

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("process.main");
    }

	Server myServer;
	String msg;
    // method used only for setting the size of the window
    public void startServer(){
        println("running settings");

    	myServer = new Server(this, 1234);
		
    }


    // identical use to setup in Processing IDE except for size()
    public void startt(){
        println("running setup");
        Client myClient = myServer.available();
        if (myClient != null) {
        	msg = myClient.readString();
        }
    }
    

    // identical use to draw in Prcessing IDE
    public void draw(){
    	
    }
}
	
	
