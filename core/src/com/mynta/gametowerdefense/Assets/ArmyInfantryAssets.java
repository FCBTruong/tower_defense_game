package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mynta.gametowerdefense.MyGame;

public class ArmyInfantryAssets {
    public static TextureAtlas textureAtlasRunningRight; // run to the Right
    public static TextureAtlas textureAtlasAttacking;
    public static Texture textureAlive;

    public static void LoadToProject(){
        textureAtlasRunningRight = MyGame.manager.get("Army/Army_Infantry/Level01/Running/running.atlas");
        textureAtlasAttacking = MyGame.manager.get("Army/Army_Infantry/Level01/attacking.atlas");
        textureAlive = MyGame.manager.get("Army/Army_Infantry/Level01/alive.png");
    }

    public static void ManagerLoad(){
        MyGame.manager.load("Army/Army_Infantry/Level01/Running/running.atlas",TextureAtlas.class);
        MyGame.manager.load("Army/Army_Infantry/Level01/attacking.atlas",TextureAtlas.class);
        MyGame.manager.load("Army/Army_Infantry/Level01/alive.png",Texture.class);
    }

    public static void Clean(){
        textureAtlasRunningRight.dispose();
        textureAtlasAttacking.dispose();
        textureAlive.dispose();
    }
}
