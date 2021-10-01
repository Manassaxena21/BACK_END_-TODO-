package com.niit.authentication.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.niit.authentication.model.User;

@Service
public class JWTSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

	// generate token for a user
	@Override
	public Map<String, String> generateToken(User user) {
		String jwtToken = Jwts.builder().setIssuer("ShopZone")
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256,"mysecret")
                .compact();
		Map<String,String> map = new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","Authentication Successful");
		return map;
	}

}
