package view;

import controller.Main;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ChooseGameToContinue extends JPanel implements ActionListener {

    JButton gameButton1;
    JButton gameButton2;
    JButton gameButton3;
    JButton backButton;

    public ChooseGameToContinue() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(1500, 900));

        backButton = new JButton("Back");
        backButton.setBounds(25, 25, 70, 70);
        backButton.addActionListener(this);

        gameButton1 = new JButton();
        gameButton2 = new JButton();
        gameButton3 = new JButton();

        this.add(backButton);
    }

    public void setComponents() {

        this.remove(gameButton1);
        this.remove(gameButton2);
        this.remove(gameButton3);

        if (Main.user.games[0] != null) {
            gameButton1 = new JButton("LEVEL: " + Main.user.games[0].level + "\n SECTION: " + Main.user.games[0].section);
        } else {
            gameButton1 = new JButton("NEW GAME 1");
        }
        gameButton1.setBounds(600, 400, 300, 100);
        gameButton1.addActionListener(this);


        if (Main.user.games[1] != null) {
            gameButton2 = new JButton("LEVEL: " + Main.user.games[1].level + "\n SECTION: " + Main.user.games[1].section);
        } else {
            gameButton2 = new JButton("NEW GAME 2");
        }
        gameButton2.setBounds(600, 550, 300, 100);
        gameButton2.addActionListener(this);

        if (Main.user.games[2] != null) {
            gameButton3 = new JButton("LEVEL: " + Main.user.games[2].level + "\n SECTION: " + Main.user.games[2].section);
        } else {
            gameButton3 = new JButton("NEW GAME 3");
        }
        gameButton3.setBounds(600, 700, 300, 100);
        gameButton3.addActionListener(this);

        this.add(gameButton1);
        this.add(gameButton2);
        this.add(gameButton3);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            Main.mainFrame.gameMainPage = new GameMainPage();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "gameMainPage");
        }
        if (e.getSource() == gameButton1) {
            Main.user.numberOfCurrentGame = 0;
            if (Main.user.games[0] != null) {
                if(Main.user.games[0].section == 1) {
                    Main.mainFrame.GPL1S1 = new GPL1S1(Main.user.games[0].typeOfCharacter);
                    Main.mainFrame.cards.add("GPL1S1", Main.mainFrame.GPL1S1);
                    Main.user.games[Main.user.numberOfCurrentGame].playerCharacter = Main.mainFrame.GPL1S1.playerCharacter;
                    Main.mainFrame.GPL1S1.playerCharacter.game = Main.user.games[Main.user.numberOfCurrentGame];
                    Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "GPL1S1");
                    Main.mainFrame.GPL1S1.setUpGame();
                    Main.mainFrame.GPL1S1.startGameThread();
                    Main.mainFrame.GPL1S1.requestFocus();
                }
                if(Main.user.games[0].section == 2) {
                    Main.mainFrame.GPL1S1 = new GPL1S1(Main.user.games[0].typeOfCharacter);
                    Main.mainFrame.cards.add("GPL1S1", Main.mainFrame.GPL1S1);
                    Main.mainFrame.GPL1S1.playerCharacter.setWorldX(7800);
                    Main.mainFrame.GPL1S1.playerCharacter.minXWorld = 7600;
                    Main.user.games[Main.user.numberOfCurrentGame].playerCharacter = Main.mainFrame.GPL1S1.playerCharacter;
                    Main.mainFrame.GPL1S1.playerCharacter.game = Main.user.games[Main.user.numberOfCurrentGame];
                    Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "GPL1S1");
                    Main.mainFrame.GPL1S1.setUpGame();
                    Main.mainFrame.GPL1S1.startGameThread();
                    Main.mainFrame.GPL1S1.requestFocus();
                }

            } else {

                Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "chooseHard");
            }
        }
        if (e.getSource() == gameButton2) {
            Main.user.numberOfCurrentGame = 1;
            if (Main.user.games[1] != null) {
                if(Main.user.games[1].section == 1) {
                    Main.mainFrame.GPL1S1 = new GPL1S1(Main.user.games[1].typeOfCharacter);
                    Main.mainFrame.cards.add("GPL1S1", Main.mainFrame.GPL1S1);
                    Main.user.games[Main.user.numberOfCurrentGame].playerCharacter = Main.mainFrame.GPL1S1.playerCharacter;
                    Main.mainFrame.GPL1S1.playerCharacter.game = Main.user.games[Main.user.numberOfCurrentGame];
                    Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "GPL1S1");
                    Main.mainFrame.GPL1S1.setUpGame();
                    Main.mainFrame.GPL1S1.startGameThread();
                    Main.mainFrame.GPL1S1.requestFocus();
                }
                if(Main.user.games[1].section == 2) {
                    Main.mainFrame.GPL1S1 = new GPL1S1(Main.user.games[1].typeOfCharacter);
                    Main.mainFrame.cards.add("GPL1S1", Main.mainFrame.GPL1S1);
                    Main.mainFrame.GPL1S1.playerCharacter.setWorldX(7800);
                    Main.mainFrame.GPL1S1.playerCharacter.minXWorld = 7600;
                    Main.user.games[Main.user.numberOfCurrentGame].playerCharacter = Main.mainFrame.GPL1S1.playerCharacter;
                    Main.mainFrame.GPL1S1.playerCharacter.game = Main.user.games[Main.user.numberOfCurrentGame];
                    Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "GPL1S1");
                    Main.mainFrame.GPL1S1.setUpGame();
                    Main.mainFrame.GPL1S1.startGameThread();
                    Main.mainFrame.GPL1S1.requestFocus();
                }
            } else {
                Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "chooseHard");
            }
        }
        if (e.getSource() == gameButton3) {
            Main.user.numberOfCurrentGame = 2;
            if (Main.user.games[2] != null) {
                if(Main.user.games[2].section == 1) {
                    Main.mainFrame.GPL1S1 = new GPL1S1(Main.user.games[2].typeOfCharacter);
                    Main.mainFrame.cards.add("GPL1S1", Main.mainFrame.GPL1S1);
                    Main.user.games[Main.user.numberOfCurrentGame].playerCharacter = Main.mainFrame.GPL1S1.playerCharacter;
                    Main.mainFrame.GPL1S1.playerCharacter.game = Main.user.games[Main.user.numberOfCurrentGame];
                    Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "GPL1S1");
                    Main.mainFrame.GPL1S1.setUpGame();
                    Main.mainFrame.GPL1S1.startGameThread();
                    Main.mainFrame.GPL1S1.requestFocus();
                }
                if(Main.user.games[2].section == 2) {
                    Main.mainFrame.GPL1S1 = new GPL1S1(Main.user.games[2].typeOfCharacter);
                    Main.mainFrame.cards.add("GPL1S1", Main.mainFrame.GPL1S1);
                    Main.mainFrame.GPL1S1.playerCharacter.setWorldX(7800);
                    Main.mainFrame.GPL1S1.playerCharacter.minXWorld = 7600;
                    Main.user.games[Main.user.numberOfCurrentGame].playerCharacter = Main.mainFrame.GPL1S1.playerCharacter;
                    Main.mainFrame.GPL1S1.playerCharacter.game = Main.user.games[Main.user.numberOfCurrentGame];
                    Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "GPL1S1");
                    Main.mainFrame.GPL1S1.setUpGame();
                    Main.mainFrame.GPL1S1.startGameThread();
                    Main.mainFrame.GPL1S1.requestFocus();
                }
            } else {
                Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "chooseHard");
            }
        }
    }

    protected void paintComponent(Graphics g) {
        try {
            BufferedImage image = ImageIO.read(Files.newInputStream(Paths.get("res/backGrounds/6.jpeg")));
            g.drawImage(image, 0, 0, 1500, 900, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
