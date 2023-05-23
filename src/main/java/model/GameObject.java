package model;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    public Rectangle solidArea = new Rectangle(0 , 0 , 50 ,50);
    public BufferedImage image ;
    private boolean collision  = false;
    private int worldX , worldY;


    public abstract void update();
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
    public int getWorldX() {
        return worldX;
    }
    public int getWorldY() {
        return worldY;
    }
    public void setWorldXAndY(int x , int y){
        this.worldX =x;
        this.worldY = y;
    }
    public void setWorldY(int y){
        worldY = y;
    }

}
