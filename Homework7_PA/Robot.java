package org.example;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.random;
import static java.lang.Thread.sleep;

public class Robot implements Runnable {
    private final String name;
    private boolean paused = false;
    private boolean running = true;
    Exploration explore;

    private int contor = 0;
    private int row = ThreadLocalRandom.current().nextInt(0, 4);
    private int col = ThreadLocalRandom.current().nextInt(0, 4);
    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
    }

    public String getName() {
        return name;
    }

    public List<Token> extractTokens() {
        return explore.getMem().extractTokens(2);
    }

    /**
     * Method "run" is used to run the robot.
     * It is necesary to override this method because Robot implements Runnable and for our program to work concurrently.
     */
    public void run() {
        while (running) {

            if (paused){
                pause(10000);
            }

            try {
                sleep ((int) (random() * 3000));
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            if(explore.getMap().visit(row, col, this)) {
                System.out.println("Robot " + name + " has visited cell with row: " + row + " and col: " + col);
                contor++;
            }
            else {
                System.out.println("Robot " + name + " has failed to visit cell with row: " + row + " and col: " + col + " because it was already visited");
               running = false;
            }
            System.out.println(explore.getMap().getMatrix()[row][col]);

            move();
        }
    }
    /**
     * Method "pause" pauses the robot for a given time
     * @param pauseTime
     */
    public void pause(int pauseTime) {
        synchronized (this) {
            try {
                wait(pauseTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getContor() {
        return contor;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    /**
     * Method "move" moves the robot to the next cell
     * Robots can move only in the right direction
     */
    public void move(){
        if (col == 4 && row == 4){
           col = 0;
           row = 0;
        }
        else if(row == 4){
           row = 0;
           col++;
        }
        else
            row++;

    }
}
