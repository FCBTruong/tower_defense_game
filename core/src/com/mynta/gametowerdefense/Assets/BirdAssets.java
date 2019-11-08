package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mynta.gametowerdefense.MyGame;

public class BirdAssets {
    public static TextureAtlas textureAtlasFlying;

    public static void ManagerLoad(){
        MyGame.manager.load("Scenery/Bird.atlas", TextureAtlas.class);
    }

    public static void LoadToProject(){
        textureAtlasFlying = MyGame.manager.get("Scenery/Bird.atlas");
    }

    public static void Clean(){
        textureAtlasFlying.dispose();
    }
}
