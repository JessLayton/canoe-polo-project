package com.bae.rest;

import java.util.List;

import com.bae.business.service.TeamPlayerService;
import org.springframework.web.bind.annotation.*;

import com.bae.persistence.domain.TeamPlayer;


@RestController
public class TeamPlayerController {
    private TeamPlayerService playerService;
    private TeamPlayerController(TeamPlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/player")
    public List<TeamPlayer> getAllPlayer() {
        return playerService.getAllPlayer();
    }

    @PostMapping("/player")
    public TeamPlayer addNewTrainer(@RequestBody TeamPlayer player) {
        return playerService.addNewPlayer(player);
    }

    @PutMapping("/player")
    public TeamPlayer updateTrainer(@RequestBody TeamPlayer player) {
        return playerService.updatePlayer(player);
    }

    @DeleteMapping("/player/{id}")
    public String deletePlayer(@PathVariable long id) {
        playerService.deletePlayer(id);
        return "Player deleted";
    }
}