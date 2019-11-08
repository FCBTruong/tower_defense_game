package com.mynta.gametowerdefense.characters.Army;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mynta.gametowerdefense.Assets.ArmyInfantryAssets;
import com.mynta.gametowerdefense.Assets.BigEnemyAssets;
import com.mynta.gametowerdefense.characters.CommonCharacter;
import com.mynta.gametowerdefense.enums.CharacterStatus;
import com.mynta.gametowerdefense.utils.CalculationFunction;
import com.mynta.gametowerdefense.utils.CoOrdinate;

/** A ArmyInfantry is an army that protects the base and fights the enemies.
 * the part of an army that fights on foot.
 * ...
 */

public class ArmyInfantry extends CommonCharacter {

    private boolean status = false; // busy or free
    public CoOrdinate positionOrigin;

    public ArmyInfantry (){
        positionCurrent.x = 0;
        positionCurrent.y = 1000;
        runningAnimationRight.setScale(1.2f);
        runningAnimationRight.setAnimation(ArmyInfantryAssets.textureAtlasRunningRight);

        attackingAnimationRight.setBool(false);
        attackingAnimationRight.setScale(1);
        attackingAnimationLeft.setAnimation(ArmyInfantryAssets.textureAtlasAttacking);
        attackingAnimationRight.setAnimation(ArmyInfantryAssets.textureAtlasAttacking);
        alive = new Sprite(ArmyInfantryAssets.textureAlive);

        dyingAnimation.setScale(1.3f);
        dyingAnimation.setAnimation(BigEnemyAssets.textureAtlasDying);
        setBlood(100);
        setDamage(10);
        width = 150;
        height = 150;
        disXofPositionBlood = 30;
        disYofPositionBlood = 130;
        speed = 2f;
        characterStatus = CharacterStatus.ALIVE;
        value = 0;
    }

    public void setPositionOrigin(CoOrdinate positionOrigin) {
        this.positionOrigin = positionOrigin;
    }

    public boolean radar(CommonCharacter enemy){
        if(status) return false;
        if(characterStatus == CharacterStatus.ALIVE) {
            float r = (positionCenter.x - enemy.positionCenter.x) * (positionCenter.x - enemy.positionCenter.x) +
                    (positionCenter.y - enemy.positionCenter.y) * (positionCenter.y - enemy.positionCenter.y);
            if(r < 40000){
                status = true;
                this.enemy = enemy;
                enemy.setEnemy(this);
                return true;
            }
        }
        return false;
    }

    @Override
    public void attack() {
        if(!status) return;
        float r = (enemy.positionCenter.x - positionOrigin.x) * (enemy.positionCenter.x - positionOrigin.x) +
                (enemy.positionCenter.y - positionOrigin.y) * (enemy.positionCenter.y - positionOrigin.y);
        if(r >= 40000){
            status = false;
            characterStatus = CharacterStatus.RUN;
            CalculationFunction.move(positionCenter,positionOrigin, speed);{
                characterStatus = CharacterStatus.ALIVE;
            }
            return;
        }

        if(characterStatus == characterStatus.FIGHT){
            super.attack();
            enemy.attack();
            if(enemy.characterStatus == CharacterStatus.DEAD) {
                System.out.println("122");
                characterStatus = CharacterStatus.ALIVE;
                status = false;
            }
            if(enemy.characterStatus == CharacterStatus.FIGHT && characterStatus == CharacterStatus.DEAD)
                enemy.characterStatus = CharacterStatus.RUN;
            return;
        }

        if(CalculationFunction.moveToFight(positionCenter,new CoOrdinate(enemy.positionCenter.x + 80,enemy.positionCenter.y),
                speed)) {
            characterStatus = CharacterStatus.FIGHT;
            enemy.characterStatus = CharacterStatus.FIGHT;
        }
        super.setPosition(new CoOrdinate(positionCenter.x - width/2, positionCenter.y - height/2));
    }
}
