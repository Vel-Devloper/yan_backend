package com.sevael.yanmar.repository;

import com.sevael.yanmar.entity.IntUserLogin;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface IntLoginRepo extends JpaRepository<IntUserLogin, Long> {
	Optional<IntUserLogin> findByUniqueid(String uniqueid);
}
