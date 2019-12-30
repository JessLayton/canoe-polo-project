package com.bae.persistence.domain;

 import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private LocalDate gameDate;
	private String opposition;
	private String location;
	
	@ManyToMany(targetEntity = TeamPlayer.class, fetch=FetchType.EAGER) 
	@JoinTable(name="Game_Players")
	private List<TeamPlayer> team;
	
	
	public GamePlan() {}
	
	public GamePlan(LocalDate gameDate, String opposition, String location, List<TeamPlayer> team) {
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
	public LocalDate getGameDate() {
		return gameDate;
	}
	public void setGameDate(LocalDate gameDate) {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameDate == null) ? 0 : gameDate.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((opposition == null) ? 0 : opposition.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GamePlan other = (GamePlan) obj;
		if (gameDate == null) {
			if (other.gameDate != null)
				return false;
		} else if (!gameDate.equals(other.gameDate))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (opposition == null) {
			if (other.opposition != null)
				return false;
		} else if (!opposition.equals(other.opposition))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}
		
}

