package com.mynta.gametowerdefense.utils;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TouchInfo {
    public static float touchX = 0;
    public static float touchY = 0;
    public static boolean touched = false;
    public static boolean back = false;

    public static float sizeImage = 105;
    public static Sprite spriteTouch; // = new Sprite(CommonAssets.textureTouch);
    public static int typeTouch = 0; // 0 if true, 1 if false
    public static Sprite spriteTouchFalse;
    public static Sprite spriteTouchMoveArmyTower;

    public static void show(SpriteBatch batch){
        if(typeTouch == 0) {
            if(touched) sizeImage = 30;

            if (sizeImage <= 100) {
                sizeImage += 5f;
                spriteTouch.setSize(sizeImage, sizeImage);
                spriteTouch.setPosition(touchX - sizeImage / 2, touchY - sizeImage / 2);
                spriteTouch.draw(batch);
            }
        }
        else if(typeTouch == 1){
            if(touched) sizeImage = 30;

            if (sizeImage <= 100) {
                sizeImage += 5f;
                spriteTouchFalse.setSize(sizeImage, sizeImage);
                spriteTouchFalse.setPosition(touchX - sizeImage / 2, touchY - sizeImage / 2);
                spriteTouchFalse.draw(batch);
            }
        }
        else if(typeTouch == 2){
            if(touched) sizeImage = 30;

            if (sizeImage <= 100) {
                sizeImage += 5f;
                spriteTouch.setSize(sizeImage, sizeImage);
                spriteTouch.setPosition(touchX - sizeImage / 2, touchY - sizeImage / 2);
                spriteTouch.draw(batch);

                spriteTouchMoveArmyTower.setPosition(touchX - 35, touchY - 10);
                spriteTouchMoveArmyTower.draw(batch);
            }
            else if(sizeImage <= 150){
                sizeImage += 1;
                spriteTouchMoveArmyTower.setPosition(touchX - 35, touchY - 10);
                spriteTouchMoveArmyTower.draw(batch);
            }
        }
    }
}
