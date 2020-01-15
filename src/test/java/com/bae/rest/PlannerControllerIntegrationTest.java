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
	
	private TeamPlayer player;
	private TeamPlayer playerWithId;
	
	private List<TeamPlayer> team;
	
	private GamePlan testGamePlan;
	private GamePlan testGamePlan2;
	
	private GamePlan testGamePlanWithID;
	
	@Before
	public void init() {
		this.plannerRepo.deleteAll();
//		this.playerRepo.deleteAll();
		this.team = new ArrayList<>();
//		this.player = new TeamPlayer("Luke", "Cottenham");
//		this.playerWithId = this.playerRepo.save(player);
		this.testGamePlan = new GamePlan(LocalDate.of(2014, 4, 16), "MUCC", "Salford", team);
		this.testGamePlan2 = new GamePlan(LocalDate.of(2014, 4, 16), "MUCC", "Salford", team);
		this.testGamePlanWithID = this.plannerRepo.save(this.testGamePlan);
		this.gameId = this.testGamePlanWithID.getGamePlanId();
	}
	
	@Test
	public void testAddNewGamePlan() throws Exception {
		String result = this.mock
				.perform(request(HttpMethod.POST, "/gamePlans/addGamePlan")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(testGamePlan2))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();
		assertEquals(this.mapper.writeValueAsString(testGamePlanWithID), result);
	}
	
	@Test
	public void testDeleteGamePlan() throws Exception {
		this.mock.perform(request(HttpMethod.DELETE, "/gamePlans/deleteGamePlan/" + this.gameId))
				.andExpect(status().isOk());
	}
		
		
	

}
