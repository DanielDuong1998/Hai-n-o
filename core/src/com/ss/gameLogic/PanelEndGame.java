package com.ss.gameLogic;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.ss.core.util.GLayerGroup;
import com.ss.core.util.GUI;
import com.ss.effects.SoundEffect;
import com.ss.gameLogic.StaticObjects.Config;
import com.ss.scenes.PlayScene;

public class PanelEndGame {
  private TextureAtlas atlas;
  private GLayerGroup group;
  private Image bg, replayBtn, lobbyBtn;
  private PlayScene game;

  public PanelEndGame(TextureAtlas atlas, GLayerGroup group, PlayScene game){
    this.atlas = atlas;
    this.group = group;
    this.game = game;
    initUI();
    setVisibleGroup(false);
  }

  private void initUI(){
    bg = GUI.createImage(atlas, "bgEndGame");
    replayBtn = GUI.createImage(atlas, "replayBtn");
    lobbyBtn = GUI.createImage(atlas, "lobbyBtn");
    group.addActor(bg);
    group.addActor(replayBtn);
    group.addActor(lobbyBtn);
    bg.setHeight(bg.getHeight()*Config.ratioY);

    replayBtn.setOrigin(Align.center);
    lobbyBtn.setOrigin(Align.center);
    replayBtn.setPosition(Config.WidthScreen/2, Config.HeightScreen/2, Align.center);
    float x = Config.WidthScreen/2 - replayBtn.getWidth()/2 - lobbyBtn.getWidth()/2 - 10;
    float y = Config.HeightScreen/2 + replayBtn.getHeight()/2 - lobbyBtn.getHeight()/2;
    lobbyBtn.setPosition(x, y, Align.center);

    addEventReplay();
    addEventLobby();
  }

  private void addEventReplay(){
    replayBtn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
      setTouchBtn(Touchable.disabled);
      SoundEffect.Play(SoundEffect.click);
      clickBtnEffect(replayBtn, ()->{
        setTouchBtn(Touchable.enabled);
        Config.scaleTime[0] = 0;
        Config.scaleTime[1] = 4;
        game.replay();
      });
      return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void addEventLobby(){
    lobbyBtn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        setTouchBtn(Touchable.disabled);
        SoundEffect.Play(SoundEffect.click);
        clickBtnEffect(lobbyBtn, ()->{
          Config.scaleTime[0] = 0;
          Config.scaleTime[1] = 4;
          SoundEffect.Playmusic(2);
          game.menu();
        });
        return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void setTouchBtn(Touchable touchable){
    replayBtn.setTouchable(touchable);
    replayBtn.setTouchable(touchable);
  }

  public void setVisibleGroup(boolean isVisible){
    group.setVisible(isVisible);
  }

  private void clickBtnEffect(Image btn, Runnable runnable){
    btn.addAction(Actions.sequence(
      Actions.scaleBy(-0.3f, -0.3f, 0.1f, Interpolation.swingIn),
      Actions.scaleBy(0.3f, 0.3f, 0.1f, Interpolation.swingOut),
      Actions.run(runnable)
    ));
  }
}
