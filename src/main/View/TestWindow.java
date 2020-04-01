package main.View;

import javax.swing.*;
import java.awt.*;

public class TestWindow extends JFrame {

    private JPanel panel1;
    private JToolBar toolbar;
    private JButton fileButton;
    private JButton saveButton;
    private JScrollBar bottomScrollBar;
    private JScrollBar sideScrollBar;
    private JPanel drawField;
    private JPanel editField;
    private JButton deceasedButton;
    private JButton addNewChildButton;
    private JButton modifyButton;
    private JPanel detailsField;
    private JTextField nameTextField;
    private JTextField birthDateTextField;
    private JTextField birthPlaceTextField;
    private JTextField deathDateTextField;
    private JTextField deathPlaceTextField;
    private JLabel nameLabel;
    private JLabel birthDateLabel;
    private JLabel birthPlaceLabel;
    private JLabel deathDateLabel;
    private JLabel deathPlaceLabel;
    //private JLabel label;

    public TestWindow() {
        panel1 = new JPanel();
        this.add(panel1);
        panel1.setLayout(new BorderLayout(0, 0));


        drawField = new JPanel();
        drawField.setLayout(new BorderLayout());

        JLabel label = new JLabel();
        label.setText("Kurva");
        drawField.add(label, BorderLayout.CENTER);
        panel1.add(drawField, BorderLayout.CENTER);
        /*
        drawField.setLayout(null);  //Turning off automatic allignment and whatnot
        //drawField.setSize(100,100);
        label = new JLabel();
        label.setText("Kurva");
        label.setHorizontalAlignment(0);
        label.setVerticalAlignment(0);
        drawField.add(label);
        panel1.add(drawField,BorderLayout.CENTER);
       */

        panel1.setBackground(new Color(-12828863));
        panel1.setEnabled(true);
        toolbar = new JToolBar();
        toolbar.setFloatable(false);
        panel1.add(toolbar, BorderLayout.NORTH);
        fileButton = new JButton();
        fileButton.setText("File");
        toolbar.add(fileButton);
        final JToolBar.Separator toolBar$Separator1 = new JToolBar.Separator();
        toolbar.add(toolBar$Separator1);
        saveButton = new JButton();
        saveButton.setText("Save");
        toolbar.add(saveButton);
        bottomScrollBar = new JScrollBar();
        bottomScrollBar.setOrientation(0);
        panel1.add(bottomScrollBar, BorderLayout.SOUTH);
        sideScrollBar = new JScrollBar();
        panel1.add(sideScrollBar, BorderLayout.EAST);
        editField = new JPanel();
        editField.setLayout(new BorderLayout(0, 0));
        panel1.add(editField, BorderLayout.WEST);
        editField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        final JToolBar toolBar1 = new JToolBar();
        toolBar1.setFloatable(false);
        editField.add(toolBar1, BorderLayout.NORTH);
        addNewChildButton = new JButton();
        addNewChildButton.setText("Add New Child");
        toolBar1.add(addNewChildButton);
        final JToolBar.Separator toolBar$Separator2 = new JToolBar.Separator();
        toolBar1.add(toolBar$Separator2);
        deceasedButton = new JButton();
        deceasedButton.setText("Deceased");
        toolBar1.add(deceasedButton);
        final JToolBar.Separator toolBar$Separator3 = new JToolBar.Separator();
        toolBar1.add(toolBar$Separator3);
        modifyButton = new JButton();
        modifyButton.setText("Modify");
        toolBar1.add(modifyButton);
        detailsField = new JPanel();
        detailsField.setLayout(new GridBagLayout());
        editField.add(detailsField, BorderLayout.CENTER);
        nameLabel = new JLabel();
        nameLabel.setText("Name");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        detailsField.add(nameLabel, gbc);
        birthDateLabel = new JLabel();
        birthDateLabel.setText("Birth Date");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        detailsField.add(birthDateLabel, gbc);
        birthPlaceLabel = new JLabel();
        birthPlaceLabel.setText("Birth Place");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        detailsField.add(birthPlaceLabel, gbc);
        deathDateLabel = new JLabel();
        deathDateLabel.setText("Death Date");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        detailsField.add(deathDateLabel, gbc);
        nameTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        detailsField.add(nameTextField, gbc);
        birthDateTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        detailsField.add(birthDateTextField, gbc);
        birthPlaceTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        detailsField.add(birthPlaceTextField, gbc);
        deathDateTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        detailsField.add(deathDateTextField, gbc);
        deathPlaceLabel = new JLabel();
        deathPlaceLabel.setText("Death Place");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        detailsField.add(deathPlaceLabel, gbc);
        deathPlaceTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        detailsField.add(deathPlaceTextField, gbc);
        //drawField = new JPanel();
        //drawField.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        //panel1.add(drawField, BorderLayout.CENTER);
        nameLabel.setLabelFor(nameTextField);
        birthDateLabel.setLabelFor(birthDateTextField);
        birthPlaceLabel.setLabelFor(birthPlaceTextField);
        deathDateLabel.setLabelFor(deathDateTextField);
        deathPlaceLabel.setLabelFor(deathPlaceTextField);


        this.setSize(800, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}