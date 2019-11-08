package com.mynta.gametowerdefense.characters.Towers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.CommonAssets;
import com.mynta.gametowerdefense.Assets.SoundAssets;
import com.mynta.gametowerdefense.Assets.TowerAssets;
import com.mynta.gametowerdefense.characters.CommonCharacter;
import com.mynta.gametowerdefense.stages.PlayGame;
import com.mynta.gametowerdefense.utils.CalculationFunction;
import com.mynta.gametowerdefense.utils.CoOrdinate;
import com.mynta.gametowerdefense.utils.Constants;
import com.mynta.gametowerdefense.utils.TouchInfo;

import static com.mynta.gametowerdefense.utils.Constants.SOUND_STATUS;

/***  TOWER
 * to decimate enemies and protect base.
 * Fixed
 * ***/

public class Tower {
    protected CoOrdinate position; /** default position is the location to display images */
    protected CoOrdinate positionCenter; /** center position of the images */
    protected float radius;
    protected int price;
    protected TowerStatus towerStatus;
    protected CommonCharacter enemy; /** should be destroyed by tower*/
    protected Sprite placeTower; /** place to put tower or tower*/
    protected TowerType towerType;

    protected boolean choosingTower; /** choosing a tower*/
    protected TowerType selected;
    protected float damage;

    private Sprite frameBuyTower;

    private Sprite chooseArcherTower;
    private Sprite chooseArmyTower;
    private Sprite chooseApprenticeMage;
    private Sprite chooseTurretTower;

    private Sprite sellTower;
    CoOrdinate positionSellTower;

    private Sprite frameRange; /* Of tower */
    public float timeOff;
    protected BitmapFont priceFont;

    protected Sprite upGradeTower;
    private CoOrdinate positionUpGrade;
    private BitmapFont priceUpGradeFont;

    protected int levelCurrent;
    protected int levelMax;
    protected int priceUp;

    protected float COOL_TIME;

    public Tower(){
        towerType = TowerType.NONE;
        placeTower = new Sprite(TowerAssets.texturePlaceTower);
        frameBuyTower = new Sprite(CommonAssets.textureFrameBuyTower);
        radius = 500;
        price = 50;
        priceUp = 52;
        timeOff = 10;
        levelCurrent = 1;
        levelMax = 3;
        towerStatus = TowerStatus.NONE;
        position = new CoOrdinate(1500,620);
        positionCenter = new CoOrdinate(1650, 695);
        placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2,positionCenter.y - placeTower.getHeight()/2);

        frameBuyTower = new Sprite(CommonAssets.textureFrameBuyTower);
        frameBuyTower.setPosition(positionCenter.x - 200, positionCenter.y - 200);

        chooseArcherTower = new Sprite(CommonAssets.textureChooseArcherTower);
        chooseArcherTower.setPosition(positionCenter.x - 230, positionCenter.y + 80);
        chooseArcherTower.setSize(150,150);

        chooseArmyTower = new Sprite(CommonAssets.textureChooseArmyTower);
        chooseArmyTower.setPosition(positionCenter.x + 80, positionCenter.y + 80);
        chooseArmyTower.setSize(150,150);

        chooseApprenticeMage = new Sprite(CommonAssets.textureChooseApprenticeMageTower);
        chooseApprenticeMage.setPosition(positionCenter.x - 230, positionCenter.y - 230);
        chooseApprenticeMage.setSize(150,150);

        chooseTurretTower = new Sprite(CommonAssets.textureChooseTurretTower);
        chooseTurretTower.setPosition(positionCenter.x + 80, positionCenter.y - 230);
        chooseTurretTower.setSize(150,150);

        sellTower = new Sprite(CommonAssets.textureSellTower);
        sellTower.setPosition(positionCenter.x - 75, positionCenter.y - 275 );
        sellTower.setSize(150,150);
        positionSellTower = new CoOrdinate(positionCenter.x, positionCenter.y - 200);

        frameRange = new Sprite(CommonAssets.textureFrameRange);
        frameRange.setPosition(positionCenter.x - 500,positionCenter.y - 375);

        upGradeTower = new Sprite(CommonAssets.textureUpGrade);
        positionUpGrade = new CoOrdinate(positionCenter.x , positionCenter.y + 215);
        upGradeTower.setSize(150,150);

        priceFont = CommonAssets.priceFont;
        priceFont.setColor(Color.YELLOW);

        priceUpGradeFont = CommonAssets.priceFont;
        priceUpGradeFont.setColor(Color.YELLOW);
    }

    public void setPosition(CoOrdinate position) {
        this.position = position;
        positionCenter.x = position.x + 100;
        positionCenter.y = position.y + 70;
        placeTower.setPosition(position.x, position.y);
        frameBuyTower.setPosition(positionCenter.x - 200, positionCenter.y - 200);
        placeTower.setPosition(positionCenter.x - 100,positionCenter.y - 70);
        sellTower.setPosition(positionCenter.x - 75, positionCenter.y - 275 );


        frameRange.setPosition(positionCenter.x - 500,positionCenter.y - 375);

        positionSellTower = new CoOrdinate(positionCenter.x, positionCenter.y - 200);
        positionUpGrade = new CoOrdinate(positionCenter.x , positionCenter.y + 215);

        chooseApprenticeMage.setPosition(positionCenter.x - 230, positionCenter.y - 230);
        chooseTurretTower.setPosition(positionCenter.x + 80, positionCenter.y - 230);
        chooseArmyTower.setPosition(positionCenter.x + 80, positionCenter.y + 80);
        chooseArcherTower.setPosition(positionCenter.x -230, positionCenter.y + 80);
    }

    public TowerType getTowerType() {
        return towerType;
    }
    public TowerType getSelected(){ return selected; }
    public CoOrdinate getPosition(){ return position; }

    public void showFirst(SpriteBatch batch){
        placeTower.draw(batch);
    }

    public void showSecond(SpriteBatch batch){
        if(choosingTower){
            frameBuyTower.draw(batch);
            if(towerType == TowerType.NONE) {
                chooseArcherTower.draw(batch);
                chooseArmyTower.draw(batch);
                chooseApprenticeMage.draw(batch);
                chooseTurretTower.draw(batch);
            }
            else{
                frameRange.draw(batch);

                sellTower.draw(batch);
                priceFont.draw(batch,Integer.toString(price), positionSellTower.x - 20, positionSellTower.y - 47 );

                upGradeTower.setPosition(positionUpGrade.x - 75, positionUpGrade.y - 75);
                upGradeTower.draw(batch);
                priceUpGradeFont.draw(batch,Integer.toString(price + (int)priceUp), positionUpGrade.x - 22, positionUpGrade.y - 48);
            }
        }
    }
    public void InputTouch(){
        if(TouchInfo.touched) {
           if(!choosingTower) {
               if (CalculationFunction.circleDetect(positionCenter, 70, TouchInfo.touchX, TouchInfo.touchY)) {
                   if(SOUND_STATUS) SoundAssets.touchSound.play();
                       choosingTower = true;
               }
           }
           else {
               if (towerType == TowerType.NONE) {
                   CoOrdinate positionArcherTower = new CoOrdinate(positionCenter.x - 155, positionCenter.y + 155);
                   if (CalculationFunction.circleDetect(positionArcherTower, 75, TouchInfo.touchX, TouchInfo.touchY)) {
                       {
                           if(SOUND_STATUS) SoundAssets.touchSound.play();
                           if(PlayGame.coinNumber >= Constants.ARCHER_PRICE) {
                               selected = TowerType.ARCHER;
                               PlayGame.coinNumber -= Constants.ARCHER_PRICE;
                           }
                       }
                   }
                   CoOrdinate positionApprenticeMageTower = new CoOrdinate(positionCenter.x - 155, positionCenter.y - 155);
                   if (CalculationFunction.circleDetect(positionApprenticeMageTower,75,TouchInfo.touchX,TouchInfo.touchY)){
                       if(SOUND_STATUS) SoundAssets.touchSound.play();
                       if(PlayGame.coinNumber >= Constants.APPRENTICE_MAGE_PRICE){
                           selected = TowerType.APPRENTICE_MAGE;
                           PlayGame.coinNumber -= Constants.APPRENTICE_MAGE_PRICE;
                       }
                   }
                   CoOrdinate positionTurretTower = new CoOrdinate(positionCenter.x + 155, positionCenter.y - 155);
                   if (CalculationFunction.circleDetect(positionTurretTower,75,TouchInfo.touchX,TouchInfo.touchY)){
                       if(SOUND_STATUS) SoundAssets.touchSound.play();
                       if(PlayGame.coinNumber >= Constants.TURRET_PRICE){
                           selected = TowerType.TURRET;
                           PlayGame.coinNumber -= Constants.TURRET_PRICE;
                       }
                   }
                   CoOrdinate positionArmyTower = new CoOrdinate(positionCenter.x + 155, positionCenter.y + 155);
                   if (CalculationFunction.circleDetect(positionArmyTower, 75, TouchInfo.touchX, TouchInfo.touchY)) {
                       {
                           if(SOUND_STATUS) SoundAssets.touchSound.play();
                           if(PlayGame.coinNumber >= Constants.ARMY_PRICE) {
                               selected = TowerType.ARMY_INFANTRY;
                               PlayGame.coinNumber -= Constants.ARMY_PRICE;
                           }
                       }
                   }
               }
               else{
                   if(CalculationFunction.circleDetect(positionSellTower,75, TouchInfo.touchX, TouchInfo.touchY)){
                       if(SOUND_STATUS) SoundAssets.touchSound.play();
                       selected = TowerType.NONE;
                           PlayGame.coinNumber += this.price;
                   }
                   if(CalculationFunction.circleDetect(positionUpGrade,75, TouchInfo.touchX, TouchInfo.touchY)){
                       if(SOUND_STATUS) SoundAssets.touchSound.play();
                       if(PlayGame.coinNumber >= price + priceUp) upGrade();
                   }
               }
               if (!CalculationFunction.circleDetect(positionCenter, 70, TouchInfo.touchX, TouchInfo.touchY))
                   choosingTower = false;
           }
        }
    }

    public TowerStatus getTowerStatus() {
        return towerStatus;
    }

    /** radar
     *  Check the enemy in range Tower or not
     *  If enemy in range Tower -> tower attack the enemy
     */
    public boolean radar(CommonCharacter enemy){
        float distance = (enemy.positionCenter.x - positionCenter.x) * (enemy.positionCenter.x - positionCenter.x)
                + (enemy.positionCenter.y -positionCenter.y) * (enemy.positionCenter.y -positionCenter.y);
        if(distance > radius * radius) return false;
        towerStatus = TowerStatus.ATTACKING;
        this.enemy = enemy;
        return true;
    }

    /** no thing -> Inheritance */
    public void attack(){
    }

    public void upGrade(){
        // to do
    }

    public void setEnemy(CommonCharacter enemy) {
        this.enemy = enemy;
    }
}
