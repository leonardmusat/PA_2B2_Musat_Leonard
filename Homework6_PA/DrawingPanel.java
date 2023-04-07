package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


import static java.lang.Math.abs;


public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image
    private Point startPoint;
    private Point endPoint;
    List<Point> listPoints = new ArrayList<>();
    Stroke stroke = new BasicStroke(2f);
    boolean bool = true;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());

        this.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {

                        startPoint = new Point(correctPointsX(e.getX()), correctPointsY(e.getY()));
                    }

                    public void mouseReleased(MouseEvent e) {

                        endPoint = new Point(correctPointsX(e.getX()), correctPointsY(e.getY()));
                        if (alreadyTaken(startPoint, endPoint)) {
                            if (bool) {

                                graphics.setStroke(stroke);
                                graphics.setColor(Color.BLUE);
                                graphics.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                                bool = false;
                                listPoints.add(startPoint);
                                listPoints.add(endPoint);
                            } else {
                                graphics.setStroke(stroke);
                                graphics.setColor(Color.RED);
                                graphics.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                                bool = true;
                                listPoints.add(startPoint);
                                listPoints.add(endPoint);
                            }
                            repaint();
                        } else {
                            System.out.println("Line already taken!!");
                        }

                    }
                });
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard() {
        if (frame.configPanel.getValue() != 0) {
            numVertices = frame.configPanel.getValue();
        } else {
            numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        }
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                graphics.drawLine(x[i], y[i], x[j], y[j]);
                graphics.setColor(Color.GRAY);
            }
        }

    }

    private void drawVertices() {
        for (int i = 0; i < numVertices; i++) {
            graphics.drawOval(x[i] - 7, y[i] - 7, 14, 14);
            graphics.fillOval(x[i] - 7, y[i] - 7, 14, 14);
            graphics.setColor(Color.BLACK);
        }
    }

    @Override
    public void update(Graphics g) {
    } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

    private int correctPointsX(int point) {
        int dif = 0;
        int ret = 1000;
        for (int i = 0; i < numVertices; i++) {
            int temp = abs(point - x[i]);
            if (temp < ret) {
                ret = temp;
                dif = x[i];
            }
        }
        return dif;
    }

    private int correctPointsY(int point) {
        int dif = 0;
        int ret = 1000;
        for (int i = 0; i < numVertices; i++) {
            int temp = abs(point - y[i]);
            if (temp < ret) {
                ret = temp;
                dif = y[i];
            }
        }
        return dif;
    }

    private boolean alreadyTaken(Point pointStart, Point pointEnd) {
        boolean bol1 = false;
        boolean bol2 = false;
        for (int i = 0; i < listPoints.size(); i = i + 2) {
            if (listPoints.get(i).equals(pointStart))
                bol1 = true;
            if (listPoints.get(i + 1).equals(pointEnd))
                bol2 = true;
            if (bol1 && bol2) {
                return false;
            }
        }
        return true;
    }
}


