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

import com.employeecare.repository.EmployeeLeaveRepository;
import com.employeecare.model.EmployeeLeave;

@RestController
@RequestMapping("/apis")
public class EmployeeLeaveRestController {

	@Autowired
	EmployeeLeaveRepository employeeLeaveRepository;

	@GetMapping("/employeeleave")
	public ResponseEntity<List<EmployeeLeave>> getAllEmployeeLeaves() {
		try {
			List<EmployeeLeave> employeeLeaves = new ArrayList<EmployeeLeave>();
			employeeLeaveRepository.findAll().forEach(employeeLeaves::add);
			if (employeeLeaves.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(employeeLeaves, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/employeeleave/{lid}")
	public ResponseEntity<EmployeeLeave> getEmployeeLeaveById(@PathVariable("lid") long lid) {
		Optional<EmployeeLeave> employeeLeaves = Optional.ofNullable(employeeLeaveRepository.findById(lid));
		if (employeeLeaves.isPresent()) {
			return new ResponseEntity<>(employeeLeaves.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/employeeleave")
	public ResponseEntity<EmployeeLeave> createEmployeeLeave(@RequestBody EmployeeLeave employeeLeave) {
		try {
			EmployeeLeave el = employeeLeaveRepository
					.save(new EmployeeLeave(employeeLeave.getEid(),employeeLeave.getFullname(),employeeLeave.getEmail(),employeeLeave.getLeave_type(),employeeLeave.getDays(),employeeLeave.getLeave_start(),employeeLeave.getLeave_end(),employeeLeave.getReason()));
			return new ResponseEntity<>(el, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/employeeleave/{id}")
	public ResponseEntity<EmployeeLeave> updateEmployeeLeave(@PathVariable("lid") long lid, @RequestBody EmployeeLeave employeeLeave) {
		Optional<EmployeeLeave> employeeLeaveData = Optional.ofNullable(employeeLeaveRepository.findById(lid));

		if (employeeLeaveData.isPresent()) {
			EmployeeLeave e = employeeLeaveData.get();
			e.setFullname(employeeLeave.getFullname());
			e.setEmail(employeeLeave.getEmail());
			e.setLeave_type(employeeLeave.getLeave_type());
			e.setDays(employeeLeave.getDays());
			e.setLeave_start(employeeLeave.getLeave_start());
			e.setLeave_end(employeeLeave.getLeave_end());
			e.setReason(employeeLeave.getReason());
			return new ResponseEntity<>(employeeLeaveRepository.save(employeeLeave), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/employeeleave/{lid}")
	public ResponseEntity<HttpStatus> deleteEmployeeLeave(@PathVariable("lid") long lid) {
		try {
			employeeLeaveRepository.deleteById(lid);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/employeeleave")
	public ResponseEntity<HttpStatus> deleteAllEmployeeLeaves() {
		try {
			employeeLeaveRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}