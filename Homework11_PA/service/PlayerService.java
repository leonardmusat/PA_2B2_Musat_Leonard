package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private Game game = new Game();

    public void addPlayer(Player player){
        game.addPlayer(player);
    }

    public List<Player> getAllPlayer(){
        return game.getList();
    }

    public void setPlayer(String newName, String oldName){
        if(game.findByName(oldName) == null)
            System.out.println("Player " + oldName + " not found.");
        else
        game.findByName(oldName).setName(newName);
    }

    public void deletePlayer(String name){
        if(game.findByName(name) == null)
            System.out.println("Player " + name + " not found.");
        else
        game.getList().remove(game.findByName(name));
    }


}
