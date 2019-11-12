package com.mynta.gametowerdefense.characters.Army;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.ArcherAssets;
import com.mynta.gametowerdefense.Weapons.Arrow;
import com.mynta.gametowerdefense.Weapons.Bullet;
import com.mynta.gametowerdefense.characters.CommonCharacter;
import com.mynta.gametowerdefense.enums.CharacterStatus;
import com.mynta.gametowerdefense.enums.Direction;
import com.mynta.gametowerdefense.utils.CoOrdinate;

public class Archer extends CommonCharacter {
    public boolean status; /** true: attacking, false: no thing */
    public Bullet arrow; /** weapon */
    public float coolTime = 0;

    public Archer(){
        alive = new Sprite(ArcherAssets.textureAlive);
        alive.setSize(width,height);

        status = true;
        damage = 15;
        direction = Direction.GO_LEFT;
        characterStatus = CharacterStatus.ALIVE;
        attackingAnimationLeft.setScale(2);
        attackingAnimationLeft.setAnimation(ArcherAssets.attackingLeft);

        attackingAnimationRight.setScale(2);
        attackingAnimationRight.setAnimation(ArcherAssets.attackingRight);

        /** Set Weapon : arrow */
        arrow = new Arrow();
        arrow.setPosition(positionCenter);
    }

    public void setPosition(CoOrdinate position){
        super.setPosition(position);
        arrow.setPosition(new CoOrdinate(positionCenter.x,positionCenter.y));
    }

    /** archer shoot */
    public boolean shoot(CoOrdinate destination){
        if(arrow.move(destination)) {
            return true;
        }
        return  false;
    }

    /** display movement of arrow */
    public void showArrow(SpriteBatch batch){
        arrow.show(batch);
    }
}
