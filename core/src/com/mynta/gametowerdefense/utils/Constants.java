package com.mynta.gametowerdefense.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mynta.gametowerdefense.GameFunction.ChooseLevel;
import com.mynta.gametowerdefense.MapGame.MapGame;

/**
 * Includes fixed attributes used in the game.
 */

public class Constants {
    public static final float APP_WIDTH = 800;
    public static final float APP_HEIGHT = 550;
    public static final float VIEWPORT_WIDTH = 2880;
    public static final float VIEWPORT_HEIGHT = 1440;

    public static final float MAP_WIDTH = 2900;
    public static final float MAP_HEIGHT = 2200;

    public static final float MAIN_GAME_SCREEN_WIDTH = 3580;
    public static final float MAIN_GAME_SCREEN_HEIGHT = 2390;

    public static float GAME_WIDTH = 2880;
    public static float GAME_HEIGHT = 1440;

    public static final float LOADING_BAR_WIDTH = 2280;
    public static final float LOADING_BAR_HEIGHT = 15;

    public static final Vector2 WORLD_GRAVITY = new Vector2(0,-10) ;

    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 25f;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;

    public static final int ARCHER_PRICE = 76;
    public static final int APPRENTICE_MAGE_PRICE = 100;
    public static final int TURRET_PRICE = 80;
    public static final int ARMY_PRICE = 70;
    //public static final int

    public static final float FRAME_DURATION = 1/15f;
    public static final float PI = 3.1416f;

    public static OrthographicCamera camera;
    public static Vector3 touchPos;

    public static MapGame MAP_LEVEL1;

    public static int LEVEL_CURRENT;
    public static int LEVEL_MAX = 1;

    public static ChooseLevel[] chooseLevels = new ChooseLevel[LEVEL_MAX + 1];

    public static void loadData(){
       for(int i = 1; i <= LEVEL_MAX; i++) {
           chooseLevels[i] = new ChooseLevel(i);
       }
       chooseLevels[1].setPosition(new CoOrdinate(1700,1290));
    }

    // ** Data Game */
    public static boolean SOUND_STATUS;
    public static boolean MUSIC_STATUS;
}
