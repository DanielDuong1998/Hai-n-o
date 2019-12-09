package com.ss.gameLogic.Level;

import com.badlogic.gdx.utils.Array;
import com.ss.gameLogic.StaticObjects.Config;
import com.ss.gameLogic.objects.ManageRocks;
import com.ss.gameLogic.objects.Rock.Rock;

public class Level1 extends Level {
  public Level1(ManageRocks manageRocks){
    this.manageRocks = manageRocks;
    startLv();
  }

  @Override
  protected void begin() {
    super.begin();
  }

  @Override
  protected void start(int mode) {
    super.start(mode);
    switch (mode){
      case 0: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();

        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[1]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[1]);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.ballr);
        rock1.activeNext();
        break;
      }
      case 1: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();

        rock1.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[1]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[1]);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.ballr);
        rock1.activeNext();
        break;
      }
      case 2: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();

        rock1.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[1]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[1]);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.ballr);
        rock1.activeNext();
        break;
      }
      case 3: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();

        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[1]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[1]);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.ballr);
        rock1.activeNext();

        break;
      }
      case 4: {
        Rock rock1 = manageRocks.getRock();

        rock1.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[1]);

        rock1.moveRock(manageRocks.balll);
        rock1.activeNext();

        break;
      }
      case 5: {
        Rock rock1 = manageRocks.getRock();

        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[1]);

        rock1.moveRock(manageRocks.balll);
        rock1.activeNext();

        break;
      }
      case 6: {
        Rock rock1 = manageRocks.getRock();

        rock1.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[1]);

        rock1.moveRock(manageRocks.ballr);
        rock1.activeNext();

        break;
      }
      case 7: {
        Rock rock1 = manageRocks.getRock();

        rock1.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[1]);

        rock1.moveRock(manageRocks.ballr);
        rock1.activeNext();

        break;
      }
      default: break;
    }
  }

  private void initMode(){
    modes = new Array<>();
    for(int i = 0; i < 8; i++){
      modes.add(i);
    }
  }

  private int getMode(){
    return 1;
  }

  @Override
  public void startLv() {
    super.startLv();
    updateTimeScroll();
    System.out.println("turn: " + turn);

    int mode;
    if(turn >= 50){
      int percent = (int) Math.floor(Math.random()*100 + 1);
      if(percent <= 70){
        mode = (int)Math.floor(Math.random()*4);
      }
      else {
        mode = (int)Math.floor(Math.random()*4 + 4);
      }
    }
    else {
      mode = (int)Math.floor(Math.random()*4);
    }

    System.out.println("random: " + mode);
    start(mode);
    //manageRocks.getSize();
  }

  protected void updateTimeScroll(){
    switch (turn){
      case 1: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.2f;
        System.out.println("log: " +turn);
        break;
      }
      case 10: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.2f;
        System.out.println("log: " +turn);
        break;
      }
      case 20: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.4f;
        System.out.println("log: " +turn);
        break;
      }
      case 30: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.4f;
        System.out.println("log: " +turn);

        break;
      }
      case 40: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.5f;
        System.out.println("log: " +turn);

        break;
      }
      case 50: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.5f;
        System.out.println("log: " +turn);

        break;
      }
      case 60: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.5f;
        System.out.println("log: " +turn);

        break;
      }
      case 70: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.6f;
        System.out.println("log: " +turn);

        break;
      }
      case 80: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.7f;
        System.out.println("log: " +turn);

        break;
      }

      default: break;
    }
  }
}
