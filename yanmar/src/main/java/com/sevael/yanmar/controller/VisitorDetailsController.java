package com.sevael.yanmar.controller;

import com.sevael.yanmar.dto.VisitorFullDetailsDTO;
import com.sevael.yanmar.service.VisitorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@CrossOrigin(origins = "*")
public class VisitorDetailsController {

    @Autowired
    private VisitorDetailsService visitorDetailsService;

    @GetMapping("/full-details")
    public List<VisitorFullDetailsDTO> getVisitorFullDetails() {
        return visitorDetailsService.fetchAllVisitorFullDetails();
    }
}
