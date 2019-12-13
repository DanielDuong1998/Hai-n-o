package com.ss.gameLogic.objects.Thumb;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.ss.commons.Tweens;
import com.ss.core.util.GLayerGroup;
import com.ss.effects.SoundEffect;
import com.ss.gameLogic.StaticObjects.Config;
import com.ss.gameLogic.objects.Ball;

public class RightThumb extends Thumb {
  public RightThumb(TextureAtlas atlas, GLayerGroup groupF, Ball ball){
    this.key = "right";
    this.atlas = atlas;
    this.groupF = groupF;
    this.ball = ball;
    initGroup();
    initShape();
    setPositionGroup();
    addTouchGroup();
    this.ball.setPosition(Config.POSSITION_ROCK_X[2], Config.HeightScreen/2 + Config.HeightScreen/20);
  }

  private void setPositionGroup(){
    group.setPosition(Config.WidthScreen*3/4, Config.HeightScreen - group.getHeight()/2, Align.center);
  }

  @Override
  protected void addTouchGroup() {
    super.addTouchGroup();
    group.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        SoundEffect.Play(SoundEffect.slideBall);
        shapeUp.setVisible(false);
        shapeDown.setVisible(true);
        ball.move(Config.POSSITION_ROCK_X[3], Config.HeightScreen/2 + Config.HeightScreen/20);
        return super.touchDown(event, x, y, pointer, button);
      }

      @Override
      public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        super.touchUp(event, x, y, pointer, button);
        shapeDown.setVisible(false);
        shapeUp.setVisible(true);
        ball.move(Config.POSSITION_ROCK_X[2], Config.HeightScreen/2 + Config.HeightScreen/20);
        //Tweens.setTimeout(group, 0.1f, ()->{ball.Overlap();});
      }
    });
  }
}
