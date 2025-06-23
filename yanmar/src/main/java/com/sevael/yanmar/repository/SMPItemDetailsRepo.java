package com.sevael.yanmar.repository;

import com.sevael.yanmar.entity.SMP_ItemDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMPItemDetailsRepo extends JpaRepository<SMP_ItemDetails,Long>{

}
