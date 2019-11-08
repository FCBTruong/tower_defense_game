package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.mynta.gametowerdefense.MyGame;

public class FlagsLevelAssets {
    public static Texture textureWinLevel1;
    public static Texture textureLevel1;

    public static void ManagerLoad(){
        MyGame.manager.load("FlagsLevel/level1.png",Texture.class);
    }
    public static void LoadToProject(){
        textureLevel1 = MyGame.manager.get("FlagsLevel/level1.png");
        textureLevel1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }
    public static void Clean(){
        textureLevel1.dispose();
    }
}
