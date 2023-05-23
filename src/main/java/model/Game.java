package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Game {


    @JsonIgnore
    public PlayerCharacter playerCharacter ;
    @JsonIgnore
    public boolean gameOver= false;

    public int typeOfCharacter =0;
    public int gameScore=0;
    public int gameLivesLeft =3;
    public int gameCoinsEarned =0;
    public int level =1;
    public int section=1;


    public Game() {
    }
    public void countScore(){
        gameScore+= (gameCoinsEarned * 10) +(gameLivesLeft * 20) ;
    }
}
