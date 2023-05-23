package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import controller.Main;
import model.*;

public class SignUpPage extends JPanel implements ActionListener {
    JTextField idField;
    JPasswordField passwordField;
    JButton signUpButton;
    JButton backButton;

    public SignUpPage() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1500, 900));
        this.setBackground(Color.CYAN);

        signUpButton = new JButton("Sign up");
        signUpButton.setBounds(750, 575, 100, 50);
        signUpButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(650, 575, 100, 50);
        backButton.addActionListener(this);

        idField = new JTextField();
        idField.setBounds(650, 375, 200, 50);

        passwordField = new JPasswordField();
        passwordField.setBounds(650, 475, 200, 50);

        JLabel iDLabel = new JLabel("ID :");
        iDLabel.setFont(new Font(null, Font.BOLD, 25));
        iDLabel.setBounds(600, 375, 50, 50);

        JLabel passwordLabel = new JLabel("Password :");
        passwordLabel.setFont(new Font(null, Font.BOLD, 25));
        passwordLabel.setBounds(500, 475, 200, 50);

        this.add(signUpButton);
        this.add(backButton);
        this.add(idField);
        this.add(passwordField);
        this.add(iDLabel);
        this.add(passwordLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
            String id = idField.getText();
            String password = String.copyValueOf(passwordField.getPassword());

            if (!id.isEmpty() && !password.isEmpty()) {

                File file = new File("./" + id + ".json");
                if (!file.exists()) {
                    try {
                        FileWriter fileWriter = new FileWriter("./" + id + ".json");
                        User user = new User(id, password);
                        user.boughtTypes.add(0);
                        Main.objectMapper.writeValue(file , user);
                        Main.user = user;
                        fileWriter.close();

                        Main.mainFrame.gameMainPage = new GameMainPage();
                        Main.mainFrame.cardLayout.show(Main.mainFrame.cards , "gameMainPage");
                        idField.setText("");
                        passwordField.setText("");

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    idField.setText("");
                    passwordField.setText("");
                }
            }
        }
        if (e.getSource() == backButton) {
            idField.setText("");
            passwordField.setText("");
            Main.mainFrame.firstPage = new FirstPage();
            Main.mainFrame.cardLayout.show(Main.mainFrame.cards, "firstPage");

        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        BufferedImage image;
        try {
            image = ImageIO.read(new File("res/backGrounds/3.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(image, 0, 0, 1500, 900, null);
    }
}

