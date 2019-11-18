package com.mynta.gametowerdefense.Auxiliary;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.AuxiliaryAssets;
import com.mynta.gametowerdefense.Assets.SoundAssets;
import com.mynta.gametowerdefense.utils.*;

public class Fire {
    private AnimationAct fire1;
    private AnimationAct fire2;
    private AnimationAct fire3;
    private Sprite icon;
    private CoOrdinate positionIcon;
    private boolean attackChoose; // true if touch Icon
    public boolean attack; // true if attack
    private Sprite frameOfIcon;
    private Sprite iconOff;
    private Sprite loading;
    public CoOrdinate positionAttack;
    private CoOrdinate positionDestination;
    private CoOrdinate positionShowFire;
    private CoOrdinate positionShowFire2;
    private CoOrdinate positionShowFire3;

    public float damage;
    public float radius;
    private float timeCoolDown;
    private final float timeCoolDownMax = 18;
    private float timeAttack;
    private boolean attackingFinish;

    public Fire(){
        fire1 = new AnimationAct();
        fire1.setAnimation(AuxiliaryAssets.textureAtlasFire);
        fire2 = new AnimationAct();
        fire2.setAnimation(AuxiliaryAssets.textureAtlasFire);
        fire3 = new AnimationAct();
        fire3.setAnimation(AuxiliaryAssets.textureAtlasFire);

        icon = new Sprite(AuxiliaryAssets.fireIcon);
        icon.setPosition(Constants.camera.position.x + 1200, Constants.camera.position.y - 700);

        iconOff = new Sprite(AuxiliaryAssets.lightingIconOff);
        frameOfIcon = new Sprite(AuxiliaryAssets.frameOfIcon);
        loading = new Sprite(AuxiliaryAssets.loading);

        positionIcon = new CoOrdinate();
        positionDestination = new CoOrdinate();
        attack = false;
        attackChoose = false;
        attackingFinish = true;
        positionAttack = new CoOrdinate();
        positionShowFire = new CoOrdinate();
        positionShowFire2 = new CoOrdinate();
        positionShowFire3 = new CoOrdinate();

        timeCoolDown = 0;
        timeAttack = 0;
        damage = 60;
        radius = 250;
    }

    public void touch(){
        if(timeCoolDown > 0) timeCoolDown -= 0.01;
        if(!TouchInfo.touched) return;
        if(!attackChoose) {
            positionIcon.x = Constants.camera.position.x + 980;
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
            attackingFinish = false;
            positionShowFire.x = TouchInfo.touchX - 150;
            positionShowFire.y = 2200 +  TouchInfo.touchY;

            positionShowFire2.x = positionShowFire.x - 100;
            positionShowFire2.y = positionShowFire.y - 70;

            positionShowFire3.x = positionShowFire.x + 80;
            positionShowFire3.y = positionShowFire.y - 90;

            timeCoolDown = timeCoolDownMax;
            attackChoose = false;
            attack = false;
            positionAttack.x = TouchInfo.touchX;
            positionAttack.y = TouchInfo.touchY;

            positionDestination.x = TouchInfo.touchX - 150;
            positionDestination.y = TouchInfo.touchY;

            if(Constants.SOUND_STATUS) SoundAssets.fireSound.play();
            timeAttack = 50;
        }
    }

    public void show(SpriteBatch batch){
        icon.setPosition(Constants.camera.position.x + 980, Constants.camera.position.y - 700);
        icon.draw(batch);

        if(timeCoolDown > 0) {
            iconOff.setPosition(Constants.camera.position.x + 990, Constants.camera.position.y - 690);
            iconOff.draw(batch);
            loading.setPosition(Constants.camera.position.x + 990, Constants.camera.position.y - 690);
            loading.setSize(180, (timeCoolDownMax - timeCoolDown)/ timeCoolDownMax * 180);
            loading.draw(batch);
        }

        if(attackChoose){
            frameOfIcon.setPosition(Constants.camera.position.x + 970, Constants.camera.position.y - 710);
            frameOfIcon.draw(batch);
        }

        if(attackingFinish) return;
        if(CalculationFunction.move(positionShowFire,positionDestination,20)) {
            attack = true;
            attackingFinish = true;
        }

        positionShowFire2.x = positionShowFire.x - 100;
        positionShowFire2.y = positionShowFire.y - 70;

        positionShowFire3.x = positionShowFire.x + 80;
        positionShowFire3.y = positionShowFire.y - 90;

        fire1.show(batch, positionShowFire);
        fire2.show(batch, positionShowFire2);
        fire3.show(batch, positionShowFire3);
    }
}
