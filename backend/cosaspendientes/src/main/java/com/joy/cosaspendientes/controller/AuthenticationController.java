package com.joy.cosaspendientes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joy.cosaspendientes.dto.request.LoginRequest;
import com.joy.cosaspendientes.dto.request.UserCreateRequest;
import com.joy.cosaspendientes.dto.response.LoginResponse;
import com.joy.cosaspendientes.service.AuthenticationService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	private AuthenticationService authService;

	public AuthenticationController(AuthenticationService authService) {
		this.authService = authService;
	}
	
	@GetMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginUser) {
		return authService.login(loginUser);
	}

	@PostMapping("/register")
	public LoginResponse register(@RequestBody UserCreateRequest req) {
		System.out.println(req);
		return authService.register(req);
	}
	
}
