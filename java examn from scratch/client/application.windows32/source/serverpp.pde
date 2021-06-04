import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import processing.net.*;

int [] btnLeft = new int[4];
int [] allbtns = new int[99];
int [] removedIndex = new int[99];
int roundnum = 1;

public void setting() {

  println("i am here");
}

void setup(){
  size(500, 800);
  String[] serveripp = loadStrings("ip.txt");
  String serveripppp = serveripp[0];
  text("conecting to " + serveripppp, 100, 100);


  myClient = new Client(this, serveripppp, 1234);
  msg = "";
  
  while(true){
        println("loop");

  if (myClient.available() > 0) {
    msg = myClient.readString();
    String[] list = split(msg, ',');
    mouseRecived(parseInt(list[0]), parseInt(list[1]));
    String msg2 = "";
    for (int i = 0; i < list.length; i++) 
    {
      if (i<2) {
      } else {
        msg2 = msg2 + list[i] + ",";
      }
    }
    msg2 = msg2.substring(0, msg2.length() -1);
    msg2 = msg2.substring(1);
    list = split(msg2, ',');
    saveStrings("teams.txt", list);
    println("broke");
    println(msg2);
    break;
  }
  }
  setup2();
}
public void setup2() {



  //println("running setup2");
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

  for (int i = 0; i < Poopie.length/2; i++) 
  {
    //println(Poopie[i]);
    gen(i, Poopie[i]);
    gen2(i, Poopie[i + (Poopie.length/2)], Poopie.length/2);
  }
}



void gen(int i, String name) {
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

void gen2(int i, String name, int x) {
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


void saveNew() {

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
  //println(coolio);
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
    //println(list);
    saveStrings("teams.txt", list);
    roundnum = roundnum + 1;
    setup2();
  } else {
    println(teams);
    int aaa = coolio - Poopie.length/2;
    text ("Need to atleast remove " + aaa + " more", 50, 45);
  }
  if (coolio==1) {
    //println("running coolio");
    clear();
    fill(200);
    rect(-1, -1, 501, 801);
    fill(50);
    size(500, 800);
    textSize(32);
    text ("WINNER " + teams, 150, 32);
  }
}


void mouseRecived(int mouseX1, int mouseY1) {
  //println("running mousePressed");

  String[] Poopie = loadStrings("teams.txt");

  //350, 7, 100, 30
  if (mouseY1 > (7)&&(mouseY1<30+7)) {
    //println("m ran");

    if (mouseX1 > (350)&&(mouseX1<100+350)) {
      saveNew();
      //println("savenew ran");
    }
  }


  for (int i = 0; i < Poopie.length/2; i++) 
  {
    //println(mouseX1, "  ", mouseY1, " ", allbtns[i], " ", i);
    if (mouseY1 < (allbtns[i] + 55)&&(mouseY1>allbtns[i])) {
      //println("mouseY1 done");
      //println(mouseX1);
      if (mouseX1 > (30)&&(mouseX1<200+30)) {
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
    //println(mouseX1, "  ", mouseY1, " ", allbtns[i], " ", i);
    if (mouseY1 < (allbtns[i] + 55)&&(mouseY1>allbtns[i])) {
      //println("mouseY1 done");
      //println(mouseX1);
      if (mouseX1 > (30+250)&&(mouseX1<30+250+200)) {
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

 this is the client part
 
 */
//String[] serveripp = loadStrings("ip.txt");
//String serveripppp = serveripp[0];

Client myClient;
String msg;

int init = 0;

void draw() {

  if (myClient.available() > 0) {
    msg = myClient.readString();
    String[] list = split(msg, ',');
    mouseRecived(parseInt(list[0]), parseInt(list[1]));

  }
}
