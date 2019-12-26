package com.ss.gameLogic.objects;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;
import com.ss.GMain;
import com.ss.core.util.GLayerGroup;
import com.ss.gameLogic.animation;

public class Ball {
  private GLayerGroup groupF, group;
  private animation aniBr, aniR;
  private float w, h, x, y;

  public Ball(GLayerGroup groupF){
    this.groupF = groupF;
    w = GMain.platform.GetConfigIntValue("widthBall", 70);
    h = GMain.platform.GetConfigIntValue("heightBall", 70);
    initGroup();
    initAni();
  }

  private void initGroup(){
    group = new GLayerGroup();
    groupF.addActor(group);
  }

  private void initAni(){
    group.setSize(90, 90);
    aniR = new animation(group.getWidth()/2, group.getHeight()/2, "aniRock", 3, 1, 0.1f, false, true);
    aniBr = new animation(group.getWidth()/2, group.getHeight()/2, "aniBroken", 4, 1, 0.1f, false, false);
    group.addActor(aniR);
    group.addActor(aniBr);
    aniBr.setVisible(false);
    //aniBr = new animation(Config.WidthScreen/2, Config.HeightScreen/2, "aniBroken", 4, 1, 0.1f, false, true);
  }

  public void setPosition(float x, float y){
    group.setPosition(x, y, Align.center);
  }

  public void move(float x, float y){
    group.addAction(Actions.moveTo(x - group.getWidth()/2, y - group.getHeight()/2, 0.05f, Interpolation.linear));
  }

  public void overlap(){
    aniR.setVisible(false);
    aniBr.setVisible(true);

  }

  public Vector2 getWH(){
    return new Vector2(w, h);
  }

  public Vector2 getXY(){
    x = group.getX() + group.getWidth()/2;
    y = group.getY() + group.getHeight()/2;
    return new Vector2(x, y);
  }

  public void setPause(boolean isPause){
    groupF.setPause(isPause);
  }

  public void reset(){
    aniBr.setVisible(false);
    aniR.setVisible(true);
    setPause(false);
  }
}
