package main.View;

import javax.swing.*;

public class MyLabel extends JLabel {
    private String personID;
    public MyLabel(String ID){
        super();
        this.personID=ID;
            }
    public String getID(){
        return personID;
    }
}

