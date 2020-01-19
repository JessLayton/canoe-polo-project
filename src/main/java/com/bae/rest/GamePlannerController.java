package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.business.GamePlannerService;
import com.bae.persistence.domain.GamePlan;

@RestController
@RequestMapping("/gamePlans")
public class GamePlannerController {

	private GamePlannerService plannerService;

	public GamePlannerController(GamePlannerService plannerService) {
		super();
		this.plannerService = plannerService;
	}

	@GetMapping("/getAllGamePlans")
	public List<GamePlan> getAllGamePlan() {
		return plannerService.getAllGamePlan();
	}

	@GetMapping("/getGamePlan/{gameId}")
	public GamePlan getGamePlan(@PathVariable Long gameId) {
		return this.plannerService.findGamePlanByID(gameId);
	}

	@PostMapping("/addGamePlan")
	public GamePlan addNewGamePlan(@RequestBody GamePlan gameplan) {
		return plannerService.addNewGamePlan(gameplan);
	}

	@PutMapping("/updateGamePlans")
	public GamePlan updateGamePlan(@PathParam("id") Long gameId, @RequestBody GamePlan gameplan) {
		return this.plannerService.updateGamePlan(gameplan, gameId);
	}

	
	@DeleteMapping("/deleteGamePlan/{gameId}")
	public String deleteGamePlan(@PathVariable long gameId) {
		plannerService.deleteGamePlan(gameId);
		return ("Game deleted");
	}

}
