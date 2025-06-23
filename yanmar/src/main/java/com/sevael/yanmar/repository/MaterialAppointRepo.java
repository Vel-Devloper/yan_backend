package com.sevael.yanmar.repository;

import com.sevael.yanmar.entity.MaterialAppoint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialAppointRepo extends JpaRepository<MaterialAppoint,Long>{

}
