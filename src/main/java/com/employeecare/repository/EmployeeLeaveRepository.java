package com.employeecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employeecare.model.EmployeeLeave;

public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Long> {

	EmployeeLeave findById(long id);
	EmployeeLeave findByEmail(String email);

}