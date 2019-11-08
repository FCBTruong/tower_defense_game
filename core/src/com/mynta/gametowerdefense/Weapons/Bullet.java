package com.mynta.gametowerdefense.Weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.utils.CalculationFunction;
import com.mynta.gametowerdefense.utils.CoOrdinate;
import com.mynta.gametowerdefense.utils.Constants;

public abstract class Bullet {
    protected CoOrdinate position;
    protected Sprite sprite;
    protected boolean status; // true : attacking, false: nothing
    protected float speed;

    public Bullet(){
        position = new CoOrdinate(1000,1000);
        speed = 13;
        status = false;
    }

    public Bullet(int type){

    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus(){
        return status;
    }

    public void show(SpriteBatch batch){
        sprite.setPosition(this.position.x, this.position.y);
        sprite.draw(batch);
    }

    public void setPosition(CoOrdinate position) {
        this.position = new CoOrdinate(position.x, position.y);
        sprite.setPosition(this.position.x, this.position.y);
    }

    public void rotate(CoOrdinate end){
        // calculate the angle
        float w = position.x - end.x;
        float h = position.y - end.y;
        float tan;
        float ang;
        if(h != 0 )
        {
            tan = w/h;
            ang = (float)Math.atan(tan);
        }
        else{
            if(position.x > end.x) ang = 180;
            else ang = 0;
        }
        if(position.y > end.y) sprite.setRotation((3 * 1.0f/2 * Constants.PI - ang)/ Constants.PI *180);
        if(position.y < end.y) sprite.setRotation((3 * 1.0f/2 * Constants.PI - ang)/ Constants.PI *180 + 180);
    }

    /** movement of arrow
     * calculate the coordinates of the arrow, divide the distance into n intervals of length speed.
     *  algorithm ...
     * */
    public boolean move(CoOrdinate destination){
        rotate(destination);
        if(CalculationFunction.move(position,destination,speed)) return true;
        return false;
    }
}
