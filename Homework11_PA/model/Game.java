package com.example.demo.model;
import java.util.ArrayList;
import java.util.List;


public class Game {
    private static final int MAX_PLAYERS = 2;
    private List<Player> players = new ArrayList<>();
    public Game (){
    }

    public void addPlayer(Player player){
        if (players.size() < MAX_PLAYERS) {
            players.add(player);
            System.out.println("Player " + player.getName() + " added to the game.");
        } else {
            System.out.println("Maximum number of players reached. Another game created.");
        }
    }

    public List<Player> getList(){
        return players;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

}
