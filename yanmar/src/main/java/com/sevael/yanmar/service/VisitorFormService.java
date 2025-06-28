package com.sevael.yanmar.service;

import org.springframework.web.multipart.MultipartFile;
import java.util.List;

import com.sevael.yanmar.dto.VisitorFullDetailsDTO;
import com.sevael.yanmar.dto.VisitorSubmissionDTO;
//import com.sevael.yanmar.dto.WrapperVisitorFormDTO;

public interface VisitorFormService {
//	void saveEntry(List<WrapperVisitorFormDTO> VisitorForm);
	void saveEntry(VisitorSubmissionDTO submissionDTO, List<MultipartFile> photoFiles);
	List<VisitorFullDetailsDTO> getAllVisitorDetailsByAppointment(Long appointment_id);
}
