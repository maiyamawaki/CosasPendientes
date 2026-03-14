package com.joy.cosaspendientes.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.joy.cosaspendientes.repository.UserInfoRepository;
import com.joy.cosaspendientes.entity.UserInfo;
import com.joy.cosaspendientes.dto.request.UserCreateRequest;
import com.joy.cosaspendientes.dto.request.UserUpdateRequest;
import com.joy.cosaspendientes.dto.response.UserResponse;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class UserInfoService {

	private UserInfoRepository userRepo;
	private PasswordEncoder passwordEncoder;

	public UserInfoService (UserInfoRepository userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	private UserResponse toDto(UserInfo user) {
		UserResponse userRes = new UserResponse();
		userRes.setUserId(user.getUserId());
		userRes.setUserName(user.getUserName());
		userRes.setUserImg(user.getUserImg());
		return userRes;
	}

	public List<UserResponse> getAllUser() {
		List<UserResponse> userList = userRepo.findAll()
																		.stream()
																		.map(this::toDto)
																		.collect(Collectors.toList());
		return userList;
	}

	public UserResponse getUserById(String userId) {
		return toDto(findUser(userId));
	}

	public UserResponse createUser(UserCreateRequest user) {
		UserInfo newUser = new UserInfo();
		newUser.setUserName(user.getUserName());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setUserImg(user.getUserImg());
		userRepo.save(newUser);
		return toDto(newUser);
	}

	public UserResponse updateUser(UserUpdateRequest user) {
		UserInfo existUser = findUser("");
		existUser.setUserName(user.getUserName());
		existUser.setPassword(user.getPassword());
		existUser.setUserImg(user.getUserImg());
		userRepo.save(existUser);
		return toDto(existUser);
	}
	
	private UserInfo findUser(String userId){
		UserInfo userInfo = userRepo.findById(userId).orElseThrow(()->new RuntimeException(""));
		return userInfo;
	}

}
