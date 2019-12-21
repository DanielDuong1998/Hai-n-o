package com.ss.scenes;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.ss.core.util.GAssetsManager;
import com.ss.core.util.GLayer;
import com.ss.core.util.GLayerGroup;
import com.ss.core.util.GScreen;
import com.ss.core.util.GStage;
import com.ss.core.util.GUI;
import com.ss.effects.SoundEffect;
import com.ss.gameLogic.StaticObjects.Config;

public class ModeScene extends GScreen {
  private TextureAtlas atlas;
  private GLayerGroup group;
  private Image bg, title, challengeBtn, infinityBtn, backBtn;

  @Override
  public void dispose() {

  }

  @Override
  public void init() {
    initAtlas();
    initGroup();
    initUI();
  }

  private void initAtlas(){
    atlas = GAssetsManager.getTextureAtlas("ModeScene.atlas");
  }

  private void initGroup(){
    group = new GLayerGroup();
    GStage.addToLayer(GLayer.ui, group);
  }

  private void initUI(){
    bg = GUI.createImage(atlas, "bg");
    title = GUI.createImage(atlas, "modeTitle");
    challengeBtn = GUI.createImage(atlas, "challengeBtn");
    infinityBtn = GUI.createImage(atlas, "infinityBtn");
    backBtn = GUI.createImage(atlas, "backBtn");

    bg.setHeight(bg.getHeight()*Config.ratioY);
    group.addActor(bg);
    group.addActor(title);
    group.addActor(challengeBtn);
    group.addActor(infinityBtn);
    group.addActor(backBtn);

    title.setPosition(Config.WidthScreen/2, Config.HeightScreen*1.5f/6, Align.center);
    challengeBtn.setPosition(Config.WidthScreen/2, Config.HeightScreen/2 - challengeBtn.getHeight()*0.5f, Align.center);
    infinityBtn.setPosition(Config.WidthScreen/2, Config.HeightScreen/2 + infinityBtn.getHeight()*1f, Align.center);
    backBtn.setPosition(Config.WidthScreen/2, Config.HeightScreen*5/6, Align.center);
    challengeBtn.setOrigin(Align.center);
    infinityBtn.setOrigin(Align.center);
    backBtn.setOrigin(Align.center);

    eventClickChallenge(challengeBtn);
    eventClickInfinity(infinityBtn);
    eventClickBack(backBtn);

  }

  private void eventClickChallenge(Image btn){
    btn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        btn.setTouchable(Touchable.disabled);
        SoundEffect.Play(SoundEffect.click);
        effectClickBtn(btn, ()->{
          setScreen(new ChooseScene());
        });
        return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void eventClickInfinity(Image btn){
    btn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        btn.setTouchable(Touchable.disabled);
        SoundEffect.Play(SoundEffect.click);
        effectClickBtn(btn, ()->{
          Config.modeSelecting = 0;
          SoundEffect.Stopmusic(2);
          setScreen(new PlayScene());
        });
        return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void eventClickBack(Image btn){
    btn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        backBtn.setTouchable(Touchable.disabled);
        SoundEffect.Play(SoundEffect.click);
        effectClickBtn(btn, ()->{
          setScreen(new StartScene());
        });
        return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void effectClickBtn(Image btn, Runnable runnable){
    btn.addAction(Actions.sequence(
      Actions.scaleBy(-0.7f, -0.7f, 0.05f, Interpolation.swingIn),
      Actions.scaleBy(0.7f, 0.7f, 0.05f, Interpolation.swingOut),
      Actions.run(runnable)
    ));
  }

  @Override
  public void run() {

  }
}
