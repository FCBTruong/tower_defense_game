package com.mynta.gametowerdefense.utils;

public class CalculationFunction {
    public static boolean circleDetect(CoOrdinate center,float radius, CoOrdinate object){
        float distance = (object.x - center.x) * (object.x - center.x) + (object.y - center.y) * (object.y -center.y);
        if(distance <= radius) return  true;
        return false;
    }

    public static boolean circleDetect(CoOrdinate center,float radius, float x, float y){
        float distance = (x - center.x) * (x - center.x) + (y - center.y) * (y -center.y);
        if(distance <= radius * radius) return  true;
        return false;
    }

    public static boolean rectangleDetect(CoOrdinate position, float width, float height, float x, float y){
        if(x >= position.x && position.x + width >= x)
        {
            if(y >= position.y && position.y + height >= y){
                return true;
            }
        }
        return false;
    }

    public static boolean move(CoOrdinate startPoint, CoOrdinate destination, float speed){
        float r = (destination.x - startPoint.x) * (destination.x - startPoint.x) + (destination.y - startPoint.y) *
                (destination.y - startPoint.y);
        if(r <= speed * speed + 30){
            startPoint.x = destination.x;
            startPoint.y = destination.y;
            return true;
        }
        double distance = Math.sqrt(r);
        float n =(float) distance / speed;
        float xM = startPoint.x - (startPoint.x - destination.x) / n;
        float yM = startPoint.y - (startPoint.y - destination.y) / n;
        startPoint.x = xM;
        startPoint.y = yM;
        return false;
    }

    public static boolean moveToFight(CoOrdinate startPoint, CoOrdinate destination, float speed){
        float r = (destination.x - startPoint.x) * (destination.x - startPoint.x) + (destination.y - startPoint.y) *
                (destination.y - startPoint.y);
        if(r <= speed * speed + 16){
            startPoint.x = destination.x;
            startPoint.y = destination.y;
            return true;
        }
        double distance = Math.sqrt(r);
        float n =(float) distance / speed;
        float xM = startPoint.x - (startPoint.x - destination.x) / n;
        float yM = startPoint.y - (startPoint.y - destination.y) / n;
        startPoint.x = xM;
        startPoint.y = yM;
        return false;
    }
}
