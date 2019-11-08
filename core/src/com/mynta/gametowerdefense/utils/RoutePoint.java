package com.mynta.gametowerdefense.utils;

import com.mynta.gametowerdefense.enums.Direction;

/**
 * The path is marked by the pegs called RoutePoint
 */
public class RoutePoint {
    public CoOrdinate position;
    public Direction direction;

    public RoutePoint(){
        direction = Direction.GO_RIGHT;
    }
    public RoutePoint(CoOrdinate position,Direction direction){
        this.position = position;
        this.direction = direction;
    }

    public void setPosition(CoOrdinate position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
