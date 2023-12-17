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
@RequestMapping("/api")
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

	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("id") long id) {
		Optional<Admin> admin = Optional.ofNullable(adminRepository.findById(id));
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

	@PutMapping("/admin/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") long id, @RequestBody Admin admin) {
		Optional<Admin> adminData = Optional.ofNullable(adminRepository.findById(id));

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

	@DeleteMapping("/admin/{id}")
	public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("id") long id) {
		try {
			adminRepository.deleteById(id);
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