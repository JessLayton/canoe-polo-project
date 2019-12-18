package com.bae.persistence.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class GamePlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gameId;
	private Date gameDate;
	private String opposition;
	private String location;
	
	@ManyToMany(targetEntity = TeamPlayer.class) 
	@JoinTable(name="Game_Players")
	private List<TeamPlayer> team;
	
	
	public GamePlan() {}
	
	public GamePlan(Date gameDate, String oppostion, String location, List<TeamPlayer> team, String opposition) {
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
	public List<TeamPlayer> getTeam() {
		return team;
	}
	public void setTeam(List<TeamPlayer> team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "GamePlan [gameId= " + gameId + ", game date = " + gameDate 
				+ ", opposition = " + opposition + ", location = " + location + ", team: " + team + "]";
	}
	
		
}

