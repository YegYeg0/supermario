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

public class FirstPage extends JPanel implements ActionListener {

    JButton login = new JButton("Login");
    JButton signUp = new JButton("Sign Up");
    JButton exit = new JButton("Exit");

    public FirstPage(){

        this.setLayout(null);
        this.setPreferredSize(new Dimension(1500  ,900));
        this.setBackground(Color.PINK);


        login.setBounds(650 , 500 , 200 ,80);
        login.setFocusable(false);
        login.addActionListener(this);
        this.add(login);

        signUp.setBounds(650 , 600 , 200  ,80);
        signUp.setFocusable(false);
        signUp.addActionListener(this);
        this.add(signUp);

        exit.setBounds(650 , 700 , 200 ,80);
        exit.setFocusable(false);
        exit.addActionListener(this);
        this.add(exit);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            Main.mainFrame.loginPage = new LoginPage();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "loginPage");
        }
        if(e.getSource() ==signUp){
            Main.mainFrame.signUpPage = new SignUpPage();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "signUpPage");
        }
        if(e.getSource() == exit){
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
        try{
            image = ImageIO.read(new File("res/backGrounds/1.jpg"));

        } catch(IOException ioException){
            throw new RuntimeException();
        }
        g.drawImage(image , 0 , 0 ,1500 ,900 , null);
    }
}

