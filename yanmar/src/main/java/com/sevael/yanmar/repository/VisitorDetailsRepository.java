package com.sevael.yanmar.repository;

import com.sevael.yanmar.dto.VisitorFullDetailsDTO;
import com.sevael.yanmar.entity.VisitorUserDetailsForm;
import com.sevael.yanmar.dto.VCheckInOutUpdateDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Component;


import java.util.List;

//@Component
//public interface VisitorDetailsRepository extends Repository<VisitorUserDetailsForm, Long> 
@Repository
public interface VisitorDetailsRepository extends JpaRepository<VisitorUserDetailsForm, Long>{

    
	
//	@Query("SELECT new com.sevael.yanmar.dto.VisitorFullDetailsDTO(" +
//		       "v.firstname, a.appointment_type, v.org_name, v.email, a.appointment_date, " +
//		       "v.checkin, v.checkout, v.photoPath, d.device_name, d.device_model, d.device_type) " +
//		       "FROM VisitorUserDetailsForm v " +
//		       "JOIN v.visitorAppoint a " +
//		       "JOIN VisitorDeviceDetailsForm d ON d.visitoruserdetailsform = v " +
//		       "WHERE v.visitor_row = 'M'")
	
//	@Query("SELECT new com.sevael.yanmar.dto.VisitorFullDetailsDTO(" +
//		       "v.firstname, a.appointment_type, v.org_name, v.email, a.appointment_date, " +
//		       "v.checkin, v.checkout, v.photoPath, d.device_name, d.device_model, d.device_type) " +
//		       "FROM VisitorUserDetailsForm v " +
//		       "JOIN v.visitorAppoint a " +
//		       "JOIN VisitorDeviceDetailsForm d ON d.visitoruserdetailsform = v " +
//		       "WHERE v.visitor_row LIKE 'M%'")

//	@Query("SELECT new com.sevael.yanmar.dto.VisitorFullDetailsDTO(" +
//		       "v.firstname, a.appointment_type, v.org_name, v.email, a.appointment_date, " +
//		       "v.checkin, v.checkout, v.photoPath, d.device_name, d.device_model, d.device_type, a.id) " +
//		       "FROM VisitorUserDetailsForm v " +
//		       "JOIN v.visitorAppoint a " +
//		       "LEFT JOIN v.visitordevicedetails d " +
//		       "JOIN a.appointment_type t"+
//		       "WHERE v.visitor_row LIKE 'M%'")
	
	@Query("SELECT new com.sevael.yanmar.dto.VisitorFullDetailsDTO(" +
		       "v.firstname, t.appointment_type, v.org_name, v.email, a.appointment_date, " +
		       "v.checkin, v.checkout, v.photoPath, d.device_name, d.device_model, d.device_type, a.id) " +
		       "FROM VisitorUserDetailsForm v " +
		       "JOIN v.visitorAppoint a " +
		       "JOIN a.appointmentType t " +
		       "LEFT JOIN v.visitordevicedetails d " +
		       "WHERE v.visitor_row LIKE 'M%'")
	
//	String nativeQuery = """
//		    SELECT 
//		        v.firstname,
//		        a.appointment_type,
//		        v.org_name,
//		        v.email,
//		        a.appointment_date,
//		        v.checkin,
//		        v.checkout,
//		        v.photo_path,
//		        d.device_name,
//		        d.device_model,
//		        d.device_type,
//		        a.id,
//		        T.appointment_type
//		    FROM visitor_details v
//		    INNER JOIN core_appointment_request a ON v.appointment_id = a.id
//		    LEFT JOIN device_details d ON v.id = d.visitor_id
//		    INNER JOIN appointment_type T ON a.appointment_type = T.id
//		    WHERE v.visitor_row LIKE 'M%'
//		    """;

    List<VisitorFullDetailsDTO> getAllVisitorFullDetails();
	
//	List<CheckInUpdateDTO> findByAppointmentId(Long appointmentId);
    
   
    List<VisitorUserDetailsForm> findByVisitorAppoint_Id(Long appointmentId);
}