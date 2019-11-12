package com.mynta.gametowerdefense.MapGame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.MapAssets;
import com.mynta.gametowerdefense.Scenery.Bird;
import com.mynta.gametowerdefense.Scenery.Flag;
import com.mynta.gametowerdefense.Scenery.Route;
import com.mynta.gametowerdefense.Scenery.WindMill;
import com.mynta.gametowerdefense.characters.Towers.Tower;

import java.util.ArrayList;
import java.util.List;

/** MAP GAME
 * Map of the game, including towers, number of enemies.
 * How to play, score ...
 */

public class MapGame {
    public int waveNumber; // number of waves.
    public int towerNumber; // number of towers
    public int routeNumber; // number of routes
    public Tower[] towerList = new Tower[20];
    public List<Wave> waveList;
    public List<Route> routeList;

    private Texture texture;
    private Sprite background;  // background
    private List<Bird> birdList;
    private List<WindMill> windMillList;
    private Flag flag;

    public int coinNumber;
    public int heartNumber;

    // character, tower...;
    public MapGame(){
        towerNumber = 0;
        for(int i = 0 ; i < 20; i ++)
            towerList[0] = new Tower();
        waveList = new ArrayList<>();
        routeList = new ArrayList<>();
        birdList = new ArrayList<>();
        flag = new Flag();
        windMillList = new ArrayList<>();

        routeNumber = 0;
        towerNumber = 0;
        waveNumber = 0;

        coinNumber = 600;
        heartNumber = 15;
    }

    public void addTower(Tower tower){
        towerList[towerNumber] = tower;
        towerNumber ++;
    }

    public void setCoinNumber(int coinNumber) {
        this.coinNumber = coinNumber;
    }

    public void setHeartNumber(int heartNumber) {
        this.heartNumber = heartNumber;
    }

    public void addRoute(Route route){
        routeList.add(route);
        routeNumber ++;
    }

    public void addWaves(Wave wave){
        waveList.add(wave);
        waveNumber ++;
    }

    public void addWindmill(WindMill windMill){
        windMillList.add(windMill);
    }


    public void addBird(Bird bird){
        birdList.add(bird);
    }

    public void setWaves(int wavesNumber) {
        this.waveNumber = wavesNumber;
    }

    public void setTowerNumber(int towerNumber) {
        this.towerNumber = towerNumber;
    }

    public void setBackground(int level){
        switch (level){
            case 1:
                background = new Sprite(MapAssets.textureMapLevel1);
                break;
            case 2:
                background = new Sprite(MapAssets.textureMapLevel2);
                        break;
        }
    }

    public void setBirdList(){
      //  Bird b = new Bird();
    }

    public void setWindMillList(){

    }

    public void showMapFirst(SpriteBatch batch){
        background.draw(batch);
        flag.show(batch);

        for(int i = 0; i < windMillList.size(); i ++){
            windMillList.get(i).show(batch);
        }

        for(int i = 0; i < towerNumber; i ++){
            towerList[i].showFirst(batch);
        }
    }

    public void showMapSecond(SpriteBatch batch){
        for(int i = 0; i < towerNumber; i ++){
            towerList[i].showSecond(batch);
        }
        for(int i = 0; i < birdList.size(); i ++){
            birdList.get(i).show(batch);
        }
    }

    public void dispose(){
        texture.dispose();
    }
}
