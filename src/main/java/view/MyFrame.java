package view;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public  FirstPage firstPage ;
    public  CardLayout cardLayout = new CardLayout();
    public  JPanel cards  = new JPanel(cardLayout);
    public  LoginPage loginPage;
    public  SignUpPage signUpPage;
    public  GameMainPage gameMainPage;
    public  ProfilePage profilePage ;
    public  StorePage storePage ;
    public  GPL1S1 GPL1S1;
    public  ChooseTypeAndHardNewGame chooseTypeAndHardNewGame;
    public  ChooseGameToStart chooseGameToStart;
    public ChooseHard chooseHard;
    public ChooseGameToContinue chooseGameToContinue;

    public MyFrame(String s){

        chooseGameToStart = new ChooseGameToStart();
        gameMainPage = new GameMainPage();
        signUpPage = new SignUpPage();
        firstPage = new FirstPage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        storePage = new StorePage();
        chooseTypeAndHardNewGame = new ChooseTypeAndHardNewGame();
        chooseHard = new ChooseHard();
        chooseGameToContinue = new ChooseGameToContinue();

        cards.add("firstPage", firstPage);
        cards.add("loginPage" ,loginPage);
        cards.add("signUpPage" , signUpPage);
        cards.add("gameMainPage" , gameMainPage);
        cards.add("profilePage" , profilePage);
        cards.add("storePage" , storePage);
        cards.add("chooseTypeAndHardNewGame" , chooseTypeAndHardNewGame);
        cards.add("chooseHard"  ,chooseHard);
        cards.add("chooseGameToStart" ,chooseGameToStart);
        cards.add("chooseGameToContinue", chooseGameToContinue);


        this.add(cards);
        this.pack();
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle(s);
        this.setVisible(true);

    }
}
