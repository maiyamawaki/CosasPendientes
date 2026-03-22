package com.joy.cosaspendientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joy.cosaspendientes.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{
	UserInfo findByUserName(String username);
}
