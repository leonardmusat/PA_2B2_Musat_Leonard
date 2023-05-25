package com.example.demo.api;
import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/api/player")
@RestController
@Api(value = "PlayerController", description = "REST API for Player", tags = { "Player" })
public class PlayerController {

    private final PlayerService playerService;

@Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping()
    public List<Player> getAllPeople(){
    return playerService.getAllPlayer();
    }


    @PostMapping()
    public void addPlayer(@RequestBody Player player){
        playerService.addPlayer(player);
    }


    @PutMapping (path = "{name}")
    public void setPlayer(@PathVariable("name") String name, @RequestBody Player player){
        playerService.setPlayer(player.getName(), name);
    }


    @DeleteMapping (path = "{name}")
    public void deletePlayer(@PathVariable("name") String name){
        playerService.deletePlayer(name);
    }

}
