package com.bae.persistence.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.TeamPlayer;
import com.bae.persistence.service.TeamPlayerService;

@RestController
public class TeamPlayerController {
	
	private TeamPlayerService playerservice;
	private TeamPlayerController(TeamPlayerService playerservice) {
		this.playerservice = playerservice;
	}

	@GetMapping("/player")
	public List<TeamPlayer> getAllPlayer() {
		return playerservice.getAllPlayer();
	}

	@PostMapping("/player")
	public TeamPlayer addNewTrainer(@RequestBody TeamPlayer player) {
		return playerservice.addNewPlayer(player);
	}

	@PutMapping("/player")
	public TeamPlayer updateTrainer(@RequestBody TeamPlayer player) {
		return playerservice.updatePlayer(player);
	}

	@DeleteMapping("/player/{id}")
	public String deleteTrainer(@PathVariable(value = "id") Long id) {
		return playerservice.deletePlayer(id);
	}
}