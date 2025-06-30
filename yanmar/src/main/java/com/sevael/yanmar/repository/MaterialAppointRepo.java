package com.sevael.yanmar.repository;

import com.sevael.yanmar.dto.MatAppointDisplayDTO;
import com.sevael.yanmar.entity.MaterialAppoint;
import com.sevael.yanmar.projection.MatAppointProjection;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialAppointRepo extends JpaRepository<MaterialAppoint,Long>{
	
	Optional<MaterialAppoint> findByUuidtoken(String token);	
	
//	@Query(value = """
//		    SELECT 
//		        A.id AS id,
//		        S.supplier_name AS supplier_name,
//		        A.purpose AS purpose,
//		        A.expec_delivery_date AS entrydate,
//		        D.driver_name AS driver_name,
//		        I.item_name AS item_name,
//		        A.approval_status AS approval_status
//		    FROM smp_supplier_details S
//		    INNER JOIN material_request A ON S.mat_requestid = A.id
//		    INNER JOIN smp_item_details I ON I.supplier_id = S.id
//		    INNER JOIN smp_driver_details D ON D.supplier_id = S.id
//		    """, nativeQuery = true)
//	    List<MatAppointDisplayDTO> fetchAllMaterialAppointments();

	@Query(value = """
		    SELECT 
		        A.id AS request_id,
		        S.supplier_name AS supplier_name,
		        A.purpose AS purpose,
		        A.expec_delivery_date AS expec_delivery_date,
		        D.driver_name AS driver_name,
		        I.item_name AS item_name,
		        A.approval_status AS approval_status
		    FROM smp_supplier_details S
		    INNER JOIN material_request A ON S.mat_requestid = A.id
		    INNER JOIN smp_item_details I ON I.supplier_id = S.id
		    INNER JOIN smp_driver_details D ON D.supplier_id = S.id
		    """, nativeQuery = true)
		List<MatAppointProjection> fetchAllMaterialAppointments();
}
