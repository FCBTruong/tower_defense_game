package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.mynta.gametowerdefense.MyGame;

public class Weapons {
    public static Texture textureArrow;
    public static Texture textureArrowLevel3;
    public static Texture textureArrowLevel4;

    public static Texture textureMagicBullet;
    public static Texture textureMagicBulletLevel2;
    public static Texture textureMagicBulletLevel3;

    public static Texture textureBulletTurretLevel1;
    public static Texture textureBulletTurretLevel3;
    public static Texture textureBulletTurretLevel4;

    public static void ManagerLoad(){
        MyGame.manager.load("Weapons/arrow.png", Texture.class);
        MyGame.manager.load("Weapons/arrowLevel3.png",Texture.class);
        MyGame.manager.load("Weapons/arrowLevel4.png",Texture.class);

        MyGame.manager.load("Weapons/magicBullet.png", Texture.class);
        MyGame.manager.load("Weapons/magicBulletLevel2.png",Texture.class);
        MyGame.manager.load("Weapons/magicBulletLevel3.png",Texture.class);

        MyGame.manager.load("Weapons/bulletTurretLevel1.png",Texture.class);
        MyGame.manager.load("Weapons/bulletTurretLevel3.png",Texture.class);
        MyGame.manager.load("Weapons/bulletTurretLevel4.png",Texture.class);
    }
    public static void LoadToProject(){
        textureArrow = MyGame.manager.get("Weapons/arrow.png");
        textureArrow.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureMagicBullet = MyGame.manager.get("Weapons/magicBullet.png");
        textureMagicBullet.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureMagicBulletLevel2 = MyGame.manager.get("Weapons/magicBulletLevel2.png");
        textureMagicBulletLevel2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureMagicBulletLevel3 = MyGame.manager.get("Weapons/magicBulletLevel3.png");
        textureMagicBulletLevel3.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureArrowLevel3 = MyGame.manager.get("Weapons/arrowLevel3.png");
        textureArrowLevel3.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureArrowLevel4 = MyGame.manager.get("Weapons/arrowLevel4.png");
        textureArrowLevel4.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureBulletTurretLevel1 = MyGame.manager.get("Weapons/bulletTurretLevel1.png");
        textureBulletTurretLevel1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureBulletTurretLevel3 = MyGame.manager.get("Weapons/bulletTurretLevel3.png");
        textureBulletTurretLevel3.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureBulletTurretLevel4 = MyGame.manager.get("Weapons/bulletTurretLevel4.png");
        textureBulletTurretLevel4.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public static void Clean(){
        textureArrow.dispose();
        textureArrowLevel3.dispose();
        textureArrowLevel4.dispose();

        textureMagicBullet.dispose();
        textureMagicBulletLevel2.dispose();
        textureMagicBulletLevel3.dispose();

        textureBulletTurretLevel1.dispose();
        textureBulletTurretLevel3.dispose();
        textureBulletTurretLevel4.dispose();
    }
}
