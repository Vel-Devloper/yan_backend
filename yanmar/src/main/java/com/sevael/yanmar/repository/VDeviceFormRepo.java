package com.sevael.yanmar.repository;

import com.sevael.yanmar.entity.VisitorDeviceDetailsForm;
import com.sevael.yanmar.entity.VisitorUserDetailsForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VDeviceFormRepo extends JpaRepository<VisitorDeviceDetailsForm, Long>{
	VisitorDeviceDetailsForm findByVisitoruserdetailsform(VisitorUserDetailsForm userForm);
}
