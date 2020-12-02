package com.employeecare.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employeecare.model.Employee;
import com.employeecare.model.EmployeeLeave;
import com.employeecare.model.Role;
import com.employeecare.repository.EmployeeLeaveRepository;
import com.employeecare.repository.EmployeeRepository;
import com.employeecare.web.dto.EmployeeLeaveRegistrationDto;

@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService{

	private EmployeeRepository employeeRepository;
	private EmployeeLeaveRepository employeeLeaveRepository;

	public EmployeeLeaveServiceImpl(EmployeeLeaveRepository employeeLeaveRepository) {
		super();
		this.employeeLeaveRepository = employeeLeaveRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Employee employee = employeeRepository.findByEmail(username);
		if(employee == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(employee.getEmail(), employee.getPassword(), mapRolesToAuthorities(employee.getRoles()));		
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public EmployeeLeave save(EmployeeLeaveRegistrationDto registrationDto) {
		EmployeeLeave employeeLeave = new EmployeeLeave(registrationDto.getEid(),registrationDto.getFullname(),
				registrationDto.getEmail(),registrationDto.getLeave_type(),registrationDto.getLeave_start(),
				registrationDto.getLeave_end(),registrationDto.getDays(),registrationDto.getReason());

		return employeeLeaveRepository.save(employeeLeave);
	}

}
