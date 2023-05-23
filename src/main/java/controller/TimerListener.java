package controller;

import view.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TimerListener implements ActionListener {

    GamePanel gp;

    public TimerListener(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gp.countDown --;
        if(gp.countDown <=0) {
            if (Main.user.games[Main.user.numberOfCurrentGame].gameLivesLeft > 0) {
                Main.user.games[Main.user.numberOfCurrentGame].gameLivesLeft--;
                gp.playerCharacter.setWorldX(300);
                gp.timer.restart();
                gp.countDown = 200;
            } else {
                Main.user.games[Main.user.numberOfCurrentGame].gameScore +=
                        (Main.user.games[Main.user.numberOfCurrentGame].gameCoinsEarned * 10)+
                        +(Main.user.games[Main.user.numberOfCurrentGame].gameLivesLeft * 20);
                Main.user.allNumberOfCoins += Main.user.games[Main.user.numberOfCurrentGame].gameCoinsEarned;
                if (Main.user.highestScore < Main.user.games[Main.user.numberOfCurrentGame].gameScore) {
                    Main.user.highestScore = Main.user.games[Main.user.numberOfCurrentGame].gameScore;
                }
                File file = new File("./" + Main.user.getId() + ".json");
                try {
                    FileWriter fileWriter = new FileWriter("./" + Main.user.getId() + ".json");
                    Main.objectMapper.writeValue(file , Main.user);
                    fileWriter.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Main.user.games[Main.user.numberOfCurrentGame] = null;
                Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "gameMainPage");
                Main.mainFrame.GPL1S1.gameThread = null;
                gp.timer.stop();
            }
        }
    }
}
