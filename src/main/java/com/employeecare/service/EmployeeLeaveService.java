package com.employeecare.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.employeecare.model.EmployeeLeave;
import com.employeecare.web.dto.EmployeeLeaveRegistrationDto;

public interface EmployeeLeaveService extends UserDetailsService{

	EmployeeLeave save(EmployeeLeaveRegistrationDto registrationDto);
}
