package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.mynta.gametowerdefense.MyGame;

public class MapAssets extends Assets{
    public static Texture textureMapLevel1;

    public static void ManagerLoad(){
        MyGame.manager.load("Scenery/map_Level01.png",Texture.class);
    }

    public static void LoadToProject(){
        textureMapLevel1 = MyGame.manager.get("Scenery/map_Level01.png");
        textureMapLevel1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public static void Clean(){
        textureMapLevel1.dispose();
    }
}
