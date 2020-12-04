package com.employeecare.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.employeecare.model.Admin;
import com.employeecare.web.dto.AdminRegistrationDto;

public interface AdminService extends UserDetailsService{

	Admin save(AdminRegistrationDto registrationDto);

}
