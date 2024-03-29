package com.employeecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employeecare.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findById(long id);
	Admin findByEmail(String email);

}