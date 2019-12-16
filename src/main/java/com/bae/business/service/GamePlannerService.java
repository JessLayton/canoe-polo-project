package com.bae.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.exceptions.GameNotFoundException;

import com.bae.persistence.domain.GamePlan;
import com.bae.persistence.repo.GamePlannerRepository;


@Service
public class GamePlannerService {
	
	@Autowired
	private GamePlannerRepository plannerRepo;
	
	public GamePlannerService(GamePlannerRepository plannerRepo) {
		this.plannerRepo = plannerRepo;
	}
	
	public List<GamePlan> getAllGamePlan() {
		if (plannerRepo.findAll().isEmpty()) {
			setUpGamePlans(new GamePlan());
		}
		return plannerRepo.findAll();
	}

	private GamePlan setUpGamePlans(GamePlan gameplan) {
		return this.plannerRepo.save(gameplan);
		
	}
	public GamePlan addNewGamePlan(GamePlan gameplan) {
		return plannerRepo.save(gameplan);
	}

	public GamePlan updateGamePlan(GamePlan gameplan) {
		return plannerRepo.save(gameplan);
	}

	public boolean deleteGamePlan(Long gameId) {
		if (!this.plannerRepo.existsById(gameId)) {
			throw new GameNotFoundException();
		}
		this.plannerRepo.deleteById(gameId);
		return this.plannerRepo.existsById(gameId);
	}

}


