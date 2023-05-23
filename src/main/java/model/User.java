package model;


import java.util.ArrayList;

public class User {

    private String id;
    private String password;
    public int highestScore;
    public int allNumberOfCoins;
    public ArrayList<Integer> boughtTypes = new ArrayList<>();
    public int numberOfCurrentGame;
    public Game[] games = new Game[3];

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
