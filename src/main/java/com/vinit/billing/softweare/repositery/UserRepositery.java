package com.vinit.billing.softweare.repositery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinit.billing.softweare.entity.User;

@Repository
public interface UserRepositery extends JpaRepository<User, Long>{

	
	Optional<User> findByUsername(String username);
}
