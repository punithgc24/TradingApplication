package com.punith.TradeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.punith.TradeApp.Domain.User;
import com.punith.TradeApp.Repository.UserRepository;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	public UserRepositoryUserDetailsService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findByUsername(username);
		if(user!=null) {
			return user;
		}
		
		throw new UsernameNotFoundException("User "+ username +" Not Found");
	}
}
