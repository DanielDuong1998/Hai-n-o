package com.ss.scenes;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.ss.core.action.exAction.GSimpleAction;
import com.ss.core.util.GAssetsManager;
import com.ss.core.util.GLayer;
import com.ss.core.util.GScreen;
import com.ss.core.util.GStage;
import com.ss.core.util.GUI;
import com.ss.effects.SoundEffect;
import com.ss.gameLogic.StaticObjects.Config;

public class ChooseScene extends GScreen {
  private TextureAtlas atlas;
  private Group group;
  private Image bg;
  private Image easyBtn, medBtn, haBtn, backBtn;

  @Override
  public void dispose() {
//    group.remove();
//    group.clear();
//    atlas.dispose();
  }

  @Override
  public void init() {
    initAtlas();
    initGroup();
    initUI();
  }

  private void initAtlas(){
    atlas = GAssetsManager.getTextureAtlas("ChooseScene.atlas");
  }

  private void initGroup(){
    group = new Group();
    GStage.addToLayer(GLayer.ui, group);
  }

  private void initUI(){
    bg = GUI.createImage(atlas, "bg");
    bg.setHeight(bg.getHeight()* Config.ratioY);

    easyBtn = GUI.createImage(atlas, "easyBtn");
    medBtn = GUI.createImage(atlas, "mediumBtn");
    haBtn = GUI.createImage(atlas, "hardBtn");
    backBtn = GUI.createImage(atlas, "backBtn");

    group.addActor(bg);
    group.addActor(easyBtn);
    group.addActor(medBtn);
    group.addActor(haBtn);
    group.addActor(backBtn);

    easyBtn.setPosition(Config.WidthScreen/2, Config.HeightScreen/3, Align.center);
    easyBtn.setOrigin(Align.center);
    medBtn.setPosition(Config.WidthScreen/2, Config.HeightScreen/2, Align.center);
    medBtn.setOrigin(Align.center);
    haBtn.setPosition(Config.WidthScreen/2, 2*Config.HeightScreen/3, Align.center);
    haBtn.setOrigin(Align.center);
    backBtn.setPosition(Config.WidthScreen/2, 4*Config.HeightScreen/5, Align.center);
    backBtn.setOrigin(Align.center);
    addEventEasy();
    addEventMedium();
    addEventHard();
    addEventBack();
  }

  private void addEventEasy(){
    easyBtn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        setTouchBtn(Touchable.disabled);
        SoundEffect.Play(SoundEffect.click);
        Config.modeSelecting = 1;
        effectBtn(easyBtn);
        SoundEffect.Stopmusic(2);
        return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void addEventMedium(){
    medBtn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        setTouchBtn(Touchable.disabled);
        SoundEffect.Play(SoundEffect.click);
        Config.modeSelecting = 2;
        effectBtn(medBtn);
        SoundEffect.Stopmusic(2);
        return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void addEventHard(){
    haBtn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        setTouchBtn(Touchable.disabled);
        SoundEffect.Play(SoundEffect.click);
        Config.modeSelecting = 3;
        effectBtn(haBtn);
        SoundEffect.Stopmusic(2);
        return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void addEventBack(){
    backBtn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        setTouchBtn(Touchable.disabled);
        SoundEffect.Play(SoundEffect.click);
        backBtn.addAction(Actions.sequence(
          Actions.scaleBy(-0.3f, -0.3f, 0.05f, Interpolation.swingIn),
          Actions.scaleBy(0.3f, 0.3f, 0.05f, Interpolation.sineOut),
          GSimpleAction.simpleAction((d, a)->{
            setScreen(new ModeScene());
            return true;
          })
        ));
        return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void setTouchBtn(Touchable touchBtn){
    easyBtn.setTouchable(touchBtn);
    medBtn.setTouchable(touchBtn);
    haBtn.setTouchable(touchBtn);
    backBtn.setTouchable(touchBtn);
  }

  private void effectBtn(Image btn){
    btn.addAction(Actions.sequence(
      Actions.scaleBy(-0.3f, -0.3f, 0.05f, Interpolation.swingIn),
      Actions.scaleBy(0.3f, 0.3f, 0.05f, Interpolation.sineOut),
      GSimpleAction.simpleAction((d, a)->{
        setScreen(new PlayScene());
        return true;
      })
    ));
  }

  @Override
  public void run() {

  }
}
