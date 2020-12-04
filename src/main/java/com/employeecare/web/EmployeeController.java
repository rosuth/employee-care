package com.employeecare.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.employeecare.model.Admin;
import com.employeecare.model.Employee;
import com.employeecare.model.EmployeeLeave;
import com.employeecare.repository.AdminRepository;
import com.employeecare.repository.EmployeeLeaveRepository;
import com.employeecare.repository.EmployeeRepository;

@Controller
@Component
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private EmployeeLeaveRepository employeeLeaveRepository;

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("/emplogin")
	public String employeelogin() {
		return "authentication/employeeLogin";
	}
	@RequestMapping(value = "/empdashboard", method=RequestMethod.GET)
	public String employeeHomepage() {
		return "employee/employeeHomepage";
	}
	@RequestMapping("/empdashboard/myprofile")
	public String employeeProfileSearchForm(){
		return "employee/employeeSearchForm";
	}
	@RequestMapping("/empdashboard/request")
	public String employeeRequest(){
		return "employee/employeeRequest";
	}
	@RequestMapping("/empdashboard/raiseissue")
	public String employeeRaiseIssue(){
		return "employee/employeeRaiseIssue";
	}
	@RequestMapping("/empdashboard/attendance")
	public String employeeAttendance(){
		return "employee/employeeAttendance";
	}
	@RequestMapping("/empdashboard/document")
	public String employeeDocuments(){
		return "employee/employeeDocuments";
	}
	@RequestMapping("/empdashboard/leaveapplication")
	public String leaveApplication(){
		return "employee/leave/leaveApplication";
	}
	@RequestMapping(value = "/empdashboard/logout", method = RequestMethod.GET)
	public String employeeLogout() {
		return "redirect:/";
	}

	@RequestMapping(value = "/empdashboard", method=RequestMethod.POST)
	public String employeeLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model) throws ObjectNotFoundException{
		try {
			Employee emp = employeeRepository.findByEmail(email);
			model.addAttribute("employee", emp);
			if(emp!=null) {
				if(email.equals(emp.getEmail()) && password.equals(emp.getPassword())) 
					return "employee/employeeHomepage";
				else 
					return "exceptions/employeeLoginError";
			}
			else {
				return "exceptions/employeeLoginError";

			}
		}
		catch(ObjectNotFoundException e){
			return "exceptions/employeeLoginError";
		}
	}

	@RequestMapping(value= "/empdashboard/leaveapplication", method = RequestMethod.POST)
	public String leaveApplied(@ModelAttribute("employeeLeave") EmployeeLeave el){
		this.employeeLeaveRepository.save(el);
		return "redirect:/empdashboard/";
	}

	@RequestMapping(value="/empdashboard/myprofile",method=RequestMethod.POST)
	public String findEmployeeProfileById(@RequestParam("eid") int eid, Model model) throws ObjectNotFoundException{
		Employee emp = employeeRepository.findById(eid);
		if(emp!=null) {
			model.addAttribute("employee", this.employeeRepository.findById(eid));
			return "employee/employeeProfile";
		}
		else {
			return "exceptions/employeeProfileNotFoundForEmployee";
		}
	}
}