package view;

import controller.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StorePage extends JPanel implements ActionListener {


    JButton backButton;
    JButton greenButton;
    JButton purpleButton;
    JButton orangeButton;
    JButton pinkButton;
    JLabel greenLabel;
    JLabel purpleLabel;
    JLabel orangeLabel;
    JLabel pinkLabel;
    JLabel greenLabel2;
    JLabel purpleLabel2;
    JLabel orangeLabel2;
    JLabel pinkLabel2;
    JLabel explanation ;
    private int price = 20;

    public StorePage(){

        this.setLayout(null);
        this.setPreferredSize(new Dimension(1500  ,900));

        backButton = new JButton();
        backButton = new JButton("Back");
        backButton.setBounds(25 , 25 , 70 , 70);
        backButton.addActionListener(this);

        explanation = new JLabel("\" THE PRICE OF EACH CHARACTER IS 20 COINS \"");
        explanation.setBounds(200 , 100 , 1300 , 200 );
        explanation.setFont(new Font("" , Font.BOLD , 50));
        explanation.setForeground(Color.RED);
        this.add(explanation);

        greenButton = new JButton();
        purpleButton = new JButton();
        orangeButton = new JButton();
        pinkButton = new JButton();
        greenLabel = new JLabel();
        purpleLabel = new JLabel();
        orangeLabel = new JLabel();
        pinkLabel = new JLabel();

        greenLabel2 = new JLabel("HIGHER JUMP");
        greenLabel2.setBounds(150 , 300 , 275 , 100);
        greenLabel2.setFont(new Font("" , Font.BOLD , 20));
        this.add(greenLabel2);
        purpleLabel2 = new JLabel("FASTER MOVE");
        purpleLabel2.setBounds(525 , 300 , 275 , 100);
        purpleLabel2.setFont(new Font("" , Font.BOLD , 20));
        this.add(purpleLabel2);
        orangeLabel2 = new JLabel("FASTER SHOOT");
        orangeLabel2.setBounds(900 , 300 , 275 , 100);
        orangeLabel2.setFont(new Font("" , Font.BOLD , 20));
        this.add(orangeLabel2);
        pinkLabel2 = new JLabel("ATTRACT COINS");
        pinkLabel2.setBounds(1275 , 300 , 275 , 100);
        pinkLabel2.setFont(new Font("" , Font.BOLD , 20));
        this.add(pinkLabel2);

        this.add(backButton);
    }

    public void setComponents(){

        this.remove(greenButton);
        this.remove(purpleButton);
        this.remove(orangeButton);
        this.remove(pinkButton);
        this.remove(greenLabel);
        this.remove(pinkLabel);
        this.remove(orangeLabel);
        this.remove(purpleLabel);

        greenButton = new JButton("MARIO-1");
        greenButton.setBounds(50 , 400 , 275 , 100);
        greenButton.addActionListener(this);
        greenButton.setBackground(new Color(4, 103, 2));

        purpleButton = new JButton("MARIO-2");
        purpleButton.setBounds(425 , 400 , 275 , 100);
        purpleButton.addActionListener(this);
        purpleButton.setBackground(new Color(105, 7, 138));

        orangeButton = new JButton("MARIO-3");
        orangeButton.setBounds(800 , 400 , 275 , 100);
        orangeButton.addActionListener(this);
        orangeButton.setBackground(new Color(220, 99, 2));

        pinkButton = new JButton("MARIO-4");
        pinkButton.setBounds(1175 , 400 , 275 , 100);
        pinkButton.addActionListener(this);
        pinkButton.setBackground(new Color(239, 75, 157));

        for (int i= 1; i< 5 ; i++){
            if(Main.user.boughtTypes.contains(i)){
                if(i == 1){
                    greenLabel = new JLabel("UNLOCKED");
                    greenLabel.setBounds(150 , 500 , 275 , 100);
                    greenLabel.setFont(new Font("" , Font.BOLD , 20));
                    this.add(greenLabel);
                }
                else if(i== 2){
                    purpleLabel = new JLabel("UNLOCKED");
                    purpleLabel.setBounds(525 , 500 , 275 , 100);
                    purpleLabel.setFont(new Font("" , Font.BOLD , 20));
                    this.add(purpleLabel);
                }
                else if(i == 3){
                    orangeLabel = new JLabel("UNLOCKED");
                    orangeLabel.setBounds(900 , 500 , 275 , 100);
                    orangeLabel.setFont(new Font("" , Font.BOLD , 20));
                    this.add(orangeLabel);
                }
                else if(i == 4){
                    pinkLabel = new JLabel("UNLOCKED");
                    pinkLabel.setBounds(1275 , 500 , 275 , 100);
                    pinkLabel.setFont(new Font("" , Font.BOLD , 20));
                    this.add(pinkLabel);
                }
            }
        }
        this.add(greenButton);
        this.add(purpleButton);
        this.add(orangeButton);
        this.add(pinkButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == backButton){
            Main.mainFrame.gameMainPage = new GameMainPage();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "gameMainPage");
            File file = new File("./" + Main.user.getId() + ".json");
            try {
                FileWriter fileWriter = new FileWriter("./" + Main.user.getId() + ".json");
                Main.objectMapper.writeValue(file , Main.user);
                fileWriter.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == greenButton){
            if(!Main.user.boughtTypes.contains(1)) {
                if (Main.user.allNumberOfCoins >= price) {
                    Main.user.allNumberOfCoins -= price;
                    Main.user.boughtTypes.add(1);
                }
            }
        }
        if(e.getSource() == purpleButton){
            if(!Main.user.boughtTypes.contains(2)) {
                if (Main.user.allNumberOfCoins >= price) {
                    Main.user.allNumberOfCoins -= price;
                    Main.user.boughtTypes.add(2);
                }
            }
        }
        if(e.getSource() == orangeButton){
            if(!Main.user.boughtTypes.contains(3)) {
                if (Main.user.allNumberOfCoins >= price) {
                    Main.user.allNumberOfCoins -= price;
                    Main.user.boughtTypes.add(3);
                }
            }
        }
        if(e.getSource() == pinkButton){
            if(!Main.user.boughtTypes.contains(4)) {
                if (Main.user.allNumberOfCoins >= price) {
                    Main.user.allNumberOfCoins -= price;
                    Main.user.boughtTypes.add(4);
                }
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        try {
            BufferedImage image = ImageIO.read(Files.newInputStream(Paths.get("res/backGrounds/5.jpg")));
            g.drawImage(image , 0 , 0 ,1500 , 900 , null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
