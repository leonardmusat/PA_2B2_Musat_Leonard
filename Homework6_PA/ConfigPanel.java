package org.example;


import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox<Double> linesCombo;
    JButton createButton;

    JButton exportButton;

    int value = 0;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(8, 3, 100, 1));
        createButton = new JButton("Create new game");
        linesLabel = new JLabel("Line probability");
        linesCombo = new JComboBox<>();
        linesCombo.addItem(1.0);
        exportButton = new JButton("Export");

        //create the rest of the components
        //...TODO
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
        createButton.addActionListener(this::createGame);
        add(exportButton);
        exportButton.addActionListener(this::exportGame);
        //...TODO
    }

    private void createGame(ActionEvent e) {
        value = (int) dotsSpinner.getValue();
        frame.canvas.createBoard();
    }

    public int getValue() {
        return value;
    }

    private void exportGame(ActionEvent e) {
        BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        frame.printAll(g);
        g.dispose();
        try {
            ImageIO.write(image, "png", new File("IMG.png"));
        } catch (IOException exp) {
            exp.printStackTrace();
        }

    }
}




