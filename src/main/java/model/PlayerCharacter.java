package model;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public abstract class PlayerCharacter implements KeyListener{

    public boolean upPressed, downPressed, rightPressed, leftPressed;
    public int minXWorld = 75;

    public Game game ;
    public int type = 0;

    public int firstHeightJump;
    public Rectangle solidArea;
    public boolean collidedWithObject = false;
    private boolean isJumping = false;
    private boolean isJumpingUp = false;
    private int worldX;
    private int worldY;
    public int screenX;
    public int screenY;
    private int height;
    private int width;
    private int xVelocity;
    private int yVelocity;
    private int ySpeed;
    private int xSpeed;
    public BufferedImage run1 ,runLeft1, run2, runLeft2, run3, runLeft3 , stand , jump ,jumpLeft;
    public Direction direction;
    public int spriteCounter = 0;
    public int spriteNum = 1 ;
    public boolean collisionOn = false;
    public int numOfCoins =0;

    public abstract void setDefaultValues();
    public abstract void getPlayerImage();
    public abstract void draw(Graphics2D g);
    public abstract void update1();
    public abstract void findDirection();
    public abstract void objectsCollisionHandler();

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public boolean isJumpingUp() {
        return isJumpingUp;
    }

    public void setJumpingUp(boolean jumpingUp) {
        isJumpingUp = jumpingUp;
    }

}
