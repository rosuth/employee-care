package com.employeecare.web;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Component
public class NavigationController {

	@RequestMapping("/employeelogin")
    public String home() {
        return "authentication/employeelogin";
    }
	
	@RequestMapping("/")
    public String home1() {
        return "index";
    }
	
	@RequestMapping("viewEmployeeProfile")
	public String viewEmployeeProfile(){
		return "viewEmployeeProfile";
	}

	@RequestMapping(value = "/admindashboard")
	public String adminHomepage() {
		return "admin/adminHomepage";
	}
	
	@RequestMapping(value = "/employeedashboard", method=RequestMethod.GET)
	public String employeeHomepage() {
		return "employee/employeeHomepage";
	}
	
	@RequestMapping(value = "/employeeprofile", method=RequestMethod.GET)
	public String employeeProfile() {
		return "employee/employeeProfile";
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

	@RequestMapping("/adminlogin")
	public String adminLogin() {
		return "authentication/adminLogin";
	}

	@RequestMapping(value = "/accountrecovery", method = RequestMethod.GET)
	public String accountRecovery() {
		return "authentication/accountRecovery";
	}

	@RequestMapping(value = "/adminlogout", method = RequestMethod.GET)
	public String adminLogout() {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/employeelogout", method = RequestMethod.GET)
	public String employeeLogout() {
		return "redirect:/";
	}
}
