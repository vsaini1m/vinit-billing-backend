package com.vinit.billing.softweare.service;

import java.util.List;

import com.vinit.billing.softweare.dto.ResultUserDto;
import com.vinit.billing.softweare.entity.User;

public interface UserService {

	
	public ResultUserDto saveUser(User user);
	
	public ResultUserDto getUserById(User user);
	
	public ResultUserDto updateUser(User user);
	
	
	public ResultUserDto deleteUser(User user);
	
	public List<User> gelAllUsers();
	
	
}
