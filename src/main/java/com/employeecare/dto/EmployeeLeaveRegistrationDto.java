package com.employeecare.dto;

import lombok.Data;

@Data
public class EmployeeLeaveRegistrationDto {

	private String id;
	private String email;
	private String leave_type;
	private String fullname;
	private String leave_start;
	private String leave_end;
	private String days;
	private String reason;

	public EmployeeLeaveRegistrationDto() {

	}

	public EmployeeLeaveRegistrationDto(String id, String email, String leave_type, String fullname,
			String leave_start, String leave_end, String days, String reason) {
		super();
		this.id = id;
		this.email = email;
		this.leave_type = leave_type;
		this.fullname = fullname;
		this.leave_start = leave_start;
		this.leave_end = leave_end;
		this.days = days;
		this.reason = reason;
	}

}
