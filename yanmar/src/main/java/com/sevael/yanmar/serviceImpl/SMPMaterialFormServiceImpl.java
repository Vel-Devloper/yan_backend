package com.sevael.yanmar.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevael.yanmar.dto.SMPItemDetailsDTO;
import com.sevael.yanmar.dto.SMPWrapperDTO;
import com.sevael.yanmar.entity.SMP_SupplierDetails;
import com.sevael.yanmar.entity.SMP_OtherDetails;
import com.sevael.yanmar.entity.SMP_RequestorDetails;
import com.sevael.yanmar.entity.SMP_ItemDetails;
import com.sevael.yanmar.entity.SMP_DriverDetails;
import com.sevael.yanmar.entity.SMP_VehicleDetails;

import com.sevael.yanmar.repository.SMPSupplierDetailsRepo;
import com.sevael.yanmar.repository.SMPOtherDetailsRepo;
import com.sevael.yanmar.repository.SMPRequestorDetailsRepo;
import com.sevael.yanmar.repository.SMPItemDetailsRepo;
import com.sevael.yanmar.repository.SMPDriverDetailsRepo;
import com.sevael.yanmar.repository.SMPVehicleDetailsRepo;

import com.sevael.yanmar.service.SMPMaterialFormService;

@Service
public class SMPMaterialFormServiceImpl implements SMPMaterialFormService{
	
	@Autowired
	SMPSupplierDetailsRepo supplierdetailsrepo;
	@Autowired
	SMPOtherDetailsRepo otherdetailsrepo;
	@Autowired
	SMPRequestorDetailsRepo requestordetailsrepo;
	@Autowired
	SMPItemDetailsRepo itemdetailsrepo;
	@Autowired
	SMPDriverDetailsRepo driverdetailsrepo;
	@Autowired
	SMPVehicleDetailsRepo vehicledetailsrepo;
	
	@Override
	public void saveEntry(SMPWrapperDTO entry) {
			
			if (entry.getSupplierdetails() !=null ) {
			SMP_SupplierDetails supplierdetails = new SMP_SupplierDetails();
			supplierdetails.setSupplier_name(entry.getSupplierdetails().getSupplier_name());
			supplierdetails.setSupplier_address(entry.getSupplierdetails().getSupplier_address());
		  	supplierdetails.setPhone_no(entry.getSupplierdetails().getPhone_no());
		  	supplierdetails.setEmail(entry.getSupplierdetails().getEmail());
		  	supplierdetails.setEntry_date(entry.getSupplierdetails().getEntry_date());
		  	supplierdetails.setGstnumber(entry.getSupplierdetails().getGstnumber());
		  	supplierdetails.setState(entry.getSupplierdetails().getState());
		  	supplierdetails.setLocation(entry.getSupplierdetails().getLocation());
		  	
		  	supplierdetailsrepo.save(supplierdetails);
			}
		  	if (entry.getOtherdetails() !=null ) {
		  	SMP_OtherDetails otherdetails = new SMP_OtherDetails();
		  	otherdetails.setInvoice_number(entry.getOtherdetails().getInvoice_number());
		  	otherdetails.setInvoice_date(entry.getOtherdetails().getInvoice_date());
		  	otherdetails.setOverall_value(entry.getOtherdetails().getOverall_value());
		  	otherdetails.setMat_due_date(entry.getOtherdetails().getMat_due_date());
		  	otherdetails.setGate_no(entry.getOtherdetails().getGate_no());
		  	
		  	otherdetailsrepo.save(otherdetails);
			}
		  	
			if (entry.getRequestordetails() !=null ) {
			SMP_RequestorDetails requestordetails = new SMP_RequestorDetails();
			requestordetails.setRequestor_name(entry.getRequestordetails().getRequestor_name());
			requestordetails.setDepartment(entry.getRequestordetails().getDepartment());
			
			requestordetailsrepo.save(requestordetails);
			}
			
			if (entry.getItems() != null) {
				for (SMPItemDetailsDTO itemEntry : entry.getItems()) {
			SMP_ItemDetails itemdetails = new SMP_ItemDetails();
			itemdetails.setItem_name(itemEntry.getItem_name());
			itemdetails.setQuantity(itemEntry.getQuantity());
			itemdetails.setUnit(itemEntry.getUnit());
			itemdetails.setValue(itemEntry.getValue());
			
			itemdetailsrepo.save(itemdetails);
			}
			}
			if (entry.getDriver() != null) {
			SMP_DriverDetails driverdetails = new SMP_DriverDetails();
			driverdetails.setDriver_name(entry.getDriver().getDriver_name());
			driverdetails.setPhone_no(entry.getDriver().getPhone_no());
			driverdetails.setLicense_no(entry.getDriver().getLicense_no());
			
			driverdetailsrepo.save(driverdetails);
			}
			
			if(entry.getVehicle() != null) {
			SMP_VehicleDetails vehicledetails = new SMP_VehicleDetails();
			vehicledetails.setVehicle_no(entry.getVehicle().getVehilce_no());
			vehicledetails.setVehicle_type(entry.getVehicle().getVehicle_type());
			
			vehicledetailsrepo.save(vehicledetails);
			}
		}
	}
