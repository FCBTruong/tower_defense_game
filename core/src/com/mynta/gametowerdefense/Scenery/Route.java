package com.mynta.gametowerdefense.Scenery;

import com.mynta.gametowerdefense.utils.RoutePoint;

import java.util.ArrayList;
import java.util.List;

/**
 * path for enemies to move
 */

public class  Route {
    public RoutePoint startingPoint; // starting point of the actor.
    public List<RoutePoint> routePointList;
    public int pointNumber;
    public RouteStyle routeStyle;

    public Route(){
        pointNumber = 0;
        routePointList = new ArrayList<RoutePoint>();
    }

    public void addPoint(RoutePoint point){
        routePointList.add(point);
        pointNumber ++;
    }

    public void setStartingPoint(RoutePoint startingPoint) {
        this.startingPoint = startingPoint;
    }

    public void setRouteStyle(RouteStyle routeStyle) {
        this.routeStyle = routeStyle;
    }
}
