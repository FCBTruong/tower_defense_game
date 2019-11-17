package com.mynta.gametowerdefense.MapGame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Auxiliary.Lighting;
import com.mynta.gametowerdefense.Scenery.Route;
import com.mynta.gametowerdefense.characters.Hostile.BigEnemy;
import com.mynta.gametowerdefense.characters.Hostile.FlyMonster;
import com.mynta.gametowerdefense.characters.Hostile.Witch;
import com.mynta.gametowerdefense.characters.Towers.Tower;
import com.mynta.gametowerdefense.characters.Towers.TowerType;
import com.mynta.gametowerdefense.enums.CharacterStatus;
import com.mynta.gametowerdefense.utils.CalculationFunction;
import com.mynta.gametowerdefense.utils.CoOrdinate;

import java.util.ArrayList;
import java.util.List;

/**  **/
/**  Different numbers of enemies in a wave. **/
public class Wave {
    public List<Witch> witchList;
    public List<FlyMonster> flyMonsterList;
    public List<BigEnemy> bigEnemyList;
    public int witchNumber;
    public int flyMonsterNumber;
    public int bigEnemyNumber;

    public Wave(){
        witchList = new ArrayList<>();
        flyMonsterList = new ArrayList<>();
        bigEnemyList = new ArrayList<>();
        witchNumber = 0;
        flyMonsterNumber = 0;
        bigEnemyNumber = 0;
    }

    /** add witches into list. */
    public void addWitches(Route route, int amount, float dis_x, float dis_y){
        Witch[] list = new Witch[amount];
        for(int i = 0; i< amount; i ++)
            list[i] = new Witch();
        CoOrdinate position = route.startingPoint.position;
        for(int i = 0; i < amount; i ++){
            list[i].setRoute(route);
            if (i < 4) list[i].setPosition(new CoOrdinate(position.x - i * 150 - dis_x, position.y));
            else if(i < 8) list[i].setPosition(new CoOrdinate(position.x - i * 150 - 400 - dis_x, position.y));
            else list[i].setPosition(new CoOrdinate(position.x - i * 150 - 600 - dis_x, position.y));
            witchList.add(list[i]);
        }
        witchNumber += amount;
    }

    public void addFlyMonsters(Route route, int amount, float dis_x, float dis_y) {
        FlyMonster[] list = new FlyMonster[amount];
        for (int i = 0; i < amount; i++) {
            list[i] = new FlyMonster();
        }
        CoOrdinate position = route.startingPoint.position;
        for (int i = 0; i < amount; i++) {
            list[i].setRoute(route);
            if (i < 4) list[i].setPosition(new CoOrdinate(position.x - i * 150 - dis_x, position.y));
            else if(i < 8) list[i].setPosition(new CoOrdinate(position.x - i * 150 - 400 - dis_x, position.y));
            else list[i].setPosition(new CoOrdinate(position.x - i * 150 - 600 - dis_x, position.y));
            flyMonsterList.add(list[i]);
        }
        flyMonsterNumber += amount;
    }

    public void addBigEnemies(Route route, int amount, float dis_x, float dis_y) {
        BigEnemy[] list = new BigEnemy[amount];
        for (int i = 0; i < amount; i++) {
            list[i] = new BigEnemy();
        }
        CoOrdinate position = route.startingPoint.position;
        for (int i = 0; i < amount; i++) {
            list[i].setRoute(route);
            if (i < 4) list[i].setPosition(new CoOrdinate(position.x - i * 150 - dis_x, position.y));
            else if(i < 8) list[i].setPosition(new CoOrdinate(position.x - i * 150 - 400 - dis_x, position.y));
            else list[i].setPosition(new CoOrdinate(position.x - i * 150 - 600 - dis_x, position.y));
            bigEnemyList.add(list[i]);
        }
        bigEnemyNumber += amount;
    }

    public void setWitchList(List<Witch> witchList) {
        this.witchList = witchList;
    }

    public void move(){
        for(int i = 0 ; i < witchNumber; i ++){
            witchList.get(i).move();
        }
        for(int i = 0; i < flyMonsterNumber; i ++){
            flyMonsterList.get(i).move();
        }
        for(int i = 0; i < bigEnemyNumber ; i ++){
            bigEnemyList.get(i).move();
        }
    }

    public void radar(Tower tower){
        for(int i = 0; i < flyMonsterNumber; i ++)
        {
            if(tower.getTowerType() == TowerType.ARMY_INFANTRY) break;
            if(flyMonsterList.get(i).getStatus() == CharacterStatus.DEAD) continue;
            if(flyMonsterList.get(i).getStatus() == CharacterStatus.NONE) continue;
            if(tower.radar(flyMonsterList.get(i))){
                return;
            }
        }
        for(int i = 0; i < witchNumber; i ++)
        {
            if(witchList.get(i).getStatus() == CharacterStatus.DEAD) continue;
            if(witchList.get(i).getStatus() == CharacterStatus.NONE) continue;
            if(tower.radar(witchList.get(i))){
               //return;
            }
        }
        for(int i = 0; i < bigEnemyNumber; i ++){
            if(bigEnemyList.get(i).getStatus() == CharacterStatus.DEAD) continue;
            if(bigEnemyList.get(i).getStatus() == CharacterStatus.NONE) continue;
            if(tower.radar(bigEnemyList.get(i))){
                return;
            }
        }
    }

    public void lightingAttack(Lighting lighting){
        for(int i = 0; i < flyMonsterNumber; i ++)
        {
           if(CalculationFunction.circleDetect(lighting.positionAttack, lighting.radius,flyMonsterList.get(i).positionCenter)) {
               flyMonsterList.get(i).bloodCurrent -= lighting.damage;
           }
        }
        for(int i = 0; i < witchNumber; i ++)
        {
            if(CalculationFunction.circleDetect(lighting.positionAttack, lighting.radius,witchList.get(i).positionCenter))
                witchList.get(i).bloodCurrent -= lighting.damage;
        }
        for(int i = 0; i < bigEnemyNumber; i ++){
            if(CalculationFunction.circleDetect(lighting.positionAttack, lighting.radius,bigEnemyList.get(i).positionCenter))
                bigEnemyList.get(i).bloodCurrent -= lighting.damage;
        }
    }

    public void show(SpriteBatch batch) {
        for (int i = 0; i < witchNumber; i++){
            witchList.get(i).show(batch);
        }
        for (int i = 0; i < flyMonsterNumber; i ++){
            flyMonsterList.get(i).show(batch);
        }
        for(int i = 0; i < bigEnemyNumber; i ++){
            bigEnemyList.get(i).show(batch);
        }
    }

    public boolean Status(){
        for(int i = 0 ; i < witchNumber; i ++){
            if(witchList.get(i).getStatus() != CharacterStatus.NONE && witchList.get(i).getStatus() != CharacterStatus.DEAD)
               return  true;
        }
        for(int i = 0; i < flyMonsterNumber; i ++){
            if(flyMonsterList.get(i).getStatus() != CharacterStatus.NONE && flyMonsterList.get(i).getStatus() != CharacterStatus.DEAD)
                return  true;
        }
        for(int i = 0; i < bigEnemyNumber ; i ++){
            if(bigEnemyList.get(i).getStatus() != CharacterStatus.NONE && bigEnemyList.get(i).getStatus() != CharacterStatus.DEAD)
                return  true;
        }
        return false;
    }
}
