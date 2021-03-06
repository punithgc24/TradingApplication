package com.punith.TradeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.punith.TradeApp.Domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

	User findByUsernameAndPassword(String username, String password);

}
