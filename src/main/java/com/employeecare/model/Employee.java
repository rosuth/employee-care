package com.employeecare.model;

import lombok.Data;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Data
@Table(name="employee")
public class Employee {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="password")
	private String password;

	@Column(name="firstname")
	private String firstname;

	@Column(name="lastname")
	private String lastname;

	@Column(name="email")
	private String email;

	@Column(name="dob")
	private String dob;

	@Column(name="gender")
	private String gender;

	@Column(name="address")
	private String address;

	@Column(name="city")
	private String city;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "employee_role",
			joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
	)
	private Collection<Role> roles;

	public Employee() {

	}

	public Employee(String password, String firstname, String lastname, String email, String dob,
			String gender, String address, String city, Collection<Role> roles) {
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.roles = roles;
	}

}