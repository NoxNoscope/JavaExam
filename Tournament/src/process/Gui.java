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
		/*String[] Poopie = loadStrings("teams.txt");
		println(Poopie[1]);
		
		int numInPoopie = 0;
		for (int i = 0; i < Poopie.length; i++) {
			  
            // Print all elements of List
            println(Poopie[i]);
            numInPoopie = i;
        }
		
        if(numInPoopie % 2 == 0) {
        	gen(numInPoopie);
        }else {
        	gen(numInPoopie-1);

        }
        
        
		gen2(4);
		gen3(2);
		gen4(1);*/
		
		
		
	}

// identical use to draw in Prcessing IDE
	public void draw() {

	}
	
	/*
	void gen(int x) {
		for (int i = 0; i < x; i++) {
			rect(30, (i) * 60, 55, 55, 7);
			
		}
		
	}
		
	void gen2(int x) {
		for (int i = 0; i < x; i++) {
			rect(30+55+55, (i) * 60, 55, 55, 7);
			line(30+55+55, 30, 85, 30);
		}
	}
	
	void gen3(int x) {
		for (int i = 0; i < x; i++) {
			rect(30+220, (i) * 60, 55, 55, 7);
			line(30+220-55, 30, 85+220-55, 30);
		}
	}
	void gen4(int x) {
		for (int i = 0; i < x; i++) {
			rect(30+275+55, (i) * 60, 55, 55, 7);
			line(30+275+55, 30, 85+275-55, 30);
		}
	}
	
*/
	}
	
	
	