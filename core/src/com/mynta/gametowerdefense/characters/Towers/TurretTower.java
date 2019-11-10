package com.mynta.gametowerdefense.characters.Towers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.TowerAssets;
import com.mynta.gametowerdefense.Weapons.TurretBullet;
import com.mynta.gametowerdefense.enums.CharacterStatus;
import com.mynta.gametowerdefense.stages.PlayGame;
import com.mynta.gametowerdefense.utils.CoOrdinate;

public class TurretTower extends Tower {
    private CharacterStatus status;
    private final int BULLET_NUMBER = 5;
    private TurretBullet bullet;

    public TurretTower(){
        placeTower = new Sprite(TowerAssets.textureTurretTowerLevel1);
        placeTower.setPosition(positionCenter.x - 200, positionCenter.y - 70);
        bullet = new TurretBullet();
        bullet.setPosition(new CoOrdinate(positionCenter.x - 10,positionCenter.y + 80));
        price = 80;
        levelCurrent = 1;
        levelMax = 4;
        towerType = TowerType.TURRET;
        damage = 3;
        priceUp = 70;
    }

    public void setPosition(CoOrdinate position){
        super.setPosition(position);
        bullet.setPosition(new CoOrdinate(positionCenter.x - 10,positionCenter.y + 80));
        placeTower.setPosition(positionCenter.x - 75, positionCenter.y - 70);
    }

    public void showFirst(SpriteBatch batch){
        super.showFirst(batch);
        if(bullet.status){
            bullet.show(batch);
        }
    }

    public void upGrade(){
        if(levelCurrent < levelMax){
            levelCurrent ++;
            switch (levelCurrent){
                case 2:
                    placeTower = new Sprite(TowerAssets.textureTurretTowerLevel2);
                    damage += 4;
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    placeTower.setPosition(positionCenter.x - 75, positionCenter.y - 70);
                    break;
                case 3:
                    placeTower = new Sprite(TowerAssets.textureTurretTowerLevel3);
                    bullet = new TurretBullet(3);
                    bullet.setPosition(new CoOrdinate(positionCenter.x - 10,positionCenter.y + 80));
                    damage += 5;
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    placeTower.setPosition(positionCenter.x - 75, positionCenter.y - 70);
                    break;
                case 4:
                    placeTower = new Sprite(TowerAssets.textureTurretTowerLevel4);
                    placeTower.setPosition(positionCenter.x - 75, positionCenter.y - 70);
                    bullet = new TurretBullet(4);
                    bullet.setPosition(new CoOrdinate(positionCenter.x - 10,positionCenter.y + 80));
                    damage += 7;
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    break;
            }
        }
    }

    public void attack() {
        bullet.status = true;
        if (bullet.move(enemy.positionCenter) == true) {
            enemy.bloodCurrent -= damage;
            towerStatus = TowerStatus.NONE;
            bullet.status = false;
            bullet.setPosition(new CoOrdinate(positionCenter.x - 15,positionCenter.y + 70));
        }
    }
}
