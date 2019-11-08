package com.mynta.gametowerdefense.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.mynta.gametowerdefense.MyGame;

public class TowerAssets {
    public static Texture texturePlaceTower;

    /** Archer Tower */
    public static Texture textureArcherTowerLevel1;
    public static Texture textureArcherTowerLevel2;
    public static Texture textureArcherTowerLevel3;
    public static Texture textureArcherTowerLevel4;

    /** Apprentice Mage Tower */
    public static Texture textureApprenticeMageTowerLevel1;
    public static Texture textureApprenticeMageTowerLevel2;
    public static Texture textureApprenticeMageTowerLevel3;

    /**  Turret Tower */
    public static Texture textureTurretTowerLevel1;
    public static Texture textureTurretTowerLevel2;
    public static Texture textureTurretTowerLevel3;
    public static Texture textureTurretTowerLevel4;

    public static void ManagerLoad(){
        MyGame.manager.load("Towers/towerPlace.png", Texture.class);
        MyGame.manager.load("Towers/Archer/towerArrowLevel1.png",Texture.class);
        MyGame.manager.load("Towers/Archer/towerArrowLevel2.png",Texture.class);
        MyGame.manager.load("Towers/Archer/towerArrowLevel3.png",Texture.class);
        MyGame.manager.load("Towers/Archer/towerArrowLevel4.png",Texture.class);

        MyGame.manager.load("Towers/ApprenticeMage/level1.png",Texture.class);
        MyGame.manager.load("Towers/ApprenticeMage/level2.png",Texture.class);
        MyGame.manager.load("Towers/ApprenticeMage/level3.png",Texture.class);

        MyGame.manager.load("Towers/Turret/turretTower1.png",Texture.class);
        MyGame.manager.load("Towers/Turret/turretTower2.png",Texture.class);
        MyGame.manager.load("Towers/Turret/turretTower3.png",Texture.class);
        MyGame.manager.load("Towers/Turret/turretTower4.png",Texture.class);

    }

    public static void LoadToProject(){
        texturePlaceTower = new Texture("Towers/towerPlace.png");
        texturePlaceTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        /** Load towers
         * Level 1, 2, 3 ...
         * Archer, Apprentice Mage, Army ...
         */
        textureArcherTowerLevel1 = MyGame.manager.get("Towers/Archer/towerArrowLevel1.png");
        textureArcherTowerLevel1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureArcherTowerLevel2 = MyGame.manager.get("Towers/Archer/towerArrowLevel2.png");
        textureArcherTowerLevel2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureArcherTowerLevel3 = MyGame.manager.get("Towers/Archer/towerArrowLevel3.png");
        textureArcherTowerLevel3.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureArcherTowerLevel4 = MyGame.manager.get("Towers/Archer/towerArrowLevel4.png");
        textureArcherTowerLevel4.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureApprenticeMageTowerLevel1 = MyGame.manager.get("Towers/ApprenticeMage/level1.png");
        textureApprenticeMageTowerLevel1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureApprenticeMageTowerLevel2 = MyGame.manager.get("Towers/ApprenticeMage/level2.png");
        textureApprenticeMageTowerLevel2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureApprenticeMageTowerLevel3 = MyGame.manager.get("Towers/ApprenticeMage/level3.png");
        textureApprenticeMageTowerLevel3.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureTurretTowerLevel1 = MyGame.manager.get("Towers/Turret/turretTower1.png");
        textureTurretTowerLevel1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureTurretTowerLevel2 = MyGame.manager.get("Towers/Turret/turretTower2.png");
        textureTurretTowerLevel2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureTurretTowerLevel3 = MyGame.manager.get("Towers/Turret/turretTower3.png");
        textureTurretTowerLevel3.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        textureTurretTowerLevel4 = MyGame.manager.get("Towers/Turret/turretTower4.png");
        textureTurretTowerLevel4.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    }

    public static void Clean(){
        textureArcherTowerLevel1.dispose();
        textureArcherTowerLevel2.dispose();
        textureArcherTowerLevel3.dispose();
        textureArcherTowerLevel4.dispose();

        textureApprenticeMageTowerLevel1.dispose();
        textureApprenticeMageTowerLevel2.dispose();
        textureApprenticeMageTowerLevel3.dispose();

        textureTurretTowerLevel1.dispose();
        textureTurretTowerLevel2.dispose();
        textureTurretTowerLevel3.dispose();
        textureTurretTowerLevel4.dispose();

        texturePlaceTower.dispose();
    }
}
