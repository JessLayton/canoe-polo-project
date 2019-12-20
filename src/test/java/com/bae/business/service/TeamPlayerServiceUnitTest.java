package com.bae.business.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.business.TeamPlayerService;
import com.bae.persistence.domain.TeamPlayer;
import com.bae.persistence.repo.TeamPlayerRepository;

@RunWith(SpringRunner.class)
public class TeamPlayerServiceUnitTest {
	
	@InjectMocks
	private TeamPlayerService service;
	
	@Mock
	private TeamPlayerRepository repo;

	private List<TeamPlayer> playerList;

	private TeamPlayer testTeamPlayer;

	private TeamPlayer testTeamPlayerWithID;

	final long id = 1L;
	
	@Before
	public void init() {
		this.playerList = new ArrayList<>();
		this.playerList.add(testTeamPlayer);
		this.testTeamPlayer = new TeamPlayer("Santa", "Claus");
		this.testTeamPlayerWithID = new TeamPlayer(testTeamPlayer.getFirstName(), testTeamPlayer.getSurname());
		this.testTeamPlayerWithID.setId(id);
	}

	@Test
	public void addNewPlayerTest() {
		when(this.repo.save(testTeamPlayer)).thenReturn(testTeamPlayerWithID);

		assertEquals(this.testTeamPlayerWithID, this.service.addNewPlayer(testTeamPlayer));

		verify(this.repo, times(1)).save(this.testTeamPlayer);
	}

	@Test
	public void deleteTeamPlayerTest() {
		when(this.repo.existsById(id)).thenReturn(true, false);

		this.service.deletePlayer(id);

		verify(this.repo, times(1)).deleteById(id);
		verify(this.repo, times(2)).existsById(id);
	}
	
	@Test
	public void findTeamPlayerByIDTest() {
		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testTeamPlayerWithID));

		assertEquals(this.testTeamPlayerWithID, this.service.findPlayerByID(this.id));

		verify(this.repo, times(1)).findById(this.id);
	}

	@Test
	public void getAllPlayerTest() {

		when(repo.findAll()).thenReturn(this.playerList);

		assertFalse("No players found", this.service.getAllPlayer().isEmpty());

		verify(repo, times(1)).findAll();
	}
	
	@Test
	public void updatePlayersTest() {
		
		TeamPlayer newTeamPlayer = new TeamPlayer("Homer", "Simpson");
		TeamPlayer updatedTeamPlayer = new TeamPlayer(newTeamPlayer.getFirstName(), newTeamPlayer.getSurname());
		updatedTeamPlayer.setId(this.id);

		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testTeamPlayerWithID));
		
		when(this.repo.save(updatedTeamPlayer)).thenReturn(updatedTeamPlayer);

		assertEquals(updatedTeamPlayer, this.service.updatePlayer(newTeamPlayer, this.id));

		verify(this.repo, times(1)).findById(1L);
		verify(this.repo, times(1)).save(updatedTeamPlayer);
	}


}
