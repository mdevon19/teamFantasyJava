package com.example.teamfantasy.repository;

import com.example.teamfantasy.dto.Teams;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TeamsRepository extends CrudRepository<Teams, String> {
}
