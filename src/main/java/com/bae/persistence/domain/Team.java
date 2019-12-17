package com.bae.persistence.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TeamPlayer> players= new LinkedList<>();
	
	
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
	
	public Team() {
    }

    public Team(String trainerName, List<TeamPlayer> players) {
        this.players = players;
    }
	

}
