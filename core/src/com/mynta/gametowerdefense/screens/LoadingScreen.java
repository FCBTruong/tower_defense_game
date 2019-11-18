package com.mynta.gametowerdefense.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.LoadAssets;
import com.mynta.gametowerdefense.MyGame;
import com.mynta.gametowerdefense.utils.TouchInfo;

import static com.mynta.gametowerdefense.utils.Constants.*;

public class LoadingScreen extends AbstractScreen{
    private SpriteBatch spriteBatch;

    private Texture textureLoadingScreen;
    private Texture textureLoadingBar;
    private Texture textureIntroduce;
    private Texture textureTouch;

    private Sprite loadingScreen;
    private Sprite loadingBar;
    private Sprite introduce;
    private Sprite tapToPlay;
    private Texture textureTapToPlay;
    private Sprite tapToPlayScreen;
    private Texture textureTapScreen;
    private Sound soundLoading;

    private boolean setTapToPlay = false;

    private BitmapFont fontLoading;

    private float progress;
    private LoadingStatus loadingStatus;
    private float coolTime;
    private AssetManager managerOfLoading;
    private float sizeOfTapToPlay;
    private float displayTapToPlay;

    public LoadingScreen(MyGame game) {
        super(game);
        coolTime = 0;
        spriteBatch = new SpriteBatch();
        managerOfLoading = new AssetManager();

        textureIntroduce = new Texture(Gdx.files.internal("Common/Introduce.png"));
        textureIntroduce.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        introduce = new Sprite(textureIntroduce);

        loadingStatus = LoadingStatus.LOAD_INTRODUCE;
        sizeOfTapToPlay = 400;
        displayTapToPlay = 1;
    }

    @Override
    public void show() {
        if(loadingStatus == LoadingStatus.LOAD_GAME_ASSETS) {
            LoadAssets.ManagerLoad();
            if (!MyGame.manager.update()) return;
        }
        if(loadingStatus == LoadingStatus.LOAD_INTRODUCE){
            managerOfLoading.load("Common/loadingBar.png",Texture.class);
            managerOfLoading.load("Common/loadingScreen.png",Texture.class);
            managerOfLoading.load("Common/Fonts/percent.fnt", BitmapFont.class);
            managerOfLoading.load("Sound/touchLoadingSound.mp3", Sound.class);
            // Touch display
            managerOfLoading.load("Common/touch.png",Texture.class);
            if(!managerOfLoading.update()) return;
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        if(loadingStatus == LoadingStatus.LOAD_INTRODUCE){
            if(coolTime >= 80) {
                if(managerOfLoading.update()){
                    textureLoadingScreen = managerOfLoading.get("Common/loadingScreen.png");
                    textureLoadingScreen.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                    loadingScreen = new Sprite(textureLoadingScreen);

                    textureLoadingBar = managerOfLoading.get("Common/loadingBar.png");
                    textureLoadingBar.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                    loadingBar = new Sprite(textureLoadingBar);
                    loadingBar.setPosition(300,165);

                    fontLoading = managerOfLoading.get("Common/Fonts/percent.fnt");

                    soundLoading = managerOfLoading.get("Sound/touchLoadingSound.mp3");

                    textureTouch = managerOfLoading.get("Common/touch.png");
                    textureTouch.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                    TouchInfo.spriteTouch = new Sprite(textureTouch);

                    loadingStatus = LoadingStatus.LOAD_GAME_ASSETS;
                    this.show();
                    spriteBatch.end();
                    return;
                }
            }
            if(coolTime > 40){
                if(coolTime <= 90) introduce.setAlpha((50f-(coolTime-40))/50);
                else introduce.setAlpha(0);
            }
            introduce.draw(spriteBatch);
            coolTime += 0.5;
        }

        if(loadingStatus == LoadingStatus.LOAD_GAME_ASSETS) {
            progress = game.manager.getProgress();
            if (MyGame.manager.update()) { // Load some, will return true if done
                // loading
                if(!setTapToPlay) {
                    textureTapToPlay = game.manager.get("Common/tapToPlay.png");
                    textureTapToPlay.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                    tapToPlay = new Sprite(textureTapToPlay);

                    textureTapScreen = game.manager.get("Common/tapToPlayScreen.png");
                    textureTapScreen.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                    tapToPlayScreen = new Sprite(textureTapScreen);

                    setTapToPlay = true;
                }
                if (TouchInfo.touched) {
                    // If player touches the screen,the touch sound will be played */
                    if(SOUND_STATUS) soundLoading.play(0.7f);
                    GAME_WIDTH = MAIN_GAME_SCREEN_WIDTH;
                    GAME_HEIGHT = MAIN_GAME_SCREEN_HEIGHT;
                    MyGame.setupCamera();
                    LoadAssets.LoadToProject();
                    game.setScreen(new GameScreen(this.game));
                }
                tapToPlayScreen.draw(spriteBatch);
                tapToPlay.setSize(sizeOfTapToPlay, sizeOfTapToPlay);
                tapToPlay.setPosition(1440 - sizeOfTapToPlay / 2, 120 - sizeOfTapToPlay / 2);
                sizeOfTapToPlay -= displayTapToPlay * 2;
                if(sizeOfTapToPlay <= 300) {
                    displayTapToPlay = -1;
                }
                if(sizeOfTapToPlay >= 400){
                    displayTapToPlay = 1;
                }
                tapToPlay.draw(spriteBatch);
            }
            // to do
            else {
                loadingScreen.draw(spriteBatch);
                loadingBar.setSize(LOADING_BAR_WIDTH * progress, 15);
                loadingBar.draw(spriteBatch);
                fontLoading.draw(spriteBatch, Integer.toString((int) (progress * 100)) + "%", 2500, 100);
            }
        }
        spriteBatch.end();
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
        spriteBatch.dispose();
    }
}
