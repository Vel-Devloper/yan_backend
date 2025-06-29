package com.sevael.yanmar.repository;


import com.sevael.yanmar.entity.AppointmentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentTypeRepo extends JpaRepository<AppointmentType, Integer> {
}