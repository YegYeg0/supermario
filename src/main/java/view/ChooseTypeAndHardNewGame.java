package view;

import controller.Main;
import model.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChooseTypeAndHardNewGame extends JPanel implements ActionListener {


    JButton redButton;
    JButton greenButton;
    JButton purpleButton;
    JButton orangeButton;
    JButton pinkButton;
    JLabel explanation;
    JLabel explanation2;

    public ChooseTypeAndHardNewGame(){


        this.setLayout(null);
        this.setPreferredSize(new Dimension(1500 , 900));

        greenButton = new JButton("MARIO-1");
        greenButton.setBounds(875 , 350 , 100 , 50);
        greenButton.addActionListener(this);
        greenButton.setBackground(new Color(4, 103, 2));

        redButton = new JButton("MARIO-0");
        redButton.setBounds(1075 , 400 , 100 , 50);
        redButton.addActionListener(this);
        redButton.setBackground(new Color(236, 0, 0));

        purpleButton = new JButton("MARIO-2");
        purpleButton.setBounds(1275 , 350 , 100 , 50);
        purpleButton.addActionListener(this);
        purpleButton.setBackground(new Color(105, 7, 138));

        orangeButton = new JButton("MARIO-3");
        orangeButton.setBounds(875 , 450 , 100 , 50);
        orangeButton.addActionListener(this);
        orangeButton.setBackground(new Color(220, 99, 2));

        pinkButton = new JButton("MARIO-4");
        pinkButton.setBounds(1275 , 450 , 100 , 50);
        pinkButton.addActionListener(this);
        pinkButton.setBackground(new Color(239, 75, 157));

        this.add(pinkButton);
        this.add(redButton);
        this.add(purpleButton);
        this.add(orangeButton);
        this.add(greenButton);

        explanation = new JLabel(" \"Choose characters you have bought,if you choose a locked character,game won't start. \"");
        explanation.setBounds(100 , 100 , 1500 , 150);
        explanation.setFont(new Font(" " , Font.BOLD , 30));
        explanation.setForeground(Color.YELLOW);
        explanation2 = new JLabel(" \"mario-0 the red button is open by default . \"");
        explanation2.setBounds(100 , 200 , 1500 , 150);
        explanation2.setFont(new Font(" " , Font.BOLD , 30));
        explanation2.setForeground(Color.BLACK);

        this.add(explanation);
        this.add(explanation2);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == redButton){
            if (Main.user.boughtTypes.contains(0)) {
                Main.user.games[Main.user.numberOfCurrentGame] = new Game();
                Main.mainFrame.GPL1S1 = new GPL1S1(0);
                Main.mainFrame.cards.add("GPL1S1", Main.mainFrame.GPL1S1);
                Main.user.games[Main.user.numberOfCurrentGame].playerCharacter = Main.mainFrame.GPL1S1.playerCharacter;
                Main.mainFrame.GPL1S1.playerCharacter.game = Main.user.games[Main.user.numberOfCurrentGame];
                Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "GPL1S1");
                Main.mainFrame.GPL1S1.setUpGame();
                Main.mainFrame.GPL1S1.startGameThread();
                Main.mainFrame.GPL1S1.requestFocus();
            }
        }
        else if(e.getSource() == greenButton){
            if(Main.user.boughtTypes.contains(1)) {
                Main.user.games[Main.user.numberOfCurrentGame] = new Game();
                Main.mainFrame.GPL1S1 = new GPL1S1(1);
                Main.mainFrame.cards.add("GPL1S1", Main.mainFrame.GPL1S1);
                Main.user.games[Main.user.numberOfCurrentGame].playerCharacter = Main.mainFrame.GPL1S1.playerCharacter;
                Main.mainFrame.GPL1S1.playerCharacter.game = Main.user.games[Main.user.numberOfCurrentGame];
                Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "GPL1S1");
                Main.mainFrame.GPL1S1.setUpGame();
                Main.mainFrame.GPL1S1.startGameThread();
                Main.mainFrame.GPL1S1.requestFocus();
            }
        }
        else if(e.getSource() == purpleButton){
            if(Main.user.boughtTypes.contains(2)) {
                Main.user.games[Main.user.numberOfCurrentGame] = new Game();
                Main.mainFrame.GPL1S1 = new GPL1S1(2);
                Main.mainFrame.cards.add("GPL1S1", Main.mainFrame.GPL1S1);
                Main.user.games[Main.user.numberOfCurrentGame].playerCharacter = Main.mainFrame.GPL1S1.playerCharacter;
                Main.mainFrame.GPL1S1.playerCharacter.game = Main.user.games[Main.user.numberOfCurrentGame];
                Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "GPL1S1");
                Main.mainFrame.GPL1S1.setUpGame();
                Main.mainFrame.GPL1S1.startGameThread();
                Main.mainFrame.GPL1S1.requestFocus();
            }
        }
        else if(e.getSource() == orangeButton){
            if(Main.user.boughtTypes.contains(3)) {
                Main.user.games[Main.user.numberOfCurrentGame] = new Game();
                Main.mainFrame.GPL1S1 = new GPL1S1(3);
                Main.mainFrame.cards.add("GPL1S1", Main.mainFrame.GPL1S1);
                Main.user.games[Main.user.numberOfCurrentGame].playerCharacter = Main.mainFrame.GPL1S1.playerCharacter;
                Main.mainFrame.GPL1S1.playerCharacter.game = Main.user.games[Main.user.numberOfCurrentGame];
                Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "GPL1S1");
                Main.mainFrame.GPL1S1.setUpGame();
                Main.mainFrame.GPL1S1.startGameThread();
                Main.mainFrame.GPL1S1.requestFocus();
            }
        }
        else if(e.getSource() == pinkButton){
            if(Main.user.boughtTypes.contains(4)) {
                Main.user.games[Main.user.numberOfCurrentGame] = new Game();
                Main.mainFrame.GPL1S1 = new GPL1S1(4);
                Main.mainFrame.cards.add("GPL1S1", Main.mainFrame.GPL1S1);
                Main.user.games[Main.user.numberOfCurrentGame].playerCharacter = Main.mainFrame.GPL1S1.playerCharacter;
                Main.mainFrame.GPL1S1.playerCharacter.game = Main.user.games[Main.user.numberOfCurrentGame];
                Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "GPL1S1");
                Main.mainFrame.GPL1S1.setUpGame();
                Main.mainFrame.GPL1S1.startGameThread();
                Main.mainFrame.GPL1S1.requestFocus();
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        BufferedImage image;
        try {
            image = ImageIO.read(new File("res/backGrounds/6.jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(image , 0 , 0 ,1500 , 900 , null);
    }
}
