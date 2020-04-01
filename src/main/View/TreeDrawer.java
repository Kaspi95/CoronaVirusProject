package main.View;

import javax.swing.*;

public class TreeDrawer {

    private JPanel drawField;

    public TreeDrawer(JPanel drawField){
        drawField.setLayout(null);  //Turning off automatic allignment and whatnot
        JLabel label = new JLabel();
        label.setText("Kurva");
        label.setHorizontalAlignment(0);
        label.setVerticalAlignment(0);
        drawField.add(label);
        label.setVisible(true);
        drawField.setVisible(true);
        drawField.repaint();
        this.drawField=drawField;
    }

    public void drawHorizontalLine(){        //TODO belerak egy label-t amit kitölt egy vízszintes vonallal
    }

    public void drawVerticalLine(){        //TODO belerak egy label-t, amit kitöl egy függőleges vonallal
    }

    public void drawPerson(String name, String id) {        //TODO belerak egy label-t amit kitölt az aktuális Person nevével

        JLabel label = new JLabel();
        label.setText(name);
    }





}
