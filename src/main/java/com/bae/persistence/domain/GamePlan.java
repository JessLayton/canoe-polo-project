package com.bae.persistence.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import antlr.collections.List;

@Entity
public class GamePlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gameId;
	private Date gameDate;
	private String opposition;
	private String location;
	private List team;
	
	public GamePlan(Date gameDate, String oppostion, String location, List team, String opposition) {
		this.gameDate = gameDate;
		this.opposition = opposition;
		this.location = location;
		this.team = team;
	}
	
	public Long getFutureGameId() {
		return gameId;
	}
	public void setFutureGameId(Long futureGameId) {
		this.gameId = futureGameId;
	}
	public Date getGameDate() {
		return gameDate;
	}
	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}
	public String getOpposition() {
		return opposition;
	}
	public void setOpposition(String opposition) {
		this.opposition = opposition;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List getTeam() {
		return team;
	}
	public void setTeam(List team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "GamePlan [gameId= " + gameId + ", game date = " + gameDate 
				+ ", opposition = " + opposition + ", location = " + location + ", team: " + team + "]";
	}
	
}

