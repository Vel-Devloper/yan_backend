package com.sevael.yanmar.repository;

import com.sevael.yanmar.entity.VisitorAppoint;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointRepo extends JpaRepository<VisitorAppoint, Long>{

	Optional<VisitorAppoint> findByUuidtoken(String token);	
}
