package com.sevael.yanmar.repository;

import com.sevael.yanmar.entity.ExtUserLogin;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ExtRegisRepo extends JpaRepository<ExtUserLogin, Long>{
	Optional<ExtUserLogin> findByVendorid(String vendorid);
}
