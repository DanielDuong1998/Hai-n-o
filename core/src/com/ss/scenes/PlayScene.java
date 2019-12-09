package com.ss.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.ss.core.util.GAssetsManager;
import com.ss.core.util.GLayer;
import com.ss.core.util.GLayerGroup;
import com.ss.core.util.GScreen;
import com.ss.core.util.GStage;
import com.ss.gameLogic.Background;
import com.ss.gameLogic.Level.Level;
import com.ss.gameLogic.Level.Level1;
import com.ss.gameLogic.Level.Level2;
import com.ss.gameLogic.Level.Level3;
import com.ss.gameLogic.StaticObjects.Config;
import com.ss.gameLogic.objects.Ball;
import com.ss.gameLogic.objects.ManageRocks;
import com.ss.gameLogic.objects.Thumb.LeftThumb;
import com.ss.gameLogic.objects.Thumb.RightThumb;
import com.ss.gameLogic.objects.Thumb.Thumb;

public class PlayScene extends GScreen {
  private TextureAtlas atlas;
  private GLayerGroup mainGroup;
  private GLayerGroup foreGroundGroup, groupF;
  private Background background;
  private float accum = 0;
  public Ball balll;
  public Ball ballr;
  private Thumb thumbl;
  private Thumb thumbr;
  private ManageRocks manageRocks;
  public Level lvtest;

  @Override
  public void dispose() {
    foreGroundGroup.remove();
    foreGroundGroup.clear();
    groupF.remove();
    groupF.clear();
    mainGroup.remove();
    mainGroup.clear();
    atlas.dispose();
  }

  @Override
  public void init() {
    initAtlas();
    initGroup();
    initBackground();

    balll = new Ball(groupF);
    ballr = new Ball(groupF);

    thumbl = new LeftThumb(atlas, groupF, balll);
    thumbr = new RightThumb(atlas, groupF, ballr);
    startGame();



  }

  private void initAtlas(){
    atlas = GAssetsManager.getTextureAtlas("GameAtlas.atlas");
  }

  private void initGroup(){
    mainGroup = new GLayerGroup();
    foreGroundGroup = new GLayerGroup(){
      @Override
      public void act(float var1) {
        if(Config.scaleTime[0] != 0){
          accum += var1;
        }
        if (accum < Config.scaleTime[0]) {
          super.act(var1*Config.scaleTime[1]);
        }
        else {
          super.act(var1);
          accum = 0;
          //Config.scaleTime[0] = 0;
          //Config.scaleTime[1] = 2;
        }
      }
    };
    groupF = new GLayerGroup();
    mainGroup.addActor(foreGroundGroup);
    mainGroup.addActor(groupF);
    GStage.addToLayer(GLayer.ui, mainGroup);
  }

  //start test
  private void startGame(){
    boolean isPause = false;
    manageRocks = new ManageRocks(atlas, foreGroundGroup, balll, ballr, this);

    switch (Config.modeSelecting){
      case 1: {
        lvtest = new Level1(manageRocks);
        break;
      }
      case 2: {
        lvtest = new Level2(manageRocks);
        break;
      }
      case 3: {
        lvtest = new Level3(manageRocks);
        break;
      }
    }
  }
  //end test
  public float setTimeScale(float dt){
    //// dt lon hon 0
    return Gdx.graphics.getDeltaTime()*dt;
  }

  private void initBackground(){
    background = new Background(atlas, foreGroundGroup);
  }



  @Override
  public void run() {

  }
}
