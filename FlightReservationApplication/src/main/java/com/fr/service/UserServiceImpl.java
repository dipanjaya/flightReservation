package com.fr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.entity.User;
import com.fr.repos.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository repository;
	
	public void registerUser(User user) {
		repository.save(user);
	}
	
}
