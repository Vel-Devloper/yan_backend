package com.sevael.yanmar.serviceImpl;

import com.sevael.yanmar.dto.VisitorFullDetailsDTO;
import com.sevael.yanmar.repository.VisitorDetailsRepository;
import com.sevael.yanmar.service.VisitorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorDetailsServiceImpl implements VisitorDetailsService {

    @Autowired
    private VisitorDetailsRepository repository;

    @Override
    public List<VisitorFullDetailsDTO> fetchAllVisitorFullDetails() {
        return repository.getAllVisitorFullDetails();
    }
}