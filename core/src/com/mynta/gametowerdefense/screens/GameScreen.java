package com.mynta.gametowerdefense.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mynta.gametowerdefense.Assets.CommonAssets;
import com.mynta.gametowerdefense.MyGame;
import com.mynta.gametowerdefense.stages.GameStage;
import com.mynta.gametowerdefense.utils.TouchInfo;

public class GameScreen extends AbstractScreen {
    private GameStage stage;

    public GameScreen(MyGame game){
        super(game);

        // set Touch Info
        TouchInfo.spriteTouchFalse = new Sprite(CommonAssets.textureTouchFalse);
        TouchInfo.spriteTouchMoveArmyTower = new Sprite(CommonAssets.textureTouchMoveArmyTower);
        stage = new GameStage();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
