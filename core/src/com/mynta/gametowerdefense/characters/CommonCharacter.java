package com.mynta.gametowerdefense.characters;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mynta.gametowerdefense.Assets.CommonAssets;
import com.mynta.gametowerdefense.Assets.SoundAssets;
import com.mynta.gametowerdefense.Scenery.Route;
import com.mynta.gametowerdefense.enums.CharacterStatus;
import com.mynta.gametowerdefense.enums.Direction;
import com.mynta.gametowerdefense.stages.PlayGame;
import com.mynta.gametowerdefense.utils.AnimationAct;
import com.mynta.gametowerdefense.utils.CalculationFunction;
import com.mynta.gametowerdefense.utils.CoOrdinate;

public  class CommonCharacter extends Actor {
    /** Character attributes */
    protected float damage;
    public float bloodCurrent;
    protected float width; // size
    protected float height; // size
    protected float speed;  // Speed of movement.
    protected int value; // Amount of money that the player receives after killing an enemy.
    protected float bloodInitial;

    private float time_dead = 0;

    protected Sprite spriteBlood;
    private Sprite frameBlood;
    protected float disXofPositionBlood;
    protected float disYofPositionBlood;
    protected float bloodLength;

    public CharacterStatus characterStatus;

    /** Activities */
    protected AnimationAct runningAnimationRight; /** run to the Right */
    protected AnimationAct runningAnimationLeft;  /** run to the Left */
    protected AnimationAct runningAnimationUp; /** run to top */
    protected AnimationAct dyingAnimation;   // die
    protected AnimationAct attackingAnimationRight; /** attack - fight to the Right */
    protected AnimationAct attackingAnimationLeft; /** attack to the Left */
    protected Sprite alive; /** no thing to do */
    protected CoOrdinate alivePosition;

    /** position and move */
    public CoOrdinate positionCurrent;
    public CoOrdinate positionCenter; // center of Character
    protected Direction direction;    // direction of movement
    protected Route route;            // the way to move
    private int index;                // index of point in route;

    protected CommonCharacter enemy; // need to destroy
    protected float coolDownTime; // time to hit
    public boolean status; // busy or free

    public CharacterType characterType;

    public CommonCharacter(){

        /** initial Animations of Actor. */
        runningAnimationRight = new AnimationAct();
        runningAnimationLeft = new AnimationAct();
        runningAnimationUp = new AnimationAct();

        attackingAnimationRight = new AnimationAct();
        attackingAnimationLeft = new AnimationAct();
        attackingAnimationRight.setBool(false);
        attackingAnimationLeft.setBool(false);

        dyingAnimation = new AnimationAct();
        dyingAnimation.setBool(false);

        attackingAnimationLeft = new AnimationAct();
        attackingAnimationRight = new AnimationAct();

        /** initial Route And move */
        route = new Route();
        index = 0;
        direction = Direction.GO_RIGHT;

        /** initial attributes */
        height = 100;
        width = 100;
        speed = 2;
        damage = 50;
        bloodCurrent = 100;
        bloodInitial = 100;
        time_dead = 0;
        value = 0;

        positionCurrent = new CoOrdinate(100,100);
        positionCenter = new CoOrdinate();

        positionCenter.x = positionCurrent.x + width / 2;
        positionCenter.y = positionCurrent.y + height / 2;
        characterStatus = CharacterStatus.RUN;

        alivePosition = new CoOrdinate(positionCurrent.x,positionCenter.y);

        spriteBlood = new Sprite(CommonAssets.textureBlood);
        frameBlood = new Sprite(CommonAssets.textureFrameBlood);
        disXofPositionBlood = 16;
        disYofPositionBlood = 110;
        bloodLength = 75;
        direction = Direction.GO_RIGHT;
        coolDownTime = 0.5f;
        status = false;
        characterType = CharacterType.NONE;
    }

    public void setPosition(CoOrdinate positionCurrent) {
        this.positionCurrent = positionCurrent;
        positionCenter.x = positionCurrent.x + width / 2;
        positionCenter.y = positionCurrent.y + height / 2;
        alivePosition.x = positionCurrent.x;
        alivePosition.y = positionCurrent.y;
    }

    public float getBloodInitial() {
        return bloodInitial;
    }

    public void setSpeed(float speed){
        this.speed = speed;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public void setBlood(float blood) {
        this.bloodCurrent= blood;
        this.bloodInitial= blood;
    }

    public void setRoute(Route route) {
        this.route = route;
        direction = route.startingPoint.direction;
    }

    public CoOrdinate getPositionCenter() {
        return positionCenter;
    }

    public CharacterStatus getStatus(){
        return characterStatus;
    }

    /** display */
    public void show(SpriteBatch batch){
         if(this.bloodCurrent <= 0 && characterStatus != CharacterStatus.NONE) {
             if(characterStatus != CharacterStatus.DEAD) PlayGame.coinNumber += this.value;
             characterStatus = CharacterStatus.DEAD;
         }
         switch (characterStatus){
             case DEAD: dyingAnimation.show(batch,this.positionCurrent,width,height);
             time_dead += 0.5;
             if(time_dead >= 100) characterStatus = CharacterStatus.NONE;
             break;
             case RUN:
                 switch (direction) {
                     case GO_RIGHT:
                         runningAnimationRight.show(batch, this.positionCurrent, width, height);
                         break;
                     case GO_LEFT:
                         runningAnimationLeft.show(batch, this.positionCurrent, width, height);
                         break;
                     case GO_UP:
                         runningAnimationUp.show(batch, this.positionCurrent, width, height);
                         // to do
                         break;
                     case GO_DOWN:
                         // to do
                         break;
                 }
             break;
             case FIGHT: switch (direction){
                 case GO_RIGHT:attackingAnimationRight.show(batch,this.positionCurrent,width,height);
                 break;
                 case GO_DOWN: // to do
                     break;
                 case GO_UP:
                 case GO_LEFT:attackingAnimationLeft.show(batch,this.positionCurrent,width,height);
             }
             break;
             case ALIVE:
                 alive.setPosition(alivePosition.x,alivePosition.y);
                 alive.draw(batch);
             break;
        }
        if(bloodCurrent > 0 && bloodCurrent < bloodInitial) {
            frameBlood.setPosition(positionCurrent.x + disXofPositionBlood, positionCurrent.y + disYofPositionBlood);
            spriteBlood.setPosition(positionCurrent.x + disXofPositionBlood + 2, positionCurrent.y + + disYofPositionBlood + 2);
            frameBlood.draw(batch);
            spriteBlood.setSize(bloodCurrent / bloodInitial * 75, 10);
            spriteBlood.draw(batch);
        }
    }

    /** Movement
     * Go right
     * left
     * up
     * down
     */
    public void move(){
        if(characterStatus == CharacterStatus.RUN) {
            if(CalculationFunction.move(positionCurrent,route.routePointList.get(index).position,speed)){
                index ++;
            }
            positionCenter.x = positionCurrent.x + width / 2;
            positionCenter.y = positionCurrent.y + height / 2;
            if(index >= route.pointNumber) {
                characterStatus = CharacterStatus.NONE;
                PlayGame.heartNumber --;
            }
        }
    }

    public void dispose(){
        runningAnimationRight.dispose();
        dyingAnimation.dispose();
        attackingAnimationRight.dispose();
    }

    public void attack(){
        coolDownTime -= 0.5;
        if(coolDownTime == 0) {
            coolDownTime = 30;
            enemy.bloodCurrent -= damage;
            if(characterType == CharacterType.ARMY_INFANTRY) SoundAssets.swordSound.play();
            if(enemy.bloodCurrent < 0) coolDownTime = 0.5f;
            attackingAnimationRight.setElapsedTime(0);
            attackingAnimationLeft.setElapsedTime(0);
        }
    }

    public void setEnemy(CommonCharacter enemy){
        this.enemy = enemy;
    }
}
