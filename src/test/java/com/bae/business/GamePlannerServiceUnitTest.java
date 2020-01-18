package com.bae.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.business.GamePlannerService;
import com.bae.persistence.domain.GamePlan;
import com.bae.persistence.domain.TeamPlayer;
import com.bae.persistence.repo.GamePlannerRepository;

@RunWith(SpringRunner.class)
public class GamePlannerServiceUnitTest {

	@InjectMocks
	private GamePlannerService service;

	@Mock
	private GamePlannerRepository repo;

	private List<GamePlan> gameList;

	private GamePlan testGamePlan;

	private GamePlan testGamePlanWithID;
	
	final long gameId = 1L;
	
	private TeamPlayer testPlayer;
	
	private List<TeamPlayer> playerList;
	
		
	@Before
	public void init() {
		this.gameList = new ArrayList<>();
		this.playerList = new ArrayList<>();
		this.gameList.add(testGamePlan);
		this.testPlayer = new TeamPlayer("Luke", "Cottenham");
		this.playerList.add(testPlayer);
		this.testGamePlan = new GamePlan(LocalDate.of(2014, 4, 16), "MUCC", "Salford", playerList);
		this.testGamePlanWithID = new GamePlan(testGamePlan.getGameDate(), testGamePlan.getOpposition(), testGamePlan.getLocation(), testGamePlan.getTeam());
		this.testGamePlanWithID.setGameId(gameId);
	}

	@Test
	public void addNewGamePlanTest() {
		when(this.repo.save(testGamePlan)).thenReturn(testGamePlanWithID);

		assertEquals(this.testGamePlanWithID, this.service.addNewGamePlan(testGamePlan));

		verify(this.repo, times(1)).save(this.testGamePlan);
	}

	@Test
	public void deleteGamePlanTest() {
		when(this.repo.existsById(gameId)).thenReturn(true, false);

		this.service.deleteGamePlan(gameId);

		verify(this.repo, times(1)).deleteById(gameId);
		verify(this.repo, times(2)).existsById(gameId);
	}

	@Test
	public void findGamePlannerByIDTest() {
		when(this.repo.findById(this.gameId)).thenReturn(Optional.of(this.testGamePlanWithID));

		assertEquals(this.testGamePlanWithID, this.service.findGamePlanByID(this.gameId));

		verify(this.repo, times(1)).findById(this.gameId);
	}

	@Test
	public void getAllGamePlanTest() {

		when(repo.findAll()).thenReturn(this.gameList);

		assertFalse("No games found", this.service.getAllGamePlan().isEmpty());

		verify(repo, times(1)).findAll();
	}

	@Test
	public void updateGamePlansTest() {
		
		GamePlan newGamePlan = new GamePlan();
		GamePlan updateGamePlan = new GamePlan(newGamePlan.getGameDate(), newGamePlan.getOpposition(), newGamePlan.getLocation(), newGamePlan.getTeam());
		updateGamePlan.setGameId(this.gameId);

		when(this.repo.findById(this.gameId)).thenReturn(Optional.of(this.testGamePlanWithID));
		
		when(this.repo.save(updateGamePlan)).thenReturn(updateGamePlan);

		assertEquals(updateGamePlan, this.service.updateGamePlan(updateGamePlan, gameId));

		verify(this.repo, times(1)).findById(1L);
		verify(this.repo, times(1)).save(updateGamePlan);
	}

}
