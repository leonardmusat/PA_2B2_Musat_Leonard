package com.example.demo.model;
import java.util.ArrayList;
import java.util.List;


public class Game {
    private List<Player> players = new ArrayList<>();

    public Game (){
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        players.add(new Player("Player 3"));
        players.add(new Player("Player 4"));
    }
    public List<Player> getList(){
        return players;
    }
}
