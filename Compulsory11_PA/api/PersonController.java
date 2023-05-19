package com.example.demo.api;
import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/api")
@RestController
public class PersonController {

    private final PlayerService playerService;

@Autowired
    public PersonController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPeople(){
    return playerService.getAllPlayer();
    }

}
