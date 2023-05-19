package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private Game game = new Game();

    public List<Player> getAllPlayer(){
        return game.getList();
    }

}
