package com.vinit.billing.softweare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinit.billing.softweare.dto.ResultUserDto;
import com.vinit.billing.softweare.entity.User;
import com.vinit.billing.softweare.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/vinit/billing/soft/api/user")
@CrossOrigin("*")
public class UserController {
	
	private final UserService userService;

	@PostMapping("/")
	public ResponseEntity<?> createUser(@RequestBody User user) throws Exception {
		
		
		
		ResultUserDto createUser = this.userService.saveUser(user);
		
		
		
		
		return createUser.isSuccess()?
				 ResponseEntity.ok(createUser.getUser()):
					 ResponseEntity.badRequest().body(createUser.getErrors());
		
		
		
		
	}
	
	
	@GetMapping("/{username}")
	public ResponseEntity<?> getUser(@PathVariable("username") String username) {
		
		User user=new User();
		user.setUsername(username);
		
		ResultUserDto userByUserName = this.userService.getUserById(user);
		
		return userByUserName.isSuccess()?
				ResponseEntity.ok(userByUserName.getUser()):
					ResponseEntity.badRequest().body(userByUserName.getErrors());
		
		
		
	}

	@DeleteMapping("/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable("username") String username) {
		
		User user=new User();
		user.setUsername(username);
		
		ResultUserDto deleteUserByUserName = this.userService.deleteUser(user);
		
		return deleteUserByUserName.isSuccess()?
				ResponseEntity.ok().build():
					ResponseEntity.badRequest().body(deleteUserByUserName.getErrors());
		
		
		
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateUser(@RequestBody User user) throws Exception {
		
		
		
		ResultUserDto updateUser = this.userService.updateUser(user);
		
		
		
		
		return updateUser.isSuccess()?
				 ResponseEntity.ok(updateUser.getUser()):
					 ResponseEntity.badRequest().body(updateUser.getErrors());
		
		
		
		
	}
	
	@GetMapping("/all/")
	public ResponseEntity<?> getUserAll() {
		
		
		
		
		return ResponseEntity.ok(this.userService.gelAllUsers());
		
		
		
	}
	
	
	
}
