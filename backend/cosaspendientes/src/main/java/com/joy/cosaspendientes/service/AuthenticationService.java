package com.joy.cosaspendientes.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.joy.cosaspendientes.repository.UserInfoRepository;
import com.joy.cosaspendientes.security.JwtService;
import com.joy.cosaspendientes.entity.UserInfo;
import com.joy.cosaspendientes.dto.request.LoginRequest;
import com.joy.cosaspendientes.dto.request.UserCreateRequest;
import com.joy.cosaspendientes.dto.response.LoginResponse;

@Service
public class AuthenticationService {
	
	private UserInfoRepository userRepo;
	private PasswordEncoder passwordEncoder;
	private JwtService jwtService;

	public AuthenticationService(UserInfoRepository userRepo, PasswordEncoder passwordEncoder, JwtService jwtService) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}

	public LoginResponse login(LoginRequest loginUser) {
		UserInfo user = userRepo.findById(loginUser.getUserId()).orElseThrow(()->new RuntimeException());
		// if(!passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
		// 	throw new RuntimeException("invalid password");
		// }
		if(!loginUser.getPassword().equals(user.getPassword())) {
			throw new RuntimeException("invalid password");
		}

		String token = jwtService.generateToken(user.getUserId());

		return new LoginResponse(token);
	} 	

	@Transactional
	public LoginResponse register(UserCreateRequest req) {
		UserInfo user = userRepo.findByUserName(req.getUserName());
		System.out.println("test : " + req.getUserName());
		if(user==null) {
			UserInfo newUser = new UserInfo();
			newUser.setUserName(req.getUserName());
			String hashedPassword = passwordEncoder.encode(req.getPassword());
			newUser.setPassword(hashedPassword);
			newUser.setUserImg(req.getUserImg());
			userRepo.save(newUser);
			String token = jwtService.generateToken(newUser.getUserId());
			return new LoginResponse(token);
		} else {
			return new LoginResponse(null);
		}
	}
}
