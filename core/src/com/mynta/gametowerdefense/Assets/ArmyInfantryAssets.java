package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mynta.gametowerdefense.MyGame;

public class ArmyInfantryAssets {
    public static TextureAtlas textureAtlasRunningRight; // run to the Right
    public static TextureAtlas textureAtlasAttacking;
    public static Texture textureAlive;
    public static TextureAtlas textureAtlasRunningLeft;
    public static TextureAtlas textureAtlasDying;

    public static void LoadToProject(){
        textureAtlasRunningRight = MyGame.manager.get("Army/Army_Infantry/Level01/runningRight.atlas");
        textureAtlasAttacking = MyGame.manager.get("Army/Army_Infantry/Level01/attacking.atlas");
        textureAlive = MyGame.manager.get("Army/Army_Infantry/Level01/alive.png");
        textureAtlasRunningLeft = MyGame.manager.get("Army/Army_Infantry/Level01/runningLeft.atlas");
        textureAtlasDying = MyGame.manager.get("Army/Army_Infantry/Level01/dying.atlas");
    }

    public static void ManagerLoad() {
        MyGame.manager.load("Army/Army_Infantry/Level01/runningRight.atlas", TextureAtlas.class);
        MyGame.manager.load("Army/Army_Infantry/Level01/attacking.atlas", TextureAtlas.class);
        MyGame.manager.load("Army/Army_Infantry/Level01/alive.png", Texture.class);
        MyGame.manager.load("Army/Army_Infantry/Level01/runningLeft.atlas", TextureAtlas.class);
        MyGame.manager.load("Army/Army_Infantry/Level01/dying.atlas",TextureAtlas.class);
    }

    public static void Clean(){
        textureAtlasRunningRight.dispose();
        textureAtlasAttacking.dispose();
        textureAlive.dispose();
        textureAtlasRunningLeft.dispose();
        textureAtlasDying.dispose();
    }
}
