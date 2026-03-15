package com.joy.cosaspendientes.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

public class AuthUtil {
		public Long getLoginUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return (Long)auth.getPrincipal();
	}
}
