package com.mynta.gametowerdefense.Weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mynta.gametowerdefense.Assets.Weapons;

public class Arrow extends Bullet{
    public Arrow(){
        sprite = new Sprite(Weapons.textureArrow);
        sprite.setPosition(position.x,position.y);
        speed = 13;
    }

    public Arrow(int type){
        speed = 13;
        switch (type){
            case 3:
                sprite = new Sprite(Weapons.textureArrowLevel3);
                sprite.setPosition(position.x,position.y);
                break;
            case 4:
                sprite = new Sprite(Weapons.textureArrowLevel4);
                sprite.setPosition(position.x,position.y);
                break;
        }
    }
}
