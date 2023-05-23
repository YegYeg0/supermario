package view;
import controller.Main;
import model.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage extends JPanel implements ActionListener {

    JTextField idField;
    JPasswordField passwordField ;
    JButton loginButton;
    JButton backButton;

    public LoginPage(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1500  ,900));

        loginButton = new JButton("Login");
        loginButton.setBounds(750 , 575 , 100 , 50);
        loginButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(650 , 575 , 100 ,50);
        backButton.addActionListener(this);

        idField = new JTextField();
        idField.setBounds(650 , 375 , 200 , 50);

        passwordField= new JPasswordField();
        passwordField.setBounds(650 , 475 , 200 , 50);

        JLabel iDLabel = new JLabel("ID :");
        iDLabel.setFont(new Font(null , Font.BOLD , 25));
        iDLabel.setBounds(600 , 375 , 50 , 50);

        JLabel passwordLabel = new JLabel("Password :");
        passwordLabel.setFont(new Font(null , Font.BOLD , 25));
        passwordLabel.setBounds(500 , 475 , 200 , 50);

        this.add(loginButton);
        this.add(backButton);
        this.add(idField);
        this.add(passwordField);
        this.add(iDLabel);
        this.add(passwordLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            String id = idField.getText();
            try {
                File newFile = new File("./" +id +".json");
                if (newFile.exists()) {
                    String password = String.valueOf(passwordField.getPassword());
                    FileReader fileReader = new FileReader("./"+id+".json");
                    User user = Main.objectMapper.readValue(fileReader , User.class);
                    String correctPassword = user.getId();

                    if(password.equalsIgnoreCase(correctPassword)) {

                        Main.user = user;
                        Main.user.boughtTypes = user.boughtTypes;
//                        System.out.println(user.boughtTypes);
//                        System.out.println(Main.user.boughtTypes);
                        idField.setText("");
                        passwordField.setText("");

                        Main.mainFrame.gameMainPage = new GameMainPage();
                        Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "gameMainPage");

                    }
                    else{
                        idField.setText("");
                        passwordField.setText("");
                    }
                }
                else {
                    idField.setText("");
                    passwordField.setText("");
                }
            } catch (IOException ex){
                throw new RuntimeException(ex);
            }

        }
        if(e.getSource() == backButton){
            Main.mainFrame.firstPage = new FirstPage();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "firstPage");
        }
    }
    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        BufferedImage image;
        try {
            image = ImageIO.read(new File("res/backGrounds/3.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(image , 0 , 0 ,1500 , 900 , null);
    }
}