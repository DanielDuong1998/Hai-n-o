package com.ss.gameLogic.objects.Thumb;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.ss.core.util.GLayerGroup;
import com.ss.core.util.GUI;
import com.ss.gameLogic.objects.Ball;

public class Thumb {
  protected TextureAtlas atlas;
  protected GLayerGroup groupF, group;
  protected Image shapeDown, shapeUp;
  protected String key;
  protected Ball ball;


  protected void initGroup(){
    group = new GLayerGroup();
    groupF.addActor(group);
  }

  protected void initShape(){
    shapeDown = GUI.createImage(atlas, key + "D");
    shapeUp = GUI.createImage(atlas, key + "U");
    group.addActor(shapeDown);
    shapeUp.setPosition(shapeUp.getWidth()/2, shapeUp.getHeight()/2, Align.center);
    shapeDown.setPosition(shapeDown.getWidth()/2, shapeUp.getHeight() - shapeDown.getHeight()/2, Align.center);
    System.out.println("y: " + (shapeUp.getHeight() - shapeDown.getHeight()));
    group.addActor(shapeUp);
    shapeDown.setVisible(false);
    group.setSize(shapeDown.getWidth(), shapeDown.getHeight());
  }

  protected void addTouchGroup(){

  }


}
