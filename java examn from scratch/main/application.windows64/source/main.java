import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.Arrays; 
import java.util.List; 
import processing.net.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class main extends PApplet {





int [] btnLeft = new int[4];
int [] allbtns = new int[99];
int [] removedIndex = new int[99];
int roundnum = 1;

String teamString = "";

public void setting() {
  println("i am here");
}

public void setup() {
  //println("running setup");
  clear();
  fill(200);
  rect(-1, -1, 501, 801);
  String[] Poopie = loadStrings("teams.txt");

  btnLeft = new int[4];
  allbtns = new int[99];
  removedIndex = new int[99];

  fill(50);
  
  textSize(32);
  text ("ROUND" + roundnum, 150, 32);

  rect(350, 7, 100, 30, 7);

  fill(255);

  textSize(15);
  text("Next Round ", 355, 28);
  


  for (int i = 0; i < Poopie.length/2; i++) 
  {
    //println(Poopie[i]);
    gen(i, Poopie[i]);
    gen2(i, Poopie[i + (Poopie.length/2)], Poopie.length/2);
  }
}



public void gen(int i, String name) {
  //println("running gen1");

  btnLeft[0] = 30;
  btnLeft[1] = (i) * 60 + 50;
  btnLeft[2] = 200;
  btnLeft[3] = 55;
  fill(50);
  rect(btnLeft[0], btnLeft[1], btnLeft[2], btnLeft[3], 7);
  textSize(20);
  fill(255);
  text (name, btnLeft[0], btnLeft[1], btnLeft[2], btnLeft[3]);
  allbtns[i] = btnLeft[1];
}

public void gen2(int i, String name, int x) {
  //println("running gen2");

  btnLeft[0] = 30+250;
  btnLeft[1] = (i) * 60 + 50; 
  btnLeft[2] = 200;
  btnLeft[3] = 55;
  fill(50);
  rect(30+50+200, (i) * 60 + 50, 200, 55, 7);
  textSize(20);
  fill(255);
  text (name, 30+50+200, (i) * 60 + 50, 200, 55);
  allbtns[x+i] = btnLeft[1];
}


public void saveNew() {

  //println("running saveNew");

  //println("asdadsd");
  String[] Poopie = loadStrings("teams.txt");
  String teams = "";
  int coolio = 0;

  for (int i = 0; i < Poopie.length; i++) {
    if (removedIndex[i] == 0) {
      coolio = coolio + 1;
    }
  }
  println(coolio);
  //println(coolio + ", " + Poopie.length/2);
  if (coolio == Poopie.length/2) {



    //if (removedIndex[i] == 0) {
    //    if (removedIndex[i] == 0) {

    for (int i = 0; i < Poopie.length; i++) {
      //println(teams);
      //println(Poopie.length, " aaa ", i-1);
      if (removedIndex[i] == 0) {
        teams = teams + Poopie[i] + ",";
      }
    }
    teams = teams.substring(0, teams.length() -1);
    //println(teams);
    String[] list = split(teams, ',');
    saveStrings("teams.txt", list);
    roundnum = roundnum + 1;
    setup();
  } else {
    int aaa = coolio - Poopie.length/2;
    text ("Need to atleast remove " + aaa + " more", 50, 45);
  }
  if (coolio==1) {
    println("running coolio");
    clear();
    fill(200);
    rect(-1, -1, 501, 801);
    fill(50);
    size(500, 800);
    textSize(32);
    text ("WINNER " + teams, 150, 32);
  }
}


public void mousePressed() {
    String[] Poopie = loadStrings("teams.txt");
  teamString = "";
  for (int i = 0; i < Poopie.length; i++) 
  {
    //println(Poopie[i]);
    teamString = teamString + "," + Poopie[i];
    println(Poopie[i]);
  }
  //println("running mousePressed");
  myServer.write(String.valueOf(mouseX) + "," + String.valueOf(mouseY) + "," + teamString);



  //350, 7, 100, 30
  if (mouseY > (7)&&(mouseY<30+7)) {
    //println("m ran");

    if (mouseX > (350)&&(mouseX<100+350)) {
      saveNew();
      //println("savenew ran");
    }
  }


  for (int i = 0; i < Poopie.length/2; i++) 
  {
    //println(mouseX, "  ", mouseY, " ", allbtns[i], " ", i);
    if (mouseY < (allbtns[i] + 55)&&(mouseY>allbtns[i])) {
      //println("mouseY done");
      //println(mouseX);
      if (mouseX > (30)&&(mouseX<200+30)) {
        if ((allbtns[i] != 0) && (removedIndex[i] == 0)) {
          rect(30, (i) * 60 + 50, 200, 55, 7);
          removedIndex[i] = 1;
          //println(i);
          break;
        }
      }
    }
  }
  for (int i = 0; i < Poopie.length/2; i++) 
  {
    //println(mouseX, "  ", mouseY, " ", allbtns[i], " ", i);
    if (mouseY < (allbtns[i] + 55)&&(mouseY>allbtns[i])) {
      println("mouseY done");
      println(mouseX);
      if (mouseX > (30+250)&&(mouseX<30+250+200)) {
        if ((allbtns[i] != 0) && (removedIndex[i + (Poopie.length/2)] == 0)) {
          rect(30+250, (i) * 60 + 50, 200, 55, 7);
          removedIndex[i + (Poopie.length/2)] = 1;
          //println(i + (Poopie.length/2));
          break;
        }
      }
    }
  }
}



/*

 this is the server part
 
 
 
 */

Server myServer = new Server(this, 1234);
String msg = "";

// method used only for setting the size of the window


// identical use to draw in Prcessing IDE



public void draw() {
}
  public void settings() {  size(500, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
