package com.sevael.yanmar.serviceImpl;

import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sevael.yanmar.dto.IntLoginRequest;
import com.sevael.yanmar.dto.IntLoginResponse;
import com.sevael.yanmar.entity.IntUserLogin;
import com.sevael.yanmar.repository.IntLoginRepo;
import com.sevael.yanmar.service.IntLoginService;
import com.sevael.yanmar.util.AppConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class IntLoginServiceImpl implements IntLoginService {
	
	@Autowired
	private IntLoginRepo userloginrepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	SecretKey key = Keys.hmacShaKeyFor("mySecretKey12345mySecretKey12345".getBytes());
    
	@Override
	public IntLoginResponse login(IntLoginRequest loginRequest) {
		Optional<IntUserLogin> userOpt = userloginrepo.findByUniqueid(loginRequest.getUniqueid());	
		
		if(userOpt.isPresent()) {
			IntUserLogin intuser = userOpt.get();
			
			//Check Password
			if(!passwordEncoder.matches(loginRequest.getPassword(),intuser.getPassword())){
			    throw new RuntimeException("Invalid credentials");
			}
			
			//Check active status
			if(intuser.getIsactive() != AppConstants.STATUS_ACTIVE) {
				throw new RuntimeException("Account Not Found or Inactive");
			}
			
//	        Generate JWT token
	        String token = Jwts.builder()
	        		.setSubject(intuser.getUniqueid())
	        		.claim("userId",intuser.getId())
	        		.claim("userType",intuser.getUsertype())
	        		.setIssuedAt(new Date())
	        		.setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000))
	        		.signWith(key, SignatureAlgorithm.HS256) // <== FIX: use Key here
	                .compact();
	        
			return new IntLoginResponse("Login Successful", token);
		}
		else {
			throw new RuntimeException("User not found");
		}	
	}

}
