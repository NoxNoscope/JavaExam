/*
vores imports der bliver brugt.
 vi laver noget med network og derfor .net og så laver vi lidt array og liste behandling.
 */
import java.util.Arrays;
import java.util.List;
import processing.net.*;

/*
globale variabler
 */
int [] btnLeft = new int[4];
int [] allbtns = new int[99];
int [] removedIndex = new int[99];
int roundnum = 1;

String teamString = "";

/*
vores setup function som setter alt op og bliver kaldt i starten når runde 2,3,4..... begynder.
 
 */
public void setup() {
  //println("running setup");
  clear(); // for at wipe alt fra den forige runde.
  fill(200);
  rect(-1, -1, 501, 801);
  String[] Poopie = loadStrings("teams.txt");

  btnLeft = new int[4];
  allbtns = new int[99];
  removedIndex = new int[99];

  fill(50);
  size(500, 800);
  textSize(32);
  text ("ROUND" + roundnum, 150, 32);

  rect(350, 7, 100, 30, 7);

  fill(255);

  textSize(15);
  text("Next Round ", 355, 28);


  /*
  loop for at gennemgå alle grupper og vise dem.
   */
  for (int i = 0; i < Poopie.length/2; i++) 
  {
    //println(Poopie[i]);
    gen(i, Poopie[i]); // functionen for række 1
    gen2(i, Poopie[i + (Poopie.length/2)], Poopie.length/2);// functionen for række 2
  }
}



void gen(int i, String name) {
  //println("running gen1");
  // x og y cords for firkanten
  btnLeft[0] = 30;
  btnLeft[1] = (i) * 60 + 50;
  btnLeft[2] = 200;
  btnLeft[3] = 55;
  fill(50);
  rect(btnLeft[0], btnLeft[1], btnLeft[2], btnLeft[3], 7); // drawing the rect
  textSize(20);
  fill(255);
  text (name, btnLeft[0], btnLeft[1], btnLeft[2], btnLeft[3]);
  allbtns[i] = btnLeft[1];
}
/*
det samme som i gen men den her gang men en anden start x for at display det ved siden af
 */

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

/*
savenew bliver brugt for at lave checks og gemme det rigtige i det nye document
 */

void saveNew() {
  //println("running saveNew");
  String[] Poopie = loadStrings("teams.txt");
  String teams = "";
  int coolio = 0;

  //check hvilke der er ud af indexet, alstå hvilke der blev klicket på
  for (int i = 0; i < Poopie.length; i++) {
    if (removedIndex[i] == 0) {
      coolio = coolio + 1;
    }
  }

  //loop igennem indexet af tal og tilføj dem til strengen
  if (coolio == Poopie.length/2) {
    for (int i = 0; i < Poopie.length; i++) {
      if (removedIndex[i] == 0) {
        teams = teams + Poopie[i] + ",";
      }
    }
    teams = teams.substring(0, teams.length() -1);
    //println(teams);
    String[] list = split(teams, ',');
    saveStrings("teams.txt", list);
    roundnum = roundnum + 1;
    setup(); // genstart
  } else {
    int aaa = coolio - Poopie.length/2;
    text ("Need to atleast remove " + aaa + " more", 50, 45);
  }
  if (coolio==1) {
    /*
    vis hvem der er vinderen hvis kravende er opfyldt
    */
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


/*
så snart musse knappen bliver trykket gør dette.
*/
void mousePressed() {
  String[] Poopie = loadStrings("teams.txt"); //hiv de opdateret informationer ned
  teamString = "";
  for (int i = 0; i < Poopie.length; i++) 
  {
    //println(Poopie[i]);
    teamString = teamString + "," + Poopie[i];
    println(Poopie[i]);
  }
  /*
  hvis x og y er inden for boxen (den rect der blev lavet i gen functionerne og next)
  skriv mouse x og mouse y til vores clienter for at de har informationerne der skal bruges
   */
  myServer.write(String.valueOf(mouseX) + "," + String.valueOf(mouseY) + "," + teamString);
  if (mouseY > (7)&&(mouseY<30+7)) {
    if (mouseX > (350)&&(mouseX<100+350)) {
      saveNew();
    }
  }

  /*
  for alle grupper og dermed knapper gå igennem hver af dem og så lav en rigtige action depending on hvor der bliver klicket
   */
  for (int i = 0; i < Poopie.length/2; i++) 
  {
    //println(mouseX, "  ", mouseY, " ", allbtns[i], " ", i);
    if (mouseY < (allbtns[i] + 55)&&(mouseY>allbtns[i])) {
      if (mouseX > (30)&&(mouseX<200+30)) {
        if ((allbtns[i] != 0) && (removedIndex[i] == 0)) {
          rect(30, (i) * 60 + 50, 200, 55, 7);
          removedIndex[i] = 1;
          //println(i);
          break; // stop loopen hvis det vil er achived
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
          break;// stop loopen hvis det vil er achived
        }
      }
    }
  }
}



/*

 this is the server part
 so whatever im doing here is for the hosting of the application to other clients.
 
 */
 
// lav serveren
Server myServer = new Server(this, 1234);
String msg = "";


void draw() {
}
