package com.bae.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.GamePlan;
import com.bae.persistence.domain.TeamPlayer;

@Repository
public interface GamePlannerRepository extends JpaRepository<GamePlan, Long>{

}
