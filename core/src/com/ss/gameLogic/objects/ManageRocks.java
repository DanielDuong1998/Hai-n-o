package com.ss.gameLogic.objects;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.ss.core.util.GLayerGroup;
import com.ss.gameLogic.objects.Rock.Rock;
import com.ss.gameLogic.objects.Rock.Rock1;
import com.ss.gameLogic.objects.Rock.Rock2;
import com.ss.gameLogic.objects.Rock.Rock3;
import com.ss.scenes.PlayScene;

public class ManageRocks {
  private TextureAtlas atlas;
  private GLayerGroup group;
  private Array<Array<Rock>> rocks;
  private PlayScene game;
  public Ball balll, ballr;

  public ManageRocks(TextureAtlas atlas, GLayerGroup group, Ball balll, Ball ballr, PlayScene game){
    this.atlas = atlas;
    this.group = group;
    this.game = game;
    this.balll = balll;
    this.ballr = ballr;
    initRocks();
  }

  private void initRocks(){
    rocks = new Array<>();
    Array<Rock> rks1 = new Array<>();
    Array<Rock> rks2 = new Array<>();
    Array<Rock> rks3 = new Array<>();
    rocks.add(rks1, rks2, rks3);
    for(int i = 0; i < rocks.size; i++){
      switch (i){
        case 0: {
          for(int j = 0; j < 20; j++) {
            Rock r = new Rock1(atlas, group, game);
            rks1.add(r);
          }
          break;
        }
        case 1: {
          for(int j = 0; j < 20; j++) {
            Rock r = new Rock2(atlas, group, game);
            rks2.add(r);
          }
          break;
        }
        case 2: {
          for(int j = 0; j < 20; j++) {
            Rock r = new Rock3(atlas, group, game);
            rks3.add(r);
          }
          break;
        }
        default: break;
      }
    }
  }

  public Rock getRock(){
    int r = (int)Math.floor(Math.random()*3);
    for(Rock rock : rocks.get(r)){
      if(rock.isAvai){
        rock.isAvai = false;
        return rock;
      }
    }
    System.out.println("no rock available!!!");
    return null;
  }

  public void getSize(){
    System.out.println("avai: ");
    int temp = 0;
    for(Rock rock : rocks.get(0)){
      if(rock.isAvai){
        temp++;
      }
    }
    System.out.println("r0: " + temp);

    temp = 0;
    for(Rock rock : rocks.get(1)){
      if(rock.isAvai){
        temp++;
      }
    }
    System.out.println("r1: " + temp);

    temp = 0;
    for(Rock rock : rocks.get(2)){
      if(rock.isAvai){
        temp++;
      }
    }
    System.out.println("r2: " + temp);

    System.out.println("--------------------------------------");
    System.out.println("not avai!");
     temp = 0;
    for(Rock rock : rocks.get(0)){
      if(!rock.isAvai){
        temp++;
      }
    }
    System.out.println("r0: " + temp);

    temp = 0;
    for(Rock rock : rocks.get(1)){
      if(!rock.isAvai){
        temp++;
      }
    }
    System.out.println("r1: " + temp);

    temp = 0;
    for(Rock rock : rocks.get(2)){
      if(!rock.isAvai){
        temp++;
      }
    }
    System.out.println("r2: " + temp);
  }
}
