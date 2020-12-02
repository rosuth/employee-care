package com.employeecare.web;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Component
public class NavigationController {

	@RequestMapping("/emplogin")
	public String home() {
		return "authentication/employeelogin";
	}

	@RequestMapping("/admlogin")
	public String adminLogin() {
		return "authentication/adminLogin";
	}

	@RequestMapping("/")
	public String contextPath() {
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}

	@RequestMapping("/support")
	public String support() {
		return "support";
	}

	@RequestMapping("/createaccount")
	public String home2() {
		return "createaccount";
	}	
	@RequestMapping("viewEmployeeProfile")
	public String employeeProfile(){
		return "admin/employee/employeeProfile";
	}

	@RequestMapping(value = "/admdashboard")
	public String adminHomepage() {
		return "admin/adminHomepage";
	}

	@RequestMapping(value = "/empdashboard", method=RequestMethod.GET)
	public String employeeHomepage() {
		return "employee/employeeHomepage";
	}

	@RequestMapping(value = "/leaveapplication", method=RequestMethod.GET)
	public String leaveApplication() {
		return "employee/leave/leaveApplication";
	}

	@RequestMapping(value = "/employeeselfhelp", method=RequestMethod.GET)
	public String employeeSelfHelp() {
		return "employee/employeeSelfHelp";
	}

	@RequestMapping(value = "/raiseissue", method=RequestMethod.GET)
	public String raiseIssue() {
		return "employee/raiseIssue";
	}

	@RequestMapping(value = "/myattendance", method=RequestMethod.GET)
	public String myAttendance() {
		return "employee/myAttendance";
	}

	@RequestMapping(value = "/mydocuments", method=RequestMethod.GET)
	public String myDocuments() {
		return "employee/myDocuments";
	}

	@RequestMapping(value = "/sendEmail")
	public String sendEmail() {
		return "sendEmailForm";
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public String forgotPassword() {
		return "authentication/forgotPassword";
	}

	@RequestMapping(value = "/admdashboard/logout", method = RequestMethod.GET)
	public String adminLogout() {
		return "redirect:/";
	}

	@RequestMapping(value = "/empdashboard/logout", method = RequestMethod.GET)
	public String employeeLogout() {
		return "redirect:/";
	}
}
