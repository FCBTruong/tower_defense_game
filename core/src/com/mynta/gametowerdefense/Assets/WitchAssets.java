package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mynta.gametowerdefense.MyGame;


/** Include assets of a Witch Object such as:
 *  textureAtlas
 *  sounds
 *  ...
 */
public class WitchAssets {
    public static TextureAtlas textureAtlasRunning; // to run
    public static TextureAtlas textureAtlasDying;    // dead
    public static TextureAtlas textureAtlasAttacking; // to fight

    public static void ManagerLoad(){
        MyGame.manager.load("Enemy/Witch01/Running/running.atlas",TextureAtlas.class);
        MyGame.manager.load("Enemy/Witch01/Dying/dying.atlas", TextureAtlas.class);
        MyGame.manager.load("Enemy/Witch01/Attacking/attacking.atlas",TextureAtlas.class);
    }

    /** Load Assets */
    public static void LoadToProject(){
        textureAtlasRunning = MyGame.manager.get("Enemy/Witch01/Running/running.atlas");
        textureAtlasDying = MyGame.manager.get("Enemy/Witch01/Dying/dying.atlas");
        textureAtlasAttacking = MyGame.manager.get("Enemy/Witch01/Attacking/attacking.atlas");
    }

    public static void Clean(){
        textureAtlasRunning.dispose();
        textureAtlasAttacking.dispose();
        textureAtlasDying.dispose();
    }
}
