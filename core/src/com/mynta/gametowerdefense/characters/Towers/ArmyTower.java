package com.mynta.gametowerdefense.characters.Towers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.CommonAssets;
import com.mynta.gametowerdefense.Assets.SoundAssets;
import com.mynta.gametowerdefense.Assets.TowerAssets;
import com.mynta.gametowerdefense.characters.Army.ArmyInfantry;
import com.mynta.gametowerdefense.characters.CommonCharacter;
import com.mynta.gametowerdefense.enums.CharacterStatus;
import com.mynta.gametowerdefense.stages.PlayGame;
import com.mynta.gametowerdefense.utils.CalculationFunction;
import com.mynta.gametowerdefense.utils.CoOrdinate;
import com.mynta.gametowerdefense.utils.Constants;
import com.mynta.gametowerdefense.utils.TouchInfo;

import static com.mynta.gametowerdefense.characters.Towers.TowerType.NONE;
import static com.mynta.gametowerdefense.utils.Constants.SOUND_STATUS;

public class ArmyTower extends Tower {
    private ArmyInfantry army1;
    private ArmyInfantry army2;
    private ArmyInfantry army3;
    private float coolTime;
    public float timeOff;
    private Sprite chooseMove;
    private boolean move;
    private CoOrdinate destinationPosition;

    public ArmyTower() {
        army1 = new ArmyInfantry();
        army2 = new ArmyInfantry();
        army3 = new ArmyInfantry();

        placeTower = new Sprite(TowerAssets.textureArmyTowerLevel1);
        frameRange = new Sprite(CommonAssets.textureFrameArmy);
        placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2, positionCenter.y - placeTower.getHeight() / 2 + 50);
        coolTime = 0;
        price = 70;
        levelCurrent = 1;
        levelMax = 4;
        towerType = TowerType.ARMY_INFANTRY;
        damage = 1;
        army1.positionOrigin = new CoOrdinate(positionCenter.x, positionCenter.y);
        army2.positionOrigin = new CoOrdinate(positionCenter.x, positionCenter.y);
        army3.positionOrigin = new CoOrdinate(positionCenter.x, positionCenter.y);

        chooseMove = new Sprite(CommonAssets.textureChooseMove);
        move = false;
        destinationPosition = new CoOrdinate();
    }

    public void upGrade() {
        if (levelCurrent < levelMax) {
            levelCurrent++;
            switch (levelCurrent) {
                case 2:
                    placeTower = new Sprite(TowerAssets.textureArmyTowerLevel2);
                    army1.setDamage(30);
                    army2.setDamage(30);
                    army3.setDamage(30);
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2, positionCenter.y - placeTower.getHeight() / 2 + 50);
                    break;
                case 3:
                    placeTower = new Sprite(TowerAssets.textureArmyTowerLevel3);
                    army1.setDamage(40);
                    army2.setDamage(40);
                    army3.setDamage(40);
                    army1.setBlood(150);
                    army1.setBlood(150);
                    army1.setBlood(150);
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2, positionCenter.y - placeTower.getHeight() / 2 + 50);
                    break;
                case 4:
                    upGradeTower = new Sprite(CommonAssets.textureCanNotUpGrade);
                    army1.setDamage(50);
                    army2.setDamage(50);
                    army3.setDamage(50);
                    army1.setBlood(200);
                    army1.setBlood(200);
                    army1.setBlood(200);
                    placeTower = new Sprite(TowerAssets.textureArmyTowerLevel4);
                    placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2, positionCenter.y - placeTower.getHeight() / 2 + 50);
                    damage += 15;
                    price = price + priceUp;
                    PlayGame.coinNumber -= price;
                    break;
            }
        }
    }

    public void setPosition(CoOrdinate position) {
        super.setPosition(position);
        frameRange.setPosition(positionCenter.x - 450, positionCenter.y - 400);
        army1.setPosition(new CoOrdinate(positionCenter.x - 50, positionCenter.y - 100));
        army2.setPosition(new CoOrdinate(positionCenter.x - 50, positionCenter.y - 100));
        army3.setPosition(new CoOrdinate(positionCenter.x - 50, positionCenter.y - 100));

        placeTower.setPosition(positionCenter.x - placeTower.getWidth() / 2, positionCenter.y - placeTower.getHeight() / 2 + 45);
        chooseMove.setPosition(positionCenter.x + 105, positionCenter.y - 140);

        army1.positionOrigin = positionOrigin;
        army2.positionOrigin = new CoOrdinate(positionOrigin.x - 50, positionOrigin.y + 50);
        army3.positionOrigin = new CoOrdinate(positionOrigin.x - 50, positionOrigin.y - 50);

        destinationPosition.x = positionOrigin.x;
        destinationPosition.y = positionOrigin.y;
    }


    public void showFirst(SpriteBatch batch) {
        if (army1.characterStatus == CharacterStatus.NONE) {
            if (army1.timeRevive == 0) {
                army1.characterStatus = CharacterStatus.ALIVE;
                army1.setBlood(army1.getBloodInitial());
                army1.setPosition(new CoOrdinate(positionCenter.x - 50, positionCenter.y - 40));
                army1.timeRevive = 300;
            } else army1.timeRevive -= 0.5f;
        }

        if (army2.characterStatus == CharacterStatus.NONE) {
            if (army2.timeRevive == 0) {
                army2.characterStatus = CharacterStatus.ALIVE;
                army2.setBlood(army2.getBloodInitial());
                army2.setPosition(new CoOrdinate(positionCenter.x - 50, positionCenter.y - 40));
                army2.timeRevive = 300;
            } else army2.timeRevive -= 0.5f;
        }

        if (army3.characterStatus == CharacterStatus.NONE) {
            if (army3.timeRevive == 0) {
                army3.characterStatus = CharacterStatus.ALIVE;
                army3.setBlood(army3.getBloodInitial());
                army3.setPosition(new CoOrdinate(positionCenter.x - 50, positionCenter.y - 40));
                army3.timeRevive = 300;
            } else army3.timeRevive -= 0.5f;
        }

        super.showFirst(batch);
        army1.show(batch);
        army2.show(batch);
        army3.show(batch);
    }

    @Override
    public void showSecond(SpriteBatch batch) {
        super.showSecond(batch);
        if (super.choosingTower) {
            if (towerType != NONE) {
                chooseMove.draw(batch);
            }
        }
        if(move) frameRange.draw(batch);
    }

    public void attack() {
        if (move) return;
        army1.attack();
        army2.attack();
        army3.attack();
    }

    public boolean radar(CommonCharacter enemy) {
        if(!CalculationFunction.move(positionOrigin,destinationPosition,6)){
            army2.positionOrigin = new CoOrdinate(positionOrigin.x - 50, positionOrigin.y + 50);
            army3.positionOrigin = new CoOrdinate(positionOrigin.x - 50, positionOrigin.y - 50);
            return true;
        }

        if (enemy.status == true) return false;
        if (army1.radar(enemy)) return false;
        if (army2.radar(enemy)) return false;
        if (army3.radar(enemy)) return false;
        return false;
    }

    public void deleteEnemy() {
        army1.deleteEnemy();
        army2.deleteEnemy();
        army3.deleteEnemy();
    }

    public void InputTouch() {
        if (TouchInfo.touched) {
            if (move) {
                if(CalculationFunction.circleDetect(positionCenter,450,TouchInfo.touchX,TouchInfo.touchY)) {
                    destinationPosition = new CoOrdinate(TouchInfo.touchX, TouchInfo.touchY);
                    TouchInfo.typeTouch = 2;
                }
                else  TouchInfo.typeTouch = 1;
                move = false;
            }

            if (!choosingTower) {
                if (CalculationFunction.circleDetect(positionCenter, 70, TouchInfo.touchX, TouchInfo.touchY)) {
                    if (SOUND_STATUS) SoundAssets.touchSound.play();
                    choosingTower = true;
                }
            } else {
                if (towerType == TowerType.NONE) {
                    CoOrdinate positionArcherTower = new CoOrdinate(positionCenter.x - 155, positionCenter.y + 155);
                    if (CalculationFunction.circleDetect(positionArcherTower, 75, TouchInfo.touchX, TouchInfo.touchY)) {
                        {
                            if (SOUND_STATUS) SoundAssets.touchSound.play();
                            if (PlayGame.coinNumber >= Constants.ARCHER_PRICE) {
                                selected = TowerType.ARCHER;
                                PlayGame.coinNumber -= Constants.ARCHER_PRICE;
                            }
                        }
                    }
                    CoOrdinate positionApprenticeMageTower = new CoOrdinate(positionCenter.x - 155, positionCenter.y - 155);
                    if (CalculationFunction.circleDetect(positionApprenticeMageTower, 75, TouchInfo.touchX, TouchInfo.touchY)) {
                        if (SOUND_STATUS) SoundAssets.touchSound.play();
                        if (PlayGame.coinNumber >= Constants.APPRENTICE_MAGE_PRICE) {
                            selected = TowerType.APPRENTICE_MAGE;
                            PlayGame.coinNumber -= Constants.APPRENTICE_MAGE_PRICE;
                        }
                    }
                    CoOrdinate positionTurretTower = new CoOrdinate(positionCenter.x + 155, positionCenter.y - 155);
                    if (CalculationFunction.circleDetect(positionTurretTower, 75, TouchInfo.touchX, TouchInfo.touchY)) {
                        if (SOUND_STATUS) SoundAssets.touchSound.play();
                        if (PlayGame.coinNumber >= Constants.TURRET_PRICE) {
                            selected = TowerType.TURRET;
                            PlayGame.coinNumber -= Constants.TURRET_PRICE;
                        }
                    }
                    CoOrdinate positionArmyTower = new CoOrdinate(positionCenter.x + 155, positionCenter.y + 155);
                    if (CalculationFunction.circleDetect(positionArmyTower, 75, TouchInfo.touchX, TouchInfo.touchY)) {
                        {
                            if (SOUND_STATUS) SoundAssets.touchSound.play();
                            if (PlayGame.coinNumber >= Constants.ARMY_PRICE) {
                                selected = TowerType.ARMY_INFANTRY;
                                PlayGame.coinNumber -= Constants.ARMY_PRICE;
                            }
                        }
                    }
                } else {
                    if (CalculationFunction.circleDetect(positionSellTower, 75, TouchInfo.touchX, TouchInfo.touchY)) {
                        if (SOUND_STATUS) SoundAssets.touchSound.play();
                        if (towerType == TowerType.ARMY_INFANTRY) this.deleteEnemy();
                        selected = TowerType.NONE;
                        PlayGame.coinNumber += this.price;
                    }
                    if (CalculationFunction.circleDetect(positionUpGrade, 75, TouchInfo.touchX, TouchInfo.touchY)) {
                        if (SOUND_STATUS) SoundAssets.touchSound.play();
                        if (PlayGame.coinNumber >= price + priceUp) upGrade();
                    }

                    CoOrdinate positionMove = new CoOrdinate(positionCenter.x + 180, positionCenter.y - 65);
                    if (CalculationFunction.circleDetect(positionMove, 75, TouchInfo.touchX, TouchInfo.touchY)) {
                        if (SOUND_STATUS) SoundAssets.touchSound.play();
                        move = true;
                    }
                }
            }
            if (!CalculationFunction.circleDetect(positionCenter, 70, TouchInfo.touchX, TouchInfo.touchY))
                choosingTower = false;
        }
    }
}
