package com.mynta.gametowerdefense.characters.Towers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.CommonAssets;
import com.mynta.gametowerdefense.Assets.TowerAssets;
import com.mynta.gametowerdefense.Weapons.MagicBullet;
import com.mynta.gametowerdefense.characters.Army.ApprenticeMage;
import com.mynta.gametowerdefense.enums.CharacterStatus;
import com.mynta.gametowerdefense.stages.PlayGame;
import com.mynta.gametowerdefense.utils.CoOrdinate;

public class ApprenticeMageTower extends Tower {
    ApprenticeMage apprenticeMage;
    private float coolTimeMax;
    public ApprenticeMageTower(){
        priceUp = 70;
        levelMax = 3;
        price = 100;
        placeTower = new Sprite(TowerAssets.textureApprenticeMageTowerLevel1);
        placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 10);
        towerType = TowerType.APPRENTICE_MAGE;
        apprenticeMage = new ApprenticeMage();
        apprenticeMage.setPosition(new CoOrdinate(position.x + 55,position.y + 121));
        damage = 25;
        coolTimeMax = 20;
    }

    public void setPosition(CoOrdinate position){
        super.setPosition(position);
        apprenticeMage.setPosition(new CoOrdinate(position.x + 55,position.y + 123));
        placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 10);
    }

    public void upGrade(){
        if(levelCurrent < levelMax){
            levelCurrent ++;
            switch (levelCurrent){
                case 2:
                    placeTower = new Sprite(TowerAssets.textureApprenticeMageTowerLevel2);
                    apprenticeMage.magicBullet = new MagicBullet(2);
                    apprenticeMage.magicBullet.setPosition(new CoOrdinate(apprenticeMage.positionCenter.x,apprenticeMage.positionCenter.y));
                    damage += 25;
                    coolTimeMax = 18;
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 10);
                    break;
                case 3:
                    upGradeTower = new Sprite(CommonAssets.textureCanNotUpGrade);
                    placeTower = new Sprite(TowerAssets.textureApprenticeMageTowerLevel3);
                    apprenticeMage.magicBullet = new MagicBullet(3);
                    apprenticeMage.magicBullet.setPosition(new CoOrdinate(apprenticeMage.positionCenter.x,apprenticeMage.positionCenter.y));
                    damage += 30;
                    coolTimeMax = 16;
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 10);
                    break;
            }
        }
    }
    public void showFirst(SpriteBatch batch) {
        super.showFirst(batch);
        if(apprenticeMage.status) apprenticeMage.showArrow(batch);
        apprenticeMage.show(batch);
    }

    public void attack() {
        if(apprenticeMage.coolTime <= coolTimeMax){
            apprenticeMage.characterStatus = CharacterStatus.FIGHT;
            apprenticeMage.coolTime += 0.5;
        }
        else {
            apprenticeMage.status = true;
            apprenticeMage.characterStatus = CharacterStatus.ALIVE;
            if (apprenticeMage.shoot(enemy.positionCenter) == true) {
                enemy.bloodCurrent -= damage;
                towerStatus = TowerStatus.NONE;
                apprenticeMage.status = false;
                apprenticeMage.magicBullet.setPosition(apprenticeMage.positionCenter);
                apprenticeMage.coolTime = 0;
            }
        }
    }
}
