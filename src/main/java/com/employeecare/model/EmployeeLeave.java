package com.employeecare.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="employee_leave")
public class EmployeeLeave {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="emp_id")
	private String emp_id;

	@Column(name="email")
	private String email;

	@Column(name="leave_type")
	private String leave_type;

	@Column(name="fullname")
	private String fullname;

	@Column(name="leave_start")
	private String leave_start;

	@Column(name="leave_end")
	private String leave_end;

	@Column(name="days")
	private String days;

	@Column(name="reason")
	private String reason;

	public EmployeeLeave() {

	}

	public EmployeeLeave(String emp_id, String email, String leave_type, String fullname, String leave_start,
			String leave_end, String days, String reason) {
		this.emp_id = emp_id;
		this.email = email;
		this.leave_type = leave_type;
		this.fullname = fullname;
		this.leave_start = leave_start;
		this.leave_end = leave_end;
		this.days = days;
		this.reason = reason;
	}

}