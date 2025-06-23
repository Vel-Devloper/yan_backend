package com.sevael.yanmar.serviceImpl;


//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevael.yanmar.dto.VVehicleDetailsDTO;
import com.sevael.yanmar.dto.VisitorSubmissionDTO;
import com.sevael.yanmar.dto.WrapperVisitorFormDTO;
import com.sevael.yanmar.entity.VisitorUserDetailsForm;
import com.sevael.yanmar.entity.VisitorDeviceDetailsForm;
import com.sevael.yanmar.entity.VisitorVehicleDetailsForm;
import com.sevael.yanmar.repository.VUserFormRepo;
import com.sevael.yanmar.repository.VDeviceFormRepo;
import com.sevael.yanmar.repository.VVehicleFormRepo;
import com.sevael.yanmar.service.VisitorFormService;

@Service
public class VisitorFormServiceImpl implements VisitorFormService{
	
	@Autowired 
	VUserFormRepo vuserformRepo;
  
	@Autowired 
    VDeviceFormRepo vdeviceformRepo;
  
	@Autowired 
	VVehicleFormRepo vvehicleformrepo;
	
	@Override
	public void saveEntry(VisitorSubmissionDTO submissionDTO){
		
		int count=0;
		int vehicleIndex=0; //for tracking vehicles
		
//		HANDLE VISITOR LIST(visitor + device)
		for (WrapperVisitorFormDTO entry : submissionDTO.getVisitorList()) {
			VisitorUserDetailsForm userForm = new VisitorUserDetailsForm();
			userForm.setFirstname(entry.getUser().getFirstname());
            userForm.setLastname(entry.getUser().getLastname());
            userForm.setPhone_no(entry.getUser().getPhone_no());
            userForm.setEmail(entry.getUser().getEmail());
            userForm.setOrg_name(entry.getUser().getOrg_name());
            userForm.setOrg_address(entry.getUser().getOrg_address());
            userForm.setProof_type(entry.getUser().getProof_type());
            userForm.setProof_id(entry.getUser().getProof_id());
//            userForm.setAppointment_id(entry.getAppointment_id());
            
            // Set visitor row (M, M1, M2, etc.)
            userForm.setVisitor_row(count == 0 ? "M" : "M" + count);

            // Save user
            VisitorUserDetailsForm savedUser = vuserformRepo.save(userForm);
            
            // Save device if available
            if (entry.getDevice() != null) {
                VisitorDeviceDetailsForm deviceForm = new VisitorDeviceDetailsForm();
                deviceForm.setDevice_name(entry.getDevice().getDevice_name());
                deviceForm.setDevice_model(entry.getDevice().getDevice_model());
                deviceForm.setDevice_type(entry.getDevice().getDevice_type());
                deviceForm.setVisitoruserdetailsform(savedUser); // Set relation
                vdeviceformRepo.save(deviceForm);
            }
            count++;
        // ✅ 2. Handle vehicleList (if present)
        if (submissionDTO.getVehicleList() != null && vehicleIndex < submissionDTO.getVehicleList().size()) {
            	VVehicleDetailsDTO vehicleDTO = submissionDTO.getVehicleList().get(vehicleIndex);

                VisitorVehicleDetailsForm vehicleForm = new VisitorVehicleDetailsForm();
                vehicleForm.setVehicle_no(vehicleDTO.getVehicle_no());
                vehicleForm.setModel(vehicleDTO.getModel());
                vehicleForm.setType(vehicleDTO.getType());

                VisitorVehicleDetailsForm savedVehicle = vvehicleformrepo.save(vehicleForm);

                // Now update savedUser with vehicleid
                savedUser.setVehicle_id(savedVehicle.getId());
                
                vuserformRepo.save(savedUser);

                // Move to next vehicle
                vehicleIndex++;
            }
        count++;
        }
	}
}






//if (entry.getVehicle() != null) {
//// Try to find an existing vehicle by vehicle number
//VisitorVehicleDetailsForm vehicleForm = vvehicleformrepo.findByVehicleNo(entry.getVehicle().getVehicle_no());
//
//// If not found, create and save a new one
//if (vehicleForm == null) {
//  vehicleForm = new VisitorVehicleDetailsForm();
//  vehicleForm.setVehicle_no(entry.getVehicle().getVehicle_no());
//  vehicleForm.setModel(entry.getVehicle().getModel());
//  vehicleForm.setType(entry.getVehicle().getType());
//  vehicleForm = vvehicleformrepo.save(vehicleForm); // Save and get managed instance
//}
//
//// Associate vehicle with user
//userForm.setVehicle(vehicleForm);  // Assuming userForm is created before this block
//}
