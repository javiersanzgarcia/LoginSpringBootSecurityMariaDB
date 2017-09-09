package com.jsg.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsg.login.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	Optional<Users> findByName(String username);
	
}
