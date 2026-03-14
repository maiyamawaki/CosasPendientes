package com.joy.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import com.joy.cosaspendientes.dto.request.UserCreateRequest;
import com.joy.cosaspendientes.dto.request.UserUpdateRequest;
import com.joy.cosaspendientes.dto.request.UserCreateRequest;
import com.joy.cosaspendientes.dto.response.UserResponse;
import com.joy.cosaspendientes.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping()
	public List<UserResponse> getAllUser() {
		return userService.getAllUser();
	}
	
	@GetMapping("/{id}")
	public UserResponse getUserById() {
		return userService.getUserById();
	}

	@PostMapping("")
	public UserResponse createUser(@RequestBody UserCreateRequest user) {
		return userService.createUser(user);
	}

	@PutMapping("/{id}")
	public UserResponse updateUser(@RequestBody UserUpdateRequest user) {
		return userService.updateUser(user);
	}
	
}
