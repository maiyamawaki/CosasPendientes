package com.joy.cosaspendientes.security;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

@Service
public class JwtService {
	private final String SECRET = "my-secret-key";

	public String generateToken(Long userId) {
		return Jwts.builder()
						.setSubject(userId.toString())
						.setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis()+86400000))
						.signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
						.compact();
	}

	public Long extractUserId(String token) {
		Claims claims = Jwts.parserBuilder()
											.setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
											.build()
											.parseClaimsJws(token)
											.getBody();
		return Long.parseLong(claims.getSubject());
	}
}
