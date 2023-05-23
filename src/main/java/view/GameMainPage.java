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

public class GameMainPage extends JPanel implements ActionListener {

    JButton backToFPageButton;
    JButton exitButton;
    JButton startNewGameButton ;
    JButton continueLastGameButton;
    JButton storeButton;
    JButton profileButton;

    public GameMainPage(){

        this.setLayout(null);
        this.setPreferredSize(new Dimension(1500  ,900));

        startNewGameButton = new JButton("START NEW GAME");
        startNewGameButton.setBounds(650 ,450, 200, 50 );
        startNewGameButton.addActionListener(this);

        continueLastGameButton = new JButton("CONTINUE PREVIOUS GAMES");
        continueLastGameButton.setBounds(650 , 550 , 200 , 50);
        continueLastGameButton.addActionListener(this);

        backToFPageButton= new JButton("BACK TO LOGIN PAGE");
        backToFPageButton.setBounds(650 , 650 , 200  ,50);
        backToFPageButton.addActionListener(this);

        exitButton = new JButton("EXIT");
        exitButton.setBounds(650 ,750 , 200 , 50);
        exitButton.addActionListener(this);

        profileButton = new JButton("PROFILE");
        profileButton.setBounds(25 , 25 , 100 , 100 );
        profileButton.addActionListener(this);

        storeButton = new JButton("STORE");
        storeButton.setBounds(1500 - 125 , 25 , 100 , 100);
        storeButton.addActionListener(this);


        this.add(startNewGameButton);
        this.add(continueLastGameButton);
        this.add(storeButton);
        this.add(profileButton);
        this.add(backToFPageButton);
        this.add(exitButton);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == continueLastGameButton){
            Main.mainFrame.chooseGameToContinue.setComponents();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "chooseGameToContinue");
        }
        if(e.getSource() == startNewGameButton){
            Main.mainFrame.chooseGameToStart.setComponents();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "chooseGameToStart");
        }
        if(e.getSource() == profileButton){
            Main.mainFrame.profilePage.setComponents();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "profilePage");
        }
        if(e.getSource() == storeButton){
            Main.mainFrame.storePage.setComponents();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "storePage");
        }
        if(e.getSource() == backToFPageButton){
            Main.mainFrame.firstPage = new FirstPage();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "firstPage");
        }
        if(e.getSource() == exitButton){
            File file = new File("./" + Main.user.getId() + ".json");
            try {
                FileWriter fileWriter = new FileWriter("./" + Main.user.getId() + ".json");
                Main.objectMapper.writeValue(file , Main.user);
                fileWriter.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.exit(0);
        }

    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        BufferedImage image;
        try {
            image = ImageIO.read(new File("res/backGrounds/2.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(image , 0 , 0 ,1500 , 900 , null);
    }
}
