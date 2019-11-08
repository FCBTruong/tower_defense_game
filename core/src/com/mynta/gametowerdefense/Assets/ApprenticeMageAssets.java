package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mynta.gametowerdefense.MyGame;

public class ApprenticeMageAssets extends Assets{
    public static TextureAtlas textureAtlasAttack;
    public static Texture textureAlive;

    public static void ManagerLoad(){
        MyGame.manager.load("Army/Apprentice_Mage/apprenticeMageAttack.atlas",TextureAtlas.class);
        MyGame.manager.load("Army/Apprentice_Mage/alive.png",Texture.class);
    }

    public static void LoadToProject(){
        textureAtlasAttack = MyGame.manager.get("Army/Apprentice_Mage/apprenticeMageAttack.atlas");
        textureAlive = MyGame.manager.get("Army/Apprentice_Mage/alive.png");
        textureAlive.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public static void Clean(){
        textureAtlasAttack.dispose();
        textureAlive.dispose();
    }
}
