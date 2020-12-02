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

import com.employeecare.repository.AdminRepository;
import com.employeecare.model.Admin;

@RestController
@RequestMapping("/apis")
public class AdminRestController {

	@Autowired
	AdminRepository adminRepository;

	@GetMapping("/admin")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		try {
			List<Admin> admins = new ArrayList<Admin>();
			adminRepository.findAll().forEach(admins::add);
			if (admins.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(admins, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/admin/{aid}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("aid") long aid) {
		Optional<Admin> admin = Optional.ofNullable(adminRepository.findById(aid));
		if (admin.isPresent()) {
			return new ResponseEntity<>(admin.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/admin")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		try {
			Admin adm = adminRepository
					.save(new Admin(admin.getFirstname(),admin.getLastname(),admin.getEmail(),admin.getPassword(),admin.getRoles()));
			return new ResponseEntity<>(adm, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/admin/{aid}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("aid") long aid, @RequestBody Admin admin) {
		Optional<Admin> adminData = Optional.ofNullable(adminRepository.findById(aid));

		if (adminData.isPresent()) {
			Admin a = adminData.get();
			a.setFirstname(admin.getFirstname());
			a.setLastname(admin.getLastname());
			a.setEmail(admin.getEmail());
			a.setPassword(admin.getPassword());
			return new ResponseEntity<>(adminRepository.save(admin), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/admin/{aid}")
	public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("aid") long aid) {
		try {
			adminRepository.deleteById(aid);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/admin")
	public ResponseEntity<HttpStatus> deleteAllAdmins() {
		try {
			adminRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}