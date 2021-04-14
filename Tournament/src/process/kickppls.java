package process;

import processing.core.PApplet;


public class kickppls extends PApplet {

	// The argument passed to main must match the class name
	public static void main(String[] args) {
		PApplet.main("process.kickppls");

	}

	public void settings() {
		size(500, 800);
	}

// identical use to setup in Processing IDE except for size()
	public void setup() {
		String teams = " Fuck-Knuckles,. Diengos,. Salty Mercenaries,. DimitriTryhard,. DaddyTorben,. London Gingers,. Grey Dodgers,. New York Hippos,. Sandmen,. Purple Koalas,. Pulse,. Purple Blue Bottles,. Hilarious Newts,. Devon Giraffes,. Red Flyers,. Conditioneers";
        String[] list = split(teams, '.');
        saveStrings("teams.txt",list);
        
        String[] Poopie = loadStrings("teams.txt");
        println(Poopie);
	}

// identical use to draw in Prcessing IDE
	public void draw() {
		

	}


	
}
	
	
	