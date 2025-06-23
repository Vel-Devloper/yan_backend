package com.sevael.yanmar.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sevael.yanmar.dto.ExtRegisterRequest;
import com.sevael.yanmar.entity.ExtUserLogin;
import com.sevael.yanmar.repository.ExtRegisRepo;
import com.sevael.yanmar.service.ExtRegisService;

@Service
public class ExtRegisServiceImpl implements ExtRegisService{
	
	@Autowired
	private ExtRegisRepo extregisrepo;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String register(ExtRegisterRequest request) {
        if (extregisrepo.findByVendorid(request.getVendorid()).isPresent()) {
            return "User already exists";
        }

        ExtUserLogin extuser = new ExtUserLogin();
        extuser.setUsername(request.getUsername());
        extuser.setVendor_name(request.getVendor_name());
        extuser.setVendorid(request.getVendorid());
        extuser.setPassword(passwordEncoder.encode(request.getPassword())); // encrypted
        extuser.setIsactive(request.getIsactive());

        extregisrepo.save(extuser);
        return "User registered successfully";
    }
}
