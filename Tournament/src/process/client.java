package process;

import processing.core.PApplet;
import processing.net.*;

public class client extends PApplet {

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("process.main");
    }
    
    String serverAdr;
    
    client(String ip){
    	this.serverAdr = ip;
    }
    
    Client myClient;
	String msg = "nothing";
    // method used only for setting the size of the window
    public void startClient(){
        println("running settings ", serverAdr);
		//myClient = new Client(this, serverAdr, 1234);
    }


    // identical use to setup in Processing IDE except for size()
    public void startt(){
        println("running setup");
        if (myClient.available() > 0) {
			msg = myClient.readString();
		}
    }
    

    // identical use to draw in Prcessing IDE
    public void draw(){
    	
    }
}
	
	
