package com.mynta.gametowerdefense.characters.Towers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.SoundAssets;
import com.mynta.gametowerdefense.Assets.TowerAssets;
import com.mynta.gametowerdefense.Weapons.Arrow;
import com.mynta.gametowerdefense.characters.Army.Archer;
import com.mynta.gametowerdefense.enums.CharacterStatus;
import com.mynta.gametowerdefense.enums.Direction;
import com.mynta.gametowerdefense.stages.PlayGame;
import com.mynta.gametowerdefense.utils.CoOrdinate;
import com.mynta.gametowerdefense.utils.Constants;

/**
 * have 2-3 archers
 *  Attack Damage
 *  Not attacked
 */

public class ArcherTower extends Tower {
    private Archer archer;
    private float coolTime;
    public float timeOff;

    public ArcherTower(){
        archer = new Archer();
        archer.setPosition(new CoOrdinate(position.x + 60,position.y + 130));
        placeTower = new Sprite(TowerAssets.textureArcherTowerLevel1);
        placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 10);
        coolTime = 0;
        price = 76;
        levelCurrent = 1;
        levelMax = 4;
        towerType = TowerType.ARCHER;
        damage = 10;
    }

    public void upGrade(){
        if(levelCurrent < levelMax){
            levelCurrent ++;
            switch (levelCurrent){
                case 2:
                    placeTower = new Sprite(TowerAssets.textureArcherTowerLevel2);
                    damage += 10;
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 10);
                    break;
                case 3:
                    placeTower = new Sprite(TowerAssets.textureArcherTowerLevel3);
                    archer.arrow = new Arrow(3);
                    archer.arrow.setPosition(new CoOrdinate(archer.positionCenter.x,archer.positionCenter.y));
                    damage += 15;
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 10);
                    break;
                case 4:
                    placeTower = new Sprite(TowerAssets.textureArcherTowerLevel4);
                    placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 10);
                    archer.arrow = new Arrow(4);
                    archer.arrow.setPosition(new CoOrdinate(archer.positionCenter.x,archer.positionCenter.y));
                    damage += 15;
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    break;
            }
        }
    }

    public void setPosition(CoOrdinate position){
        super.setPosition(position);
        archer.setPosition(new CoOrdinate(position.x + 60,position.y + 130));
        placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2 + 10);
    }

    public void showFirst(SpriteBatch batch) {
        super.showFirst(batch);
        if(archer.status) archer.showArrow(batch);
        archer.show(batch);
    }

    public void attack() {
            if(archer.coolTime <= 15){
                if(archer.characterStatus == CharacterStatus.ALIVE)
                    if(Constants.SOUND_STATUS) SoundAssets.arrowSound.play();
                archer.characterStatus = CharacterStatus.FIGHT;
                archer.coolTime += 0.5;
            }
            else {
                if(archer.positionCenter.x > enemy.positionCenter.x){
                    archer.direction = Direction.GO_LEFT;
                }
                else archer.direction = Direction.GO_RIGHT;
                archer.status = true;
                archer.characterStatus = CharacterStatus.ALIVE;
                if (archer.shoot(enemy.positionCenter) == true) {
                    enemy.bloodCurrent -= damage;
                    towerStatus = TowerStatus.NONE;
                    archer.status = false;
                    archer.arrow.setPosition(archer.positionCenter);
                    archer.coolTime = 0;
                }
            }
    }
}
