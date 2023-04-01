package org.example;



import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox<Double> linesCombo;
    JButton createButton;


    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        createButton = new JButton("Create new game");
        linesLabel = new JLabel("Line probability");
        linesCombo = new JComboBox<>();
        linesCombo.addItem(1.0);

        //create the rest of the components
 //...TODO
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
 //...TODO
    }

}
