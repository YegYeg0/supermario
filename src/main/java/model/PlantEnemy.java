package model;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PlantEnemy extends GameObject{

    private int ySpeed = -3;
    private int wait = 0;
    private int minY;
    private boolean isInsidePipe = true;

    public PlantEnemy(int minY){
        this.minY = minY;

        try{
            image = ImageIO.read(Files.newInputStream(Paths.get("res/objects/plant.png")));

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        wait++;

        if(wait >= 240){

            if(isInsidePipe) {
                this.setWorldY(this.getWorldY() + ySpeed);
                if (getWorldY() <= minY) {
                    setWorldY(minY);
                    ySpeed =3 ;
                    isInsidePipe = false;
                    wait = 0;
                }
            }
            else{
                this.setWorldY(this.getWorldY() + ySpeed);
                if(getWorldY() >=minY + 50){
                    setWorldY(minY + 50);
                    ySpeed = -3;
                    isInsidePipe = true;
                    wait = 0;
                }
            }

        }

    }
}
