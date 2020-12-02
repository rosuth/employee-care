package com.employeecare.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeecare.repository.EmployeeRepository;
import com.employeecare.model.Employee;

@RestController
@RequestMapping("/apis")
public class EmployeeRestController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		try {
			List<Employee> employees = new ArrayList<Employee>();
			employeeRepository.findAll().forEach(employees::add);
			if (employees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/employee/{eid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("eid") long eid) {
		Optional<Employee> employee = Optional.ofNullable(employeeRepository.findById(eid));
		if (employee.isPresent()) {
			return new ResponseEntity<>(employee.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		try {
			Employee emp = employeeRepository
					.save(new Employee(employee.getFirstname(),employee.getLastname(),employee.getEmail(),employee.getDob(),employee.getGender(),employee.getPassword(),employee.getAddress(),employee.getCity(),employee.getRoles()));
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/employee/{eid}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("eid") long eid, @RequestBody Employee employee) {
		Optional<Employee> employeeData = Optional.ofNullable(employeeRepository.findById(eid));

		if (employeeData.isPresent()) {
			Employee e = employeeData.get();
			e.setFirstname(employee.getFirstname());
			e.setLastname(employee.getLastname());
			e.setEmail(employee.getEmail());
			e.setDob(employee.getDob());
			e.setGender(employee.getGender());
			e.setPassword(employee.getPassword());
			e.setAddress(employee.getAddress());
			e.setCity(employee.getCity());
			return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/employee/{eid}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("eid") long eid) {
		try {
			employeeRepository.deleteById(eid);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/employee")
	public ResponseEntity<HttpStatus> deleteAllEmployees() {
		try {
			employeeRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
