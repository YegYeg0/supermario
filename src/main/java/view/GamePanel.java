package view;

import controller.CollisionChecker;
import controller.ObjectsManager;
import controller.TimerListener;
import model.GameObject;
import model.Mario;
import model.PlayerCharacter;
import controller.TileManager;
import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class GamePanel extends JPanel implements Runnable, ActionListener {

    final int maxWorldCol = 150;
    final int maxWorldRow = 18;
    final int worldWidth = 150 * 50;
    final int worldHeight = 18 * 50;
    public Thread gameThread;
    public Timer timer ;
    public int countDown;
    public final int fps = 60;
    public PlayerCharacter playerCharacter;
    public TileManager tileManager;
    public CollisionChecker collisionChecker ;
    public GameObject[] objects ;
    public ObjectsManager objectsManager ;
    protected JLabel scoreLabel;
    protected JLabel coinLabel;
    protected JLabel levelSectionLabel;
    protected JLabel timeLabel;
    protected JLabel livesLabel;
    protected JButton backButton;


    public GamePanel(int type){

        playerCharacter = new Mario(this , type);
        countDown = 200;
        timer = new Timer(1000 , new TimerListener(this));
        timer.start();
    }

    public abstract void setUpGame();

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    public abstract void update();

}
