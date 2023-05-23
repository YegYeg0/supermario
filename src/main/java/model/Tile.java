package model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    float x ;
    float y ;
    int width;
    Rectangle solidArea ;
    int height;
    public BufferedImage image;
    public boolean collision = false;

    public Tile(){
//        this.x = x;
//        this.y = y;
        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 50;
        solidArea.height = 50;

        width = 50;
        height = 50;
    }



    public float getLeft(){
        return x;
    }
    public float getRight(){
        return x + width;
    }
    public float getTop(){
        return y;
    }
    public float getBottom(){
        return y +height;
    }
    public void setLeft(float newLeft){
        x = newLeft;
    }
    public void setRight(float newRight){
        x = newRight - width;
    }
    public void setTop(float newTop){
        y = newTop;
    }
    public void setBottom(float newBottom){
        y = newBottom - height;
    }
}
