package com.sevael.yanmar.repository;

import com.sevael.yanmar.entity.VisitorUserDetailsForm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VUserFormRepo extends JpaRepository<VisitorUserDetailsForm,Long>{
	List<VisitorUserDetailsForm> findByAppointmentId(Long appointmentId);
}
