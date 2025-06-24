package com.sevael.yanmar.serviceImpl;

import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sevael.yanmar.dto.ExtLoginRequest;
import com.sevael.yanmar.dto.ExtLoginResponse;
import com.sevael.yanmar.entity.ExtUserLogin;
import com.sevael.yanmar.repository.ExtLoginRepo;
import com.sevael.yanmar.service.ExtLoginService;
import com.sevael.yanmar.util.AppConstants;
import com.sevael.yanmar.exception.CustomException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class ExtLoginServiceImpl implements ExtLoginService{
	
	@Autowired
	private ExtLoginRepo extloginrepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	SecretKey key = Keys.hmacShaKeyFor("mySecretKey12345mySecretKey12345".getBytes());
	
	@Override
	public ExtLoginResponse login(ExtLoginRequest extloginrequest) {
		Optional<ExtUserLogin> userOpt = extloginrepo.findByVendoridAndUsername(
				extloginrequest.getVendorid(),
				extloginrequest.getUsername());
		
		if(userOpt.isPresent()) {
			ExtUserLogin extuser = userOpt.get();
			
			//Check Password
			if(!passwordEncoder.matches(extloginrequest.getPassword(),extuser.getPassword())){
			    throw new CustomException("Invalid credentials");
			}
			
			//Check active status
			if(extuser.getIsactive() != AppConstants.STATUS_ACTIVE) {
				throw new CustomException("Account Not Found or Inactive");
			}
			
//			Generate JWT token
			String token = Jwts.builder()
					.setSubject(extuser.getVendorid())
					.claim("username", extuser.getUsername())
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000))
					.signWith(key,SignatureAlgorithm.HS256)
					.compact();
			
			return new ExtLoginResponse(token, true);
			
		}
		else {
			throw new CustomException("User Not Found");
		}
	}
}

//if(!extuser.getPassword().equals(extloginrequest.getPassword())) {
//throw new RuntimeException("Invalid Credentials");
//}