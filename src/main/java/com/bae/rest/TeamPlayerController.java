package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bae.business.TeamPlayerService;
import com.bae.persistence.domain.TeamPlayer;


@RestController
@RequestMapping("/teamPlayers")
@CrossOrigin
public class TeamPlayerController {
    
	private TeamPlayerService playerService;
	
	@Autowired
	public TeamPlayerController(TeamPlayerService playerService) {
		super();
		this.playerService = playerService;
	}
    
	@GetMapping("/getAllPlayers")
    public List<TeamPlayer> getAllPlayer() {
        return playerService.getAllPlayer();
    }
    
    @GetMapping("/getPlayer/{id}")
	public TeamPlayer getPlayer(@PathVariable Long id) {
		return this.playerService.findPlayerByID(id);
	}

    @PostMapping("/addPlayer")
    public TeamPlayer addNewPlayer(@RequestBody TeamPlayer player) {
        return this.playerService.addNewPlayer(player);
    }
      
    @PutMapping("/updatePlayer/{id}")
	public TeamPlayer updatePlayer(@PathVariable("id") Long id, @RequestBody TeamPlayer player) {
		return this.playerService.updatePlayer(player, id);
	}

    @DeleteMapping("/deletePlayer/{id}")
    public String deletePlayer(@PathVariable long id) {
        this.playerService.deletePlayer(id);
        return "Player deleted";
    }
}