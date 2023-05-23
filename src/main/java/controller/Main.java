package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import view.MyFrame;
import model.User;

public class Main {
    public static MyFrame mainFrame;
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static User user = new User();

    public static void main(String[] args){


        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        mainFrame = new MyFrame("SUPER MARIO");

        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(0);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
