package com.employeecare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEELEAVE")
public class EmployeeLeave {

	@Id
	@Column(name="LID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long lid;

	@Column(name="EID")
	private String eid;

	@Column(name="EMAIL")
	private String email;

	@Column(name="LEAVE_TYPE")
	private String leave_type;

	@Column(name="FULLNAME")
	private String fullname;

	@Column(name="LEAVE_START")
	private String leave_start;

	@Column(name="LEAVE_END")
	private String leave_end;

	@Column(name="DAYS")
	private String days;

	@Column(name="REASON")
	private String reason;

	public EmployeeLeave() {

	}

	public EmployeeLeave(String eid, String email, String leave_type, String fullname, String leave_start,
			String leave_end, String days, String reason) {
		this.eid = eid;
		this.email = email;
		this.leave_type = leave_type;
		this.fullname = fullname;
		this.leave_start = leave_start;
		this.leave_end = leave_end;
		this.days = days;
		this.reason = reason;
	}

	public Long getLid() {
		return lid;
	}

	public void setLid(Long lid) {
		this.lid = lid;
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

	@Override
	public String toString() {
		return "EmployeeLeave [lid=" + lid + ", eid=" + eid + ", email=" + email + ", leave_type=" + leave_type
				+ ", fullname=" + fullname + ", leave_start=" + leave_start + ", leave_end=" + leave_end + ", days="
				+ days + ", reason=" + reason + "]";
	}
}