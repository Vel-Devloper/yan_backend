package com.sevael.yanmar.repository;

import com.sevael.yanmar.entity.VisitorVehicleDetailsForm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VVehicleFormRepo extends JpaRepository<VisitorVehicleDetailsForm,Long>{
//	VisitorVehicleDetailsForm findByVehicleNo(String vehicleNo);
}
