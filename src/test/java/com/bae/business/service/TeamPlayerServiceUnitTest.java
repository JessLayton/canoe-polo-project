package com.bae.business.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.business.TeamPlayerService;
import com.bae.persistence.repo.TeamPlayerRepository;

@RunWith(SpringRunner.class)
class TeamPlayerServiceUnitTest {
	
	@InjectMocks
	private TeamPlayerService service;

	@Mock
	private TeamPlayerRepository repo;

	private List<TeamPlayer> playerList;

	private Duck testDuck;

	private Duck testDuckWithID;

	final long id = 1L;

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
