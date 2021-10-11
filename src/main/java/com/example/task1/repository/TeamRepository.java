package com.example.task1.repository;

import com.example.task1.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
