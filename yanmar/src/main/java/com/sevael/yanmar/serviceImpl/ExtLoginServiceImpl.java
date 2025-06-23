package com.sevael.yanmar.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sevael.yanmar.dto.ExtLoginRequest;
import com.sevael.yanmar.dto.ExtLoginResponse;
import com.sevael.yanmar.entity.ExtUserLogin;
import com.sevael.yanmar.repository.ExtLoginRepo;
import com.sevael.yanmar.service.ExtLoginService;

@Service
public class ExtLoginServiceImpl implements ExtLoginService{
	
	@Autowired
	private ExtLoginRepo extloginrepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	@Override
	public ExtLoginResponse login(ExtLoginRequest extloginrequest) {
		Optional<ExtUserLogin> userOpt = extloginrepo.findByVendoridAndUsername(
				extloginrequest.getVendorid(),
				extloginrequest.getUsername());
		
		if(userOpt.isPresent()) {
			ExtUserLogin extuser = userOpt.get();
			
			//Check Password
			if(!passwordEncoder.matches(extloginrequest.getPassword(),extuser.getPassword())){
			    throw new RuntimeException("Invalid credentials");
			}
			
			//Check active status
			if(extuser.getIsactive()==0) {
				throw new RuntimeException("Account Not Found or Inactive");
			}
			return new ExtLoginResponse("Login Successful, Logged in as external user");
			
		}
		else {
			throw new RuntimeException("User Not Found");
		}
	}
}

//if(!extuser.getPassword().equals(extloginrequest.getPassword())) {
//throw new RuntimeException("Invalid Credentials");
//}