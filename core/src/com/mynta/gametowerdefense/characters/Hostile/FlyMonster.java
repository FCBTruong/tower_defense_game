package com.mynta.gametowerdefense.characters.Hostile;

import com.mynta.gametowerdefense.Assets.FlyMonsterAssets;
import com.mynta.gametowerdefense.characters.CommonCharacter;

/** FLY MONSTERS.
 * It's an enemy that can fly.
 */

public class FlyMonster extends CommonCharacter {
   public FlyMonster(){
       runningAnimationRight.setAnimation(FlyMonsterAssets.textureAtlasFlyMonsterRight);
       runningAnimationUp.setAnimation(FlyMonsterAssets.getTextureAtlasFlyMonsterUp);
       dyingAnimation.setAnimation(FlyMonsterAssets.textureAtlasDying);
       width = 150;
       height = 150;
       disXofPositionBlood = 20;
       disYofPositionBlood = 130;
       value = 5; // coins
       speed = 2;
       damage = 5;
   }
}
