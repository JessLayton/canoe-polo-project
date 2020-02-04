package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.business.GamePlannerService;
import com.bae.persistence.domain.GamePlan;
import com.bae.persistence.domain.TeamPlayer;


@RunWith(SpringRunner.class)
public class PlannerControllerUnitTest {
	@InjectMocks
	private GamePlannerController plannerController;

	@Mock
	private GamePlannerService plannerService;
	
	private List<GamePlan> gamePlanList;
	
	private List<TeamPlayer> team;

	private GamePlan testGamePlan;

	private GamePlan testGamePlanWithID;

	final long gameId = 1L;
	
	@Before
	public void init() {
		this.gamePlanList = new ArrayList<>();
		this.testGamePlan = new GamePlan(LocalDate.of(2020, 5, 12), "Wildcats", "Leeds", team);
		this.gamePlanList.add(testGamePlan);
		this.testGamePlanWithID = new GamePlan(testGamePlan.getGameDate(), testGamePlan.getOpposition(), testGamePlan.getLocation(), testGamePlan.getTeam());
		this.testGamePlanWithID.setGameId(gameId);
	}

	@Test
	public void testAddNewGamePlan() {
		when(this.plannerService.addNewGamePlan(testGamePlan)).thenReturn(testGamePlanWithID);

		assertEquals(this.testGamePlanWithID, this.plannerController.addNewGamePlan(testGamePlan));

		verify(this.plannerService, times(1)).addNewGamePlan(this.testGamePlan);
	}

	@Test
	public void deletePlanTest() {
		this.plannerController.deleteGamePlan(gameId);

		verify(this.plannerService, times(1)).deleteGamePlan(gameId);
	}

	@Test
	public void findPlayerByIDTest() {
		when(this.plannerService.findGamePlanByID(this.gameId)).thenReturn(this.testGamePlanWithID);

		assertEquals(this.testGamePlanWithID, this.plannerController.getGamePlan(this.gameId));

		verify(this.plannerService, times(1)).findGamePlanByID(this.gameId);
	}

	@Test
	public void getAllGamePlanTest() {

		when(plannerService.getAllGamePlan()).thenReturn(this.gamePlanList);

		assertFalse("Controller has found no plans", this.plannerController.getAllGamePlan().isEmpty());

		verify(plannerService, times(1)).getAllGamePlan();
	}

	@Test
	public void updateGamePlanTest() {
		// given
		GamePlan newGamePlan = new GamePlan(LocalDate.of(2030, 5, 12), "Ghostbusters", "London", team);
		GamePlan updatedGamePlan = new GamePlan(newGamePlan.getGameDate(), newGamePlan.getOpposition(), newGamePlan.getLocation(), newGamePlan.getTeam());
		updatedGamePlan.setGameId(this.gameId);

		when(this.plannerService.updateGamePlan(newGamePlan, this.gameId)).thenReturn(updatedGamePlan);

		assertEquals(updatedGamePlan, this.plannerController.updateGamePlan(this.gameId, newGamePlan));

		verify(this.plannerService, times(1)).updateGamePlan(newGamePlan, this.gameId);
	}

}