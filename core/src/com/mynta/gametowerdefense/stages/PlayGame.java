package com.mynta.gametowerdefense.stages;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.CommonAssets;
import com.mynta.gametowerdefense.Assets.SoundAssets;
import com.mynta.gametowerdefense.MapGame.MapGame;
import com.mynta.gametowerdefense.MyGame;
import com.mynta.gametowerdefense.characters.Army.ArmyInfantry;
import com.mynta.gametowerdefense.characters.Towers.*;
import com.mynta.gametowerdefense.utils.AnimationAct;
import com.mynta.gametowerdefense.utils.CoOrdinate;
import com.mynta.gametowerdefense.utils.Constants;
import com.mynta.gametowerdefense.utils.TouchInfo;

import static com.mynta.gametowerdefense.stages.ResultPlay.DEFEAT;
import static com.mynta.gametowerdefense.stages.ResultPlay.WIN;
import static com.mynta.gametowerdefense.utils.Constants.*;

/**
 * to play
 */

public class PlayGame {
    private MapGame mapGame;

    /* Shows money that the player currently has */
    private AnimationAct Coin;
    public static int coinNumber;
    private CoOrdinate positionOfCoin;
    private float coolTimeRotateCoin;
    private Sprite showCoinNumber;
    private BitmapFont coinNumberFont;
    private ResultPlay resultPlay;

    /* hearts of Player */
    private Sprite Heart;
    public static int heartNumber;
    private CoOrdinate positionOfHeart;
    private BitmapFont heartNumberFont;

    /* waves */
    private Sprite spriteWave;  // Display number of waves
    private int indexWaveCurrent; // wave current.
    private int waveNumber;
    private CoOrdinate positionOfSpriteWave;
    private BitmapFont waveNumberFont;

    /* Pause */
    private Sprite pause;
    CoOrdinate positionPause;

    /* Defeat, Victory */
    private Sprite defeat;
    private Sprite victory;

    private float waveShiftTime; // /** time out between two wave */

    private float coolTimeEndGame;
    private float waitingTime;

    ArmyInfantry arm = new ArmyInfantry();

    public PlayGame(MapGame mapGame) {
        arm.setPosition(new CoOrdinate(1000,1000));
        this.mapGame = mapGame;
        indexWaveCurrent = 0;
        waveShiftTime = 0;
        waitingTime = 60;

        Coin = new AnimationAct();
        Coin.setBool(false);
        Coin.setAnimation(CommonAssets.textureAtlasCoin);

        resultPlay = ResultPlay.NONE;

        coolTimeRotateCoin = 100;
        positionOfCoin = new CoOrdinate();
        coinNumber = mapGame.coinNumber;
        showCoinNumber = new Sprite(CommonAssets.textureShowCoinNumber);

        // coinNumberFont.
        coinNumberFont = CommonAssets.defaultNormalFont;
        coinNumberFont.setColor(Color.WHITE);

        Heart = new Sprite(CommonAssets.textureHeart);
        positionOfHeart = new CoOrdinate();
        heartNumber = mapGame.heartNumber;
        heartNumberFont =CommonAssets.defaultNormalFont;
        heartNumberFont.setColor(Color.WHITE);

        spriteWave = new Sprite(CommonAssets.textureSpriteWave);
        positionOfSpriteWave = new CoOrdinate();
        waveNumber = mapGame.waveNumber;
        waveNumberFont = CommonAssets.defaultNormalFont;
        waveNumberFont.setColor(Color.WHITE);

        pause = new Sprite(CommonAssets.texturePause);
        pause.setSize(100,100);
        positionPause = new CoOrdinate(Constants.camera.position.x + 1320,Constants.camera.position.y + 600 );

        defeat = new Sprite(CommonAssets.textureDefeat);
        victory = new Sprite(CommonAssets.textureVictory);
        coolTimeEndGame = 50;
    }

    public void play() {
        if(resultPlay == ResultPlay.DEFEAT) {
            waitingTime -= 0.5;
            if(waitingTime > 0) return;
            if(TouchInfo.touched) {
                if(SOUND_STATUS) SoundAssets.touchSound.play();
                GAME_WIDTH = MAIN_GAME_SCREEN_WIDTH;
                GAME_HEIGHT = MAIN_GAME_SCREEN_HEIGHT;
                MyGame.setupCamera();
                GameStage.gameStatus = GameStatus.MAIN_GAME_SCREEN;
            }
            return;
        }

        if(resultPlay == WIN){
            if(GameStage.level == LEVEL_CURRENT) {
                LEVEL_CURRENT++;
                FileHandle file = new FileHandle("Data/Data.txt");
                file.writeString(SOUND_STATUS + " " + MUSIC_STATUS + " " + LEVEL_CURRENT,false);
            }

            waitingTime -= 0.5;
            if(waitingTime > 0) return;
            if(TouchInfo.touched) {
                if(SOUND_STATUS) SoundAssets.touchSound.play();
                GAME_WIDTH = MAIN_GAME_SCREEN_WIDTH;
                GAME_HEIGHT = MAIN_GAME_SCREEN_HEIGHT;
                MyGame.setupCamera();
                GameStage.gameStatus = GameStatus.MAIN_GAME_SCREEN;
            }
            return;
        }

        if(heartNumber <= 0) resultPlay = DEFEAT;

        if(waveShiftTime == 0)  {
            /** if the wave finished ,move the next Wave; */
            if (!mapGame.waveList.get(indexWaveCurrent).Status()){
                waveShiftTime = 100;
            }
        }

        /** time out between two wave */
        if(waveShiftTime > 0){
            waveShiftTime -= 0.5;
            if(waveShiftTime <= 0) {
                indexWaveCurrent++;
                if(indexWaveCurrent == waveNumber) {
                    resultPlay = WIN;
                    indexWaveCurrent --;
                    return;
                }
            }
        }

        /*
         * Set Tower if player touch ...
         * touch event handling
         */
        if(TouchInfo.touched)
        for(int i = 0; i < mapGame.towerNumber; i ++){
            mapGame.towerList[i].InputTouch();
            if(mapGame.towerList[i].getTowerType() == TowerType.NONE) {
                if (mapGame.towerList[i].getSelected() == TowerType.ARCHER) {
                    CoOrdinate positionOfTower = mapGame.towerList[i].getPosition();
                    mapGame.towerList[i] = new ArcherTower();
                    mapGame.towerList[i].setPosition(positionOfTower);
                }
                else if(mapGame.towerList[i].getSelected() == TowerType.APPRENTICE_MAGE){
                    CoOrdinate positionOfTower = mapGame.towerList[i].getPosition();
                    mapGame.towerList[i] = new ApprenticeMageTower();
                    mapGame.towerList[i].setPosition(positionOfTower);
                }
                else if(mapGame.towerList[i].getSelected() == TowerType.TURRET){
                    CoOrdinate positionOfTower = mapGame.towerList[i].getPosition();
                    mapGame.towerList[i] = new TurretTower();
                    mapGame.towerList[i].setPosition(positionOfTower);
                }
                else if(mapGame.towerList[i].getSelected() == TowerType.ARMY_INFANTRY){
                    CoOrdinate positionOfTower = mapGame.towerList[i].getPosition();
                    mapGame.towerList[i] = new ArmyTower();
                    mapGame.towerList[i].setPosition(positionOfTower);
                }
            }
            else {
                if(mapGame.towerList[i].getSelected() == TowerType.NONE){
                    CoOrdinate positionOfTower = mapGame.towerList[i].getPosition();
                    mapGame.towerList[i] = new Tower();
                    mapGame.towerList[i].setPosition(positionOfTower);
                }
            }
        }

        /**
         *  Check waves are finished or not
         */
        if (indexWaveCurrent < mapGame.waveNumber)
            mapGame.waveList.get(indexWaveCurrent).move();

        /**
         * Check that the tower is installed and if the enemy is in range.
         */
        for (int i = 0; i < mapGame.towerNumber; i++) {
            if(mapGame.towerList[i].getTowerType() == TowerType.NONE) continue;
            if (mapGame.towerList[i].getTowerType() == TowerType.ARMY_INFANTRY){
                mapGame.waveList.get(indexWaveCurrent).radar(mapGame.towerList[i]);
                mapGame.towerList[i].attack();
                continue;
            }

            if (mapGame.towerList[i].getTowerStatus() == TowerStatus.ATTACKING) {
                mapGame.towerList[i].attack();
            } else
                mapGame.waveList.get(indexWaveCurrent).radar(mapGame.towerList[i]);
        }
    }

    public void show(SpriteBatch batch) {
        if(resultPlay != ResultPlay.NONE){
            coolTimeEndGame -= 0.5;
            if (resultPlay == WIN) coolTimeEndGame -= 1.5;
            if(coolTimeEndGame < 0) {
                GAME_WIDTH = VIEWPORT_WIDTH;
                GAME_HEIGHT = VIEWPORT_HEIGHT;
                MyGame.setupCamera();
                if(resultPlay == ResultPlay.DEFEAT) defeat.draw(batch);
                else victory.draw(batch);
                return;
            }
        }

        mapGame.showMapFirst(batch);
        mapGame.waveList.get(indexWaveCurrent).show(batch);
        mapGame.showMapSecond(batch);

        positionOfCoin.x = Constants.camera.position.x - 1200;
        positionOfCoin.y = Constants.camera.position.y + 600;

        positionOfHeart.x = Constants.camera.position.x - 1440;
        positionOfHeart.y = Constants.camera.position.y + 600;

        positionOfSpriteWave.x = Constants.camera.position.x - 1440;
        positionOfSpriteWave.y = Constants.camera.position.y + 480;

        positionPause.x = Constants.camera.position.x + 1320;
        positionPause.y = Constants.camera.position.y + 600;

        /**
         *  Show number of coins
         *  Show number of hearts
         *  Show number of waves
         */
        showCoinNumber.setPosition(positionOfCoin.x, positionOfCoin.y);
        showCoinNumber.draw(batch);
        Coin.show(batch,positionOfCoin);
        coinNumberFont.draw(batch, Integer.toString(coinNumber), positionOfCoin.x + 160, positionOfCoin.y + 75);

        if(coolTimeRotateCoin == 0){
            Coin.setBool(true);
            coolTimeRotateCoin = 100;
        }
        if(coolTimeRotateCoin == 80){
            Coin.setBool(false);
        }
        coolTimeRotateCoin -= 0.5;

        /* Show number of hearts */
        Heart.setPosition(positionOfHeart.x, positionOfHeart.y);
        Heart.draw(batch);
        heartNumberFont.draw(batch,Integer.toString(heartNumber), positionOfHeart.x + 120, positionOfHeart.y + 75);

        /* Show number of waves */
        spriteWave.setPosition(positionOfSpriteWave.x, positionOfSpriteWave.y);
        spriteWave.draw(batch);
        waveNumberFont.draw(batch, Integer.toString(indexWaveCurrent + 1) + "/" + Integer.toString(waveNumber),
                positionOfSpriteWave.x + 270, positionOfSpriteWave.y + 75);

        pause.setPosition(positionPause.x, positionPause.y);
        pause.draw(batch);
    }

    public void dispose(){

    }
}
