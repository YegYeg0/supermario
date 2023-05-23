package model;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Coin extends GameObject {

    public Coin (){
        try{
            image = ImageIO.read(Files.newInputStream(Paths.get("res/objects/coin.png")));
        } catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update() {

    }
}
