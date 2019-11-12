package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.mynta.gametowerdefense.MyGame;

public class MapAssets extends Assets{
    public static Texture textureMapLevel1;
    public static Texture textureMapLevel2;

    public static void ManagerLoad(){
        MyGame.manager.load("Scenery/map_Level01.png",Texture.class);
        MyGame.manager.load("Scenery/map_Level02.png",Texture.class);
    }

    public static void LoadToProject(){
        textureMapLevel1 = MyGame.manager.get("Scenery/map_Level01.png");
        textureMapLevel1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureMapLevel2 = MyGame.manager.get("Scenery/map_Level02.png");
        textureMapLevel2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public static void Clean(){
        textureMapLevel1.dispose();
        textureMapLevel2.dispose();
    }
}
