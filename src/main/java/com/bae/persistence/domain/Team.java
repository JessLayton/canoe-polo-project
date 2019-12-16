package com.bae.persistence.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;
	
	@OneToMany
	private List<TeamPlayer> players;

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public List<TeamPlayer> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<TeamPlayer> players) {
		this.players = players;
	}
	
	@Override
	public String toString() {
		return "Team [" + players + "]";
	}
	

}
