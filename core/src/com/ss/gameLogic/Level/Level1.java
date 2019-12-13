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
        int id = 1;
        if(turn >= 60){
          int percent = (int) Math.floor(Math.random()*100 + 1);
          if(percent >= 70) {
            id = 0;
          }
          else {
            id = 1;
          }
        }

        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.ballr);
        rock1.activeNext();
        break;
      }
      case 1: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();
        int id = 1;
        if(turn >= 60){
          int percent = (int) Math.floor(Math.random()*100 + 1);
          if(percent >= 70) {
            id = 0;
          }
          else {
            id = 1;
          }
        }

        rock1.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[id]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.ballr);
        rock1.activeNext();
        break;
      }
      case 2: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();
        int id = 1;
        if(turn >= 60){
          int percent = (int) Math.floor(Math.random()*100 + 1);
          if(percent >= 70) {
            id = 0;
          }
          else {
            id = 1;
          }
        }

        rock1.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[id]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.ballr);
        rock1.activeNext();
        break;
      }
      case 3: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();
        int id = 1;
        if(turn >= 60){
          int percent = (int) Math.floor(Math.random()*100 + 1);
          if(percent >= 70) {
            id = 0;
          }
          else {
            id = 1;
          }
        }

        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.ballr);
        rock1.activeNext();

        break;
      }
      case 4: {
        Rock rock1 = manageRocks.getRock();
        int id = 1;
        if(turn >= 60){
          int percent = (int) Math.floor(Math.random()*100 + 1);
          if(percent >= 70) {
            id = 0;
          }
          else {
            id = 1;
          }
        }

        rock1.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock1.activeNext();

        break;
      }
      case 5: {
        Rock rock1 = manageRocks.getRock();
        int id = 1;
        if(turn >= 60){
          int percent = (int) Math.floor(Math.random()*100 + 1);
          if(percent >= 70) {
            id = 0;
          }
          else {
            id = 1;
          }
        }

        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock1.activeNext();

        break;
      }
      case 6: {
        Rock rock1 = manageRocks.getRock();
        int id = 1;
        if(turn >= 60){
          int percent = (int) Math.floor(Math.random()*100 + 1);
          if(percent >= 70) {
            id = 0;
          }
          else {
            id = 1;
          }
        }

        rock1.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.ballr);
        rock1.activeNext();

        break;
      }
      case 7: {
        Rock rock1 = manageRocks.getRock();
        int id = 1;
        if(turn >= 60){
          int percent = (int) Math.floor(Math.random()*100 + 1);
          if(percent >= 70) {
            id = 0;
          }
          else {
            id = 1;
          }
        }

        rock1.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]);

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

  @Override
  public int getMode(int start, int end) {
    int rs = (int) Math.floor(Math.random()*(end - start + 1) + start);
    tempRandom.add(rs);
    if(tempRandom.size == 2){
      if(tempRandom.get(0) == tempRandom.get(1)){
        int temp = rs;
        while(temp == rs){
          temp = (int)Math.floor(Math.random()*(end - start + 1) + start);
        }
        tempRandom.removeRange(0, 1);
        System.out.println("size: " + tempRandom.size);
        return temp;
      }
      else {
        tempRandom.removeRange(0, 1);
        return rs;
      }
    }
    return rs;
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
        mode = getMode(0, 3);
      }
      else {
        mode = getMode(4, 7);
      }
    }
    else {
      mode = getMode(0, 3);
    }

    System.out.println("random: " + mode);
    start(mode);
  }

  protected void updateTimeScroll(){
    switch (turn){
      case 1: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1f;
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
        Config.scaleTime[1] = 1.8f;
        System.out.println("log: " +turn);

        break;
      }

      default: break;
    }
  }
}
