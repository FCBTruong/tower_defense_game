package com.mynta.gametowerdefense.Auxiliary;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.AuxiliaryAssets;
import com.mynta.gametowerdefense.Assets.SoundAssets;
import com.mynta.gametowerdefense.utils.*;

/** thunder */
public class Lighting {
    private AnimationAct light;
    private Sprite icon;
    private CoOrdinate positionIcon;
    private boolean attackChoose; // true if touch Icon
    public boolean attack; // true if attack
    private Sprite frameOfIcon;
    private Sprite iconOff;
    private Sprite loading;
    public CoOrdinate positionAttack;
    private CoOrdinate positionShowLight;
    public float damage;
    public float radius;
    private float timeCoolDown;
    private final float timeCoolDownMax = 24;
    private float timeAttack;

    public Lighting(){
        light = new AnimationAct();
        light.setAnimation(AuxiliaryAssets.light);

        icon = new Sprite(AuxiliaryAssets.lightingIcon);
        icon.setPosition(Constants.camera.position.x + 1200, Constants.camera.position.y - 700);

        iconOff = new Sprite(AuxiliaryAssets.lightingIconOff);
        frameOfIcon = new Sprite(AuxiliaryAssets.frameOfIcon);
        loading = new Sprite(AuxiliaryAssets.loading);

        positionIcon = new CoOrdinate();
        attack = false;
        attackChoose = false;
        positionAttack = new CoOrdinate();
        positionShowLight = new CoOrdinate();
        timeCoolDown = 0;
        timeAttack = 0;
        damage = 100;
        radius = 250;
    }

    public void touch(){
        if(timeCoolDown > 0) timeCoolDown -= 0.01;
        if(!TouchInfo.touched) return;
        if(!attackChoose) {
            positionIcon.x = Constants.camera.position.x + 1200;
            positionIcon.y = Constants.camera.position.y - 700;
            if(timeCoolDown <= 0)
                if (CalculationFunction.rectangleDetect(positionIcon, 200, 200, TouchInfo.touchX, TouchInfo.touchY)) {
                    attackChoose = true;
                    if(Constants.SOUND_STATUS) SoundAssets.touchSound.play();
                }
        }
        else {
            if(Constants.SOUND_STATUS) SoundAssets.touchSound.play();
            if (CalculationFunction.rectangleDetect(positionIcon, 200, 200, TouchInfo.touchX, TouchInfo.touchY)) {
                attackChoose = false;
                return;
            }
            timeCoolDown = timeCoolDownMax;
            attackChoose = false;
            attack = true;
            positionAttack.x = TouchInfo.touchX;
            positionShowLight.x = TouchInfo.touchX - 200;
            positionAttack.y = TouchInfo.touchY;
            positionShowLight.y = TouchInfo.touchY - 150;
            if(Constants.SOUND_STATUS) SoundAssets.thunderSound.play();
            timeAttack = 50;
        }
    }

    public void attack(SpriteBatch batch){
        if(timeAttack > 0){
            timeAttack -= 1;
            light.show(batch,positionShowLight,370,1600);
        }
    }

    public void show(SpriteBatch batch){
        icon.setPosition(Constants.camera.position.x + 1200, Constants.camera.position.y - 700);
        icon.draw(batch);

        if(timeCoolDown > 0) {
            iconOff.setPosition(Constants.camera.position.x + 1210, Constants.camera.position.y - 690);
            iconOff.draw(batch);
            loading.setPosition(Constants.camera.position.x + 1210, Constants.camera.position.y - 690);
            loading.setSize(180, (timeCoolDownMax - timeCoolDown)/ timeCoolDownMax * 180);
            loading.draw(batch);
        }

        if(attackChoose){
            frameOfIcon.setPosition(Constants.camera.position.x + 1190, Constants.camera.position.y - 710);
            frameOfIcon.draw(batch);
        }

        attack(batch);
    }
}
