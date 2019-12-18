package com.bae.business.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.business.TeamPlayerService;
import com.bae.persistence.domain.TeamPlayer;
import com.bae.persistence.repo.TeamPlayerRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TeamPlayerServiceIntegrationTest {
	
		
	@InjectMocks
	private TeamPlayerService service;

	@Mock
	private TeamPlayerRepository playerRepo;
	
	@Test
	public void getAllPlayersTest() {
		List<TeamPlayer> teams; 
		
	}

}
