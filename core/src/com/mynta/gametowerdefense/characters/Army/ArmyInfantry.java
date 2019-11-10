package com.mynta.gametowerdefense.characters.Army;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.ArmyInfantryAssets;
import com.mynta.gametowerdefense.Assets.CommonAssets;
import com.mynta.gametowerdefense.characters.CharacterType;
import com.mynta.gametowerdefense.characters.CommonCharacter;
import com.mynta.gametowerdefense.enums.CharacterStatus;
import com.mynta.gametowerdefense.enums.Direction;
import com.mynta.gametowerdefense.utils.CalculationFunction;
import com.mynta.gametowerdefense.utils.CoOrdinate;

/** A ArmyInfantry is an army that protects the base and fights the enemies.
 * the part of an army that fights on foot.
 * ...
 */

public class ArmyInfantry extends CommonCharacter {

    public CoOrdinate positionOrigin;
    private float radius;
    public float timeRevive; // Time to Revive;

    public ArmyInfantry (){
        characterType = CharacterType.ARMY_INFANTRY;
        positionCurrent.x = 0;
        positionCurrent.y = 1000;

        runningAnimationRight.setAnimation(ArmyInfantryAssets.textureAtlasRunningRight);
        runningAnimationLeft.setAnimation(ArmyInfantryAssets.textureAtlasRunningLeft);

        attackingAnimationRight.setBool(false);
        attackingAnimationRight.setScale(1);
        attackingAnimationLeft.setAnimation(ArmyInfantryAssets.textureAtlasAttacking);
        attackingAnimationRight.setAnimation(ArmyInfantryAssets.textureAtlasAttacking);
        alive = new Sprite(ArmyInfantryAssets.textureAlive);

        dyingAnimation.setScale(1.3f);
        dyingAnimation.setAnimation(ArmyInfantryAssets.textureAtlasDying);

        spriteBlood = new Sprite(CommonAssets.textureBloodArmy);

        setBlood(100);
        setDamage(20);
        width = 150;
        height = 150;
        disXofPositionBlood = 40;
        disYofPositionBlood = 130;
        speed = 2;
        characterStatus = CharacterStatus.ALIVE;
        value = 0;
        direction = Direction.GO_LEFT;
        radius = 200;
        timeRevive = 200;
    }

    public void setPositionOrigin(CoOrdinate positionOrigin) {
        this.positionOrigin = positionOrigin;
    }

    public boolean radar(CommonCharacter enemy){
        if(status) return false;
        if(characterStatus == CharacterStatus.ALIVE) {
            float r = (positionOrigin.x - enemy.positionCenter.x) * (positionOrigin.x - enemy.positionCenter.x) +
                    (positionOrigin.y - enemy.positionCenter.y) * (positionOrigin.y - enemy.positionCenter.y);
            if(r < radius * radius){
                if(enemy.positionCenter.x + 70 > positionCenter.x){
                    direction = Direction.GO_RIGHT;
                }
                else direction = Direction.GO_LEFT;

                status = true;
                enemy.status = true;
                enemy.setSpeed(0.5f);
                this.enemy = enemy;
                enemy.setEnemy(this);
                return true;
            }
        }
        return false;
    }

    @Override
    public void attack() {
        if(characterStatus == CharacterStatus.DEAD || characterStatus == CharacterStatus.NONE){
            if(enemy.characterStatus != CharacterStatus.DEAD && enemy.characterStatus != CharacterStatus.NONE)
                enemy.characterStatus = characterStatus.RUN;
            enemy.setEnemy(new CommonCharacter());
            enemy.status = false;
            enemy.setSpeed(2);
            enemy = new CommonCharacter();
            status = false;
        }

        if(status)
            if(enemy.characterStatus == CharacterStatus.FIGHT && characterStatus == CharacterStatus.DEAD) {
            enemy.characterStatus = CharacterStatus.RUN;
            status = false;
            enemy.setSpeed(2);
            enemy.status = false;
            return;
        }

        if(characterStatus == CharacterStatus.DEAD || characterStatus == CharacterStatus.NONE) return;
        if(!status) {
            if(!CalculationFunction.move(positionCenter,positionOrigin,speed)) {
                if (positionOrigin.x < positionCenter.x) {
                    direction = Direction.GO_LEFT;
                } else direction = Direction.GO_RIGHT;
                characterStatus = CharacterStatus.RUN;
            }
            else characterStatus = CharacterStatus.ALIVE;
            super.setPosition(new CoOrdinate(positionCenter.x - width/2, positionCenter.y - height/2));
            return;
        }
        float r = (enemy.positionCenter.x - positionOrigin.x) * (enemy.positionCenter.x - positionOrigin.x) +
                (enemy.positionCenter.y - positionOrigin.y) * (enemy.positionCenter.y - positionOrigin.y);
        if(r >= radius * radius){
            enemy.setSpeed(2);
            enemy.status = true;
            status = false;
            characterStatus = CharacterStatus.ALIVE;
            return;
        }

        if(characterStatus == characterStatus.FIGHT){
            super.attack();
            enemy.attack();
            if(enemy.characterStatus == CharacterStatus.DEAD) {
                characterStatus = CharacterStatus.ALIVE;
                status = false;
            }
            return;
        }

        if(CalculationFunction.moveToFight(positionCenter,new CoOrdinate(enemy.positionCenter.x + 70,enemy.positionCenter.y),
                speed)) {
            if(enemy.positionCenter.x + 70 > positionCenter.x){
                direction = Direction.GO_LEFT;
            }
            else direction = Direction.GO_RIGHT;
            characterStatus = CharacterStatus.FIGHT;
            enemy.characterStatus = CharacterStatus.FIGHT;
        }
        else characterStatus = CharacterStatus.RUN;
        super.setPosition(new CoOrdinate(positionCenter.x - width/2, positionCenter.y - height/2));
    }

    public void show(SpriteBatch batch) {
        super.show(batch);
        if (characterStatus == CharacterStatus.ALIVE) {
            if (bloodCurrent < bloodInitial) {
                bloodCurrent += 0.02f;
            }
            else{
                bloodCurrent = bloodInitial;
            }
        }
    }
}

