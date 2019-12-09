package com.ss.gameLogic.objects.Thumb;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.ss.commons.Tweens;
import com.ss.core.util.GLayerGroup;
import com.ss.gameLogic.StaticObjects.Config;
import com.ss.gameLogic.objects.Ball;

public class LeftThumb extends Thumb {
  public LeftThumb(TextureAtlas atlas, GLayerGroup groupF, Ball ball){
    this.key = "left";
    this.atlas = atlas;
    this.groupF = groupF;
    this.ball = ball;
    initGroup();
    initShape();
    setPositionGroup();
    addTouchGroup();
    this.ball.setPosition(Config.POSSITION_ROCK_X[1], Config.HeightScreen/2);

  }

  private void setPositionGroup(){
    group.setPosition(Config.WidthScreen/2 - (group.getWidth()/2 + 10), Config.HeightScreen - group.getHeight()/2, Align.center);
  }

  @Override
  protected void addTouchGroup() {
    super.addTouchGroup();
    group.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        shapeUp.setVisible(false);
        shapeDown.setVisible(true);
        ball.move(Config.POSSITION_ROCK_X[0], Config.HeightScreen/2);
        return super.touchDown(event, x, y, pointer, button);
      }

      @Override
      public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        super.touchUp(event, x, y, pointer, button);
        shapeDown.setVisible(false);
        shapeUp.setVisible(true);
        ball.move(Config.POSSITION_ROCK_X[1], Config.HeightScreen/2);
      }
    });
  }
}
