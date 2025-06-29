package com.sevael.yanmar.service;

import com.sevael.yanmar.dto.VisitorFullDetailsDTO;
import java.util.List;

public interface VisitorDetailsService {
    List<VisitorFullDetailsDTO> fetchAllVisitorFullDetails();
}