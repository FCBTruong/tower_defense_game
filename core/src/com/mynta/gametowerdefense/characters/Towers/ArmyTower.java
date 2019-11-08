package com.mynta.gametowerdefense.characters.Towers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.TowerAssets;
import com.mynta.gametowerdefense.characters.Army.ArmyInfantry;
import com.mynta.gametowerdefense.characters.CommonCharacter;
import com.mynta.gametowerdefense.utils.CoOrdinate;

public class ArmyTower extends Tower {
    private ArmyInfantry a;
    private float coolTime;
    public float timeOff;

    public ArmyTower(){
        a = new ArmyInfantry();
        a.setPosition(new CoOrdinate(positionCenter.x,positionCenter.y));
        placeTower = new Sprite(TowerAssets.textureArcherTowerLevel1);
        placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 10);
        coolTime = 0;
        price = 76;
        levelCurrent = 1;
        levelMax = 4;
        towerType = TowerType.ARMY_INFANTRY;
        damage = 1;
        a.positionOrigin = new CoOrdinate(positionCenter.x,positionCenter.y);
    }

    public void upGrade(){

    }

    public void setPosition(CoOrdinate position){
        super.setPosition(position);
        a.setPosition(new CoOrdinate(positionCenter.x ,positionCenter.y- 300));
        a.setPositionOrigin(new CoOrdinate(positionCenter.x ,positionCenter.y- 300));
        placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 10);
    }

    public void showFirst(SpriteBatch batch) {
        super.showFirst(batch);
        a.show(batch);
    }

    public void attack() {
        a.attack();
    }

    public boolean radar(CommonCharacter enemy){
        a.radar(enemy);
        return false;
    }
}
