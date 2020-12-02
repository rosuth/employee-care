package com.employeecare.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employeecare.model.Employee;
import com.employeecare.model.Role;
import com.employeecare.repository.EmployeeRepository;
import com.employeecare.web.dto.EmployeeRegistrationDto;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee save(EmployeeRegistrationDto registrationDto) {
		Employee employee = new Employee(registrationDto.getFirstname(),registrationDto.getLastname(),
				registrationDto.getEmail(),registrationDto.getPassword(),registrationDto.getDob(),
				registrationDto.getAddress(),registrationDto.getGender(),registrationDto.getCity(),Arrays.asList(new Role("EMP_ROLE")));

		return employeeRepository.save(employee);
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

}