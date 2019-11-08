package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mynta.gametowerdefense.MyGame;

public class FlyMonsterAssets {
    public static TextureAtlas textureAtlasFlyMonsterRight; /** fly to the right */
    public static TextureAtlas getTextureAtlasFlyMonsterUp; /** fly to left */
    public static TextureAtlas textureAtlasDying;


    public static void ManagerLoad(){
        MyGame.manager.load("Enemy/Fly_Monsters/Level01/flyingRight.atlas",TextureAtlas.class);
        MyGame.manager.load("Enemy/Fly_Monsters/Level01/dying.atlas",TextureAtlas.class);
        MyGame.manager.load("Enemy/Fly_Monsters/Level01/flyingUp.atlas",TextureAtlas.class);
    }

    public static void LoadToProject(){
        textureAtlasFlyMonsterRight= MyGame.manager.get("Enemy/Fly_Monsters/Level01/flyingRight.atlas");
        textureAtlasDying = MyGame.manager.get("Enemy/Fly_Monsters/Level01/dying.atlas");
        getTextureAtlasFlyMonsterUp = MyGame.manager.get("Enemy/Fly_Monsters/Level01/flyingUp.atlas");
    }

    public static void Clean(){
        textureAtlasDying.dispose();
        textureAtlasFlyMonsterRight.dispose();
        getTextureAtlasFlyMonsterUp.dispose();
    }
}
