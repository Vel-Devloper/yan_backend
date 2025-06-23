package com.sevael.yanmar.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sevael.yanmar.dto.IntRegisterRequest;
import com.sevael.yanmar.entity.IntUserLogin;
import com.sevael.yanmar.repository.IntRegisRepo;
import com.sevael.yanmar.service.IntRegisService;

@Service
public class IntRegisServiceImpl implements IntRegisService{
	
	@Autowired
	private IntRegisRepo intregisrepo;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String register(IntRegisterRequest request) {
        if (intregisrepo.findByUniqueid(request.getUniqueid()).isPresent()) {
            return "User already exists";
        }

        IntUserLogin intuser = new IntUserLogin();
        intuser.setUsername(request.getUsername());
        intuser.setUniqueid(request.getUniqueid());
        intuser.setPassword(passwordEncoder.encode(request.getPassword())); // encrypted
        intuser.setIsactive(request.getIsactive());
        intuser.setUsertype(request.getUsertype());

        intregisrepo.save(intuser);
        return "User registered successfully";
    }
}
