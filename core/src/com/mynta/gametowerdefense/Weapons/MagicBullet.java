package com.mynta.gametowerdefense.Weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mynta.gametowerdefense.Assets.Weapons;

public class MagicBullet extends Bullet {
    public MagicBullet(){
        sprite = new Sprite(Weapons.textureMagicBullet);
        sprite.setPosition(position.x,position.y);
        speed = 10;
    }
    public MagicBullet(int type){
       switch (type) {
           case 2:
               sprite = new Sprite(Weapons.textureMagicBulletLevel2);
               sprite.setPosition(position.x, position.y);
               speed = 11;
                   break;
           case 3:
               sprite = new Sprite(Weapons.textureMagicBulletLevel3);
               sprite.setPosition(position.x, position.y);
               speed = 12;
       }
    }
}
