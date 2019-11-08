package com.mynta.gametowerdefense.MapGame;

import com.mynta.gametowerdefense.Scenery.Bird;
import com.mynta.gametowerdefense.Scenery.Route;
import com.mynta.gametowerdefense.Scenery.RouteStyle;
import com.mynta.gametowerdefense.Scenery.WindMill;
import com.mynta.gametowerdefense.characters.Towers.Tower;
import com.mynta.gametowerdefense.enums.Direction;
import com.mynta.gametowerdefense.utils.CoOrdinate;
import com.mynta.gametowerdefense.utils.RoutePoint;

import java.util.ArrayList;
import java.util.List;

import static com.mynta.gametowerdefense.utils.Constants.MAP_LEVEL1;


/*** Process to set Game map ***/

public class SetMap {
    /*** SET MAP ***/

    // LEVEL 1.
    public static void MAP_LEVEL1(){

        MAP_LEVEL1 = new MapGame();
        MAP_LEVEL1.setBackground(1);

        // route that the enemy moves
        Route route1Left = new Route();
        Route route1Center = new Route();
        Route route1Right = new Route();

        /** The number of towers that a player able to build. */
        List<CoOrdinate> listTower = new ArrayList<>();

        /** The number of waves */
        List<Wave> wavesList = new ArrayList<>();

        /** set route 1 */
        route1Right.setStartingPoint(new RoutePoint(new CoOrdinate(-200,390), Direction.GO_RIGHT));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(2040,390),Direction.GO_UP));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(2040,1350),Direction.GO_RIGHT));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(2950, 1350),Direction.GO_RIGHT));
        route1Right.setRouteStyle(RouteStyle.RIGHT);

        route1Center.setStartingPoint(new RoutePoint(new CoOrdinate(-200,470), Direction.GO_RIGHT));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(1945,470),Direction.GO_UP));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(1945,1425),Direction.GO_RIGHT));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(2950, 1425),Direction.GO_RIGHT));
        route1Center.setRouteStyle(RouteStyle.CENTER);

        route1Left.setStartingPoint(new RoutePoint(new CoOrdinate(-200,530), Direction.GO_RIGHT));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(1880,530),Direction.GO_UP));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(1880,1510),Direction.GO_RIGHT));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(2950, 1510),Direction.GO_RIGHT));
        route1Left.setRouteStyle(RouteStyle.LEFT);

        /** Set Wave */
        Wave wave1 = new Wave();
        wave1.addFlyMonsters(route1Center,4, 0,0);
        wave1.addWitches(route1Right,2,400,0);
        wave1.addFlyMonsters(route1Left,3,900,0);
        wave1.addFlyMonsters(route1Center,6,1300,0);
        wave1.addFlyMonsters(route1Right,2,1900,0);
        wave1.addWitches(route1Center,6,3500,0);
        wave1.addFlyMonsters(route1Right,3,6000,0);
        wave1.addFlyMonsters(route1Center,4,6500,0);
        wave1.addWitches(route1Center,4, 5300,0);

        Wave wave2 = new Wave();
        wave2.addFlyMonsters(route1Center,8,0,0);
        wave2.addFlyMonsters(route1Right,4, 1300,0);
        wave2.addWitches(route1Center,3,2000,0);
        wave2.addFlyMonsters(route1Center,8,4000,0);
        wave2.addFlyMonsters(route1Left,3,5900,0);
        wave2.addWitches(route1Center,4,6000,0);
        wave2.addBigEnemies(route1Center,2,7600,0);

        // create Towers
        Tower tower1 = new Tower();
        tower1.setPosition(new CoOrdinate(450,630));
        Tower tower2 = new Tower();
        tower2.setPosition(new CoOrdinate(1600,630));
        Tower tower3 = new Tower();
        tower3.setPosition(new CoOrdinate(1100,630));
        Tower tower4 = new Tower();
        tower4.setPosition(new CoOrdinate(1600,1150));
        Tower tower5 = new Tower();
        tower5.setPosition(new CoOrdinate(1200,1150));
        Tower tower6 = new Tower();
        tower6.setPosition(new CoOrdinate(2150,700));
        Tower tower7 = new Tower();
        tower7.setPosition(new CoOrdinate(2150,1150));
        Tower tower8 = new Tower();
        tower8.setPosition(new CoOrdinate(2200,1600));
        Tower tower9 = new Tower();
        tower9.setPosition(new CoOrdinate(1700,1600));
        Tower tower10 = new Tower();
        tower10.setPosition(new CoOrdinate(490,1400));
        Tower tower11 = new Tower();
        tower11.setPosition(new CoOrdinate(460,1700));
        Tower tower12 = new Tower();
        tower12.setPosition(new CoOrdinate(1650,180));

        /** set towers for MAP */
        MAP_LEVEL1.addTower(tower1);
        MAP_LEVEL1.addTower(tower2);
        MAP_LEVEL1.addTower(tower3);
        MAP_LEVEL1.addTower(tower4);
        MAP_LEVEL1.addTower(tower5);
        MAP_LEVEL1.addTower(tower6);
        MAP_LEVEL1.addTower(tower7);
        MAP_LEVEL1.addTower(tower8);
        MAP_LEVEL1.addTower(tower9);
        MAP_LEVEL1.addTower(tower10);
        MAP_LEVEL1.addTower(tower11);
        MAP_LEVEL1.addTower(tower12);

        // set A WindMill for map
        WindMill windMill = new WindMill();
        windMill.setPosition(new CoOrdinate(2200,1800));
        MAP_LEVEL1.addWindmill(windMill);

        MAP_LEVEL1.setCoinNumber(1000);
        MAP_LEVEL1.setHeartNumber(15);

        // create a bird
        Bird b = new Bird();
        MAP_LEVEL1.addBird(b);

        MAP_LEVEL1.addWaves(wave1);
        MAP_LEVEL1.addWaves(wave2);
    }
}
