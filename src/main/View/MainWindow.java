package main.View;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{

    private JPanel mainPanel = new JPanel();


    public MainWindow(){
        this.setSize(800,800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void load(){
        mainPanel.setBackground(Color.BLACK);
        this.add(mainPanel);

    }



}
