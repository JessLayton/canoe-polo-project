package com.bae.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.exceptions.TeamNotFoundException;
import com.bae.persistence.domain.Team;
import com.bae.persistence.repo.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepo;
	
	public TeamService(TeamRepository teamRepo) {
		this.teamRepo = teamRepo;
	}
	
	public List<Team> getAllTeam() {
		if (teamRepo.findAll().isEmpty()) {
			setUpTeams(new Team());
		}
		return teamRepo.findAll();
	}
	private Team setUpTeams(Team team) {
		return this.teamRepo.save(team);
		
	}
	public Team addNewTeam(Team team) {
		return teamRepo.save(team);
	}

	public Team updateTeam(Team team) {
		return teamRepo.save(team);
	}
	
	public boolean deleteTeam(Long teamId) {
		if (!this.teamRepo.existsById(teamId)) {
			throw new TeamNotFoundException();
		}
		this.teamRepo.deleteById(teamId);
		return this.teamRepo.existsById(teamId);
	}
	

}
