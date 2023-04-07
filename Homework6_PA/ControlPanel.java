package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class ControlPanel extends JPanel {
    MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton saveBtn = new JButton("Save");

    //...TODO
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::saveGame);
        loadBtn.addActionListener(this::loadGame);
        //...TODO
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void saveGame(ActionEvent e) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("s.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(frame);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in s.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private void loadGame(ActionEvent e) {
        MainFrame frm = null;
        try {
            FileInputStream fileIn = new FileInputStream("s.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            frm = (MainFrame) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("MainFrame class not found");
            c.printStackTrace();
            return;
        }
        frame = frm;
    }
    //...TODO
}

