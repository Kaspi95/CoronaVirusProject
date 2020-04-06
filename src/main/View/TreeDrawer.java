package main.View;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;

public class TreeDrawer {

    private JPanel drawField;

    public TreeDrawer(JPanel drawField) {    //set params!

        drawField.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1, true, true));  // params( magasság,szélesség,borders of this container,-,-)
        this.drawField = drawField;
    }

    public void drawTree(){



    }

    public void drawPerson(String name, String id, int xCoordinate, int yCoordinate) {

        MyLabel label = new MyLabel(id);
        label.setText(name);
        drawField.add(label, new GridConstraints(yCoordinate, xCoordinate, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    public void drawHorizontalLine(int xCoordinate, int yCoordinate) {
        JLabel label = new JLabel();
        label.setText("|");
        drawField.add(label, new GridConstraints(yCoordinate, xCoordinate, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

    }

    public void drawVerticalLine(int xCoordinate, int yCoordinate) {
        JLabel label = new JLabel();
        label.setText("-");
        drawField.add(label, new GridConstraints(yCoordinate, xCoordinate, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

    }
}

