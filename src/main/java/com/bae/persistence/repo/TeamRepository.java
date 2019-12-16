package com.bae.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Team;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}
