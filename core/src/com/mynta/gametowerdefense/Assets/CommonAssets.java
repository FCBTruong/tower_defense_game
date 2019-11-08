package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mynta.gametowerdefense.MyGame;

public class CommonAssets {
    public static Texture textureBlood;
    public static TextureAtlas textureAtlasFlag;
    public static Texture textureFrameBuyTower;
    public static Texture textureSellTower;
    public static Texture textureFrameBlood;
    public static TextureAtlas textureAtlasCoin;
    public static Texture textureHeart;
    public static Texture textureSpriteWave;
    public static Texture textureShowCoinNumber;
    public static Texture textureFrameRange;
    public static Texture textureUpGrade;
    public static Texture texturePause;
    public static Texture textureChooseArcherTower;
    public static Texture textureChooseArmyTower;
    public static Texture textureChooseApprenticeMageTower;
    public static Texture textureChooseTurretTower;

    public static Texture textureSettings;
    public static Texture textureSettingIcon;
    public static Texture textureQuit;
    public static Texture textureAskAgainQuit;
    public static Texture textureAskAgainRestart;
    public static Texture textureRestart;

    public static Texture textureDefeat;
    public static Texture textureVictory;

    public static Texture textureMainGameScreen;

    public static TextureAtlas textureAtlasTapToPlay;

    public static Texture textureX; // off Sound or Music

    /**
     * Font Assets
     */
    public static BitmapFont defaultNormalFont;
    public static BitmapFont priceFont;

    public static void ManagerLoad(){
        MyGame.manager.load("blood.png",Texture.class);

        MyGame.manager.load("Scenery/flag.atlas",TextureAtlas.class);

        MyGame.manager.load("Common/frameBuyTower.png",Texture.class);

        MyGame.manager.load("Common/ChooseArcherTower.png",Texture.class);

        MyGame.manager.load("Common/sell.png",Texture.class);

        MyGame.manager.load("Common/frameBlood.png",Texture.class);

        MyGame.manager.load("Common/Coin.atlas",TextureAtlas.class);

        MyGame.manager.load("Common/heart.png",Texture.class);

        MyGame.manager.load("Common/wave.png",Texture.class);

        MyGame.manager.load("Common/Cointail.png",Texture.class);

        MyGame.manager.load("Common/frameRange.png",Texture.class);

        MyGame.manager.load("Common/setting.png",Texture.class);
        MyGame.manager.load("Common/settingIcon.png", Texture.class);
        MyGame.manager.load("Common/quit.png", Texture.class);
        MyGame.manager.load("Common/question.png",Texture.class);
        MyGame.manager.load("Common/restart.png",Texture.class);
        MyGame.manager.load("Common/restartQuestion.png",Texture.class);

        //Load Tap To play
        MyGame.manager.load("Common/tapToPlay.png",Texture.class);
        MyGame.manager.load("Common/tapToPlayScreen.png",Texture.class);

        // Main game screen
        MyGame.manager.load("Common/main_game_screen.png",Texture.class);

        // loading screen
        MyGame.manager.load("Common/loadingScreen.png",Texture.class);

        /* font assets */
        MyGame.manager.load("Common/Fonts/font.fnt",BitmapFont.class);

        MyGame.manager.load("Common/Fonts/priceFont.fnt",BitmapFont.class);

        MyGame.manager.load("Common/upGrade.png",Texture.class);

        MyGame.manager.load("Common/pause.png",Texture.class);

        MyGame.manager.load("Common/ChooseArmyTower.png",Texture.class);

        MyGame.manager.load("Common/ChooseApprenticeMage.png",Texture.class);

        MyGame.manager.load("Common/ChooseTurretTower.png",Texture.class);

        MyGame.manager.load("Common/defeat.png",Texture.class);
        MyGame.manager.load("Common/victory.png",Texture.class);

        MyGame.manager.load("Common/x.png",Texture.class);
    }

    public static void LoadToProject() {
        textureBlood = MyGame.manager.get("blood.png");
        textureBlood.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureAtlasFlag = MyGame.manager.get("Scenery/flag.atlas");

        textureFrameBuyTower = MyGame.manager.get("Common/frameBuyTower.png");
        textureFrameBuyTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureSellTower = MyGame.manager.get("Common/sell.png");
        textureSellTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureFrameBlood = MyGame.manager.get("Common/frameBlood.png");
        textureFrameBlood.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureAtlasCoin = MyGame.manager.get("Common/Coin.atlas");

        textureHeart = MyGame.manager.get("Common/heart.png");
        textureHeart.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureSpriteWave = MyGame.manager.get("Common/wave.png");
        textureSpriteWave.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureShowCoinNumber = MyGame.manager.get("Common/Cointail.png");
        textureShowCoinNumber.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureFrameRange = MyGame.manager.get("Common/frameRange.png");
        textureFrameRange.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        /* font assets */
        defaultNormalFont = MyGame.manager.get("Common/Fonts/font.fnt");
        defaultNormalFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        priceFont = MyGame.manager.get("Common/Fonts/priceFont.fnt");
        priceFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureUpGrade = MyGame.manager.get("Common/upGrade.png");
        textureUpGrade.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        texturePause = MyGame.manager.get("Common/pause.png");
        texturePause.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


        /** Choose Tower */
        textureChooseArcherTower = MyGame.manager.get("Common/ChooseArcherTower.png");
        textureChooseArcherTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureChooseArmyTower = MyGame.manager.get("Common/ChooseArmyTower.png");
        textureChooseArmyTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureChooseApprenticeMageTower = MyGame.manager.get("Common/ChooseApprenticeMage.png");
        textureChooseApprenticeMageTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureChooseTurretTower = MyGame.manager.get("Common/ChooseTurretTower.png");
        textureChooseTurretTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


        /** Settings */
        textureSettings = MyGame.manager.get("Common/setting.png");
        textureSettings.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureSettingIcon = MyGame.manager.get("Common/settingIcon.png");
        textureSettingIcon.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureQuit = MyGame.manager.get("Common/quit.png");
        textureQuit.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureRestart = MyGame.manager.get("Common/restart.png");
        textureRestart.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureMainGameScreen = MyGame.manager.get("Common/main_game_screen.png");
        textureMainGameScreen.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureAskAgainQuit = MyGame.manager.get("Common/question.png");
        textureAskAgainQuit.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureAskAgainRestart = MyGame.manager.get("Common/restartQuestion.png");
        textureAskAgainRestart.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureDefeat = MyGame.manager.get("Common/defeat.png");
        textureDefeat.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureVictory = MyGame.manager.get("Common/victory.png");
        textureVictory.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureX = MyGame.manager.get("Common/x.png");
        textureX.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public static void Clean(){
        textureAtlasFlag.dispose();
        textureBlood.dispose();
        textureFrameBlood.dispose();

        textureFrameBuyTower.dispose();
        textureSellTower.dispose();
        textureAtlasCoin.dispose();
        textureHeart.dispose();
        textureSpriteWave.dispose();
        textureShowCoinNumber.dispose();
        textureFrameRange.dispose();
        defaultNormalFont.dispose();
        priceFont.dispose();
        textureUpGrade.dispose();
        texturePause.dispose();

        textureChooseArcherTower.dispose();
        textureChooseArmyTower.dispose();
        textureChooseApprenticeMageTower.dispose();
        textureChooseTurretTower.dispose();

        textureSettings.dispose();
        textureSettingIcon.dispose();

        textureQuit.dispose();
        textureRestart.dispose();
        textureMainGameScreen.dispose();
        textureAskAgainQuit.dispose();
        textureAskAgainRestart.dispose();

        textureDefeat.dispose();
        textureVictory.dispose();

        textureX.dispose();
    }
}
