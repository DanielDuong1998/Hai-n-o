package com.ss.gameLogic.StaticObjects;

import com.badlogic.gdx.math.Vector2;
import com.ss.core.util.GStage;

public class Config {
  //constant
  public static float ratioX = GStage.getWorldWidth()/720;
  public static float ratioY = GStage.getWorldHeight()/1280;
  public static float WidthScreen = GStage.getWorldWidth();
  public static float HeightScreen = GStage.getWorldHeight();
  //position
  public static float[] POSSITION_ROCK_Y = new float[]{-Config.HeightScreen*0.23f, -Config.HeightScreen*0.28f, -Config.HeightScreen*0.22f , -Config.HeightScreen*0.2f, -Config.HeightScreen/3};
  public static float[] POSSITION_ROCK_X = new float[]{Config.WidthScreen/8, 3*Config.WidthScreen/8, 5*Config.WidthScreen/8, 7*Config.WidthScreen/8};

  //can change
  public static float duaration = 5;
  public static float velocity = 500;
  public static float[] scaleTime = new float[]{1000, 1};
  public static int modeSelecting = 1; //1 -> easy, 2 -> medium, 3 -> hard, 0 -> infinity
  public static int bestScoreInf = 0;
  public static int bestScoreLv1 = 0;
  public static int bestScoreLv2 = 0;
  public static int bestScoreLv3 = 0;
  public static boolean showHelpStart = true;
  public static boolean isContinue = false;

  public static int scoreCtn = 0;
  public static float[] scaleTimeCtn = new float[]{0, 0};

  public static int numberAd = 1;
  public static int countAd = 0;
  public static int numberAdF = 4;
  public static int countAdF = 0;


  //method
  public static void reset(){
    duaration = 5;
  }

  public static void setDuaration(float dua){
    duaration = dua;
  }

  public static void setVelocity(float v){
    velocity = v;
  }

  public static float module(Vector2 p1, Vector2 p2){
    return (float) Math.sqrt((p2.x - p1.x)*(p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y));
  }

}
