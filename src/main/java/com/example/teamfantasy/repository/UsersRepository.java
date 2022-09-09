package com.example.teamfantasy.repository;

import com.example.teamfantasy.dto.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {
}
