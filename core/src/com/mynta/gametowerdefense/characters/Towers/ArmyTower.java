package com.mynta.gametowerdefense.characters.Towers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.TowerAssets;
import com.mynta.gametowerdefense.characters.Army.ArmyInfantry;
import com.mynta.gametowerdefense.characters.CommonCharacter;
import com.mynta.gametowerdefense.enums.CharacterStatus;
import com.mynta.gametowerdefense.stages.PlayGame;
import com.mynta.gametowerdefense.utils.CoOrdinate;

public class ArmyTower extends Tower {
    private ArmyInfantry army1;
    private ArmyInfantry army2;
    private ArmyInfantry army3;
    private float coolTime;
    public float timeOff;

    public ArmyTower(){
        army1 = new ArmyInfantry();
        army2 = new ArmyInfantry();
        army3 = new ArmyInfantry();

        placeTower = new Sprite(TowerAssets.textureArmyTowerLevel1);
        placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 50);
        coolTime = 0;
        price = 70;
        levelCurrent = 1;
        levelMax = 4;
        towerType = TowerType.ARMY_INFANTRY;
        damage = 1;
        army1.positionOrigin = new CoOrdinate(positionCenter.x,positionCenter.y);
        army2.positionOrigin = new CoOrdinate(positionCenter.x,positionCenter.y);
        army3.positionOrigin = new CoOrdinate(positionCenter.x,positionCenter.y);
    }

    public void upGrade(){
        if(levelCurrent < levelMax){
            levelCurrent ++;
            switch (levelCurrent){
                case 2:
                    placeTower = new Sprite(TowerAssets.textureArmyTowerLevel2);
                    army1.setDamage(30);
                    army2.setDamage(30);
                    army3.setDamage(30);
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 50);
                    break;
                case 3:
                    placeTower = new Sprite(TowerAssets.textureArmyTowerLevel3);
                    army1.setDamage(40);
                    army2.setDamage(40);
                    army3.setDamage(40);
                    army1.setBlood(150);
                    army1.setBlood(150);
                    army1.setBlood(150);
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 50);
                    break;
                case 4:
                    army1.setDamage(50);
                    army2.setDamage(50);
                    army3.setDamage(50);
                    army1.setBlood(200);
                    army1.setBlood(200);
                    army1.setBlood(200);
                    placeTower = new Sprite(TowerAssets.textureArmyTowerLevel4);
                    placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 50);
                    damage += 15;
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    break;
            }
        }
    }

    public void setPosition(CoOrdinate position){
        super.setPosition(position);
        army1.setPosition(new CoOrdinate(positionCenter.x - 50,positionCenter.y - 40));
        army2.setPosition(new CoOrdinate(positionCenter.x - 50,positionCenter.y - 40));
        army3.setPosition(new CoOrdinate(positionCenter.x - 50,positionCenter.y - 40));

        placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 45);

        army1.positionOrigin = positionOrigin;
        army2.positionOrigin = new CoOrdinate(positionOrigin.x - 50, positionOrigin.y + 50);
        army3.positionOrigin = new CoOrdinate(positionOrigin.x - 50, positionOrigin.y - 50);
    }


    public void showFirst(SpriteBatch batch) {
        if(army1.characterStatus == CharacterStatus.NONE){
            if(army1.timeRevive == 0){
                army1.characterStatus = CharacterStatus.ALIVE;
                army1.setBlood(army1.getBloodInitial());
                army1.setPosition(new CoOrdinate(positionCenter.x - 50,positionCenter.y - 40));
                army1.timeRevive = 300;
            }
            else army1.timeRevive -= 0.5f;
        }

        if(army2.characterStatus == CharacterStatus.NONE){
            if(army2.timeRevive == 0){
                army2.characterStatus = CharacterStatus.ALIVE;
                army2.setBlood(army2.getBloodInitial());
                army2.setPosition(new CoOrdinate(positionCenter.x - 50,positionCenter.y - 40));
                army2.timeRevive = 300;
            }
            else army2.timeRevive -= 0.5f;
        }

        if(army3.characterStatus == CharacterStatus.NONE){
            if(army3.timeRevive == 0){
                army3.characterStatus = CharacterStatus.ALIVE;
                army3.setBlood(army3.getBloodInitial());
                army3.setPosition(new CoOrdinate(positionCenter.x - 50,positionCenter.y - 40));
                army3.timeRevive = 300;
            }
            else army3.timeRevive -= 0.5f;
        }

        army1.show(batch);
        army2.show(batch);
        army3.show(batch);
        super.showFirst(batch);
    }

    public void attack() {
        army1.attack();
        army2.attack();
        army3.attack();
    }

    public boolean radar(CommonCharacter enemy){
        if(enemy.status == true) return false;
        if(army1.radar(enemy)) return false;
        if(army2.radar(enemy)) return false;
        if(army3.radar(enemy)) return false;
        return false;
    }

    public void deleteEnemy(){
        army1.deleteEnemy();
        army2.deleteEnemy();
        army3.deleteEnemy();
    }
}
