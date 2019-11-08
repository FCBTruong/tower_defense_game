package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mynta.gametowerdefense.MyGame;

public class WindmillAssets {
    public static TextureAtlas textureAtlasWindmill;
    public static Texture texturePost;

    public static void ManagerLoad(){
        MyGame.manager.load("Scenery/windmill.atlas",TextureAtlas.class);
        MyGame.manager.load("Scenery/postWind.png",Texture.class);
    }

    public static void LoadToProject(){
        textureAtlasWindmill = MyGame.manager.get("Scenery/windmill.atlas");
        texturePost = MyGame.manager.get("Scenery/postWind.png");
        texturePost.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public static void Clean(){
        texturePost.dispose();
        textureAtlasWindmill.dispose();
    }
}
