package com.joy.cosaspendientes.security;

import java.util.ArrayList;
import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	private JwtService jwtService;

	public JwtFilter(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
																	HttpServletResponse response,
																	FilterChain filterChain)
																	throws ServletException, IOException {
		String header = request.getHeader("Authorization");
		if(header != null && header.startsWith("Bearer")) {
			String token = header.substring(7);
			Long userid = jwtService.extractUserId(token);
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userid, null, new ArrayList<>());
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		filterChain.doFilter(request, response);
	}
	
}
