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

public class ChooseHard extends JPanel implements ActionListener {
    JButton easyButton;
    JButton mediumButton;
    JButton hardButton;

    public ChooseHard(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1500 , 900));

        easyButton = new JButton("EASY");
        easyButton.setBounds(225 , 300 , 300 , 50);
        easyButton.addActionListener(this);
        mediumButton = new JButton("MEDIUM");
        mediumButton.setBounds(225 , 400 , 300 , 50);
        mediumButton.addActionListener(this);
        hardButton = new JButton("HARD");
        hardButton.setBounds(225 , 500 , 300 , 50);
        hardButton.addActionListener(this);

        this.add(easyButton);
        this.add(mediumButton);
        this.add(hardButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == easyButton){
            Main.mainFrame.chooseTypeAndHardNewGame = new ChooseTypeAndHardNewGame();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "chooseTypeAndHardNewGame");
        }
        if(e.getSource() == mediumButton){
            Main.mainFrame.chooseTypeAndHardNewGame = new ChooseTypeAndHardNewGame();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "chooseTypeAndHardNewGame");
        }
        if(e.getSource() == hardButton){
            Main.mainFrame.chooseTypeAndHardNewGame = new ChooseTypeAndHardNewGame();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "chooseTypeAndHardNewGame");
        }
    }
    protected void paintComponent(Graphics g){
        try {
            BufferedImage image = ImageIO.read(Files.newInputStream(Paths.get("res/backGrounds/6.jpeg")));
            g.drawImage(image , 0 , 0 , 1500 , 900 , null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
