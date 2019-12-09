package com.ss.gameLogic;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.ss.core.action.exAction.GSimpleAction;
import com.ss.core.util.GLayerGroup;
import com.ss.core.util.GUI;
import com.ss.gameLogic.StaticObjects.Config;


public class Background {
  private TextureAtlas atlas;
  private GLayerGroup group;
  private Array<Image> bgImgs;

  public Background(TextureAtlas atlas, GLayerGroup group){
    this.atlas = atlas;
    this.group = group;
    initGroup();
    initBackGround();
    scrollStart();
  }

  float accum = 0;
  private void initGroup(){

  }

  //start init
  private void initBackGround(){
    bgImgs = new Array<>();
    for(int i = 0; i < 3; i++) {
      initBgTexture();
    }
    bgImgs.get(0).setY(-2*(Config.HeightScreen-1));
    bgImgs.get(1).setY(-1*(Config.HeightScreen-1));
  }
  // end init

  private void initBgTexture(){
    Image bg = GUI.createImage(atlas, "bg");
    group.addActor(bg);
    bg.setHeight(bg.getHeight()*Config.ratioY);
    bgImgs.add(bg);
  }

  private void moveBg(int id, Image bg){
    switch (id){
      case 1:{
        Vector2 vt1 = new Vector2(0, -2*(Config.HeightScreen-1));
        Vector2 vt2 = new Vector2(0, -1*(Config.HeightScreen-1));
        float dua = Config.module(vt1, vt2)/Config.velocity;

        bg.setY(-2*(Config.HeightScreen-1));
        bg.addAction(Actions.sequence(

          Actions.moveTo(0, -1*(Config.HeightScreen-1), dua, Interpolation.linear),
          GSimpleAction.simpleAction((d ,a)->{
            moveBg(2, bg);
            return true;
          })
        ));
        break;
      }
      case 2:{
        Vector2 vt1 = new Vector2(0, -1*(Config.HeightScreen-1));
        Vector2 vt2 = new Vector2(0, 0);
        float dua = Config.module(vt1, vt2)/Config.velocity;

        bg.addAction(Actions.sequence(
          Actions.moveTo(0, 0, dua, Interpolation.linear),
          GSimpleAction.simpleAction((d ,a)->{
            moveBg(3, bg);
            return true;
          })
        ));
        break;
      }
      case 3:{
        Vector2 vt1 = new Vector2(0, 0);
        Vector2 vt2 = new Vector2(0, 1*(Config.HeightScreen-1));
        float dua = Config.module(vt1, vt2)/Config.velocity;

        bg.addAction(Actions.sequence(
          Actions.moveTo(0, 1*(Config.HeightScreen-1), dua, Interpolation.linear),
          GSimpleAction.simpleAction((d ,a)->{
            moveBg(1, bg);
            return true;
          })
        ));
        break;
      }
      default: break;
    }
  }

  //start test
  private void scrollStart(){
    moveBg(1, bgImgs.get(0));
    moveBg(2, bgImgs.get(1));
    moveBg(3, bgImgs.get(2));
  }
  // end test

  public void setPause(boolean isPause){
    group.setPause(isPause);
  }

}
