package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mynta.gametowerdefense.MyGame;

public class BigEnemyAssets {
    public static TextureAtlas textureAtlasRunRight; // run to the Right.
    public static TextureAtlas textureAtlasRunLeft; // run to Left.
    public static TextureAtlas textureAtlasAttackingRight; // attack to Right.
    public static TextureAtlas textureAtlasDying;

    public static void LoadToProject(){
        textureAtlasRunRight = MyGame.manager.get("Enemy/BigEnemy/running.atlas");
        textureAtlasDying = MyGame.manager.get("Enemy/BigEnemy/dying.atlas");
    }

    public static void ManagerLoad(){
        MyGame.manager.load("Enemy/BigEnemy/running.atlas",TextureAtlas.class);
        MyGame.manager.load("Enemy/BigEnemy/dying.atlas",TextureAtlas.class);
    }

    public static void Clean(){
        textureAtlasRunRight.dispose();
        textureAtlasAttackingRight.dispose();
        textureAtlasDying.dispose();
        textureAtlasRunLeft.dispose();
    }
}
