package com.bae.business.service;

import java.util.List;

import com.bae.exceptions.PlayerNotFoundException;
import com.bae.persistence.domain.TeamPlayer;
import com.bae.persistence.repo.TeamPlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamPlayerService {
	
	private TeamPlayerRepository playerRepo;

	public TeamPlayerService(TeamPlayerRepository playerRepo) {
		this.playerRepo = playerRepo;
	}

	public List<TeamPlayer> getAllPlayer() {
		if (playerRepo.findAll().isEmpty()) {
			setUpPlayers();
		}
		return playerRepo.findAll();
	}

	private void setUpPlayers() {
		TeamPlayer jess = new TeamPlayer("Jess", "Layton");
		TeamPlayer matt = new TeamPlayer("Matt", "Berry");
		TeamPlayer james = new TeamPlayer("James", "Kiesslinger");
		playerRepo.save(jess);
		playerRepo.save(matt);
		playerRepo.save(james);

	}

	public TeamPlayer addNewPlayer(TeamPlayer player) {
		return playerRepo.save(player);
	}

	public TeamPlayer updatePlayer(TeamPlayer player) {
		return playerRepo.save(player);
	}

	public boolean deletePlayer(Long id) {
		if (!this.playerRepo.existsById(id)) {
			throw new PlayerNotFoundException();
		}
		this.playerRepo.deleteById(id);
		return this.playerRepo.existsById(id);
	}

}