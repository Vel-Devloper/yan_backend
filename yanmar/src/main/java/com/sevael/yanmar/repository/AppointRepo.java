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
//	List<VisitorAppoint> findAllByStatus(String status); 
	
//	@Query("SELECT new com.sevael.yanmar.dto.AppointmentDisplayDTO(v.firstname, a.appointment_date, a.appointment_type, a.checkin, a.checkout, a.approval_status) " +
//		       "FROM AppointmentEntity a JOIN VisitorEntity v ON a.id = v.")
//		List<AppointmentTableDTO> fetchAllAppointmentsForDisplay();
	
//	@Query("SELECT new com.sevael.yanmar.dto.AppointmentDisplayDTO(" +
//		       "a.id, CONCAT(v.firstname, ' ', v.lastname), " +
//		       "CAST(a.appointment_date AS string), a.hostname, " +
//		       "CAST(a.appointment_type AS string), " +
//		       "CAST(v.checkin AS string), CAST(v.checkout AS string)) " +
//		       "FROM VisitorAppoint a JOIN a.visitorDetails v " +
//		       "WHERE v.visitor_row = 'M'")
//	List<AppointmentDisplayDTO> fetchAppointmentsWithMainVisitors();
}
