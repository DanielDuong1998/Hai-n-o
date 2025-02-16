package com.ss.gameLogic.Level;

import com.ss.gameLogic.StaticObjects.Config;
import com.ss.gameLogic.objects.ManageRocks;
import com.ss.gameLogic.objects.Rock.Rock;

public class Level2 extends Level {
  public Level2(ManageRocks manageRocks, int turn){
    this.manageRocks = manageRocks;
    this.turn = turn;
    Config.scaleTime[0] = Config.scaleTimeCtn[0];
    Config.scaleTime[1] = Config.scaleTimeCtn[1];
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
        int id = (int) Math.floor(Math.random()*2);
        if(turn >=80){
          id = 1;
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
        int id = (int) Math.floor(Math.random()*2);
        if(turn >=80){
          id = 1;
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
        int id = (int) Math.floor(Math.random()*2);
        if(turn >=80){
          id = 1;
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
        int id = (int) Math.floor(Math.random()*2);
        if(turn >=80){
          id = 1;
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
        int id = 0;


        rock1.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock1.activeNext();

        break;
      }
      case 5: {
        Rock rock1 = manageRocks.getRock();
        int id = 0;

        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock1.activeNext();

        break;
      }
      case 6: {
        Rock rock1 = manageRocks.getRock();
        int id = 0;


        rock1.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.ballr);
        rock1.activeNext();

        break;
      }
      case 7: {
        Rock rock1 = manageRocks.getRock();
        int id = 0;


        rock1.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.ballr);
        rock1.activeNext();

        break;
      }
      default: break;
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
        tempRandom.add(temp);
        System.out.println("size: " + tempRandom.size);
        return temp;
      }
      else {
        tempRandom.removeRange(0, 1);
        tempRandom.add(rs);
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
    int length = turn >= 50 ? 8 : 4;
    int mode;
    if(turn >= 50){
      mode = getMode(0,7);
    }
    else mode = getMode(0,3);
    System.out.println("random: " + mode);
    if(turn > 99){
      System.out.println("end");
      return;
    }
    start(mode);
    //manageRocks.getSize();
  }

  protected void updateTimeScroll(){
    switch (turn){
      case 10: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.5f;
        System.out.println("log: " +turn);
        break;
      }
      case 20: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.6f;
        System.out.println("log: " +turn);
        break;
      }
      case 30: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.7f;
        System.out.println("log: " +turn);

        break;
      }
      case 40: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.8f;
        System.out.println("log: " +turn);

        break;
      }
      case 50: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 2f;
        System.out.println("log: " +turn);

        break;
      }
      case 60: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 2.2f;
        System.out.println("log: " +turn);

        break;
      }
      case 70: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 2.2f;
        System.out.println("log: " +turn);

        break;
      }
      case 80: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 2.3f;
        System.out.println("log: " +turn);

        break;
      }
      case 90: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 2.6f;
        System.out.println("log: " +turn);

        break;
      }

      default: break;
    }
  }
}
