package controller;

import view.GamePanel;
import model.Coin;
import model.GameObject;
import model.PlantEnemy;

import java.awt.*;

public class ObjectsManager {

    GamePanel gp;

    public ObjectsManager(GamePanel gp){
        this.gp = gp;
    }

    public void setObjectL1(){

        gp.objects[1] = new PlantEnemy(13 * 50);
        gp.objects[1].setWorldXAndY((24 * 50) - 25 , 14* 50);
        gp.objects[9] = new PlantEnemy(12 * 50);
        gp.objects[9].setWorldXAndY((31 * 50) - 25 , 13* 50);
        gp.objects[10] = new PlantEnemy(10 * 50);
        gp.objects[10].setWorldXAndY((56 * 50) - 25 , 11* 50);
        gp.objects[31] = new PlantEnemy(9 * 50);
        gp.objects[31].setWorldXAndY((133 * 50) - 25 , 10* 50);
        gp.objects[41] = new PlantEnemy(11 * 50);
        gp.objects[41].setWorldXAndY((250 * 50) - 25 , 12* 50);
        gp.objects[42] = new PlantEnemy(9 * 50);
        gp.objects[42].setWorldXAndY((283 * 50) - 25 , 10* 50);


        gp.objects[0]= new Coin();
        gp.objects[0].setWorldXAndY(1800 , 450);
        gp.objects[2]= new Coin();
        gp.objects[2].setWorldXAndY(11*50 , 10*50);
        gp.objects[3]= new Coin();
        gp.objects[3].setWorldXAndY(11*50 , 10*50);
        gp.objects[4]= new Coin();
        gp.objects[4].setWorldXAndY(12*50 , 10*50);
        gp.objects[5]= new Coin();
        gp.objects[5].setWorldXAndY(13*50 , 10*50);
        gp.objects[6]= new Coin();
        gp.objects[6].setWorldXAndY(14*50 , 10*50);
        gp.objects[7]= new Coin();
        gp.objects[7].setWorldXAndY(15*50 , 10*50);
        gp.objects[8]= new Coin();
        gp.objects[8].setWorldXAndY(16*50 , 10*50);
        gp.objects[11]= new Coin();
        gp.objects[11].setWorldXAndY(13*50 , 6*50);
        gp.objects[12]= new Coin();
        gp.objects[12].setWorldXAndY(14*50 , 6*50);
        gp.objects[13]= new Coin();
        gp.objects[13].setWorldXAndY(81*50 , 8*50);
        gp.objects[14]= new Coin();
        gp.objects[14].setWorldXAndY(82*50 , 8*50);
        gp.objects[15]= new Coin();
        gp.objects[15].setWorldXAndY(83*50 , 8*50);
        gp.objects[16]= new Coin();
        gp.objects[16].setWorldXAndY(84*50 , 8*50);
        gp.objects[17]= new Coin();
        gp.objects[17].setWorldXAndY(85*50 , 8*50);
        gp.objects[18]= new Coin();
        gp.objects[18].setWorldXAndY(86*50 , 8*50);
        gp.objects[19]= new Coin();
        gp.objects[19].setWorldXAndY(87*50 , 8*50);
        gp.objects[20]= new Coin();
        gp.objects[20].setWorldXAndY(120*50 , 11*50);
        gp.objects[21]= new Coin();
        gp.objects[21].setWorldXAndY(119*50 , 12*50);
        gp.objects[22]= new Coin();
        gp.objects[22].setWorldXAndY(120*50 , 13*50);
        gp.objects[23]= new Coin();
        gp.objects[23].setWorldXAndY(119*50 , 14*50);
        gp.objects[24]= new Coin();
        gp.objects[24].setWorldXAndY(120*50 , 15*50);
        gp.objects[25]= new Coin();
        gp.objects[25].setWorldXAndY(139*50 , 10*50);
        gp.objects[26]= new Coin();
        gp.objects[26].setWorldXAndY(141*50 , 10*50);
        gp.objects[27]= new Coin();
        gp.objects[27].setWorldXAndY(143*50 , 10*50);
        gp.objects[28]= new Coin();
        gp.objects[28].setWorldXAndY(145*50 , 10*50);
        gp.objects[29]= new Coin();
        gp.objects[29].setWorldXAndY(141*50 , 7*50);
        gp.objects[30]= new Coin();
        gp.objects[30].setWorldXAndY(143*50 , 7*50);
        gp.objects[31]= new Coin();
        gp.objects[31].setWorldXAndY(186* 50 , 14*50);
        gp.objects[32]= new Coin();
        gp.objects[32].setWorldXAndY(186* 50 , 15*50);
        gp.objects[33]= new Coin();
        gp.objects[33].setWorldXAndY(187* 50 , 14*50);
        gp.objects[34]= new Coin();
        gp.objects[34].setWorldXAndY(187* 50 , 15*50);
        gp.objects[35]= new Coin();
        gp.objects[35].setWorldXAndY(188* 50 , 14*50);
        gp.objects[36]= new Coin();
        gp.objects[36].setWorldXAndY(188* 50 , 15*50);
        gp.objects[37]= new Coin();
        gp.objects[37].setWorldXAndY(269* 50 , 14*50);
        gp.objects[38]= new Coin();
        gp.objects[38].setWorldXAndY(270* 50 , 14*50);
        gp.objects[39]= new Coin();
        gp.objects[39].setWorldXAndY(269* 50 , 15*50);
        gp.objects[40]= new Coin();
        gp.objects[40].setWorldXAndY(270* 50 , 15*50);
    }
    public void draw(Graphics2D g){

        for (int i= 0 ; i < gp.objects.length; i++){

            if(gp.objects[i] != null){

                int screenX = gp.objects[i].getWorldX() - gp.playerCharacter.getWorldX() + gp.playerCharacter.screenX;

                g.drawImage(gp.objects[i].image , screenX , gp.objects[i].getWorldY() , 50 , 50 , null);
            }
        }
    }

    public void update(){
        for (GameObject object : gp.objects){
            if(object != null){
                object.update();
            }
        }
    }
}
