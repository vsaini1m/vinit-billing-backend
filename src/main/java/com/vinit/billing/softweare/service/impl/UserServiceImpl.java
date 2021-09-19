package com.vinit.billing.softweare.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.vinit.billing.softweare.dto.ResultUserDto;
import com.vinit.billing.softweare.entity.User;
import com.vinit.billing.softweare.repositery.UserRepositery;
import com.vinit.billing.softweare.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepositery userRepositery;

	@Override
	public ResultUserDto saveUser(User user) {

		ResultUserDto resultUserDto = null;

		User savedUser = userRepositery.save(user);

		if (savedUser == null) {

			List<String> errors = new ArrayList<>();

			errors.add("User not saved.");

			resultUserDto = ResultUserDto.builder().success(false).errors(errors).build();

		} else {
			resultUserDto = ResultUserDto.builder().success(true).user(new ModelMapper().map(savedUser, User.class))
					.build();
		}

		return resultUserDto;

	}

	@Override
	public ResultUserDto getUserById(User user) {

		ResultUserDto resultUserDto = null;

		Optional<User> savedUser = userRepositery.findByUsername(user.getUsername());

		if (!savedUser.isPresent()) {

			List<String> errors = new ArrayList<>();

			errors.add("User Not found");

			resultUserDto = ResultUserDto.builder().success(false).errors(errors).build();

		} else {
			resultUserDto = ResultUserDto.builder().success(true).user(new ModelMapper().map(savedUser, User.class))
					.build();
		}

		return resultUserDto;

	}

	@Override
	public ResultUserDto updateUser(User user) {

		ResultUserDto resultUserDto = null;

		User savedUser = userRepositery.save(user);

		if (savedUser == null) {

			List<String> errors = new ArrayList<>();

			errors.add("Unable to update. try again");

			resultUserDto = ResultUserDto.builder().success(false).errors(errors).build();

		} else {
			resultUserDto = ResultUserDto.builder().success(true).user(new ModelMapper().map(savedUser, User.class))
					.build();
		}

		return resultUserDto;
	}

	@Override
	public ResultUserDto deleteUser(User user) {

		ResultUserDto resultUserDto = null;

		Optional<User> savedUser = userRepositery.findByUsername(user.getUsername());

		if (!savedUser.isPresent()) {

			List<String> errors = new ArrayList<>();

			errors.add("User Not found");

			resultUserDto = ResultUserDto.builder().success(false).errors(errors).build();

		} else {

			try {

				this.userRepositery.delete(savedUser.get());

			} catch (Exception e) {

				List<String> errors = new ArrayList<>();

				errors.add("Unable to delete User");

				resultUserDto = ResultUserDto.builder().success(false).errors(errors).build();

			}

			resultUserDto = ResultUserDto.builder().success(true).build();

		}

		return resultUserDto;
	}

	@Override
	public List<User> gelAllUsers() {
		
			
		
		return userRepositery.findAll();
	}

}
