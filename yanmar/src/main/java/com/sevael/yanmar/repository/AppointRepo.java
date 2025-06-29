package com.sevael.yanmar.repository;

import com.sevael.yanmar.dto.AppointmentDisplayDTO;
import com.sevael.yanmar.entity.VisitorAppoint;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointRepo extends JpaRepository<VisitorAppoint, Long>{

	Optional<VisitorAppoint> findBytoken(String token);	

	@Query("SELECT new com.sevael.yanmar.dto.AppointmentDisplayDTO(" +
		       "v.firstname, " +
		       "a.appointment_date, a.appointment_type, v.checkin, v.checkout, a.approval_status) " +
		       "FROM VisitorAppoint a JOIN a.visitorDetails v " +
		       "WHERE v.visitor_row = 'M'")
		List<AppointmentDisplayDTO> fetchAppointmentsWithMainVisitors();
	
//	@Query("SELECT new com.sevael.yanmar.dto.AppointmentDisplayDTO(" +
//		       "v.firstname, " +
//		       "a.appointment_date, a.appointment_type, v.checkin, v.checkout, a.approval_status) " +
//		       "FROM VisitorAppoint a JOIN a.visitorDetails v " +
//		       "WHERE v.visitor_row = 'M'")
//		List<AppointmentDisplayDTO> fetchAppointmentsWithMainVisitors();
}

//List<VisitorAppoint> findAllByStatus(String status); 

//@Query("SELECT new com.sevael.yanmar.dto.AppointmentDisplayDTO(v.firstname, a.appointment_date, a.appointment_type, a.checkin, a.checkout, a.approval_status) " +
//	       "FROM AppointmentEntity a JOIN VisitorEntity v ON a.id = v.")
//	List<AppointmentTableDTO> fetchAllAppointmentsForDisplay();
