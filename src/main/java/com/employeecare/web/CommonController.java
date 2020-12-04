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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.employeecare.model.Employee;
import com.employeecare.repository.AdminRepository;
import com.employeecare.repository.EmployeeLeaveRepository;
import com.employeecare.repository.EmployeeRepository;

@Controller
@Component
public class CommonController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private EmployeeLeaveRepository employeeLeaveRepository;

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("/")
	public String contextPath() {
		return "index";
	}
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public String forgotPassword() {
		return "authentication/forgotPassword";
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
	
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public String recoverAccount(Model model, @RequestParam("eid") int eid, @RequestParam("firstname") String firstname, @RequestParam("email") String email, HttpServletRequest request){
		try {
			Employee emp = employeeRepository.findByEmail(email);
			model.addAttribute("employee", emp);
			if(emp!=null) {
				if(eid==emp.getEid() && firstname.equals(emp.getFirstname()) && email.equals(emp.getEmail())) {
					String temp = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
					emp.setPassword(temp);
					String subject = "Employee Care Account Recovery Process";
					String message = "We have received the account recovery request on your Employee Care Account, kindly follow the steps below to complete the process and enjoy the benefits of Employee Care Account.\nIn case if you have not made any request for the same then do not share the information provided in this email to anyone.\n\n"
							+ "Your Employee Care Account Information:\n\n"
							+ "Employee ID: "+emp.getEid()+"\n"
							+ "Name: "+emp.getFirstname()+" "+emp.getLastname()+"\n"
							+ "Email: "+emp.getEmail()+"\n"
							+ "New Password: "+temp+"\n\n"
							+ "Use the above EID and Password when trying to login into your account.\n\n"
							+ "Thanks for using Employee Care.";
					SimpleMailMessage accountrecoverymail = new SimpleMailMessage();
					accountrecoverymail.setTo(email);
					accountrecoverymail.setSubject(subject);
					accountrecoverymail.setText(message);
					this.employeeRepository.save(emp);
					mailSender.send(accountrecoverymail);
					return "authentication/forgotPasswordSuccessful";
				}
				else 
					return "authentication/forgotPasswordFailed";
			}
			else
				return "authentication/forgotPasswordFailed";
		}
		catch(ObjectNotFoundException e){
			return "authentication/forgotPasswordFailed";
		}
	}
}