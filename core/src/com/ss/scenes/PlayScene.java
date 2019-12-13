package com.ss.scenes;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.ss.commons.Tweens;
import com.ss.core.action.exAction.GSimpleAction;
import com.ss.core.exSprite.GShapeSprite;
import com.ss.core.util.GAssetsManager;
import com.ss.core.util.GLayer;
import com.ss.core.util.GLayerGroup;
import com.ss.core.util.GScreen;
import com.ss.core.util.GStage;
import com.ss.core.util.GUI;
import com.ss.effects.SoundEffect;
import com.ss.gameLogic.Background;
import com.ss.gameLogic.Level.Level;
import com.ss.gameLogic.Level.Level1;
import com.ss.gameLogic.Level.Level2;
import com.ss.gameLogic.Level.Level3;
import com.ss.gameLogic.PanelEndGame;
import com.ss.gameLogic.StaticObjects.Config;
import com.ss.gameLogic.objects.Ball;
import com.ss.gameLogic.objects.ManageRocks;
import com.ss.gameLogic.objects.Thumb.LeftThumb;
import com.ss.gameLogic.objects.Thumb.RightThumb;
import com.ss.gameLogic.objects.Thumb.Thumb;

public class PlayScene extends GScreen {
  private TextureAtlas atlas;
  private GLayerGroup mainGroup, pauseGroup, endGameGroup;
  private GLayerGroup foreGroundGroup, groupF;
  private Background background;
  private float accum = 0;
  public Ball balll;
  public Ball ballr;
  private Thumb thumbl;
  private Thumb thumbr;
  private ManageRocks manageRocks;
  public Level lvtest;

  private Image pauseBtn, continueBtn, quitBtn;
  private Array<Image> txtCountDown;
  private GShapeSprite blackOverlay;
  private PanelEndGame panelEndGame;
  int tick = 0;
  public int score = 0;

  private BitmapFont font;
  private Label labelScore;


  @Override
  public void dispose() {

  }



  @Override
  public void init() {
    SoundEffect.Playmusic(1);
    initAtlas();
    initGroup();
    initBackground();
    initUI();
    initDarkScreen();
    initCountDownTxt();
    initBitmapfont();

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
    mainGroup = new GLayerGroup(){
      @Override
      public void act(float var1) {
      super.act(var1);
        if(labelScore != null){
          labelScore.setText(score + "%");
        }
      }
    };
    pauseGroup = new GLayerGroup();
    endGameGroup = new GLayerGroup();
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
    GStage.addToLayer(GLayer.ui, pauseGroup);
    GStage.addToLayer(GLayer.ui, endGameGroup);
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


  private void initBackground(){
    background = new Background(atlas, foreGroundGroup);
  }

  private void initUI(){
    panelEndGame = new PanelEndGame(atlas, endGameGroup, this);

    pauseBtn = GUI.createImage(atlas, "pauseBtn");
    continueBtn = GUI.createImage(atlas, "continueBtn");
    quitBtn = GUI.createImage(atlas, "quitBtn");
    pauseGroup.addActor(pauseBtn);
    pauseGroup.addActor(continueBtn);
    pauseGroup.addActor(quitBtn);
    pauseBtn.setPosition(Config.WidthScreen/8, Config.HeightScreen/20, Align.center);
    continueBtn.setPosition(Config.WidthScreen/2, Config.HeightScreen/2 - continueBtn.getHeight(), Align.center);
    quitBtn.setPosition(Config.WidthScreen/2, Config.HeightScreen/2 + continueBtn.getHeight(), Align.center);
    pauseBtn.setOrigin(Align.center);
    continueBtn.setOrigin(Align.center);
    quitBtn.setOrigin(Align.center);

    continueBtn.setVisible(false);
    quitBtn.setVisible(false);
    addEventPauseBtn();
    addEventContinueBtn();
    addEventQuitBtn();
  }

  private void addEventPauseBtn(){
    pauseBtn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
      pauseBtn.setTouchable(Touchable.disabled);
      SoundEffect.Play(SoundEffect.click);
      clickBtnEffect(pauseBtn, ()->{
        continueBtn.setTouchable(Touchable.enabled);
        continueBtn.setVisible(true);
        quitBtn.setVisible(true);
        mainGroup.setPause(true);
        setColorDarkScreen(true, 0.8f);
      });
      return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void addEventContinueBtn(){
    continueBtn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        continueBtn.setTouchable(Touchable.disabled);
        SoundEffect.Play(SoundEffect.click);
        clickBtnEffect(continueBtn, ()->{
          continueBtn.setVisible(false);
          quitBtn.setVisible(false);
          countDown();
          Tweens.setTimeout(pauseGroup, 3f, ()->{
            pauseBtn.setTouchable(Touchable.enabled);
            setColorDarkScreen(false, 0);
            mainGroup.setPause(false);
          });
        });
        return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void addEventQuitBtn(){
    quitBtn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
      quitBtn.setTouchable(Touchable.disabled);
      SoundEffect.Play(SoundEffect.click);
      clickBtnEffect(quitBtn, ()->{
        setScreen(new StartScene());
      });
      return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void clickBtnEffect(Image btn, Runnable runnable){
    btn.addAction(Actions.sequence(
      Actions.scaleBy(-0.3f, -0.3f, 0.05f, Interpolation.swingIn),
      Actions.scaleBy(0.3f, 0.3f, 0.05f, Interpolation.swingOut),
      Actions.run(runnable)
    ));
  }

  private void initCountDownTxt(){
    txtCountDown = new Array<>();
    Image readyTxt = GUI.createImage(atlas, "readyTxt");
    Image one = GUI.createImage(atlas, "1");
    Image two = GUI.createImage(atlas, "2");
    Image three = GUI.createImage(atlas, "3");
    txtCountDown.add(readyTxt, one, two, three);
    pauseGroup.addActor(readyTxt);
    pauseGroup.addActor(one);
    pauseGroup.addActor(two);
    pauseGroup.addActor(three);
    for(int i = 0; i < txtCountDown.size; i++){
      txtCountDown.get(i).setOrigin(Align.center);
    }
    readyTxt.setPosition(Config.WidthScreen/2, Config.HeightScreen/3, Align.center);
    one.setPosition(Config.WidthScreen/2, Config.HeightScreen/2, Align.center);
    two.setPosition(Config.WidthScreen/2, Config.HeightScreen/2, Align.center);
    three.setPosition(Config.WidthScreen/2, Config.HeightScreen/2, Align.center);
    readyTxt.setVisible(false);
    one.setVisible(false);
    two.setVisible(false);
    three.setVisible(false);
  }

  private void initBitmapfont(){
    font = GAssetsManager.getBitmapFont("font_white.fnt");
    labelScore = new Label("" + 0, new Label.LabelStyle(font, null));
    labelScore.setPosition(Config.WidthScreen/2, Config.HeightScreen/2, Align.center);
    mainGroup.addActor(labelScore);
  }

  private void pauseBtnClick(){

  }

  private void countDown(){
    txtCountDown.get(0).setVisible(true);
    showTxt(1);
  }

  private void showTxt(int index){
    if(index == txtCountDown.size){
      txtCountDown.get(0).setVisible(false);
      return;
    }
    else{
      txtCountDown.get(index).setVisible(true);
      txtCountDown.get(index).setScale(0.3f);
      final int indexTemp = index + 1;
      txtCountDown.get(index).addAction(Actions.sequence(
        Actions.scaleTo(1, 1, 0.8f, Interpolation.swingIn),
        GSimpleAction.simpleAction((d, a)->{
          SoundEffect.Play(SoundEffect.tick);
          return true;
        }),
        Actions.delay(0.2f),
        GSimpleAction.simpleAction((d, a)->{
          txtCountDown.get(index).setVisible(false);
          showTxt(indexTemp);
          return true;
        })
      ));
    }
  }

  private void initDarkScreen(){
    blackOverlay = new GShapeSprite();
    blackOverlay.createRectangle(true, -GStage.getWorldWidth()/2,-GStage.getWorldHeight()/2, GStage.getWorldWidth()*2, GStage.getWorldHeight()*2);
    mainGroup.addActor(blackOverlay);
    blackOverlay.setVisible(false);
  }


  private void setColorDarkScreen(boolean isVisible, float blur){
    blackOverlay.setVisible(isVisible);
    blackOverlay.setColor(0, 0, 0, blur);
  }

  @Override
  public void run() {

  }

  public void menu(){
    setScreen(new ChooseScene());
  }

  public void lobby(){
    setScreen(new StartScene());
  }


  public void endGame(){
    Tweens.setTimeout(endGameGroup, 0.5f, ()->{
      SoundEffect.Play(SoundEffect.lose);
      panelEndGame.setVisibleGroup(true);
    });
  }

  public void replay(){
    setScreen(new PlayScene());
//    panelEndGame.setVisibleGroup(false);
//    background.reset();
//    manageRocks.reset();
//    balll.reset();
//    ballr.reset();
//    foreGroundGroup.setPause(false);
//    lvtest.reset();
  }
}
