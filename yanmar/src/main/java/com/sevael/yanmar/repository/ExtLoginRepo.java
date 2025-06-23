package com.sevael.yanmar.repository;

import com.sevael.yanmar.entity.ExtUserLogin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExtLoginRepo extends JpaRepository<ExtUserLogin, Long>{
	Optional<ExtUserLogin> findByVendoridAndUsername(String vendorid,String username);
}
