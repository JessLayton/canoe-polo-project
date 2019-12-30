package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bae.business.TeamPlayerService;
import com.bae.persistence.domain.TeamPlayer;


@RestController
@RequestMapping("/player")
@CrossOrigin
public class TeamPlayerController {
    
	private TeamPlayerService playerService;
	
	@Autowired
	public TeamPlayerController(TeamPlayerService playerService) {
		super();
		this.playerService = playerService;
	}
    
    @GetMapping("/player")
    public List<TeamPlayer> getAllPlayer() {
        return playerService.getAllPlayer();
    }
    
    @GetMapping("/get/{id}")
	public TeamPlayer getDuck(@PathVariable Long id) {
		return this.playerService.findPlayerByID(id);
	}

    @PostMapping("/player")
    public TeamPlayer addNewPlayer(@RequestBody TeamPlayer player) {
        return this.playerService.addNewPlayer(player);
    }
      
    @PutMapping("/player")
	public TeamPlayer updatePlayer(@PathParam("id") Long id, @RequestBody TeamPlayer player) {
		return this.playerService.updatePlayer(player, id);
	}

    @DeleteMapping("/player/{id}")
    public String deletePlayer(@PathVariable long id) {
        this.playerService.deletePlayer(id);
        return "Player deleted";
    }
}