package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.bae.persistence.domain.TeamPlayer;
import com.bae.persistence.repo.TeamPlayerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;

	@Autowired
	private TeamPlayerRepository playerRepo;

	private ObjectMapper mapper = new ObjectMapper();

	private long id;

	private TeamPlayer testTeamPlayer;

	private TeamPlayer testPlayerWithID;
	
	@Before
	public void init() {
		this.playerRepo.deleteAll();

		this.testTeamPlayer = new TeamPlayer("Jess", "Layton");
		this.testPlayerWithID = this.playerRepo.save(this.testTeamPlayer);
		this.id = this.testPlayerWithID.getId();
	}
	
	@Test
	public void testAddNewPlayer() throws Exception {
		String result = this.mock
				.perform(request(HttpMethod.POST, "/player/addNewPlayer").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(testTeamPlayer)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertEquals(this.mapper.writeValueAsString(testPlayerWithID), result);
	}
	
	@Test
	public void testDeletePlayer() throws Exception {
		this.mock.perform(request(HttpMethod.DELETE, "/player/deletePlayer/" + this.id)).andExpect(status().isOk());
	}

	@Test
	public void testGetAllPlayers() throws Exception {
		List<TeamPlayer> playerList = new ArrayList<>();
		playerList.add(this.testPlayerWithID);

		String content = this.mock.perform(request(HttpMethod.GET, "/player/getAllPlayer").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(playerList), content);
	}

	@Test
	public void testUpdateTeamPlayer() throws Exception {
		TeamPlayer newTeamPlayer = new TeamPlayer("Annie", "Latham");
		TeamPlayer updatedTeamPlayer = new TeamPlayer(newTeamPlayer.getFirstName(), newTeamPlayer.getSurname());
		updatedTeamPlayer.setId(this.id);

		String result = this.mock
				.perform(request(HttpMethod.PUT, "/player/updatePlayer/?id=" + this.id).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newTeamPlayer)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(updatedTeamPlayer), result);
	}


}
