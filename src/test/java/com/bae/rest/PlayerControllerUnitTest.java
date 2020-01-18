package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.business.TeamPlayerService;
import com.bae.persistence.domain.TeamPlayer;


@RunWith(SpringRunner.class)
public class PlayerControllerUnitTest {
	@InjectMocks
	private TeamPlayerController playerController;

	@Mock
	private TeamPlayerService playerService;
	
	private List<TeamPlayer> playerList;

	private TeamPlayer testPlayer;

	private TeamPlayer testPlayerWithID;

	final long id = 1L;
	
	@Before
	public void init() {
		this.playerList = new ArrayList<>();
		this.playerList.add(testPlayer);
		this.testPlayer = new TeamPlayer("Lady", "Gaga");
		this.testPlayerWithID = new TeamPlayer(testPlayer.getFirstName(), testPlayer.getSurname());
		this.testPlayerWithID.setId(id);
	}

	@Test
	public void testAddNewPlayer() {
		when(this.playerService.addNewPlayer(testPlayer)).thenReturn(testPlayerWithID);

		assertEquals(this.testPlayerWithID, this.playerController.addNewPlayer(testPlayer));

		verify(this.playerService, times(1)).addNewPlayer(this.testPlayer);
	}

	@Test
	public void deletePlayerTest() {
		this.playerController.deletePlayer(id);

		verify(this.playerService, times(1)).deletePlayer(id);
	}

	@Test
	public void findPlayerByIDTest() {
		when(this.playerService.findPlayerByID(this.id)).thenReturn(this.testPlayerWithID);

		assertEquals(this.testPlayerWithID, this.playerController.getPlayer(this.id));

		verify(this.playerService, times(1)).findPlayerByID(this.id);
	}

	@Test
	public void getAllPlayersTest() {

		when(playerService.getAllPlayer()).thenReturn(this.playerList);

		assertFalse("Controller has found no players", this.playerController.getAllPlayer().isEmpty());

		verify(playerService, times(1)).getAllPlayer();
	}

	@Test
	public void updateDucksTest() {
		// given
		TeamPlayer newTeamPlayer = new TeamPlayer("Iggy", "Pop");
		TeamPlayer updatedTeamPlayer = new TeamPlayer(newTeamPlayer.getFirstName(), newTeamPlayer.getSurname());
		updatedTeamPlayer.setId(this.id);

		when(this.playerService.updatePlayer(newTeamPlayer, this.id)).thenReturn(updatedTeamPlayer);

		assertEquals(updatedTeamPlayer, this.playerController.updatePlayer(this.id, newTeamPlayer));

		verify(this.playerService, times(1)).updatePlayer(newTeamPlayer, this.id);
	}

}

