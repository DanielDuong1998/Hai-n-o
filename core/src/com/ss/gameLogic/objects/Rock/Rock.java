package com.ss.gameLogic.objects.Rock;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.ss.core.action.exAction.GSimpleAction;
import com.ss.core.util.GLayerGroup;
import com.ss.core.util.GUI;
import com.ss.gameLogic.StaticObjects.Config;
import com.ss.gameLogic.objects.Ball;
import com.ss.scenes.PlayScene;

import static com.badlogic.gdx.math.Interpolation.*;

public class Rock extends Actor {
  protected String info;
  protected TextureAtlas atlas;
  protected GLayerGroup group;
  protected Image shape;
  public boolean isAvai = true;
  protected PlayScene game;
  private boolean isNext = false;
  protected Ball ball;


  public Rock(){
    info = "rock";
  }
  public void info(){
    System.out.println(info);
  }

  protected void init(){
    initShape();
  }

  protected void initShape(){
    shape = GUI.createImage(atlas, info);
    group.addActor(shape);
  }

  public void setPosition1(float x, float y){
    shape.setPosition(x, y, Align.center);
  }

  public void moveRock(Ball ball){
    this.ball = ball;
    shape.setVisible(true);
    Vector2 vt1 = new Vector2(shape.getX(), shape.getY());
    Vector2 vt2 = new Vector2(shape.getX(), Config.HeightScreen + shape.getHeight());
    float dua = Config.module(vt1, vt2)/Config.velocity;
    shape.addAction(Actions.sequence(
      Actions.parallel(
        Actions.moveTo(shape.getX(), Config.HeightScreen + shape.getHeight(), dua,linear),
        GSimpleAction.simpleAction((d, a)->{
          if(isNext){
            if(shape.getY() >= 0){
              game.lvtest.startLv();
              isNext = false;
            }
          }
          else{
            if(checkOverlap(new Vector2(shape.getWidth(), shape.getHeight()), ball.getWH(), new Vector2(shape.getX(), shape.getY()),ball.getXY())){
              System.out.println("overlap!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
              ball.overlap();
              ball.setPause(true);
              group.setPause(true);
            }
          }
            return true;
        })
      ),
      GSimpleAction.simpleAction((d, a)->{
        reset();
        return true;
      })
    ));
  }

  @Override
  public void act(float delta) {
    super.act(delta);
  }

  public void activeNext(){
    isNext = true;
  }

  protected void reset(){
    isNext = false;
    shape.setVisible(false);
  }

  public float getWidthS(){
    return shape.getWidth();
  }

  public float getHeightS(){
    return shape.getHeight();
  }

  private boolean checkOverlap(Vector2 whBigRock, Vector2 whSmallRock, Vector2 pB, Vector2 pSm){
    if(isPointOfRect(new Vector2(pSm.x - whSmallRock.x/2, pSm.y - whSmallRock.y/2), whBigRock, pB) ||
      isPointOfRect(new Vector2(pSm.x + whSmallRock.x/2, pSm.y - whSmallRock.y/2), whBigRock, pB) ||
      isPointOfRect(new Vector2(pSm.x + whSmallRock.x/2, pSm.y + whSmallRock.y/2), whBigRock, pB) ||
      isPointOfRect(new Vector2(pSm.x - whSmallRock.x/2, pSm.y + whSmallRock.y/2), whBigRock, pB))
      return true;
    return false;
  }

  private boolean isPointOfRect(Vector2 p, Vector2 whRect, Vector2 pRect) {
    System.out.println("--------------------------------------------------------------------------");
    System.out.println("px -- (pRectx - whRect.x/2): " + p.x + "-" + (pRect.x - whRect.x / 2));
    System.out.println("px -- (pRect.x + whRect.x/2): " + p.x + "-" + (pRect.x + whRect.x / 2));
    System.out.println("py -- (pRect.y - whRect.y/2): " + p.y + "-" + (pRect.y - whRect.y / 2));
    System.out.println("py -- (pRect.y + whRect.y/2): " + p.y + "-" + (pRect.y + whRect.y / 2));
    if (p.x >= pRect.x - whRect.x / 2 && p.x <= pRect.x + whRect.x / 2 && p.y >= pRect.y - whRect.y / 2 && p.y <= pRect.y + whRect.y / 2){
      System.out.println("true");
      return true;
    }
    System.out.println("false");
    return false;
  }
}
