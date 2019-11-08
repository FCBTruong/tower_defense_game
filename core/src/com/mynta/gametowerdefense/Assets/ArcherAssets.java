package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mynta.gametowerdefense.MyGame;

public class ArcherAssets extends Assets {
    public static TextureAtlas attackingLeft;
    public static Texture textureAlive;
   // public static final AssetManager manager = new AssetManager();

    public static void LoadToProject(){
        attackingLeft = MyGame.manager.get("Army/Air_Force/Level01/Attacking/attackingLeftA.atlas");
        textureAlive = MyGame.manager.get("Army/Air_Force/Level01/alive.png");
        textureAlive.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public static void ManagerLoad(){
        MyGame.manager.load("Army/Air_Force/Level01/Attacking/attackingLeftA.atlas", TextureAtlas.class);
        MyGame.manager.load("Army/Air_Force/Level01/alive.png", Texture.class);
    }

    public static void Clean(){
      attackingLeft.dispose();
      textureAlive.dispose();
    }
}
