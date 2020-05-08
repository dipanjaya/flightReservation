package com.fr.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fr.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
