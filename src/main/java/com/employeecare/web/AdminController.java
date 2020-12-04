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
public class AdminController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private EmployeeLeaveRepository employeeLeaveRepository;

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "/admdashboard")
	public String adminHomepage() {
		return "admin/adminHomepage";
	}
	@RequestMapping("/admlogin")
	public String adminLogin() {
		return "authentication/adminLogin";
	}
	@RequestMapping("/admdashboard/timetracking")
	public String employeeTimeTracking(){
		return "admin/employee/employeeTimeTracking";
	}
	@RequestMapping("/admdashboard/attendance")
	public String employeeAttendanceForAdmin(){
		return "admin/employee/employeeAttendance";
	}
	@RequestMapping("/admdashboard/documents")
	public String employeeDocumentsForAdmin(){
		return "admin/employee/employeeDocuments";
	}
	@RequestMapping("/admdashboard/requests")
	public String employeeRequestForAdmin(){
		return "admin/employee/employeeRequests";
	}
	@RequestMapping("/admdashboard/findemployee")
	public String employeeSearchForm(){
		return "admin/employee/employeeSearchForm";
	}
	@RequestMapping(value = "/admdashboard/logout", method = RequestMethod.GET)
	public String adminLogout() {
		return "redirect:/";
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
	@RequestMapping("/admdashboard/employeeleave/approve/{lid}")
	public String sendLeaveApprovalMail(@PathVariable("lid") long lid, Model model){
		model.addAttribute("employeeLeave", this.employeeLeaveRepository.findById(lid));
		model.addAttribute("listEmployeesLeave", this.employeeLeaveRepository.findAll());
		this.employeeLeaveRepository.deleteById(lid);
		return "admin/leave/approvalForm";
	}
	@RequestMapping("/admdashboard/employeeleave/reject/{lid}")
	public String sendLeaveRejectionMail(@PathVariable("lid") long lid, Model model){
		model.addAttribute("employeeLeave", this.employeeLeaveRepository.findById(lid));
		model.addAttribute("listEmployeesLeave", this.employeeLeaveRepository.findAll());
		this.employeeLeaveRepository.deleteById(lid);
		return "admin/leave/rejectionForm";
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

	@RequestMapping(value = "/admdashboard", method = RequestMethod.POST)
	String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		try {
			Admin admin = adminRepository.findByEmail(email);
			model.addAttribute("admin", admin);
			if(admin!=null) {
				if(email.equals(admin.getEmail()) && password.equals(admin.getPassword())) 
					return "admin/adminHomepage";
				else 
					return "exceptions/adminLoginError";
			}
			else {
				return "exceptions/adminLoginError";
			}
		}
		catch(ObjectNotFoundException e){
			return "exceptions/adminLoginError";
		}
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
		return "redirect:/admdashboard";
	}

	@RequestMapping(value= "/admdashboard/employee/update", method = RequestMethod.POST)
	public String employeeEdited(@ModelAttribute("employee") Employee emp){
		if(emp.getEid() != 0){
			emp.setPassword(null);
			String temp = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
			emp.setPassword(temp);
			String recipientAddress = emp.getEmail();
			String subject = "Account Updated";
			String message = "Dear "+emp.getFirstname()+""
					+ "\n\nYour account was updated recently by your system admin and thus we've generated a new password for you."
					+ "\nKindly use the below password from your next session on Employee Care."
					+ "\n\n"
					+ "New Password: "+temp+"";
			SimpleMailMessage passwordChangedEmail = new SimpleMailMessage();
			passwordChangedEmail.setTo(recipientAddress);
			passwordChangedEmail.setSubject(subject);
			passwordChangedEmail.setText(message);
			mailSender.send(passwordChangedEmail);
			this.employeeRepository.save(emp);
		}
		return "redirect:/admdashboard/employees";
	}

	@RequestMapping(value="/admdashboard/findemployee",method=RequestMethod.POST)
	public String findEmployeeById(@RequestParam("eid") int eid, Model model) throws ObjectNotFoundException{
		Employee emp = employeeRepository.findById(eid);
		if(emp!=null) {
			model.addAttribute("employee", this.employeeRepository.findById(eid));
			return "admin/employee/employeeProfile";
		}
		else {
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

	@RequestMapping(value="/admindashboard/employeeleave/rejected",method=RequestMethod.POST)
	public String rejectionMail(HttpServletRequest request) {
		String recipientAddress = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		mailSender.send(email);
		return "redirect:/admdashboard/employeeleaves";
	}

	@RequestMapping(value="/admindashboard/employeeleave/approved",method=RequestMethod.POST)
	public String approvalEmail(HttpServletRequest request) {
		String recipientAddress = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		mailSender.send(email);
		return "redirect:/admdashboard/employeeleaves";
	}
}