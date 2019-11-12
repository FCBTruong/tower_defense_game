package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mynta.gametowerdefense.MyGame;

public class ArcherAssets extends Assets {
    public static TextureAtlas attackingLeft;
    public static TextureAtlas attackingRight;
    public static Texture textureAlive;
   // public static final AssetManager manager = new AssetManager();

    public static void LoadToProject(){
        attackingLeft = MyGame.manager.get("Army/Air_Force/Level01/Attacking/attackingLeft.atlas");
        textureAlive = MyGame.manager.get("Army/Air_Force/Level01/alive.png");
        attackingRight = MyGame.manager.get("Army/Air_Force/Level01/Attacking/attackingRight.atlas");
        textureAlive.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public static void ManagerLoad(){
        MyGame.manager.load("Army/Air_Force/Level01/Attacking/attackingLeft.atlas", TextureAtlas.class);
        MyGame.manager.load("Army/Air_Force/Level01/alive.png", Texture.class);
        MyGame.manager.load("Army/Air_Force/Level01/Attacking/attackingRight.atlas", TextureAtlas.class);
    }

    public static void Clean(){
      attackingLeft.dispose();
      textureAlive.dispose();
      attackingRight.dispose();
    }
}
