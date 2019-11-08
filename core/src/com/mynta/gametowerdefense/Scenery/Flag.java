package com.mynta.gametowerdefense.Scenery;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.CommonAssets;
import com.mynta.gametowerdefense.utils.AnimationAct;
import com.mynta.gametowerdefense.utils.CoOrdinate;

public class Flag {
    private AnimationAct flag;
    public Flag(){
        flag = new AnimationAct();
        flag.setAnimation(CommonAssets.textureAtlasFlag);
    }
    public void show(SpriteBatch batch){
        flag.show(batch,new CoOrdinate(1000,2000), 150,150);
    }
}
