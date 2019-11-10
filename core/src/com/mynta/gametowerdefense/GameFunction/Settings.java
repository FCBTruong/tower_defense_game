package com.mynta.gametowerdefense.GameFunction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.CommonAssets;
import com.mynta.gametowerdefense.Assets.SoundAssets;
import com.mynta.gametowerdefense.MapGame.SetMap;
import com.mynta.gametowerdefense.enums.Answer;
import com.mynta.gametowerdefense.stages.GameStage;
import com.mynta.gametowerdefense.stages.GameStatus;
import com.mynta.gametowerdefense.stages.PlayGame;
import com.mynta.gametowerdefense.utils.CalculationFunction;
import com.mynta.gametowerdefense.utils.CoOrdinate;
import com.mynta.gametowerdefense.utils.Constants;
import com.mynta.gametowerdefense.utils.TouchInfo;

import static com.mynta.gametowerdefense.utils.Constants.*;

public class Settings {
    private Sprite spriteSetting;
    private Sprite settingIcon;
    private CoOrdinate positionIcon;
    private boolean restart;
    public boolean close; // on or off
    private CoOrdinate positionClose;

    private Sprite quitIcon;
    private CoOrdinate positionQuit;

    private Sprite restartIcon;
    private CoOrdinate positionRestart;

    private Sprite spriteAskAgainQuit;
    private Sprite spriteAskAgainRestart;
    private CoOrdinate chooseNo;
    private CoOrdinate chooseYes;
    private CoOrdinate chooseClose; // centre
    private CoOrdinate positionSound;
    private CoOrdinate positionMusic;
    private Sprite soundX; // turn off sound
    private Sprite musicX; // turn off music

    private Answer answer;
    private boolean question; // true if it's a quit question, false : restart

    private boolean askAgain;

    public Settings(){
        spriteSetting = new Sprite(CommonAssets.textureSettings);
        spriteSetting.setPosition(Constants.camera.position.x - 750,Constants.camera.position.y - 450);
        positionClose = new CoOrdinate(Constants.camera.position.x + 540,Constants.camera.position.y + 255);

        settingIcon = new Sprite(CommonAssets.textureSettingIcon);
        settingIcon.setPosition(Constants.camera.position.x + 1320,Constants.camera.position.y + 600);

        positionIcon = new CoOrdinate(Constants.camera.position.x + 1320,Constants.camera.position.y + 600);
        close = false;
        askAgain = false;

        quitIcon = new Sprite(CommonAssets.textureQuit);
        quitIcon.setPosition(Constants.camera.position.x - 300,Constants.camera.position.y - 405);
        positionQuit = new CoOrdinate(Constants.camera.position.x - 300,Constants.camera.position.y - 405);

        restartIcon = new Sprite(CommonAssets.textureRestart);
        restartIcon.setPosition(Constants.camera.position.x + 30, Constants.camera.position.y - 405);
        positionRestart = new CoOrdinate(Constants.camera.position.x + 30, Constants.camera.position.y - 405);

        spriteAskAgainQuit = new Sprite(CommonAssets.textureAskAgainQuit);
        spriteAskAgainQuit.setPosition(Constants.camera.position.x - 650, Constants.camera.position.y - 390);
        spriteAskAgainRestart = new Sprite(CommonAssets.textureAskAgainRestart);
        spriteAskAgainRestart.setPosition(Constants.camera.position.x - 650, Constants.camera.position.y - 390);

        chooseNo = new CoOrdinate(Constants.camera.position.x - 416, Constants.camera.position.y - 351);
        chooseYes = new CoOrdinate(Constants.camera.position.x + 26, Constants.camera.position.y - 351);
        chooseClose = new CoOrdinate(Constants.camera.position.x + 468, Constants.camera.position.y + 221);

        positionSound = new CoOrdinate(Constants.camera.position.x - 420, Constants.camera.position.y - 150);
        positionMusic = new CoOrdinate(Constants.camera.position.x + 120, Constants.camera.position.y - 150);

        soundX = new Sprite(CommonAssets.textureX);
        musicX = new Sprite(CommonAssets.textureX);

        answer = Answer.NONE;
    }

    public void showIcon(SpriteBatch batch){
        setSettingIconPosition(Constants.camera.position.x + 1320,Constants.camera.position.y + 600);
        if(GameStage.gameStatus == GameStatus.MAIN_GAME_SCREEN) {
            settingIcon.draw(batch);
        }
    }

    public void setSettingIconPosition(float x, float y){
        positionIcon.x = x;
        positionIcon.y = y;
        settingIcon.setPosition(x,y);
    }

    public void Touch(){
        if(!TouchInfo.touched && TouchInfo.back == false) return;
        if(close)
        {
            positionClose.x = Constants.camera.position.x + 540;
            positionClose.y = Constants.camera.position.y + 255;
            if(!askAgain) {
                if (CalculationFunction.circleDetect(new CoOrdinate(positionClose.x + 75, positionClose.y + 75), 75,
                        TouchInfo.touchX, TouchInfo.touchY)) {
                    if (SOUND_STATUS) SoundAssets.touchSound.play();
                    close = false;
                    return;
                }
                positionSound.x = Constants.camera.position.x - 420;
                positionSound.y = Constants.camera.position.y - 150;
                positionMusic.x = Constants.camera.position.x + 120;
                positionMusic.y = Constants.camera.position.y - 150;

                if(CalculationFunction.rectangleDetect(positionSound,300,300,TouchInfo.touchX,TouchInfo.touchY)){
                    SOUND_STATUS = !SOUND_STATUS;
                    System.out.println("11");
                    FileHandle file = Gdx.files.internal("Data/Data.txt");
                //    System.out.println("12");
                    //file.writeString(SOUND_STATUS + " " + MUSIC_STATUS + " " + LEVEL_CURRENT,false);
                }
                if(CalculationFunction.rectangleDetect(positionMusic,300,300,TouchInfo.touchX,TouchInfo.touchY)){
                    MUSIC_STATUS = !MUSIC_STATUS;
                    FileHandle file = new FileHandle("Data/Data.txt");
                    //file.writeString(SOUND_STATUS + " " + MUSIC_STATUS + " " + LEVEL_CURRENT,false);
                }
            }
            if(GameStage.gameStatus == GameStatus.PLAY_GAME){
                positionQuit.x = Constants.camera.position.x - 480;
                positionQuit.y = Constants.camera.position.y - 405;

                positionRestart.x = Constants.camera.position.x + 30;
                positionRestart.y = Constants.camera.position.y - 405;

                if(!askAgain) {
                    if (CalculationFunction.rectangleDetect(positionQuit, 450, 180, TouchInfo.touchX, TouchInfo.touchY)) {
                        if(SOUND_STATUS) SoundAssets.touchSound.play();
                        askAgain = true;
                        question = true;
                    }
                    else if (CalculationFunction.rectangleDetect(positionRestart,450, 180, TouchInfo.touchX, TouchInfo.touchY)){
                        if(SOUND_STATUS) SoundAssets.touchSound.play();
                        askAgain = true;
                        question = false;
                    }
                }
                else {
                    askAgain();
                    if (answer == Answer.YES) {
                        if(question) {
                            GameStage.gameStatus = GameStatus.MAIN_GAME_SCREEN;
                            Constants.GAME_WIDTH = Constants.MAIN_GAME_SCREEN_WIDTH;
                            Constants.GAME_HEIGHT = Constants.MAIN_GAME_SCREEN_HEIGHT;
                        }
                        else{   /** Restart game */
                            switch (GameStage.level) {
                                case 1:
                                    SetMap.MAP_LEVEL1();
                                    GameStage.playGame = new PlayGame(Constants.MAP_LEVEL1);
                                    break;
                            }
                        }
                        askAgain = false;
                        answer = Answer.NONE;
                        close = false;
                        return;
                    }
                    else if(answer == Answer.NO){
                        askAgain = false;
                    }
                    else if(answer == Answer.CLOSE){
                        askAgain = false;
                    }
                }
            }
            else{
                if(askAgain){
                    askAgain();
                    if (answer == Answer.YES) {
                        Gdx.app.exit();
                        askAgain = false;
                        answer = Answer.NONE;
                        close = false;
                        return;
                    } else if (answer == Answer.NO) {
                        close = false;
                        askAgain = false;
                    } else if (answer == Answer.CLOSE) {
                        close = false;
                        askAgain = false;
                    }
                }
            }
        }
        else {
            positionIcon.x = Constants.camera.position.x + 1320;
            positionIcon.y = Constants.camera.position.y + 600;
            if (GameStage.gameStatus == GameStatus.MAIN_GAME_SCREEN) {
                if (CalculationFunction.circleDetect(new CoOrdinate(positionIcon.x + 50, positionIcon.y + 50), 50,
                        TouchInfo.touchX, TouchInfo.touchY)) {
                    if(SOUND_STATUS) SoundAssets.touchSound.play();
                    close = true;
                    return;
                }
                if (TouchInfo.back) {
                   close = true;
                   askAgain = true;
                   return;
                }
            }
            else if (GameStage.gameStatus == GameStatus.PLAY_GAME) {
                if (CalculationFunction.rectangleDetect(positionIcon, 100, 100,
                        TouchInfo.touchX, TouchInfo.touchY) || TouchInfo.back == true) {
                    if(SOUND_STATUS) SoundAssets.touchSound.play();
                    close = true;
                    return;
                }
            }
        }
    }

    private void askAgain(){
        if(!TouchInfo.touched && TouchInfo.back == false) return;
        chooseNo.x = Constants.camera.position.x - 416;
        chooseNo.y = Constants.camera.position.y - 351;

        chooseYes.x = Constants.camera.position.x + 26;
        chooseYes.y = Constants.camera.position.y - 351;

        chooseClose.x = Constants.camera.position.x + 468;
        chooseClose.y = Constants.camera.position.y + 221;

        if(CalculationFunction.rectangleDetect(chooseNo,390,156,TouchInfo.touchX,TouchInfo.touchY))
        {
            if(SOUND_STATUS) SoundAssets.touchSound.play();
            answer = Answer.NO;
        }
        else if(CalculationFunction.rectangleDetect(chooseYes,390,156,TouchInfo.touchX,TouchInfo.touchY)) {
            if(SOUND_STATUS) SoundAssets.touchSound.play();
            answer = Answer.YES;
        }
        else if(CalculationFunction.circleDetect(positionClose,65,TouchInfo.touchX,TouchInfo.touchY)) {
            if(SOUND_STATUS) SoundAssets.touchSound.play();
            answer = Answer.CLOSE;
        }
    }

    public void show(SpriteBatch batch){
        if(GameStage.gameStatus == GameStatus.MAIN_GAME_SCREEN) {
            if(askAgain) {
                this.showQuestionAgain(batch);
                return;
            }
        }
        spriteSetting.setPosition(Constants.camera.position.x - 750, Constants.camera.position.y - 450);
        spriteSetting.draw(batch);
        if(!SOUND_STATUS){
            soundX.setPosition(camera.position.x - 240, camera.position.y - 180);
            soundX.draw(batch);
        }
        if(!MUSIC_STATUS){
            musicX.setPosition(camera.position.x + 300, camera.position.y - 180);
            musicX.draw(batch);
        }

        if(GameStage.gameStatus == GameStatus.PLAY_GAME){
            quitIcon.setPosition(Constants.camera.position.x - 480,Constants.camera.position.y - 405);
            quitIcon.draw(batch);
            restartIcon.setPosition(Constants.camera.position.x + 30, Constants.camera.position.y - 405);
            restartIcon.draw(batch);
            this.showQuestionAgain(batch);
        }
    }

    public void showQuestionAgain(SpriteBatch batch){
        if(askAgain){
            if(question) {
                spriteAskAgainQuit.setPosition(Constants.camera.position.x - 650, Constants.camera.position.y - 390);
                spriteAskAgainQuit.draw(batch);
            }
            else{
                spriteAskAgainRestart.setPosition(Constants.camera.position.x - 650, Constants.camera.position.y - 390);
                spriteAskAgainRestart.draw(batch);
            }
        }
    }
}
