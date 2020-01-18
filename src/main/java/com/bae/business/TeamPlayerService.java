package com.bae.business;

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

	public TeamPlayer findPlayerByID(Long id) {
		return this.playerRepo.findById(id).orElseThrow(PlayerNotFoundException::new);
	}

	public List<TeamPlayer> getAllPlayer() {
		return playerRepo.findAll();
	}

	public TeamPlayer addNewPlayer(TeamPlayer player) {
		return playerRepo.save(player);
	}

	public TeamPlayer updatePlayer(TeamPlayer player, Long id) {
		TeamPlayer toUpdate = findPlayerByID(id);
		toUpdate.setFirstName(player.getFirstName());
		toUpdate.setSurname(player.getSurname());
		return this.playerRepo.save(toUpdate);
	}

	public boolean deletePlayer(Long id) {
		if (!this.playerRepo.existsById(id)) {
			throw new PlayerNotFoundException();
		}
		this.playerRepo.deleteById(id);
		return this.playerRepo.existsById(id);
	}

}