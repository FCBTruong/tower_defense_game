package com.mynta.gametowerdefense.GameFunction;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.FlagsLevelAssets;
import com.mynta.gametowerdefense.utils.CalculationFunction;
import com.mynta.gametowerdefense.utils.CoOrdinate;
import com.mynta.gametowerdefense.utils.TouchInfo;

public class ChooseLevel {
    private Sprite showLevel;
    private Sprite showLevelWin;
    public boolean status; // win or not
    private CoOrdinate position;

    public ChooseLevel(int level){
        status = false;
        switch (level) {
            case 1:
                showLevel = new Sprite(FlagsLevelAssets.textureLevel1);
                showLevel.setPosition(1000,1000);
                break;
        }
        position = new CoOrdinate();
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setPosition(CoOrdinate position) {
        this.position = position;
        showLevel.setPosition(position.x,position.y);
    }

    public void show(SpriteBatch batch){
        if(!status){
            showLevel.draw(batch);
        }
    }

    public boolean Touch(){
        if(CalculationFunction.circleDetect(new CoOrdinate(position.x + 75, position.y + 75),75, TouchInfo.touchX, TouchInfo.touchY))
            return true;
        return false;
    }
}
