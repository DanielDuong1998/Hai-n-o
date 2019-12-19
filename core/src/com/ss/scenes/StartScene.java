package com.ss.scenes;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.ss.GMain;
import com.ss.commons.Tweens;
import com.ss.core.exSprite.GShapeSprite;
import com.ss.core.util.GAssetsManager;
import com.ss.core.util.GLayer;
import com.ss.core.util.GScreen;
import com.ss.core.util.GStage;
import com.ss.core.util.GUI;
import com.ss.effects.SoundEffect;
import com.ss.gameLogic.StaticObjects.Config;

public class StartScene extends GScreen {
  private TextureAtlas atlas;
  private Group group;
  private Image bg, startBtn;

  @Override
  public void dispose() {

  }

  @Override
  public void init() {
    SoundEffect.Playmusic(2);
    getPrefs();
    initAtlas();
    initGroup();
    initUI();
  }

  private void getPrefs(){
    Config.bestScoreInf = GMain.prefs.getInteger("BestScoreInf", 0);
    Config.bestScoreLv1 = GMain.prefs.getInteger("BestScoreLv1",0);
    Config.bestScoreLv2 = GMain.prefs.getInteger("BestScoreLv2",0);
    Config.bestScoreLv3 = GMain.prefs.getInteger("BestScoreLv3",0);
  }

  private void initAtlas(){
    atlas = GAssetsManager.getTextureAtlas("StartScene.atlas");
  }

  private void initGroup(){
    group = new Group();
    GStage.addToLayer(GLayer.ui, group);
  }

  private void initUI(){
    bg = GUI.createImage(atlas, "bg");
    startBtn = GUI.createImage(atlas, "startBtn");
    bg.setHeight(bg.getHeight()*Config.ratioY);
    group.addActor(bg);
    group.addActor(startBtn);
    startBtn.setPosition(Config.WidthScreen/2, 2*Config.HeightScreen/3, Align.center);
    startBtn.setOrigin(Align.center);
    addEventStartBtn();
  }


  private void addEventStartBtn(){
    startBtn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
      startBtn.setTouchable(Touchable.disabled);
      SoundEffect.Play(SoundEffect.click);
      startBtn.addAction(Actions.sequence(
        Actions.scaleBy(-0.3f, -0.3f, 0.05f, Interpolation.swingIn),
        Actions.scaleBy(0.3f, 0.3f, 0.05f, Interpolation.sineOut)
      ));
      Tweens.setTimeout(group, 0.1f, ()->{
        nextScene();
      });
      return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void darkScreen(){
    final GShapeSprite blackOverlay = new GShapeSprite();
    blackOverlay.createRectangle(true, -GStage.getWorldWidth()/2,-GStage.getWorldHeight()/2, GStage.getWorldWidth()*2, GStage.getWorldHeight()*2);
    group.addActor(blackOverlay);
    blackOverlay.setColor(0,0,0,1f);
  }

  private void nextScene(){
    //darkScreen();
    setScreen(new ModeScene());
  }


  @Override
  public void run() {
  }
}
