package com.employeecare.web.dto;

public class EmployeeLeaveRegistrationDto {

	private String eid;
	private String email;
	private String leave_type;
	private String fullname;
	private String leave_start;
	private String leave_end;
	private String days;
	private String reason;

	public EmployeeLeaveRegistrationDto() {

	}

	public EmployeeLeaveRegistrationDto(String eid, String email, String leave_type, String fullname,
			String leave_start, String leave_end, String days, String reason) {
		super();
		this.eid = eid;
		this.email = email;
		this.leave_type = leave_type;
		this.fullname = fullname;
		this.leave_start = leave_start;
		this.leave_end = leave_end;
		this.days = days;
		this.reason = reason;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getLeave_start() {
		return leave_start;
	}

	public void setLeave_start(String leave_start) {
		this.leave_start = leave_start;
	}

	public String getLeave_end() {
		return leave_end;
	}

	public void setLeave_end(String leave_end) {
		this.leave_end = leave_end;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
