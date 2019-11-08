package com.mynta.gametowerdefense.Weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mynta.gametowerdefense.Assets.Weapons;

public class TurretBullet extends Bullet {
    public boolean status;
    public TurretBullet(){
        sprite = new Sprite(Weapons.textureBulletTurretLevel1);
        sprite.setPosition(position.x,position.y);
        speed = 20;
        status = false;
    }
    public TurretBullet(int type){
        speed = 20;
        status = false;
        switch (type) {
            case 3:
                sprite = new Sprite(Weapons.textureBulletTurretLevel3);
                sprite.setPosition(position.x,position.y);
                break;
            case 4:
                sprite = new Sprite(Weapons.textureBulletTurretLevel4);
                sprite.setPosition(position.x,position.y);
                break;
        }
    }
}
