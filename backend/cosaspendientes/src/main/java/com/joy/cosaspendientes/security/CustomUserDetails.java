package com.joy.cosaspendientes.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.joy.cosaspendientes.entity.UserInfo;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails{
	private Long userId;
	private String userName;
	private String password;

	public CustomUserDetails(UserInfo user) {
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			return Collections.emptyList();
	}

	public Long getUserId() {
		return userId;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	
}
