package com.bae.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.business.service.TeamService;

import com.bae.persistence.domain.Team;

@RestController
public class TeamController {
	private TeamService teamService;
	private TeamController(TeamService teamService) {
		this.teamService = teamService;
	}
	
	@GetMapping("/team")
    public List<Team> getAllTeam() {
        return teamService.getAllTeam();
    }
    
    @PostMapping("/team")
    public Team addNewTeam(@RequestBody Team team) {
        return teamService.addNewTeam(team);
    }
    
    @PutMapping("/team")
    public Team updateTeam(@RequestBody Team team) {
    	return teamService.updateTeam(team);
    }
    
    @DeleteMapping("/team/{teamId}")
    public String deleteTeam(@RequestBody long teamId) {
    	teamService.deleteTeam(teamId);
    	return("Team deleted");
    }

}
