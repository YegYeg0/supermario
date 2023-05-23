package view;

import controller.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProfilePage extends JPanel implements ActionListener {

    JLabel idLabel;
    JLabel highestScoreLabel;
    JLabel numberOfCoinsLabel;
    JLabel boughtCharacters;
    JButton backButton;


    public ProfilePage(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1500 , 900));

        idLabel = new JLabel();
        highestScoreLabel = new JLabel();
        numberOfCoinsLabel = new JLabel();
        boughtCharacters = new JLabel();

        backButton = new JButton("Back");
        backButton.setBounds(25 , 25 , 70 , 70);
        backButton.addActionListener(this);


        this.add(backButton);
    }

    public void setComponents(){

        this.remove(idLabel);
        this.remove(highestScoreLabel);
        this.remove(numberOfCoinsLabel);
        this.remove(boughtCharacters);

        idLabel = new JLabel( "ID : \""+ Main.user.getId()+"\"");
        idLabel.setBounds( 1150,100 , 300 , 100);
        idLabel.setFont(new Font(null , Font.BOLD , 30));
        idLabel.setBackground(Color.pink);

        highestScoreLabel = new JLabel("MAX SCORE : \""+(Main.user.highestScore)+"\"");
        highestScoreLabel.setBounds(1150 , 200 , 300 , 100);
        highestScoreLabel.setFont(new Font(null , Font.BOLD , 30));
        highestScoreLabel.setBackground(Color.pink);

        numberOfCoinsLabel = new JLabel("COINS : \""+(Main.user.allNumberOfCoins)+"\"");
        numberOfCoinsLabel.setBounds(1150 , 300 , 300 , 100);
        numberOfCoinsLabel.setFont(new Font(null , Font.BOLD , 30));
        numberOfCoinsLabel.setBackground(Color.pink);

        boughtCharacters = new JLabel("CHARACTERS : \""+((Main.user.boughtTypes))+"\"");
        boughtCharacters.setBounds(1050 , 400 , 500 , 100);
        boughtCharacters.setFont(new Font(null , Font.BOLD , 30));
        boughtCharacters.setBackground(Color.pink);

        this.add(idLabel);
        this.add(highestScoreLabel);
        this.add(numberOfCoinsLabel);
        this.add(boughtCharacters);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            Main.mainFrame.gameMainPage = new GameMainPage();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "gameMainPage");
        }

    }
    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        BufferedImage image;
        try {
            image = ImageIO.read(new File("res/backGrounds/4.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(image , 0 , 0 ,1500 , 900 , null);
    }
}
