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
import static com.mynta.gametowerdefense.utils.Constants.MAP_LEVEL2;


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

        Route route2Left = new Route();
        Route route2Center = new Route();
        Route route2Right = new Route();

        /** The number of towers that a player able to build. */
        List<CoOrdinate> listTower = new ArrayList<>();

        /** The number of waves */
        List<Wave> wavesList = new ArrayList<>();

        /** set route 1 */
        route1Right.setStartingPoint(new RoutePoint(new CoOrdinate(-200,390), Direction.GO_RIGHT));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(1900,390),Direction.GO_UP));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(2040,520),Direction.GO_UP));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(2040,1300),Direction.GO_RIGHT));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(2100,1350),Direction.GO_RIGHT));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(2950, 1350),Direction.GO_RIGHT));
        route1Right.setRouteStyle(RouteStyle.RIGHT);

        route1Center.setStartingPoint(new RoutePoint(new CoOrdinate(-200,470), Direction.GO_RIGHT));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(1800,470),Direction.GO_UP));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(1945,570),Direction.GO_UP));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(1945,1365),Direction.GO_RIGHT));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(2000,1425),Direction.GO_RIGHT));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(2950, 1425),Direction.GO_RIGHT));
        route1Center.setRouteStyle(RouteStyle.CENTER);

        route1Left.setStartingPoint(new RoutePoint(new CoOrdinate(-200,530), Direction.GO_RIGHT));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(1760,530),Direction.GO_UP));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(1880,600),Direction.GO_UP));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(1880,1330),Direction.GO_RIGHT));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(2010,1510),Direction.GO_UP));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(2950, 1510),Direction.GO_RIGHT));
        route1Left.setRouteStyle(RouteStyle.LEFT);


        /* Set Route 2 */
        route2Right.setStartingPoint(new RoutePoint(new CoOrdinate( 680,2600), Direction.GO_RIGHT));
        route2Right.addPoint(new RoutePoint(new CoOrdinate(680,2600),Direction.GO_DOWN));
        route2Right.addPoint(new RoutePoint(new CoOrdinate(680,1450),Direction.GO_RIGHT));
        route2Right.addPoint(new RoutePoint(new CoOrdinate(780,1350),Direction.GO_RIGHT));
        route2Right.addPoint(new RoutePoint(new CoOrdinate(2950, 1350),Direction.GO_RIGHT));
        route2Right.setRouteStyle(RouteStyle.RIGHT);

        route2Center.setStartingPoint(new RoutePoint(new CoOrdinate( 750,2500), Direction.GO_RIGHT));
        route2Center.addPoint(new RoutePoint(new CoOrdinate(750,2600),Direction.GO_DOWN));
        route2Center.addPoint(new RoutePoint(new CoOrdinate(750,1500),Direction.GO_RIGHT));
        route2Center.addPoint(new RoutePoint(new CoOrdinate(800,1445),Direction.GO_RIGHT));
        route2Center.addPoint(new RoutePoint(new CoOrdinate(2950, 1445),Direction.GO_RIGHT));
        route2Center.setRouteStyle(RouteStyle.RIGHT);

        route2Left.setStartingPoint(new RoutePoint(new CoOrdinate( 810,2600), Direction.GO_RIGHT));
        route2Left.addPoint(new RoutePoint(new CoOrdinate(810,2600),Direction.GO_DOWN));
        route2Left.addPoint(new RoutePoint(new CoOrdinate(810,1550),Direction.GO_RIGHT));
        route2Left.addPoint(new RoutePoint(new CoOrdinate(850,1500),Direction.GO_RIGHT));
        route2Left.addPoint(new RoutePoint(new CoOrdinate(2950, 1500),Direction.GO_RIGHT));
        route2Left.setRouteStyle(RouteStyle.RIGHT);

        /** Set Wave */


        Wave wave1 = new Wave();
        wave1.addWitches(route2Left,8, 800,0);
        wave1.addFlyMonsters(route2Center,6,2000,0);
        wave1.addWitches(route2Right,8, 3500,0);
        wave1.addWitches(route1Right, 3, 5000, 0);
        wave1.addWitches(route1Left, 3, 300, 0);
        wave1.addWitches(route1Center,5, 2000, 0);
        wave1.addFlyMonsters(route1Center,5,1500,0);
        wave1.addWitches(route1Left,4,2500,0);

        Wave wave2 = new Wave();
        wave2.addFlyMonsters(route1Left,9, 0,0);
        wave2.addFlyMonsters(route1Center,3,600,0);
        wave2.addWitches(route2Center,2,1000,0);
        wave2.addWitches(route2Left,2,1200,0);
        wave2.addWitches(route2Center,3,1500,0);
        wave2.addFlyMonsters(route1Center,8,4000,0);
        wave2.addWitches(route1Right,4,3000,0);
        wave2.addWitches(route1Center,4,3800,0);
        wave2.addWitches(route2Right,5,4000,0);

        Wave wave3 = new Wave();
        wave3.addFlyMonsters(route1Center,8,0,0);
        wave3.addWitches(route2Center,2,1000,0);
        wave3.addWitches(route2Left,2,1200,0);
        wave3.addWitches(route2Right,3,1500,0);
        wave3.addFlyMonsters(route2Center,6,5000,0);
        wave3.addBigEnemies(route2Center,3,7000,0);
        wave3.addFlyMonsters(route1Right,4, 1300,0);
        wave3.addWitches(route1Center,3,2000,0);
        wave3.addFlyMonsters(route1Center,8,4000,0);
        wave3.addFlyMonsters(route1Left,3,5900,0);
        wave3.addWitches(route1Center,4,6000,0);
        wave3.addBigEnemies(route1Center,2,7600,0);

        Wave wave4 = new Wave();
        wave4.addFlyMonsters(route1Center,4, 0,0);
        wave4.addFlyMonsters(route2Center,4,2000,0);
        wave4.addWitches(route2Left,3,3000,0);
        wave4.addWitches(route2Right,4, 3900,0);
        wave4.addFlyMonsters(route2Right,6,5000,0);
        wave4.addBigEnemies(route1Center,4,10000,0);
        wave4.addWitches(route1Right,2,400,0);
        wave4.addFlyMonsters(route1Left,3,900,0);
        wave4.addFlyMonsters(route1Center,6,1300,0);
        wave4.addFlyMonsters(route1Right,2,1900,0);
        wave4.addWitches(route1Center,6,3500,0);
        wave4.addFlyMonsters(route1Right,3,6000,0);
        wave4.addFlyMonsters(route1Center,4,6500,0);
        wave4.addWitches(route1Center,4, 5300,0);
        wave4.addWitches(route1Left,8,7000,0);
        wave4.addBigEnemies(route1Center,6,10000,0);

        Wave wave5 = new Wave();
        wave5.addFlyMonsters(route1Center,10,200,0);
        wave5.addWitches(route1Left,5,800,0);
        wave5.addWitches(route1Right,4,1000,0);
        wave5.addFlyMonsters(route2Center,10,2000,0);
        wave5.addFlyMonsters(route2Left,4,2500,0);
        wave5.addWitches(route2Right,4,3000,0);
        wave5.addFlyMonsters(route1Left,4,5000,0);
        wave5.addFlyMonsters(route2Center,5,4000,0);
        wave5.addBigEnemies(route1Center,4,6000,0);
        wave5.addFlyMonsters(route1Center,8,9000,0);
        wave5.addWitches(route2Center,4,10000,0);
        wave5.addWitches(route2Left,4,11000,0);
        wave5.addFlyMonsters(route1Right,4,12000,0);

        Wave wave6 = new Wave();
        wave6.addWitches(route2Center,3,0,0);
        wave6.addWitches(route2Right,3,200,0);
        wave6.addWitches(route2Left,2,400,0);
        wave6.addFlyMonsters(route2Center,5,2000,0);
        wave6.addWitches(route1Center,4,2000,0);
        wave6.addFlyMonsters(route1Left,8,2500,0);
        wave6.addFlyMonsters(route2Center,10,4000,0);
        wave6.addWitches(route1Left,8,6000,0);
        wave6.addWitches(route1Center,4,7000,0);
        wave6.addFlyMonsters(route2Center,16,9000,0);
        wave6.addBigEnemies(route1Center,5,12000,0);
        wave6.addWitches(route1Left,4,13000,0);
        wave6.addBigEnemies(route1Right,4,14000,0);

        Wave wave7 = new Wave();
        wave7.addFlyMonsters(route1Center,10,0,0);
        wave7.addWitches(route2Left,4,1000,0);
        wave7.addWitches(route2Center,4,1900,0);
        wave7.addBigEnemies(route1Center,8,22000,0);
        wave7.addBigEnemies(route1Left,2,3400,0);
        wave7.addWitches(route1Right,4,5000,0);
        wave7.addFlyMonsters(route2Right,12,8000,0);
        wave7.addWitches(route2Center,4,13000,0);
        wave7.addBigEnemies(route2Left,4,14000,0);
        wave7.addWitches(route1Center,5,6000,0);
        wave7.addFlyMonsters(route1Center,20,9000,0);
        wave7.addWitches(route1Left,4,10000,0);
        wave7.addBigEnemies(route1Center,2,16500,0);
        wave7.addFlyMonsters(route2Center,16,19000,0);
        wave7.addFlyMonsters(route1Left,10,16000,0);


        Wave wave8 = new Wave();
        wave8.addFlyMonsters(route1Center,8,0,0);
        wave8.addWitches(route2Right,4,1000,0);
        wave8.addWitches(route2Center,5,1900,0);
        wave8.addBigEnemies(route1Center,8,21000,0);
        wave8.addFlyMonsters(route2Right,10,4000,0);
        wave8.addBigEnemies(route1Left,2,3400,0);
        wave8.addWitches(route1Right,4,5000,0);
        wave8.addFlyMonsters(route2Right,12,8000,0);
        wave8.addWitches(route2Center,4,13000,0);
        wave8.addBigEnemies(route2Left,4,14000,0);
        wave8.addWitches(route1Center,5,6000,0);
        wave8.addWitches(route1Right,4,6300,0);
        wave8.addFlyMonsters(route1Center,20,9000,0);
        wave8.addWitches(route1Left,4,10000,0);
        wave8.addBigEnemies(route1Center,2,16500,0);
        wave8.addFlyMonsters(route2Center,16,19000,0);
        wave8.addFlyMonsters(route1Left,10,16000,0);
        wave8.addWitches(route2Center,5,18000,0);
        wave8.addWitches(route2Left,4,18400,0);
        wave8.addWitches(route2Right,3,19000,0);
        wave8.addFlyMonsters(route1Center,16,23000,0);
        wave8.addFlyMonsters(route1Left,10,23500,0);
        wave8.addFlyMonsters(route1Right,10,25000,0);

        // create Towers
        Tower tower1 = new Tower();
        tower1.setPosition(new CoOrdinate(450,630));
        tower1.setPositionOrigin(new CoOrdinate(546,520));
        Tower tower2 = new Tower();
        tower2.setPosition(new CoOrdinate(1600,630));
        tower2.setPositionOrigin(new CoOrdinate(1700,520));
        Tower tower3 = new Tower();
        tower3.setPosition(new CoOrdinate(1100,630));
        tower3.setPositionOrigin(new CoOrdinate(1200,520));
        Tower tower4 = new Tower();
        tower4.setPosition(new CoOrdinate(1600,1150));
        tower4.setPositionOrigin(new CoOrdinate(1700,1480));
        Tower tower5 = new Tower();
        tower5.setPosition(new CoOrdinate(1200,1150));
        tower5.setPositionOrigin(new CoOrdinate(1250,1480));
        Tower tower6 = new Tower();
        tower6.setPosition(new CoOrdinate(2150,700));
        tower6.setPositionOrigin(new CoOrdinate(2000,800));
        Tower tower7 = new Tower();
        tower7.setPosition(new CoOrdinate(2150,1150));
        tower7.setPositionOrigin(new CoOrdinate(2250,1480));
        Tower tower8 = new Tower();
        tower8.setPosition(new CoOrdinate(2200,1600));
        tower8.setPositionOrigin(new CoOrdinate(2300,1470));
        Tower tower9 = new Tower();
        tower9.setPosition(new CoOrdinate(1700,1600));
        tower9.setPositionOrigin(new CoOrdinate(1800,1470));
        Tower tower10 = new Tower();
        tower10.setPosition(new CoOrdinate(490,1400));
        tower10.setPositionOrigin(new CoOrdinate(830,1550));
        Tower tower11 = new Tower();
        tower11.setPosition(new CoOrdinate(460,1700));
        tower11.setPositionOrigin(new CoOrdinate(830,1800));
        Tower tower12 = new Tower();
        tower12.setPosition(new CoOrdinate(1650,180));
        tower12.setPositionOrigin(new CoOrdinate(1650,510));

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
        MAP_LEVEL1.addWaves(wave3);
        MAP_LEVEL1.addWaves(wave4);
        MAP_LEVEL1.addWaves(wave5);
        MAP_LEVEL1.addWaves(wave6);
        MAP_LEVEL1.addWaves(wave7);
        MAP_LEVEL1.addWaves(wave8);
    }

    public static void MAP_LEVEL2(){

        MAP_LEVEL2 = new MapGame();
        MAP_LEVEL2.setBackground(2);

        // route that the enemy moves
        Route route1Left = new Route();
        Route route1Center = new Route();
        Route route1Right = new Route();

        Route route2Left = new Route();
        Route route2Center = new Route();
        Route route2Right = new Route();

        /** The number of towers that a player able to build. */
        List<CoOrdinate> listTower = new ArrayList<>();

        /** The number of waves */
        List<Wave> wavesList = new ArrayList<>();

        /** set route 1 */
        route1Right.setStartingPoint(new RoutePoint(new CoOrdinate(-200,770), Direction.GO_RIGHT));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(840,770),Direction.GO_UP));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(840,1365),Direction.GO_UP));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(1380,1365),Direction.GO_RIGHT));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(1380,580),Direction.GO_RIGHT));
        route1Right.addPoint(new RoutePoint(new CoOrdinate(2930, 580),Direction.GO_RIGHT));
        route1Right.setRouteStyle(RouteStyle.RIGHT);

        route1Center.setStartingPoint(new RoutePoint(new CoOrdinate(-200,850), Direction.GO_RIGHT));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(760,850),Direction.GO_UP));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(760,1430),Direction.GO_UP));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(1450,1430),Direction.GO_RIGHT));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(1450,650),Direction.GO_RIGHT));
        route1Center.addPoint(new RoutePoint(new CoOrdinate(2950, 650),Direction.GO_RIGHT));
        route1Center.setRouteStyle(RouteStyle.CENTER);

        route1Left.setStartingPoint(new RoutePoint(new CoOrdinate(-200,910), Direction.GO_RIGHT));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(680,910),Direction.GO_UP));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(680,1510),Direction.GO_UP));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(1520,1510),Direction.GO_RIGHT));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(1520,720),Direction.GO_UP));
        route1Left.addPoint(new RoutePoint(new CoOrdinate(2950,720),Direction.GO_RIGHT));
        route1Left.setRouteStyle(RouteStyle.LEFT);



        /** Set Wave */


        Wave wave1 = new Wave();
        wave1.addWitches(route1Right, 3, 200, 0);
        wave1.addWitches(route1Left, 3, 300, 0);
        wave1.addWitches(route1Center, 3, 350, 0);

        wave1.addFlyMonsters(route1Left,10,1000,0);
        wave1.addFlyMonsters(route1Right,5,1050,0);
        wave1.addFlyMonsters(route1Center,6,1100,0);

        wave1.addWitches(route1Center,5,2000,0);
        wave1.addWitches(route1Left,6,2200,0);
        wave1.addWitches(route1Right,4,2300,0);

        wave1.addFlyMonsters(route1Center,10,3500,0);
        wave1.addFlyMonsters(route1Left,4,4000,0);
        wave1.addWitches(route1Right,4,4500,0);
        wave1.addFlyMonsters(route1Center,10,6000,0);

        Wave wave2 = new Wave();
        wave2.addFlyMonsters(route1Center,10,200,0);
        wave2.addWitches(route1Left,4,800,0);
        wave2.addWitches(route1Right,5,1000,0);

        wave2.addFlyMonsters(route1Center,30,2000,0);
        wave2.addFlyMonsters(route1Left,30,2200,0);
        wave2.addWitches(route1Right,10,3000,0);
        wave2.addWitches(route1Center,8,5000,0);
        wave2.addWitches(route1Left,8,5200,0);
        wave2.addFlyMonsters(route1Right,10,6000,0);

        wave2.addBigEnemies(route1Center,10,8000,0);
        wave2.addFlyMonsters(route1Left,10,8500,0);

        Wave wave3 = new Wave();
        wave3.addFlyMonsters(route1Center,13,-200,0);
        wave3.addWitches(route1Left,4,1200,0);
        wave3.addWitches(route1Right,5,1000,0);

        wave3.addFlyMonsters(route1Center,30,2400,0);
        wave3.addFlyMonsters(route1Left,30,2200,0);
        wave3.addWitches(route1Right,10,4000,0);
        wave3.addWitches(route1Center,8,6000,0);
        wave3.addWitches(route1Left,10,6200,0);
        wave3.addFlyMonsters(route1Right,10,7000,0);

        wave3.addBigEnemies(route1Center,10,9000,0);
        wave3.addFlyMonsters(route1Left,10,9500,0);
        wave3.addBigEnemies(route1Center,10,12000,0);
        wave3.addBigEnemies(route1Left,10,12000,0);
        wave3.addBigEnemies(route1Right,10,12000,0);
        wave3.addFlyMonsters(route1Center,10,15000,0);
        wave3.addFlyMonsters(route1Left,10,15000,0);
        wave3.addFlyMonsters(route1Right,10,15000,0);


        // create Towers
        Tower tower1 = new Tower();
        tower1.setPosition(new CoOrdinate(100,600));
        tower1.setPositionOrigin(new CoOrdinate(250,900));
        Tower tower2 = new Tower();
        tower2.setPosition(new CoOrdinate(650,600));
        tower2.setPositionOrigin(new CoOrdinate(800,900));
        Tower tower3 = new Tower();
        tower3.setPosition(new CoOrdinate(1400,400));
        tower3.setPositionOrigin(new CoOrdinate(1570,690));
        Tower tower4 = new Tower();
        tower4.setPosition(new CoOrdinate(1400,1620));
        tower4.setPositionOrigin(new CoOrdinate(1550,1500));
        Tower tower5 = new Tower();
        tower5.setPosition(new CoOrdinate(1050,1160));
        tower5.setPositionOrigin(new CoOrdinate(1200,1520));
        Tower tower6 = new Tower();
        tower6.setPosition(new CoOrdinate(2250,400));
        tower6.setPositionOrigin(new CoOrdinate(2400,690));
        Tower tower7 = new Tower();
        tower7.setPosition(new CoOrdinate(2250,820));
        tower7.setPositionOrigin(new CoOrdinate(2250,700));


        /** set towers for MAP */
        MAP_LEVEL2.addTower(tower1);
        MAP_LEVEL2.addTower(tower2);
        MAP_LEVEL2.addTower(tower3);
        MAP_LEVEL2.addTower(tower4);
        MAP_LEVEL2.addTower(tower5);
        MAP_LEVEL2.addTower(tower6);
        MAP_LEVEL2.addTower(tower7);

        // set A WindMill for map

        MAP_LEVEL2.setCoinNumber(1000);
        MAP_LEVEL2.setHeartNumber(15);

        // create a bird
        Bird b = new Bird();
        MAP_LEVEL2.addBird(b);

        MAP_LEVEL2.addWaves(wave1);
        MAP_LEVEL2.addWaves(wave2);
        MAP_LEVEL2.addWaves(wave3);
    }
}
