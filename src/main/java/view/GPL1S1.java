package view;

import controller.*;
import model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GPL1S1 extends GamePanel {


    public GPL1S1(int type) {
        super(type);

        this.setLayout(null);
        this.setPreferredSize(new Dimension(1500, 900));
        this.setBackground(new Color(128, 213, 255, 195));
        this.setDoubleBuffered(true);
        this.addKeyListener(playerCharacter);
        this.setFocusable(true);

        backButton = new JButton("Back");
        backButton.setBounds(25 , 25 , 70 , 70);
        backButton.addActionListener(this);

        this.add(backButton);
        this.collisionChecker = new CollisionChecker(this);
        this.objects = new GameObject[50];
        this.objectsManager = new ObjectsManager(this);
        this.tileManager = new TileManager(this, "res/maps/L1S1.txt");
    }

    @Override
    public void setUpGame() {

        objectsManager.setObjectL1();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {


            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta > 1) {
                update();
                repaint();
                delta--;
            }
        }

    }

    public void update() {
        playerCharacter.update1();
        objectsManager.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        objectsManager.draw(g2);
        tileManager.draw(g2);


        g2.drawRect(25 , 25 , 70 ,70);
        g.drawString("Back" ,50 , 50  );

        g2.drawString("SCORE:" +(playerCharacter.game.gameScore), 300 , 50 );
        g2.drawString("COINS:"+(playerCharacter.game.gameCoinsEarned), 500 , 50);
        g2.drawString("LIVES:"+(playerCharacter.game.gameLivesLeft), 700 , 50);
        g2.drawString("SECTION:"+(playerCharacter.game.section), 900 , 50);
        g2.drawString("LEVEL:"+(playerCharacter.game.level), 1100 , 50);
        g.drawString("TIME:"+ countDown , 1300 , 50);

        playerCharacter.draw(g2);

        g2.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            Main.user.games[Main.user.numberOfCurrentGame].typeOfCharacter = playerCharacter.type;
            File file = new File("./" + Main.user.getId() + ".json");
            try {
                FileWriter fileWriter = new FileWriter("./" + Main.user.getId() + ".json");
                Main.objectMapper.writeValue(file , Main.user);
                fileWriter.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "gameMainPage");
            gameThread = null;
            timer.stop();
        }
    }
}
