package com.mynta.gametowerdefense.stages;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mynta.gametowerdefense.Assets.CleanAssets;
import com.mynta.gametowerdefense.Assets.CommonAssets;
import com.mynta.gametowerdefense.Assets.SoundAssets;
import com.mynta.gametowerdefense.GameFunction.Settings;
import com.mynta.gametowerdefense.MapGame.SetMap;
import com.mynta.gametowerdefense.MyGame;
import com.mynta.gametowerdefense.utils.Constants;
import com.mynta.gametowerdefense.utils.TouchInfo;

import static com.mynta.gametowerdefense.utils.Constants.*;

/** GAME STAGE
 * execute the game
 * Play games, load menus
 */

public class GameStage extends Stage implements InputProcessor {
    private float x;
    private SpriteBatch batch;

    public static PlayGame playGame;
    public static Settings settings;
    public static GameStatus gameStatus;
    private Sprite mainGameScreen;
    public static int level;

    public GameStage(){
        Constants.loadData();
        level = 0;
        settings = new Settings();
        //playGame = new PlayGame(MAP_LEVEL1);
        batch = new SpriteBatch();
        gameStatus = GameStatus.MAIN_GAME_SCREEN;
        mainGameScreen = new Sprite(CommonAssets.textureMainGameScreen);
    }


    @Override
    public void act(float delta){
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        if(MUSIC_STATUS) SoundAssets.music.play();
        else SoundAssets.music.stop();

        switch (gameStatus) {
            case MAIN_GAME_SCREEN:
                mainGameScreen.draw(batch);
                for(int i = 1; i <= LEVEL_CURRENT; i ++){
                    Constants.chooseLevels[i].show(batch);
                }
                settings.showIcon(batch);
                if(TouchInfo.touched || TouchInfo.back) settings.Touch();
                if(settings.close) settings.show(batch);
                else {
                    for (int i = 1; i <= LEVEL_CURRENT; i++) {
                        if (Constants.chooseLevels[i].Touch()) {
                            // If player touches the screen,the touch sound will be played */
                            if(SOUND_STATUS) SoundAssets.touchSound.play();

                            switch (i) {
                                case 1:
                                    level = 1;
                                    SetMap.MAP_LEVEL1();
                                    playGame = new PlayGame(MAP_LEVEL1);
                                    break;
                            }
                            gameStatus = GameStatus.PLAY_GAME;
                            GAME_WIDTH = MAP_WIDTH;
                            GAME_HEIGHT = MAP_HEIGHT;
                            MyGame.setupCamera();
                            break;
                        }
                    }
                }
                break;
            case PLAY_GAME:
                playGame.show(batch);
                if(TouchInfo.touched || TouchInfo.back) settings.Touch();
                if(!settings.close)
                {
                    playGame.play();
                }
                else settings.show(batch);
                break;
        }
        batch.end();
    }

    @Override
    public void dispose() {
        CleanAssets.Clean();
        batch.dispose();
        playGame.dispose();
    }
}
