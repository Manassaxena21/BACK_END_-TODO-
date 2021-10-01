package com.niit.authentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niit.authentication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
	
	User findByEmailAndPassword(String email, String password);

	User findByUsernameAndPassword(String username, String password);

	User findByToken(String token);

	Optional<User> findByEmail(String email);

}
