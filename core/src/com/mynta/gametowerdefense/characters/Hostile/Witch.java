package com.mynta.gametowerdefense.characters.Hostile;

import com.mynta.gametowerdefense.Assets.WitchAssets;
import com.mynta.gametowerdefense.characters.CommonCharacter;


/** WITCH
 * an enemy
 */

public class Witch extends CommonCharacter {
    /** set Witch */
    public Witch(){
        runningAnimationRight.setAnimation(WitchAssets.textureAtlasRunning);
        dyingAnimation.setAnimation(WitchAssets.textureAtlasDying);
        attackingAnimationRight.setAnimation(WitchAssets.textureAtlasAttacking);
        setBlood(100);
        width = 120;
        height = 120;
        value = 5;
        damage = 5;
    }

}
