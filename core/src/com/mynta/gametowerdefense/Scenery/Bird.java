package com.mynta.gametowerdefense.Scenery;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.BirdAssets;
import com.mynta.gametowerdefense.utils.AnimationAct;
import com.mynta.gametowerdefense.utils.CoOrdinate;

/** BIRD
 * a bird flying back and forth around the map.
 */

public class Bird {
    private CoOrdinate position;
    private AnimationAct animation;
    private float speed;
    public Bird(){
        speed = 1.5f;
        position = new CoOrdinate(-1000,1800);
        animation = new AnimationAct();
        animation.setScale(1.6f);
        animation.setAnimation(BirdAssets.textureAtlasFlying);
    }

    public void setPosition(CoOrdinate position) {
        this.position = position;
    }

    public void show(SpriteBatch batch){
        if(position.x < 3000) position.x += speed;
        else{
            position.x = -2000;
            position.y -= 50;
        }
        if(position.y < 500) position.y = 1100;
        animation.show(batch,position,110,110);
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void dispose(){
        animation.dispose();
    }
}
