package controller;

import model.PlayerCharacter;

public class JumpHandler {

    int gravity ;
    PlayerCharacter player;

    public JumpHandler(PlayerCharacter player){
        this.player = player;
        gravity = 1;
        player.setyVelocity(-5);
    }

    public void jumpYoRight(){

        while (player.getyVelocity() != 5){

            player.setyVelocity(player.getyVelocity() - gravity);
            player.setWorldY(player.getWorldY() + player.getyVelocity());
        }
        player.setyVelocity(0);

    }

}
