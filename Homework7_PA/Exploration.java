package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exploration {
    private final SharedMemory mem = new SharedMemory(20);
    private final ExplorationMap map = new ExplorationMap();
    private static final List<Robot> robots = new ArrayList<>();

    static boolean running = true;


    public SharedMemory getMem() {
        return mem;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }

    /**
     * Method "setPause" sets the boolean value of "paused" to true.
     * Paused is used in Robot class to pause the robot.
     */
    public static void setPause(){
        while (running){
            System.out.println("Enter command: ");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if(command.equals ("pause")){
                for(Robot robot: robots){
                    robot.setPaused(true);

                }
            }
            else if(command.equals("stop")){
                running = false;
                for (Robot robot : robots) {
                    System.out.println("Robotul cu numele " + " a vizitat " + robot.getContor() + " celule");
                }
            }
            else{
                System.out.println("Invalid command");
            }
        }
    }

    public static void main(String args[]) {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E", explore));
        explore.addRobot(new Robot("R2D2", explore));
        explore.addRobot(new Robot("Optimus Prime",explore));
        explore.start();
        setPause();

    }

    private void addRobot(Robot robot) {
        robots.add(robot);
    }

}
