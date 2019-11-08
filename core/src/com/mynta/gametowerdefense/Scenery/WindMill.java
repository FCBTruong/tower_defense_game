package com.mynta.gametowerdefense.Scenery;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mynta.gametowerdefense.Assets.WindmillAssets;
import com.mynta.gametowerdefense.utils.AnimationAct;
import com.mynta.gametowerdefense.utils.CoOrdinate;

/**
 *  a windmill.
 */

public class WindMill {
    private AnimationAct propeller;
    private CoOrdinate position;
    private final float SIZE_WIND_MILL = 300;
    private Sprite post;

    public WindMill(){
         propeller = new AnimationAct();
         propeller.setAnimation(WindmillAssets.textureAtlasWindmill);
         position = new CoOrdinate( 1000,1300);
         post = new Sprite(WindmillAssets.texturePost);
         post.setSize(400,400);
         post.setPosition(950,1220);
    }

    public void setPosition(CoOrdinate position) {
        this.position = position;
        post.setPosition(position.x - 50, position.y - 80);
    }

    public void show(SpriteBatch batch){
        post.draw(batch);
        propeller.show(batch, position, SIZE_WIND_MILL, SIZE_WIND_MILL);
    }

    public void dispose(){
        propeller.dispose();
    }
}
