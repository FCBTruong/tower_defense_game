package com.mynta.gametowerdefense;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mynta.gametowerdefense.screens.LoadingScreen;
import com.mynta.gametowerdefense.utils.Constants;
import com.mynta.gametowerdefense.utils.TouchInfo;

import static com.mynta.gametowerdefense.utils.Constants.*;

public class MyGame extends Game implements ApplicationListener, GestureDetector.GestureListener {
    public static final AssetManager manager = new AssetManager();

    @Override
    public void create(){
        //** read Data from file */
        Preferences prefs = Gdx.app.getPreferences("TowerDefense");

        //If the preference key is empty, create it by putting a value into it
        if(!prefs.contains("sound")) {
            prefs.putBoolean("sound", true);
            SOUND_STATUS = true;
        }

        if(!prefs.contains("music")) {
            prefs.putBoolean("music", true);
            MUSIC_STATUS = true;
        }
        if(!prefs.contains("levelCurrent")) {
            prefs.putInteger("levelCurrent", 1);
            LEVEL_CURRENT = 1;
        }

        //This will finally save the changes to storage
        prefs.flush();

        //Get value from a preference key  (must not be empty)
        if(prefs.getBoolean("sound")) SOUND_STATUS = true;
        else SOUND_STATUS = false;
        if(prefs.getBoolean("music")) MUSIC_STATUS = true;
        else MUSIC_STATUS = false;
        LEVEL_CURRENT = prefs.getInteger("levelCurrent");

       //Do something with your value and put it back to the preference

        Gdx.input.setInputProcessor(new GestureDetector(this));
        Gdx.input.setCatchBackKey(true);
        setupCamera();
        setScreen(new LoadingScreen(this));
    }

    public static void setupCamera(){
        touchPos = new Vector3();
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH,Constants.VIEWPORT_HEIGHT);
        camera.position.set( Constants.VIEWPORT_WIDTH/2 + (GAME_WIDTH - VIEWPORT_WIDTH) / 2 ,
                Constants.VIEWPORT_HEIGHT/2 + (GAME_HEIGHT - VIEWPORT_HEIGHT) / 2,0f);
        camera.update();
    }

    @Override
    public void render() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.BACK)) {
            TouchInfo.back = true;
        } else TouchInfo.back = false;

        if (Gdx.input.justTouched()) TouchInfo.touched = true;
        else {
            TouchInfo.touched = false;
        }
        super.render();
    }

    @Override
    public void resize(int width, int height){
        super.resize(width, height);
    }

    @Override
    public void pause(){
        super.pause();
    }

    @Override
    public void resume(){
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
        manager.dispose();
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        camera.unproject(touchPos.set(x,y,0));
        TouchInfo.touchX = touchPos.x;
        TouchInfo.touchY = touchPos.y;
        TouchInfo.touched = true;
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
       // camera.translate(100 , 0);
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
          if(deltaY + camera.position.y + VIEWPORT_HEIGHT/2  <= GAME_HEIGHT && deltaY + camera.position.y - VIEWPORT_HEIGHT/2 >= 0)
          {
              camera.translate(0 , deltaY);
          }
          if(-deltaX + camera.position.x + VIEWPORT_WIDTH/2<= GAME_WIDTH && -deltaX + camera.position.x - VIEWPORT_WIDTH/2 >= 0) {
              camera.translate(-deltaX, 0);
          }
          camera.update();
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
       return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {
    }
}
