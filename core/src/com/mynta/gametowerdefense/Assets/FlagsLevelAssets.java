package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.mynta.gametowerdefense.MyGame;

public class FlagsLevelAssets {
    public static Texture textureWinLevel1;
    public static Texture textureLevel1;

    public static Texture textureWinLevel2;
    public static Texture textureLevel2;

    public static void ManagerLoad(){
        MyGame.manager.load("FlagsLevel/level1.png",Texture.class);
        MyGame.manager.load("FlagsLevel/level1Win.png",Texture.class);
        MyGame.manager.load("FlagsLevel/level2.png",Texture.class);
        MyGame.manager.load("FlagsLevel/level2Win.png",Texture.class);
    }
    public static void LoadToProject(){
        textureLevel1 = MyGame.manager.get("FlagsLevel/level1.png");
        textureLevel1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureWinLevel1 = MyGame.manager.get("FlagsLevel/level1Win.png");
        textureWinLevel1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureLevel2 = MyGame.manager.get("FlagsLevel/level2.png");
        textureLevel2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureWinLevel2 = MyGame.manager.get("FlagsLevel/level2Win.png");
        textureWinLevel2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }
    public static void Clean(){
        textureLevel1.dispose();
        textureWinLevel1.dispose();
        textureLevel2.dispose();
        textureWinLevel2.dispose();
    }
}
