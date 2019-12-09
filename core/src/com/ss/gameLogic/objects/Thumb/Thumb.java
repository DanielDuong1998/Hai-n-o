package com.ss.gameLogic.objects.Thumb;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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
    group.debug();
  }

  protected void initShape(){
    shapeDown = GUI.createImage(atlas, key + "D");
    shapeUp = GUI.createImage(atlas, key + "U");
    group.addActor(shapeDown);
    shapeDown.setPosition(0,shapeUp.getHeight() - shapeDown.getHeight());
    System.out.println("y: " + (shapeUp.getHeight() - shapeDown.getHeight()));
    group.addActor(shapeUp);
    shapeDown.setVisible(false);
    group.setSize(shapeDown.getWidth(), shapeDown.getHeight());
  }

  protected void addTouchGroup(){

  }


}
