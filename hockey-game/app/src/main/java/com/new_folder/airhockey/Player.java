package com.new_folder.airhockey;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.math.MathUtils;
import android.util.Log;

/**
 * Created by Horus on 2/24/2018.
 */

public class Player {
    //Bitmap to get character from image
    private Bitmap bitmap,
                   spr_mood,
                   spr_glad;

    //coordinates
    private int x;
    private int y;
    private int max_x, max_y;
    private int old_x, old_y,
                slide_x, slide_y;

    //motion speed of the character
    private int speed = 1;

    private boolean snagged,
                    sliding;

    //constructor
    public Player(Context context, int screenX, int screenY) {
        x = 75;
        y = 50;
        speed = 1;

        //Getting bitmap from drawable resource
        spr_mood = BitmapFactory.decodeResource(context.getResources(), R.drawable.face1);
        spr_glad = BitmapFactory.decodeResource(context.getResources(), R.drawable.face2);
        bitmap = spr_mood;

        max_x = screenX - bitmap.getWidth();
        max_y = screenY - bitmap.getHeight();

        snagged = false;
    }

    //Method to update coordinate of character
    public void update(){
        //updating x coordinate
        //x++;
        if (snagged)
        {
            bitmap = spr_glad;
        }
        else
            bitmap = spr_mood;

        if (sliding)
        {
            x += slide_x * speed;
            y += slide_y * speed;

            speed -= 0.05 / 1000000;

            if (speed <= 0)
            {
                speed = 1;
                sliding = false;
            }
        }

        x = MathUtils.clamp(x, 0, max_x);
        y = MathUtils.clamp(y, 0, max_y);
    }

    public boolean snag(float touch_x, float touch_y) {
        if (Math.sqrt(Math.pow((touch_x - x - bitmap.getWidth()/2), 2) + Math.pow((touch_y - y - bitmap.getHeight()/2), 2)) > bitmap.getWidth()/2)
            snagged = false;
        else
            snagged = true;

        return snagged;
    }

    public void unsnag(){
        snagged = false;
        release();
    }

    public void move(float touch_x, float touch_y) {
        if (snagged)
        {
            old_x = x;
            old_y = y;

            x = (int)touch_x - bitmap.getWidth()/2;
            y = (int)touch_y - bitmap.getHeight()/2;

            x = MathUtils.clamp(x, 0, max_x);
            y = MathUtils.clamp(y, 0, max_y);
            //update previous x and y so that a release vector can be calculated
        }
    }

    public void release() {
        //if (snagged)
        {
            slide_x = x - old_x;
            slide_y = y - old_y;

            Log.d("BUTT", slide_x + " " + slide_y);

            //snagged = false;
            sliding = true;
        }
    }

    /*
    * These are getters you can generate it autmaticallyl
    * right click on editor -> generate -> getters
    * */
    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
}
