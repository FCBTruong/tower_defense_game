package com.mynta.gametowerdefense.characters.Army;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.ApprenticeMageAssets;
import com.mynta.gametowerdefense.Weapons.Bullet;
import com.mynta.gametowerdefense.Weapons.MagicBullet;
import com.mynta.gametowerdefense.characters.CommonCharacter;
import com.mynta.gametowerdefense.enums.CharacterStatus;
import com.mynta.gametowerdefense.enums.Direction;
import com.mynta.gametowerdefense.utils.CoOrdinate;

public class ApprenticeMage extends CommonCharacter {
    public boolean status; /** true: attacking, false: no thing */
    public Bullet magicBullet; /** weapon */
    public float coolTime = 0;

    public ApprenticeMage(){
        alive = new Sprite(ApprenticeMageAssets.textureAlive);
        alive.setSize(width - 10,height);
        alive.setPosition(positionCurrent.x,positionCurrent.y + 50);
        width = 150;
        height = 150;

        status = false;
        damage = 15;
        direction = Direction.GO_LEFT;
        characterStatus = CharacterStatus.ALIVE;
        attackingAnimationLeft.setScale(2);
        attackingAnimationLeft.setAnimation(ApprenticeMageAssets.textureAtlasAttack);

        /** Set Weapon : arrow */
        magicBullet = new MagicBullet();
        magicBullet.setPosition(positionCenter);
    }

    public void setPosition(CoOrdinate position){
        super.setPosition(position);
        alivePosition.y = positionCurrent.x;
        alivePosition.y = positionCurrent.y + 20;
        magicBullet.setPosition(new CoOrdinate(positionCenter.x,positionCenter.y));
    }

    /** apprentice Mage shoot */
    public boolean shoot(CoOrdinate destination){
        if(magicBullet.move(destination)) {
            return true;
        }
        return  false;
    }

    /** display movement of arrow */
    public void showArrow(SpriteBatch batch){
        magicBullet.show(batch);
    }
}
