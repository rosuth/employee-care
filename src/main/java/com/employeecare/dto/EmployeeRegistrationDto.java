package com.employeecare.dto;

import lombok.Data;

@Data
public class EmployeeRegistrationDto {

	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String dob;
	private String gender;
	private String address;
	private String city;

	public EmployeeRegistrationDto() {

	}

	public EmployeeRegistrationDto(String password, String firstname, String lastname, String email, String dob,
			String gender, String address, String city) {
		super();
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.city = city;
	}

}
