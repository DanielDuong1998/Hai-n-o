package com.ss.gameLogic.Level;


import com.badlogic.gdx.utils.Array;
import com.ss.gameLogic.objects.Ball;
import com.ss.gameLogic.objects.ManageRocks;

public class Level {
  protected ManageRocks manageRocks;
  protected Array<Integer> modes;
  protected int turn = 0;

  protected void begin(){

  }

  protected void start(int mode){
    turn++;
  }

  public void startLv(){

  }
}
