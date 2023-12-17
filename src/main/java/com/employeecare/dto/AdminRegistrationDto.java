package com.employeecare.dto;

import lombok.Data;

@Data
public class AdminRegistrationDto {

	private String firstname;
	private String lastname;
	private String email;
	private String password;

	public AdminRegistrationDto(){

	}

	public AdminRegistrationDto(String firstname, String lastname, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

}
