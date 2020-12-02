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

	@RequestMapping(value = "/empdashboard", method=RequestMethod.POST)
	public String employeeLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model) throws ObjectNotFoundException{
		try {
			Employee emp = employeeRepository.findByEmail(email);
			model.addAttribute("employee", emp);
			if(email.equals(emp.getEmail()) && password.equals(emp.getPassword())) 
				return "employee/employeeHomepage";
			else 
				return "exceptions/employeeLoginError";
		}
		catch(ObjectNotFoundException e){
			return "exceptions/employeeLoginError";
		}
	}

	@RequestMapping(value = "/admdashboard", method = RequestMethod.POST)
	String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		try {
			Admin admin = adminRepository.findByEmail(email);
			model.addAttribute("admin", admin);
			if(email.equals(admin.getEmail()) && password.equals(admin.getPassword())) 
				return "admin/adminHomepage";
			else 
				return "exceptions/adminLoginError";
		}
		catch(ObjectNotFoundException e){
			return "exceptions/adminLoginError";
		}
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public String recoverAccount(Model model, @RequestParam("eid") int eid, @RequestParam("firstname") String firstname, @RequestParam("email") String email, HttpServletRequest request){
		try {
			Employee emp = employeeRepository.findByEmail(email);
			model.addAttribute("employee", emp);
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
				mailSender.send(accountrecoverymail);
				return "authentication/forgotPasswordSuccessful";
			}
			else 
				return "authentication/forgotPasswordFailed";
		}
		catch(ObjectNotFoundException e){
			return "authentication/forgotPasswordFailed";
		}
	}

	@RequestMapping("/admdashboard/employees")
	public String viewEmployees(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployees", this.employeeRepository.findAll());
		return "admin/employee/employeeList";
	}

	@RequestMapping("/admdashboard/employeeleaves")
	public String viewEmployeeLeaves(Model model) {
		model.addAttribute("employeeLeave", new EmployeeLeave());
		model.addAttribute("listEmployeesLeaves", this.employeeLeaveRepository.findAll());
		return "admin/leave/employeeLeaveList";
	}

	@RequestMapping("/admdashboard/employee/add")
	public String employeeRegistrationForm(@ModelAttribute("employee") Employee emp)
	{
		return "admin/employee/employeeRegistrationForm";
	}

	@RequestMapping("/admdashboard/employeeleave/add")
	public String employeeLeaveForm(@ModelAttribute("employeeLeave") EmployeeLeave el)
	{
		return "employee/leave/employeeLeaveForm";
	}

	@RequestMapping(value= "/admdashboard/employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee emp){
		String temp = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
		if(emp.getPassword()==null) {
			emp.setPassword(temp);
		}
		this.employeeRepository.save(emp);
		String recipientAddress = emp.getEmail();
		String subject = "Welcome "+emp.getFirstname()+" to Employee Care";
		String message = "Employee Care Welcomes You!\n\nYour Employee Account has been created successfully by your System Admin.\nEnjoy the unlimited benefits of tracking all your records, documents, leaves and many other things that matter on a single platform."
				+ "\nKindly find the below information for logging into your account."
				+ "\n\nEID : "+emp.getEid()+""
				+ "\nEmail : "+emp.getEmail()+""
				+ "\nPassword: "+temp+""
				+ "\n\nYou can login into your account with the above EID and Password.\n\nThanks.";
		SimpleMailMessage welcomeemail = new SimpleMailMessage();
		welcomeemail.setTo(recipientAddress);
		welcomeemail.setSubject(subject);
		welcomeemail.setText(message);
		mailSender.send(welcomeemail);
		return "redirect:/app/admdashboard";
	}

	@RequestMapping(value= "leaveApplied", method = RequestMethod.POST)
	public String leaveApplied(@ModelAttribute("employeeLeave") EmployeeLeave el){
		this.employeeLeaveRepository.save(el);
		return "redirect:/admdashboard/";
	}

	@RequestMapping(value= "/admdashboard/employee/update", method = RequestMethod.POST)
	public String employeeEdited(@ModelAttribute("employee") Employee emp){
		if(emp.getEid() != 0){
			this.employeeRepository.save(emp);
		}
		return "redirect:/admdashboard/employees";
	}

	@RequestMapping("/admdashboard/employee/delete/{eid}")
	public String removeEmployee(@PathVariable("eid") long eid){
		this.employeeRepository.deleteById(eid);
		return "redirect:/admdashboard/employees";
	}

	@RequestMapping("/admdashboard/employee/edit/{eid}")
	public String editEmployee(@PathVariable("eid") int eid, Model model){
		model.addAttribute("employee", this.employeeRepository.findById(eid));
		model.addAttribute("listEmployees", this.employeeRepository.findAll());
		return "admin/employee/employeeUpdateForm";
	}

	@RequestMapping("/admdashboard/employee/email/{eid}")
	public String sendEmailToEmployee(@PathVariable("eid") int eid, Model model){
		model.addAttribute("employee", this.employeeRepository.findById(eid));
		model.addAttribute("listEmployees", this.employeeRepository.findAll());
		return "admin/employee/employeeEmailForm";
	}

	@RequestMapping("/admdashboard/approveleave/{lid}")
	public String leaveApproval(@PathVariable("lid") long lid, Model model){
		model.addAttribute("employeeLeave", this.employeeLeaveRepository.findById(lid));
		model.addAttribute("listEmployeesLeave", this.employeeLeaveRepository.findAll());
		this.employeeLeaveRepository.deleteById(lid);
		return "admin/leave/leaveApprovalMessageForm";
	}

	@RequestMapping("/admdashboard/rejectleave/{lid}")
	public String leaveReject(@PathVariable("lid") long lid, Model model){
		model.addAttribute("employeeLeave", this.employeeLeaveRepository.findById(lid));
		model.addAttribute("listEmployeesLeave", this.employeeLeaveRepository.findAll());
		this.employeeLeaveRepository.deleteById(lid);
		return "admin/leave/leaveRejectionMessageForm";
	}

	@RequestMapping("/admdashboard/employee/findemployee")
	public String employeeSearchForm(){
		return "admin/employee/employeeSearchForm";
	}

	@RequestMapping(value="/admdashboard/getemployee",method=RequestMethod.POST)
	public String findEmployeeById(@RequestParam("eid") int eid, Model model) throws ObjectNotFoundException{
		try {
			model.addAttribute("employee", this.employeeRepository.findById(eid));
			return "admin/employee/viewEmployeeProfile";
		}
		catch(ObjectNotFoundException o){
			return "exceptions/employeeProfileNotFound";
		}
	}

	@RequestMapping(value="/admdashboard/employee/email",method=RequestMethod.POST)
	public String sendEmail(HttpServletRequest request) {
		String recipientAddress = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		mailSender.send(email);
		return "redirect:/admdashboard";
	}

	@RequestMapping(value="/sendRejectEmail",method=RequestMethod.POST)
	public String rejectionMail(HttpServletRequest request) {
		String recipientAddress = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		mailSender.send(email);
		return "redirect:/admdashboard";
	}

	@RequestMapping(value="/sendApproveEmail",method=RequestMethod.POST)
	public String approvalEmail(HttpServletRequest request) {
		String recipientAddress = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		mailSender.send(email);
		return "redirect:/admdashboard";
	}
}