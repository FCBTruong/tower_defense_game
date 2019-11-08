package com.mynta.gametowerdefense.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * to show animation of character
 */
public class AnimationAct {
    private Animation animation;
    private TextureAtlas textureAtlas;
    private float elapsedTime;
    private float scale; // of animation scale * FRAME_DURATION
    private boolean bool; // of animation

    public AnimationAct(){
        elapsedTime = 0;
        bool = true;
        scale = 1;
    }

    public void setAnimation(TextureAtlas textureAtlas) {
       this.textureAtlas = textureAtlas;
       animation = new Animation(Constants.FRAME_DURATION * scale, textureAtlas.getRegions());
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setElapsedTime(float elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public void show(SpriteBatch batch, CoOrdinate position, float width, float height){
        elapsedTime += Gdx.graphics.getDeltaTime();
       // animation.se
        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, bool), position.x,
                position.y,0,0,width,height,1,1,0);
    }

    public void show(SpriteBatch batch,CoOrdinate position){
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, bool), position.x,position.y);
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public void dispose(){
        textureAtlas.dispose();
    }
}
