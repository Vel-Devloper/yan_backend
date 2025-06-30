package com.sevael.yanmar.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sevael.yanmar.dto.SMPItemDetailsDTO;
import com.sevael.yanmar.dto.SMPWrapperDTO;

import com.sevael.yanmar.entity.SMP_SupplierDetails;
import com.sevael.yanmar.entity.SMP_OtherDetails;
import com.sevael.yanmar.entity.SMP_RequestorDetails;
import com.sevael.yanmar.entity.SMP_ItemDetails;
import com.sevael.yanmar.entity.MaterialAppoint;
import com.sevael.yanmar.entity.SMP_DriverDetails;
import com.sevael.yanmar.entity.SMP_VehicleDetails;
import com.sevael.yanmar.entity.SMP_VendorAttachment;

import com.sevael.yanmar.repository.SMPSupplierDetailsRepo;
import com.sevael.yanmar.repository.SMPOtherDetailsRepo;
import com.sevael.yanmar.repository.SMPRequestorDetailsRepo;
import com.sevael.yanmar.repository.SMPItemDetailsRepo;
import com.sevael.yanmar.repository.MaterialAppointRepo;
import com.sevael.yanmar.repository.SMPDriverDetailsRepo;
import com.sevael.yanmar.repository.SMPVehicleDetailsRepo;
import com.sevael.yanmar.repository.SMPVendorAttachmentRepo;

import com.sevael.yanmar.service.SMPMaterialFormService;


@Service
public class SMPMaterialFormServiceImpl implements SMPMaterialFormService {

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
    @Autowired
    SMPVendorAttachmentRepo vendorAttachmentRepo;
    @Autowired
    MaterialAppointRepo materialappointrepo;

    @Override
    public void saveEntry(SMPWrapperDTO entry) {

        // Resolve material request ID
        Long materialRequestId = null;
        if (entry.getToken() != null && !entry.getToken().isBlank()) {
            Optional<MaterialAppoint> optional = materialappointrepo.findByUuidtoken(entry.getToken());
            if (optional.isPresent()) {
                materialRequestId = optional.get().getId();
            } else {
                throw new RuntimeException("Invalid token. No material appointment found.");
            }
        } else if (entry.getMat_requestid() != null) {
            materialRequestId = entry.getMat_requestid();
        } else {
            throw new RuntimeException("Missing token or material request ID.");
        }

        // Save Supplier first
        SMP_SupplierDetails savedSupplier = null;
        if (entry.getSupplierdetails() != null) {
            SMP_SupplierDetails supplierdetails = new SMP_SupplierDetails();
            supplierdetails.setSupplier_name(entry.getSupplierdetails().getSupplier_name());
            supplierdetails.setSupplier_address(entry.getSupplierdetails().getSupplier_address());
            supplierdetails.setPhone_no(entry.getSupplierdetails().getPhone_no());
            supplierdetails.setEmail(entry.getSupplierdetails().getEmail());
            supplierdetails.setEntry_date(entry.getSupplierdetails().getEntry_date());
            supplierdetails.setGstnumber(entry.getSupplierdetails().getGstnumber());
            supplierdetails.setState(entry.getSupplierdetails().getState());
            supplierdetails.setLocation(entry.getSupplierdetails().getLocation());

            if (materialRequestId != null) {
                supplierdetails.setMat_requestid(materialRequestId);
            }

            savedSupplier = supplierdetailsrepo.save(supplierdetails);
        }

        // Save Other Details
        if (entry.getOtherdetails() != null) {
            SMP_OtherDetails otherdetails = new SMP_OtherDetails();
            otherdetails.setInvoice_number(entry.getOtherdetails().getInvoice_number());
            otherdetails.setInvoice_date(entry.getOtherdetails().getInvoice_date());
            otherdetails.setOverall_value(entry.getOtherdetails().getOverall_value());
            otherdetails.setMat_due_date(entry.getOtherdetails().getMat_due_date());

            if (savedSupplier != null) {
                otherdetails.setSupplier(savedSupplier);
            }

            otherdetailsrepo.save(otherdetails);
        }

        // Save Requestor Details
        if (entry.getRequestordetails() != null) {
            SMP_RequestorDetails requestordetails = new SMP_RequestorDetails();
            requestordetails.setRequestor_name(entry.getRequestordetails().getRequestor_name());
            requestordetails.setDepartment(entry.getRequestordetails().getDepartment());

            if (savedSupplier != null) {
                requestordetails.setSupplier(savedSupplier);
            }

            requestordetailsrepo.save(requestordetails);
        }

        // Save Vendor Attachments
        if (entry.getVendorAttachments() != null && !entry.getVendorAttachments().isEmpty()) {
            for (MultipartFile file : entry.getVendorAttachments()) {
                try {
                    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                    String uploadDir = "uploads/vendor";
                    File dir = new File(uploadDir);
                    if (!dir.exists()) dir.mkdirs();

                    Path filePath = Paths.get(uploadDir, fileName);
                    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                    SMP_VendorAttachment attachment = new SMP_VendorAttachment();
                    attachment.setFilepath(filePath.toString());

                    if (savedSupplier != null) {
                        attachment.setSupplier(savedSupplier);
                    }

                    vendorAttachmentRepo.save(attachment);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to store vendor file: " + file.getOriginalFilename(), e);
                }
            }
        }

        // Save Item Details
        if (entry.getItems() != null) {
            for (SMPItemDetailsDTO itemEntry : entry.getItems()) {
                SMP_ItemDetails itemdetails = new SMP_ItemDetails();
                itemdetails.setItem_name(itemEntry.getItem_name());
                itemdetails.setQuantity(itemEntry.getQuantity());
                itemdetails.setUnit(itemEntry.getUnit());
                itemdetails.setValue(itemEntry.getValue());

                if (savedSupplier != null) {
                    itemdetails.setSupplier(savedSupplier);
                }

                itemdetailsrepo.save(itemdetails);
            }
        }

        // Save Driver Details
        if (entry.getDriver() != null) {
            SMP_DriverDetails driverdetails = new SMP_DriverDetails();
            driverdetails.setDriver_name(entry.getDriver().getDriver_name());
            driverdetails.setPhone_no(entry.getDriver().getPhone_no());
            driverdetails.setLicense_no(entry.getDriver().getLicense_no());

            if (savedSupplier != null) {
                driverdetails.setSupplier(savedSupplier);
            }

            driverdetailsrepo.save(driverdetails);
        }

        // Save Vehicle Details
        if (entry.getVehicle() != null) {
            SMP_VehicleDetails vehicledetails = new SMP_VehicleDetails();
            vehicledetails.setVehicle_no(entry.getVehicle().getVehilce_no());
            vehicledetails.setVehicle_type(entry.getVehicle().getVehicle_type());

            if (savedSupplier != null) {
                vehicledetails.setSupplier(savedSupplier);
            }

            vehicledetailsrepo.save(vehicledetails);
        }
    }
}


//@Service
//public class SMPMaterialFormServiceImpl implements SMPMaterialFormService{
//	
//	@Autowired
//	SMPSupplierDetailsRepo supplierdetailsrepo;
//	@Autowired
//	SMPOtherDetailsRepo otherdetailsrepo;
//	@Autowired
//	SMPRequestorDetailsRepo requestordetailsrepo;
//	@Autowired
//	SMPItemDetailsRepo itemdetailsrepo;
//	@Autowired
//	SMPDriverDetailsRepo driverdetailsrepo;
//	@Autowired
//	SMPVehicleDetailsRepo vehicledetailsrepo;
//	@Autowired
//	SMPVendorAttachmentRepo vendorAttachmentRepo;
//	@Autowired
//	MaterialAppointRepo materialappointrepo;
//	
//	@Override
//	public void saveEntry(SMPWrapperDTO entry) {
//			
//		 	// Get material request ID from token
//			Long materialRequestId = null;
//	
//			if (entry.getToken() != null && !entry.getToken().isBlank()) {
//			    // Automatic request: resolve token to ID
//			    Optional<MaterialAppoint> optional = materialappointrepo.findByUuidtoken(entry.getToken());
//			    if (optional.isPresent()) {
//			        materialRequestId = optional.get().getId();
//			    } else {
//			        throw new RuntimeException("Invalid token. No material appointment found.");
//			    }
//			} else if (entry.getMat_requestid() != null) {
//			    // Manual request: use provided request ID
//			    materialRequestId = entry.getMat_requestid();
//			} else {
//			    throw new RuntimeException("Missing token or material request ID.");
//			}
//				
//			if (entry.getSupplierdetails() !=null ) {
//			SMP_SupplierDetails supplierdetails = new SMP_SupplierDetails();
//			supplierdetails.setSupplier_name(entry.getSupplierdetails().getSupplier_name());
//			supplierdetails.setSupplier_address(entry.getSupplierdetails().getSupplier_address());
//		  	supplierdetails.setPhone_no(entry.getSupplierdetails().getPhone_no());
//		  	supplierdetails.setEmail(entry.getSupplierdetails().getEmail());
//		  	supplierdetails.setEntry_date(entry.getSupplierdetails().getEntry_date());
//		  	supplierdetails.setGstnumber(entry.getSupplierdetails().getGstnumber());
//		  	supplierdetails.setState(entry.getSupplierdetails().getState());
//		  	supplierdetails.setLocation(entry.getSupplierdetails().getLocation());
//		  	
//		  	if (materialRequestId != null) {
//		  		supplierdetails.setMat_requestid(materialRequestId);  // ✅ Set the foreign key
//	        }
//		  	
//		  	supplierdetailsrepo.save(supplierdetails);
//			}
//		  	if (entry.getOtherdetails() !=null ) {
//		  	SMP_OtherDetails otherdetails = new SMP_OtherDetails();
//		  	otherdetails.setInvoice_number(entry.getOtherdetails().getInvoice_number());
//		  	otherdetails.setInvoice_date(entry.getOtherdetails().getInvoice_date());
//		  	otherdetails.setOverall_value(entry.getOtherdetails().getOverall_value());
//		  	otherdetails.setMat_due_date(entry.getOtherdetails().getMat_due_date());
//		  	otherdetails.setGate_no(entry.getOtherdetails().getGate_no());
//		  	
//		  	otherdetailsrepo.save(otherdetails);
//			}
//		  	
//			if (entry.getRequestordetails() !=null ) {
//			SMP_RequestorDetails requestordetails = new SMP_RequestorDetails();
//			requestordetails.setRequestor_name(entry.getRequestordetails().getRequestor_name());
//			requestordetails.setDepartment(entry.getRequestordetails().getDepartment());
//			
//			requestordetailsrepo.save(requestordetails);
//			}
//			
//			if (entry.getVendorAttachments() != null && !entry.getVendorAttachments().isEmpty()) {
//			    for (MultipartFile file : entry.getVendorAttachments()) {
//			        try {
//			            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//			            String uploadDir = "uploads/vendor"; // customize as needed
//			            File dir = new File(uploadDir);
//			            if (!dir.exists()) dir.mkdirs();
//
//			            Path filePath = Paths.get(uploadDir, fileName);
//			            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//			            SMP_VendorAttachment attachment = new SMP_VendorAttachment();
//			            attachment.setFilepath(filePath.toString());
//			            
//			            vendorAttachmentRepo.save(attachment);
//			        } catch (IOException e) {
//			            throw new RuntimeException("Failed to store vendor file: " + file.getOriginalFilename(), e);
//			        }
//			    }
//			}
//
//			
//			if (entry.getItems() != null) {
//				for (SMPItemDetailsDTO itemEntry : entry.getItems()) {
//			SMP_ItemDetails itemdetails = new SMP_ItemDetails();
//			itemdetails.setItem_name(itemEntry.getItem_name());
//			itemdetails.setQuantity(itemEntry.getQuantity());
//			itemdetails.setUnit(itemEntry.getUnit());
//			itemdetails.setValue(itemEntry.getValue());
//			
//			itemdetailsrepo.save(itemdetails);
//			}
//			}
//			if (entry.getDriver() != null) {
//			SMP_DriverDetails driverdetails = new SMP_DriverDetails();
//			driverdetails.setDriver_name(entry.getDriver().getDriver_name());
//			driverdetails.setPhone_no(entry.getDriver().getPhone_no());
//			driverdetails.setLicense_no(entry.getDriver().getLicense_no());
//			
//			driverdetailsrepo.save(driverdetails);
//			}
//			
//			if(entry.getVehicle() != null) {
//			SMP_VehicleDetails vehicledetails = new SMP_VehicleDetails();
//			vehicledetails.setVehicle_no(entry.getVehicle().getVehilce_no());
//			vehicledetails.setVehicle_type(entry.getVehicle().getVehicle_type());
//			
//			vehicledetailsrepo.save(vehicledetails);
//			}
//		}
//	}
