package com.bae.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.business.service.GamePlannerService;
import com.bae.persistence.domain.GamePlan;


@RestController
public class GamePlannerController {
	private GamePlannerService plannerService;
    private GamePlannerController(GamePlannerService plannerService) {
        this.plannerService = plannerService;
    }
    
    @GetMapping("/gameplan")
    public List<GamePlan> getAllGamePlan() {
        return plannerService.getAllGamePlan();
    }
    
    @PostMapping("/gameplan")
    public GamePlan addNewGamePlan(@RequestBody GamePlan gameplan) {
        return plannerService.addNewGamePlan(gameplan);
    }
    
    @PutMapping("/gameplan")
    public GamePlan updateGamePlan(@RequestBody GamePlan gameplan) {
    	return plannerService.updateGamePlan(gameplan);
    }
    
    @DeleteMapping("/gameplan/{gameId}")
    public String deleteGamePlan(@RequestBody long gameId) {
    	plannerService.deleteGamePlan(gameId);
    	return("Game deleted");
    }
    
    

}
