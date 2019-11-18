package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mynta.gametowerdefense.MyGame;

public class AuxiliaryAssets extends Assets {
    public static TextureAtlas light;
    public static Texture lightingIcon;
    public static Texture lightingIconOff;

    public static TextureAtlas textureAtlasFire;
    public static Texture fireIcon;

    public static Texture loading;
    public static Texture frameOfIcon;

    public static void ManagerLoad(){
        MyGame.manager.load("Common/lighting.atlas",TextureAtlas.class);
        MyGame.manager.load("Common/lightingIcon.png",Texture.class);
        MyGame.manager.load("Common/frameOfLightingIcon.png",Texture.class);
        MyGame.manager.load("Common/lightingIconOff.png",Texture.class);
        MyGame.manager.load("Common/loadingLighting.png",Texture.class);
        MyGame.manager.load("Common/fire.atlas",TextureAtlas.class);
        MyGame.manager.load("Common/fireIcon.png",Texture.class);
    }

    public static void LoadToProject(){
        light = MyGame.manager.get("Common/lighting.atlas");
        lightingIcon = MyGame.manager.get("Common/lightingIcon.png");
        lightingIcon.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        frameOfIcon = MyGame.manager.get("Common/frameOfLightingIcon.png");
        frameOfIcon.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        lightingIconOff = MyGame.manager.get("Common/lightingIconOff.png");
        lightingIconOff.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        loading = MyGame.manager.get("Common/loadingLighting.png");
        loading.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureAtlasFire = MyGame.manager.get("Common/fire.atlas");
        fireIcon = MyGame.manager.get("Common/fireIcon.png");
    }

    public static void Clean(){
        lightingIcon.dispose();
        light.dispose();
        frameOfIcon.dispose();
        lightingIconOff.dispose();
        loading.dispose();

        textureAtlasFire.dispose();
        fireIcon.dispose();
    }
}
