package model;
import controller.Main;
import view.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Mario extends PlayerCharacter {

    GamePanel gp;
    int gravity = 1;

    public Mario(GamePanel gp , int type) {
        this.game = new Game();
        this.type = type;
        screenX = 300;
        screenY = 750;
        this.gp = gp;
        solidArea = new Rectangle();
        solidArea.x = 5;
        solidArea.y = 10;
        solidArea.width = 40;
        solidArea.height = 40;
        this.setDefaultValues();
        this.getPlayerImage();
    }

    public void setDefaultValues() {
        System.out.println(type);
        this.setWidth(50);
        this.setHeight(50);
        this.setWorldX(300);
        this.setWorldY(750);
        this.setxVelocity(0);
        this.setyVelocity(0);
        direction = Direction.STAND;
        if(type == 0) {
            this.setxSpeed(5);
            this.setySpeed(25);
        }
        else if(type == 1){
            this.setxSpeed(5);
            this.setySpeed(25);
        }
        else if(type == 2){
            this.setxSpeed(5);
            this.setySpeed(25);
        }
        else if(type == 3){
            this.setxSpeed(5);
            this.setySpeed(25);
        }
        else if(type == 4){
            this.setxSpeed(5);
            this.setySpeed(25);
        }

    }

    public void getPlayerImage() {
        try {
            if(type == 0) {
                stand = ImageIO.read(Files.newInputStream(Paths.get("res/player/stand.png")));
                run2 = ImageIO.read(Files.newInputStream(Paths.get("res/player/run-2.png")));
                runLeft2 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runleft-2.png")));
                run3 = ImageIO.read(Files.newInputStream(Paths.get("res/player/run-3.png")));
                runLeft3 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runleft-3.png")));
                jump = ImageIO.read(Files.newInputStream(Paths.get("res/player/jump.png")));
                jumpLeft = ImageIO.read(Files.newInputStream(Paths.get("res/player/jumpleft.png")));
            }
            else if(type == 1){
                stand = ImageIO.read(Files.newInputStream(Paths.get("res/player/standGreen.png")));
                run2 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runGreen-2.png")));
                runLeft2 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runLeftGreen-2.png")));
                run3 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runGreen-3.png")));
                runLeft3 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runLeftGreen-3.png")));
                jump = ImageIO.read(Files.newInputStream(Paths.get("res/player/jumpGreen.png")));
                jumpLeft = ImageIO.read(Files.newInputStream(Paths.get("res/player/jumpleftGreen.png")));
            }
            else if(type == 2){
                stand = ImageIO.read(Files.newInputStream(Paths.get("res/player/standPurple.png")));
                run2 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runPurple-2.png")));
                runLeft2 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runLeftPurple-2.png")));
                run3 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runPurple-3.png")));
                runLeft3 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runLeftPurple-3.png")));
                jump = ImageIO.read(Files.newInputStream(Paths.get("res/player/jumpPurple.png")));
                jumpLeft = ImageIO.read(Files.newInputStream(Paths.get("res/player/jumpleftPurple.png")));
            }
            else if(type == 3){
                stand = ImageIO.read(Files.newInputStream(Paths.get("res/player/standOrange.png")));
                run2 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runOrange-2.png")));
                runLeft2 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runLeftOrange-2.png")));
                run3 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runOrange-3.png")));
                runLeft3 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runLeftOrange-3.png")));
                jump = ImageIO.read(Files.newInputStream(Paths.get("res/player/jumpOrange.png")));
                jumpLeft = ImageIO.read(Files.newInputStream(Paths.get("res/player/jumpleftOrange.png")));
            }
            else if(type ==4){
                stand = ImageIO.read(Files.newInputStream(Paths.get("res/player/standPink.png")));
                run2 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runPink-2.png")));
                runLeft2 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runLeftPink-2.png")));
                run3 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runPink-3.png")));
                runLeft3 = ImageIO.read(Files.newInputStream(Paths.get("res/player/runLeftPink-3.png")));
                jump = ImageIO.read(Files.newInputStream(Paths.get("res/player/jumpPink.png")));
                jumpLeft = ImageIO.read(Files.newInputStream(Paths.get("res/player/jumpleftPink.png")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update1() {
        this.findDirection();
        collisionOn = false;
        gp.collisionChecker.checkTile(this);


        this.setJumpingUp(this.getyVelocity() + gravity <= 0);
        gp.collisionChecker.checkTileForJump(this);
        this.setWorldY(this.getWorldY() + this.getyVelocity());
        this.setyVelocity(this.getyVelocity() + gravity);

        if(this.getWorldY() >800){

            if(Main.user.games[Main.user.numberOfCurrentGame].gameLivesLeft >0) {
                Main.user.games[Main.user.numberOfCurrentGame].gameLivesLeft--;
                if(getWorldX() >= 7500){
                    this.setWorldX(7600);
                } else {
                    this.setWorldX(300);
                }
                this.setWorldY(750);
            }
            else{
                Main.user.allNumberOfCoins += Main.user.games[Main.user.numberOfCurrentGame].gameCoinsEarned;
                if (Main.user.highestScore < Main.user.games[Main.user.numberOfCurrentGame].gameScore) {
                    Main.user.highestScore =Main.user.games[Main.user.numberOfCurrentGame].gameScore;
                }
                File file = new File("./" + Main.user.getId() + ".json");
                try {
                    FileWriter fileWriter = new FileWriter("./" + Main.user.getId() + ".json");
                    Main.objectMapper.writeValue(file , Main.user);
                    fileWriter.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Main.user.games[Main.user.numberOfCurrentGame] = null;
                Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "gameMainPage");
                Main.mainFrame.GPL1S1.gameThread = null;
                gp.timer.stop();
            }
        }
        objectsCollisionHandler();

        if (!collisionOn) {

            this.setWorldX(this.getWorldX() + this.getxVelocity());
            if(getWorldX() <= minXWorld){
                setWorldX(minXWorld);
            }
            if(getWorldX() >= (gp.tileManager.maxWorldCol * 50) - 25){
                setWorldX((gp.tileManager.maxWorldCol * 50) - 25);
            }
            if(getWorldX() <= 300){
                setWorldX(300);
            }
            if(getWorldX() ==7500){
                minXWorld = 7600;
                int secondsLeft = gp.countDown;
                Main.user.games[Main.user.numberOfCurrentGame].gameScore +=
                        (Main.user.games[Main.user.numberOfCurrentGame].gameCoinsEarned * 10)+
                        (secondsLeft )+(Main.user.games[Main.user.numberOfCurrentGame].gameLivesLeft * 20);
                gp.countDown = 200;
                Main.user.games[Main.user.numberOfCurrentGame].section++;
            }
            if (getWorldX() >=14800) {
                int secondsLeft = gp.countDown;
                Main.user.games[Main.user.numberOfCurrentGame].gameScore +=
                        (Main.user.games[Main.user.numberOfCurrentGame].gameCoinsEarned * 10)+
                                (secondsLeft )+(Main.user.games[Main.user.numberOfCurrentGame].gameLivesLeft * 20);
                Main.user.allNumberOfCoins += Main.user.games[Main.user.numberOfCurrentGame].gameCoinsEarned;
                if (Main.user.highestScore < Main.user.games[Main.user.numberOfCurrentGame].gameScore) {
                    Main.user.highestScore =Main.user.games[Main.user.numberOfCurrentGame].gameScore;
                }
                Main.user.games[Main.user.numberOfCurrentGame] = null;
                Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "gameMainPage");
                gp.gameThread = null;
                gp.timer.stop();
            }
        }
    }
    public void objectsCollisionHandler(){

        int i = gp.collisionChecker.checkObjectsCollision(this , true);
        if(collidedWithObject){
            if(i != 1379){
                if(gp.objects[i] instanceof Coin){
                    gp.objects[i] = null;
                    if(Main.user.games[Main.user.numberOfCurrentGame] != null) {
                        Main.user.games[Main.user.numberOfCurrentGame].gameCoinsEarned++;
                    }
                }
                else if(gp.objects[i] instanceof PlantEnemy){

                    if(Main.user.games[Main.user.numberOfCurrentGame].gameLivesLeft >0) {
                        Main.user.games[Main.user.numberOfCurrentGame].gameLivesLeft--;
                        if(getWorldX() >= 7500){
                            this.setWorldX(7600);
                        } else {
                            this.setWorldX(300);
                        }
                    }
                    else{
                        Main.user.allNumberOfCoins += Main.user.games[Main.user.numberOfCurrentGame].gameCoinsEarned;
                        if (Main.user.highestScore < Main.user.games[Main.user.numberOfCurrentGame].gameScore) {
                            Main.user.highestScore =Main.user.games[Main.user.numberOfCurrentGame].gameScore;
                        }
                        File file = new File("./" + Main.user.getId() + ".json");
                        try {
                            FileWriter fileWriter = new FileWriter("./" + Main.user.getId() + ".json");
                            Main.objectMapper.writeValue(file , Main.user);
                            fileWriter.close();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        Main.user.games[Main.user.numberOfCurrentGame] = null;
                        Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "gameMainPage");
                        gp.gameThread = null;
                        gp.timer.stop();
                    }
                }
            }
            collidedWithObject = false;
        }
    }

    public void findDirection() {
        if (leftPressed || rightPressed
                || upPressed || downPressed) {


            if(upPressed && !rightPressed && !leftPressed){
                direction= Direction.JUSTUP;
            }
            if (rightPressed && !upPressed) {
                direction = Direction.RIGHT;

            }
            else if (rightPressed && upPressed) {
                direction = Direction.UPTORIGHT;
            }

            else if (leftPressed && !upPressed) {
                direction = Direction.LEFT;

            }
            else if (leftPressed && upPressed) {
                direction = Direction.UPTOLEFT;

            }
            else if (downPressed) {
                direction = Direction.DOWN;
            }
            spriteCounter++;
            if (spriteCounter > 10) {

                if (spriteNum == 1) {
                    spriteNum = 2;

                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else {
            direction = Direction.STAND;

        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case RIGHT:
                if (spriteNum == 1) {
                    image = run2;
                }
                if (spriteNum == 2) {
                    image = run3;
                }
                break;
            case LEFT:
                if (spriteNum == 1) {
                    image = runLeft2;
                }
                if (spriteNum == 2) {
                    image = runLeft3;
                }
                break;
            case STAND:
                image = stand;
                break;
            case UPTORIGHT:
                image = jump;
                break;
            case JUSTUP:
                image = jump;
                break;
            case UPTOLEFT:
                image = jumpLeft;
                break;

        }
        g2.drawImage(image, screenX, getWorldY(), getWidth(), getHeight(), null);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            if (!this.isJumping()) {
                firstHeightJump = this.getWorldY() + this.getHeight();
                this.setJumping(true);
                upPressed = true;
                this.setyVelocity(-this.getySpeed());
            }
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed = true;
//            this.setyVelocity(this.getySpeed());
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
            this.setxVelocity(this.getxSpeed());
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = true;
            this.setxVelocity(-this.getxSpeed());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
            this.setxVelocity(0);
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = false;
            this.setxVelocity(0);
        }
    }
}


