package com.wsu.towerdefense;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.Image;

/**
 * Class that controls the Tower objects on the Map
 */
public class Tower extends AbstractMapObject {

    public Tower(Point someLocation, Image someImage) {
        super(someLocation, someImage);
    }

    /**
     * @param delta amount of time that has passed between updates
     */
    @Override
    protected void update(double delta) {

    }

    /**
     * @param lerp   interpolation factor
     */
    @Override
    protected void render(double lerp, Canvas canvas, Paint paint) {

    }

}
