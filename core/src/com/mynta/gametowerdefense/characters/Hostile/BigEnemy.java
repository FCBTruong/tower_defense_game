package com.mynta.gametowerdefense.characters.Hostile;

import com.mynta.gametowerdefense.Assets.BigEnemyAssets;
import com.mynta.gametowerdefense.characters.CommonCharacter;

public class BigEnemy extends CommonCharacter {
    public BigEnemy(){
        runningAnimationRight.setScale(1.2f);
        runningAnimationRight.setAnimation(BigEnemyAssets.textureAtlasRunRight);
        dyingAnimation.setScale(1.3f);
        dyingAnimation.setAnimation(BigEnemyAssets.textureAtlasDying);
        attackingAnimationRight.setAnimation(BigEnemyAssets.textureAtlasAttacking);
        attackingAnimationLeft.setAnimation(BigEnemyAssets.textureAtlasAttacking);
        setBlood(200);
        setDamage(20);
        disXofPositionBlood = 67;
        disYofPositionBlood = 155;
        width = 225;
        height = 150;
        value = 10;
    }
    public BigEnemy(int type){
        switch (type){
            case 1:
                runningAnimationRight.setAnimation(BigEnemyAssets.textureAtlasRunRight);
                break;
        }
    }
}
