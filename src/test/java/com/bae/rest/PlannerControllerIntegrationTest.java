package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bae.persistence.domain.GamePlan;
import com.bae.persistence.domain.TeamPlayer;
import com.bae.persistence.repo.GamePlannerRepository;
import com.bae.persistence.repo.TeamPlayerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlannerControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private GamePlannerRepository plannerRepo;
	
	@Autowired TeamPlayerRepository playerRepo;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	private long gameId;
	
	
	private TeamPlayer playerWithId;
	
	private List<TeamPlayer> playerList;
	
	private TeamPlayer testPlayer;
	
	private GamePlan testGamePlan;
		
	private GamePlan testGamePlanWithID;
	
	@Before
	public void init() {
		this.mapper.registerModule(new JavaTimeModule());
		this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		this.plannerRepo.deleteAll();
		this.playerRepo.deleteAll();
		this.playerList = new ArrayList<>();
		this.testPlayer = new TeamPlayer("Joe", "Bloggs");
		this.playerList.add(testPlayer);
		this.playerWithId = this.playerRepo.save(testPlayer);
		this.testGamePlan = new GamePlan(LocalDate.of(2014, 4, 16), "MUCC", "Salford", playerList);
		this.testGamePlanWithID = this.plannerRepo.save(this.testGamePlan);
		this.gameId = this.testGamePlanWithID.getGamePlanId();
	}
	
	@Test
	public void testGetAllGamePlans() throws Exception {
		List<GamePlan> plannerList = new ArrayList<>();
		plannerList.add(this.testGamePlanWithID);

		String content = this.mock.perform(request(HttpMethod.GET, "/gamePlans/getAllGamePlans")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		assertEquals(this.mapper.writeValueAsString(plannerList), content);
	}
	
	@Test
	public void testGamePlan() throws Exception {
		List<GamePlan> plannerList = new ArrayList<>();
		plannerList.add(this.testGamePlanWithID);

		String content = this.mock.perform(request(HttpMethod.GET, "/gamePlans/getGamePlan/" + this.gameId)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		assertEquals(this.mapper.writeValueAsString(testGamePlan), content);
	}
	
	@Test
	public void testAddNewGamePlan() throws Exception {
		GamePlan testGamePlan2WithId = new GamePlan(this.testGamePlan.getGameDate(), this.testGamePlan.getOpposition(), this.testGamePlan.getLocation(), this.testGamePlan.getTeam()); 
		testGamePlan2WithId.setGameId(this.gameId + 1);
		String result = this.mock
				.perform(request(HttpMethod.POST, "/gamePlans/addGamePlan")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(testGamePlan))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();
		assertEquals(this.mapper.writeValueAsString(testGamePlan2WithId), result);
	}
	
	@Test
	public void testUpdateGamePlans() throws Exception {
		GamePlan newGamePlan = new GamePlan(LocalDate.of(2020, 5, 12), "Wildcats", "Leeds", playerList);
		GamePlan updatedGamePlan = new GamePlan(newGamePlan.getGameDate(), newGamePlan.getOpposition(), newGamePlan.getLocation(), newGamePlan.getTeam());
		updatedGamePlan.setGameId(this.gameId);

		String result = this.mock
				.perform(request(HttpMethod.PUT, "/gamePlans/updateGamePlans?gameId=" + this.gameId)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(newGamePlan)))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(updatedGamePlan), result);
	}
	
	
	
	@Test
	public void testDeleteGamePlan() throws Exception {
		this.mock.perform(request(HttpMethod.DELETE, "/gamePlans/deleteGamePlan/" + this.gameId))
				.andExpect(status().isOk());
	}

}
		
