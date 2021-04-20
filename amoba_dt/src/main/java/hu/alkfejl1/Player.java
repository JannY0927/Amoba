package hu.alkfejl1;

import java.util.Timer;

public class Player {

private boolean isMachine;
private String mySign;
private int myTime;

public Player(boolean isMachine, String mySign) {
    this.isMachine = isMachine;
    this.mySign = mySign;
    this.myTime = 60;
}


public boolean isMachine() {
    return isMachine;
}

public String getMySign() {
    return mySign;
}

public int getMyTime() {return myTime;}

public void setMyTime(int myTime) {
    this.myTime = myTime;
}

}
