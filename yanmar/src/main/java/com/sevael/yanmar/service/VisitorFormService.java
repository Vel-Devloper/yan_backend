package com.sevael.yanmar.service;

//import java.util.List;

import com.sevael.yanmar.dto.VisitorSubmissionDTO;
//import com.sevael.yanmar.dto.WrapperVisitorFormDTO;

public interface VisitorFormService {
//	void saveEntry(List<WrapperVisitorFormDTO> VisitorForm);
	void saveEntry(VisitorSubmissionDTO submissionDTO);
}
