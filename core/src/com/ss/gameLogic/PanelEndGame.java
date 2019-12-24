package com.ss.gameLogic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.ss.GMain;
import com.ss.core.action.exAction.GSimpleAction;
import com.ss.core.exSprite.GShapeSprite;
import com.ss.core.util.GLayerGroup;
import com.ss.core.util.GStage;
import com.ss.core.util.GUI;
import com.ss.effects.SoundEffect;
import com.ss.gameLogic.StaticObjects.Config;
import com.ss.scenes.PlayScene;

public class PanelEndGame {
  private TextureAtlas atlas;
  private GLayerGroup group;
  private Image bg, replayBtn, lobbyBtn, continueBtn, banner, title;
  private PlayScene game;
  private int score, bestScore;
  private Label scoreTxt, bestScoreTxt;
  private Image newRecord, frameAds, btnYes, btnNo;

  public PanelEndGame(TextureAtlas atlas, GLayerGroup group, PlayScene game, int score){
    this.atlas = atlas;
    this.group = group;
    this.game = game;
    this.score = score;
    initUI();
    setVisibleGroup(false);
  }

  private void updateBestScore(){
    switch (Config.modeSelecting){
      case 0: {
        if(score > Config.bestScoreInf){
          Config.bestScoreInf = score;
          GMain.prefs.putInteger("BestScoreInf", score);
          GMain.prefs.flush();
          newRecord.setVisible(true);
        }
        break;
      }
      case 1: {
        System.out.println("Score-BestScore1: " + score + "-" + Config.bestScoreLv1);
        if(score > Config.bestScoreLv1){
          Config.bestScoreLv1 = score;
          GMain.prefs.putInteger("BestScoreLv1", score);
          GMain.prefs.flush();
          System.out.println("Best score lv1");
          newRecord.setVisible(true);

        }
        break;
      }
      case 2: {
        if(score > Config.bestScoreLv2){
          Config.bestScoreLv2 = score;
          GMain.prefs.putInteger("BestScoreLv2", score);
          GMain.prefs.flush();
          System.out.println("Best score lv2");
          newRecord.setVisible(true);

        }
        break;
      }
      case 3: {
        if(score > Config.bestScoreLv3){
          Config.bestScoreLv3 = score;
          GMain.prefs.putInteger("BestScoreLv3", score);
          GMain.prefs.flush();
          System.out.println("Best score lv3");
          newRecord.setVisible(true);
        }
        break;
      }
      default: {
        break;
      }
    }
  }

  private void initUI(){
    bg = GUI.createImage(atlas, "bgEndGame");
    replayBtn = GUI.createImage(atlas, "replayBtn");
    lobbyBtn = GUI.createImage(atlas, "lobbyBtn");
    continueBtn = GUI.createImage(atlas, "continueVBtn");
    banner = GUI.createImage(atlas, "bannerEndGame");
    title = GUI.createImage(atlas, "reportTxt");
    newRecord = GUI.createImage(atlas, "newRecord");

    group.addActor(bg);
    group.addActor(replayBtn);
    group.addActor(lobbyBtn);
    group.addActor(continueBtn);
    group.addActor(banner);
    group.addActor(title);
    group.addActor(newRecord);

    newRecord.setPosition(Config.WidthScreen*1.1f/2, Config.HeightScreen/3, Align.center);
    newRecord.setVisible(false);
    bg.setHeight(bg.getHeight()*Config.ratioY);

    replayBtn.setOrigin(Align.center);
    lobbyBtn.setOrigin(Align.center);
    continueBtn.setOrigin(Align.center);
    replayBtn.setPosition(Config.WidthScreen/2, Config.HeightScreen/2, Align.center);
    float x = Config.WidthScreen/2 - replayBtn.getWidth()/2 - lobbyBtn.getWidth()/2 - 10;
    float y = Config.HeightScreen/2 + replayBtn.getHeight()/2 - lobbyBtn.getHeight()/2;
    lobbyBtn.setPosition(x, y, Align.center);
    continueBtn.setPosition(Config.WidthScreen/2, lobbyBtn.getY() + lobbyBtn.getHeight()*2f, Align.center);

    title.setPosition(Config.WidthScreen/2, Config.HeightScreen*2/10, Align.center);
    banner.setPosition(Config.WidthScreen/2, Config.HeightScreen*3.5f/10, Align.center);

    addEventReplay();
    addEventLobby();
    addEventContinue();

    scoreTxt = new Label(""+score, new Label.LabelStyle(game.getFont(), null));
    group.addActor(scoreTxt);
    scoreTxt.setFontScale(1.5f);
    scoreTxt.setPosition(Config.WidthScreen/3, Config.HeightScreen*3.53f/10, Align.center);

    bestScoreTxt = new Label(""+bestScore, new Label.LabelStyle(game.getFont(), null));
    bestScoreTxt.setFontScale(0.8f);
    group.addActor(bestScoreTxt);
    bestScoreTxt.setPosition(Config.WidthScreen*6.8f/8, Config.HeightScreen*3.65f/10, Align.center);
  }

  private void chooseBestScore(){
    switch (Config.modeSelecting){
      case 0: {
        bestScore = Config.bestScoreInf;
        break;
      }
      case 1: {
        bestScore = Config.bestScoreLv1;
        break;
      }
      case 2: {
        bestScore = Config.bestScoreLv2;
        break;
      }
      case 3: {
        bestScore = Config.bestScoreLv3;
        break;
      }
      default: {
        break;
      }
    }
  }

  private void addEventReplay(){
    replayBtn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
      setTouchBtn(Touchable.disabled);
      SoundEffect.Play(SoundEffect.click);
      SoundEffect.Stopmusic(2);
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
      SoundEffect.Stopmusic(2);
      clickBtnEffect(lobbyBtn, ()->{
        Config.scaleTime[0] = 1000;
        Config.scaleTime[1] = 1;
        SoundEffect.Playmusic(2);
        Config.showHelpStart = true;
        game.menu();
      });
      return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void addEventContinue(){
    continueBtn.addListener(new ClickListener(){
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
      setTouchBtn(Touchable.disabled);
      SoundEffect.Play(SoundEffect.click);
      SoundEffect.Stopmusic(2);
      clickBtnEffect(continueBtn, ()->{
        continueBtnClicked();
      });
      return super.touchDown(event, x, y, pointer, button);
      }
    });
  }

  private void continueBtnClicked(){
    Group groupDark = new Group();
    group.addActor(groupDark);
    GShapeSprite blackOverlay = new GShapeSprite();
    blackOverlay.createRectangle(true, -GStage.getWorldWidth()/2,-GStage.getWorldHeight()/2, GStage.getWorldWidth()*2, GStage.getWorldHeight()*2);
    groupDark.addActor(blackOverlay);
    blackOverlay.setColor(0, 0, 0, 0.4f);
    Image frm = GUI.createImage(atlas, "frmAds");
    Image btnYes = GUI.createImage(atlas, "btnYes");
    Image btnNo = GUI.createImage(atlas, "btnNo");
    groupDark.addActor(frm);
    groupDark.addActor(btnYes);

    btnYes.setOrigin(Align.center);
    btnNo.setOrigin(Align.center);

    frm.setPosition(Config.WidthScreen/2, Config.HeightScreen/2, Align.center);
    btnYes.setPosition(frm.getX() + frm.getWidth()*1.5f/5, frm.getY() + frm.getHeight()*3.5f/5, Align.center);
    btnNo.setPosition(frm.getX() + frm.getWidth()*3.5f/5, frm.getY() + frm.getHeight()*3.5f/5, Align.center);
    eventBtnYes(btnYes, groupDark);
    eventBtnNo(btnNo, groupDark);

//    Config.countAd++;
//    game.coninue();
  }

  private void eventBtnYes(Image img, Group group){

  }

  private void eventBtnNo(Image img, Group group){

  }

  private void setTouchBtn(Touchable touchable){
    replayBtn.setTouchable(touchable);
    lobbyBtn.setTouchable(touchable);
    continueBtn.setTouchable(touchable);
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

  public void setScore(int score){
    if(score >= 90 || Config.countAd == Config.numberAd){
      System.out.println("countAd: " + Config.countAd);
      Config.countAd = 0;
      continueBtn.setVisible(false);
    }

    String cha = Config.modeSelecting == 0 ? "m" : "%";
    this.score = score;
    scoreTxt.setText(this.score + cha);
    updateBestScore();
    chooseBestScore();
    this.bestScoreTxt.setText(this.bestScore+cha);
  }

  void showAds(Image btn, Group group, int index){
    if(GMain.platform.isVideoRewardReady()) {
      GMain.platform.ShowVideoReward((boolean success) -> {
        if (success) {
          //Unlock(index);
          group.clear();
          group.remove();
        }else {
          btn.setTouchable(Touchable.enabled);
        }
      });
    }else {
      Label notice = new Label("Kiểm tra kết nối",new Label.LabelStyle(game.getFont(), Color.RED));
      notice.setPosition(0,0,Align.center);
      group.addActor(notice);
      notice.addAction(Actions.sequence(
        Actions.moveBy(0,-50,0.5f),
        GSimpleAction.simpleAction((d, a)->{
          notice.clear();
          notice.remove();
          btn.setTouchable(Touchable.enabled);
          return true;
        })
      ));

    }
  }
}
