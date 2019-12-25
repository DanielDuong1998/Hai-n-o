package com.ss.gameLogic.Level;

import com.badlogic.gdx.utils.Array;
import com.ss.gameLogic.StaticObjects.Config;
import com.ss.gameLogic.objects.ManageRocks;
import com.ss.gameLogic.objects.Rock.Rock;

public class LevelInfinity extends Level {

  private int padding = 20;

  public LevelInfinity(ManageRocks manageRocks, int turn){
    this.manageRocks = manageRocks;
    this.turn = turn;
    Config.scaleTime[0] = Config.scaleTimeCtn[0];
    Config.scaleTime[1] = Config.scaleTimeCtn[1];
    startLv();
  }

  private int getId(){
    int percent = (int) Math.floor(Math.random()*100 + 1);
    if(percent <= 70){
      return 3;
    }
    else if(percent <= 90){
      return 2;
    }
    else return 4;
  }

  @Override
  protected void start(int mode) {
    super.start(mode);
    switch (mode){
      case 0: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();
        int id = getId();

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
        int id = getId();

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
        int id = getId();

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
        int id = getId();

        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.ballr);
        rock1.activeNext();

        break;
      }
      case 4: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();
        Rock rock3 = manageRocks.getRock();
        int id = getId();

        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id] - rock1.getHeightS()/2 - rock2.getHeightS()/2 - padding);
        rock3.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.balll);
        rock3.moveRock(manageRocks.ballr);
        rock2.activeNext();

        break;
      }
      case 5: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();
        Rock rock3 = manageRocks.getRock();
        int id = getId();

        rock1.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id] - rock1.getHeightS()/2 - rock2.getHeightS()/2 - padding);
        rock3.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.ballr);
        rock2.moveRock(manageRocks.ballr);
        rock3.moveRock(manageRocks.balll);
        rock2.activeNext();

        break;
      }
      case 6: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();
        int id = getId();

        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id]-rock1.getHeightS()/2 - rock2.getHeightS()/2 - padding);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.ballr);
        rock2.activeNext();

        break;
      }
      case 7: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();
        int id = getId();

        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]-rock2.getHeightS()/2 - rock1.getHeightS()/2 - padding);
        rock2.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.ballr);
        rock1.activeNext();

        break;
      }
      case 8: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();
        Rock rock3 = manageRocks.getRock();
        int id = getId();

        rock1.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[id]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[id]-rock2.getHeightS()/2 - rock1.getHeightS()/2 - padding);
        rock3.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock2.moveRock(manageRocks.balll);
        rock3.moveRock(manageRocks.ballr);
        rock2.activeNext();

        break;
      }
      case 9: {
        Rock rock1 = manageRocks.getRock();
        Rock rock2 = manageRocks.getRock();
        Rock rock3 = manageRocks.getRock();
        int id = getId();

        rock1.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]);
        rock2.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]-rock2.getHeightS()/2 - rock1.getHeightS()/2 - padding);
        rock3.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.ballr);
        rock2.moveRock(manageRocks.ballr);
        rock3.moveRock(manageRocks.balll);
        rock2.activeNext();

        break;
      }
//      case 10: {
//        Rock rock1 = manageRocks.getRock();
//        Rock rock2 = manageRocks.getRock();
//        Rock rock3 = manageRocks.getRock();
//        Rock rock4 = manageRocks.getRock();
//        int id = getId();
//
//        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]);
//        rock2.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]-rock2.getHeightS()/2 - rock1.getHeightS()/2 - padding);
//        rock3.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id]-rock2.getHeightS()/2 - rock1.getHeightS()/2 - padding);
//        rock4.setPosition1(Config.POSSITION_ROCK_X[2], rock3.getY() - rock3.getHeightS()/2 - rock4.getHeightS()/2);
//
//        rock1.moveRock(manageRocks.balll);
//        rock2.moveRock(manageRocks.balll);
//        rock3.moveRock(manageRocks.ballr);
//        rock4.moveRock(manageRocks.ballr);
//        rock4.activeNext();
//
//        break;
//      }
//      case 11: {
//        Rock rock1 = manageRocks.getRock();
//        Rock rock2 = manageRocks.getRock();
//        Rock rock3 = manageRocks.getRock();
//        Rock rock4 = manageRocks.getRock();
//        int id = getId();
//
//        rock1.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id]);
//        rock2.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id]-rock2.getHeightS()/2 - rock1.getHeightS()/2 - padding);
//        rock3.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]-rock2.getHeightS()/2 - rock1.getHeightS()/2 - padding);
//        rock4.setPosition1(Config.POSSITION_ROCK_X[1], rock3.getY() - rock3.getHeightS()/2 - rock4.getHeightS()/2);
//
//        rock1.moveRock(manageRocks.ballr);
//        rock2.moveRock(manageRocks.ballr);
//        rock3.moveRock(manageRocks.balll);
//        rock4.moveRock(manageRocks.balll);
//        rock4.activeNext();
//
//        break;
//      }
//      case 12: {
//        Rock rock1 = manageRocks.getRock();
//        Rock rock2 = manageRocks.getRock();
//        Rock rock3 = manageRocks.getRock();
//        Rock rock4 = manageRocks.getRock();
//        Rock rock5 = manageRocks.getRock();
//        int id = getId();
//
//        rock1.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[id]);
//        rock2.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[id]-rock2.getHeightS()/2 - rock1.getHeightS()/2 - padding);
//        rock3.setPosition1(Config.POSSITION_ROCK_X[0], rock2.getY() - rock3.getHeightS()/2 - rock2.getHeightS()/2 - padding);
//        rock4.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]);
//        rock5.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]-rock5.getHeightS()/2 - rock4.getHeightS()/2 - padding);
//
//        rock1.moveRock(manageRocks.balll);
//        rock2.moveRock(manageRocks.balll);
//        rock3.moveRock(manageRocks.balll);
//        rock4.moveRock(manageRocks.ballr);
//        rock5.moveRock(manageRocks.ballr);
//        rock3.activeNext();
//
//        break;
//      }
//      case 13: {
//        Rock rock1 = manageRocks.getRock();
//        Rock rock2 = manageRocks.getRock();
//        Rock rock3 = manageRocks.getRock();
//        Rock rock4 = manageRocks.getRock();
//        Rock rock5 = manageRocks.getRock();
//        int id = getId();
//
//        rock1.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]);
//        rock2.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]-rock2.getHeightS()/2 - rock1.getHeightS()/2 - padding);
//        rock3.setPosition1(Config.POSSITION_ROCK_X[3], rock2.getY() - rock3.getHeightS()/2 - rock2.getHeightS()/2 - padding);
//        rock4.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[id]);
//        rock5.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[id]-rock5.getHeightS()/2 - rock4.getHeightS()/2 - padding);
//
//        rock1.moveRock(manageRocks.ballr);
//        rock2.moveRock(manageRocks.ballr);
//        rock3.moveRock(manageRocks.ballr);
//        rock4.moveRock(manageRocks.balll);
//        rock5.moveRock(manageRocks.balll);
//        rock3.activeNext();
//
//        break;
//      }
      case 10: {
        Rock rock1 = manageRocks.getRock();
        int id = getId();

        rock1.setPosition1(Config.POSSITION_ROCK_X[0], Config.POSSITION_ROCK_Y[id]);
        rock1.moveRock(manageRocks.balll);
        rock1.activeNext();
        break;
      }
      case 11: {
        Rock rock1 = manageRocks.getRock();
        int id = getId();
        rock1.setPosition1(Config.POSSITION_ROCK_X[1], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.balll);
        rock1.activeNext();
        break;
      }
      case 12: {
        Rock rock1 = manageRocks.getRock();
        int id = getId();

        rock1.setPosition1(Config.POSSITION_ROCK_X[2], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.ballr);
        rock1.activeNext();
        break;
      }
      case 13: {
        Rock rock1 = manageRocks.getRock();
        int id = getId();

        rock1.setPosition1(Config.POSSITION_ROCK_X[3], Config.POSSITION_ROCK_Y[id]);

        rock1.moveRock(manageRocks.ballr);
        rock1.activeNext();
        break;
      }
      default: break;
    }
  }

  private boolean check(int checkN, Array<Integer> nums){
    for(int num : nums){
      if(checkN == num){
        return true;
      }
    }
    return false;
  }

  private int checkMode(Array<Integer> tempArr){
    Array<Integer> nums = new Array<>();
    nums.add(0, 4, 5, 6);
    nums.add(7, 12, 13);
    if(check(tempArr.get(0), nums) && check(tempArr.get(1), nums)){
      int temp = tempArr.get(1);
      while (check(temp, nums)){
        temp = (int)Math.floor(Math.random()*10);
      }
      tempArr.removeRange(0, 1);
      tempArr.add(temp);
      return temp;
    }
    else {
      nums.removeRange(0, 6);
      nums.add(1, 2, 3, 8);
      nums.add(9, 10, 11);
      if(check(tempArr.get(0), nums) && check(tempArr.get(1), nums)){
        int temp = tempArr.get(1);
        while (check(temp, nums)){
          temp = (int)Math.floor(Math.random()*10);
        }
        tempArr.removeRange(0, 1);
        tempArr.add(temp);
        return temp;
      }
      else {
        int temp = tempArr.get(1);
        tempArr.removeRange(0, 1);
        tempArr.add(temp);
        return temp;
      }
    }
  }

  @Override
  public int getMode(int start, int end) {
    int rs = (int)Math.floor(Math.random()*(end - start + 1) + start);
    tempRandom.add(rs);
    if(tempRandom.size == 2){
      return checkMode(tempRandom);
    }
    return rs;
  }

  @Override
  public void startLv() {
    super.startLv();
    updateTimeScroll();
    int mode = getMode(0, 13);
    start(mode);
  }

  protected void updateTimeScroll(){
    System.out.println("scaleTime: " + Config.scaleTime[1] + " turn: " + turn);
    switch (turn){
      case 0: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1.8f;
        System.out.println("log: " +turn);
        break;
      }
      case 10: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 2f;
        System.out.println("log: " +turn);
        break;
      }
      case 20: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 2.2f;
        System.out.println("log: " +turn);
        break;
      }
      case 30: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 2.3f;
        System.out.println("log: " +turn);

        break;
      }
      case 40: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 2.5f;
        System.out.println("log: " +turn);

        break;
      }
      case 50: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 2.6f;
        System.out.println("log: " +turn);

        break;
      }
      case 60: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 2.8f;
        System.out.println("log: " +turn);

        break;
      }
      case 70: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 3f;
        System.out.println("log: " +turn);

        break;
      }
      case 80: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 3.2f;
        System.out.println("log: " +turn);

        break;
      }
      case 90: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 3.4f;
        System.out.println("log: " +turn);

        break;
      }
      case 100: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 3.6f;
        System.out.println("log: " +turn);

        break;
      }
      case 110: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 3.8f;
        System.out.println("log: " +turn);

        break;
      }
      case 120: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 4f;
        System.out.println("log: " +turn);

        break;
      }
      case 130: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 4.2f;
        System.out.println("log: " +turn);

        break;
      }
      case 140: {
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 4.6f;
        System.out.println("log: " +turn);

        break;
      }
    }
  }
}
