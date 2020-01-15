package com.bae.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.business.GamePlannerService;
import com.bae.persistence.domain.GamePlan;
import com.bae.persistence.domain.TeamPlayer;
import com.bae.persistence.repo.GamePlannerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlannerServiceIntegrationTest {

	@Autowired
	private GamePlannerService service;

	@Autowired
	private GamePlannerRepository repo;

	private GamePlan testGamePlan;

	private GamePlan testPlanWithID;
	
	private List<GamePlan> gameList;
	
	
	private List<TeamPlayer> team;
	

	@Before
	public void init() {
		this.team = new ArrayList<>();
		this.gameList = new ArrayList<>();
		this.gameList.add(testGamePlan);
		this.testGamePlan = new GamePlan(LocalDate.of(2014, 4, 16), "MUCC", "Salford", team);
		
		this.repo.deleteAll();
	
		this.testPlanWithID = this.repo.save(this.testGamePlan);
		}
	
	@Test
	public void testAddNewGamePlan() {
		assertEquals(this.testPlanWithID.toString(), this.service.addNewGamePlan(testGamePlan).toString());
	}
	
		
	@Test
	public void testDeleteGamePlan() {
		assertThat(this.service.deleteGamePlan(this.testPlanWithID.getGamePlanId())).isFalse();
	}
	
	@Test
	public void testFindGamePlanByID() {
		assertEquals(this.service.findGamePlanByID(this.testPlanWithID.getGamePlanId()).toString(), this.testPlanWithID.toString());
	}

	@Test
	public void testGetAllGamePlan() {
		assertThat(this.service.getAllGamePlan().toString()).isEqualTo(Arrays.asList(new GamePlan[] {this.testPlanWithID }).toString());
	}

	@Test
	public void testUpdateGamePlan() {
		GamePlan newGamePlan = new GamePlan(LocalDate.of(2020, 4, 16), "MUCC", "Salford", team);
		GamePlan updateGamePlan = new GamePlan(newGamePlan.getGameDate(), newGamePlan.getOpposition(), newGamePlan.getLocation(), newGamePlan.getTeam());
		updateGamePlan.setGameId(this.testPlanWithID.getGamePlanId());

		assertThat(this.service.updateGamePlan(newGamePlan, this.testPlanWithID.getGamePlanId()).toString()).isEqualTo(updateGamePlan.toString());
	}


	
}