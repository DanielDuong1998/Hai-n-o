package com.ss.gameLogic.objects.Rock;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.ss.core.util.GLayerGroup;
import com.ss.gameLogic.StaticObjects.Config;
import com.ss.scenes.PlayScene;

public class Rock1 extends Rock {
  public Rock1(TextureAtlas atlas, GLayerGroup group, PlayScene game){
    info = "rock1";
    this.atlas = atlas;
    this.group = group;
    this.game = game;
    init();
    setPosition1(Config.POSSITION_ROCK_X[0],  Config.POSSITION_ROCK_Y[1]);
  }

  @Override
  protected void reset() {
    super.reset();
    setPosition1(Config.POSSITION_ROCK_X[0],  Config.POSSITION_ROCK_Y[1]);
    isAvai = true;
  }
}
