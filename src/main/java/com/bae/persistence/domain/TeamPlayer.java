package com.bae.persistence.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class TeamPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String firstName;
	private String surname;
	
	@ManyToMany(targetEntity = GamePlan.class)
	@JoinTable(name="Game_Players")
	private List<GamePlan> games;

	public TeamPlayer() {}

	public TeamPlayer(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "TeamPlayer [id=" + id + ", firstName=" + firstName + ", surname=" + surname + "]";
	}

}
