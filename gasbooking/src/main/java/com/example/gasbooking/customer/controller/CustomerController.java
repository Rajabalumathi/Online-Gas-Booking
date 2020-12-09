package com.example.gasbooking.customer.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.gasbooking.customer.entity.Customer;
import com.example.gasbooking.customer.repository.CustomerRepository;
import com.example.gasbooking.customer.service.CustomerService;
import com.example.gasbooking.customer.service.EmailSenderService;
import org.springframework.util.StringUtils;

@Controller

public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@Autowired
	private EmailSenderService emailSenderService;

	@Autowired
	private CustomerRepository customerRepository;

	BCryptPasswordEncoder passwordsEncoder = new BCryptPasswordEncoder();

	/* Display Registration Page */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView displayRegistration(ModelAndView modelAndView, Customer customer,
			@RequestParam(value = "msg", required = false) String msg) {
		modelAndView.addObject("msg", msg);
		modelAndView.addObject("customer", customer);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	/* Saving Customer Details */
	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String registerUser(ModelAndView modelAndView, Customer customer,
			@RequestParam("file") MultipartFile[] files, RedirectAttributes redirectAttributes) {
		String msg;
		Customer existingUser = customerRepository.findByCustomerEmailIgnoreCase(customer.getCustomerEmail());
		if (existingUser != null) {
			// modelAndView.addObject("message", "This email already exists!");
			msg = "This email already exists!";

		} else {
			for (MultipartFile file : files) {
				String encodedPassword = passwordsEncoder.encode(customer.getCustomerPassword());
				customer.setCustomerPassword(encodedPassword);
				customerService.createOrUpdateCustomer(customer, file);
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(customer.getCustomerEmail());
				mailMessage.setSubject("Complete Registration!");
				mailMessage.setFrom("balumathi333.com");
				mailMessage.setText("To confirm your account, please click here : "
						+ "http://localhost:8055/confirm-account?token=" + customer.getConfirmationToken());
				emailSenderService.sendEmail(mailMessage);
			}
			msg = "Verification Link has been send to Registered Mail!!!";
		}
		redirectAttributes.addAttribute("msg", msg);
		return "redirect:/registration";

	}

	/* Confirming emailId */
	@RequestMapping(value = "/confirm-account", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
		Customer token = customerRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			Customer customer = customerRepository.findByCustomerEmailIgnoreCase(token.getCustomerEmail());
			customer.setEnabled(true);
			customer.setConfirmationToken(null);
			customerRepository.save(customer);
			modelAndView.setViewName("account-verified");
		} else {
			modelAndView.addObject("message", "The link is invalid or broken!");
			modelAndView.setViewName("error");
		}

		return modelAndView;
	}

	/* Registered Customer Details */
	@GetMapping("/customerdetails")
	public String listOfCustomer(Model model) {
		List<Customer> customerDetails = customerService.findByIsEnable();
		model.addAttribute("customerDetails", customerDetails);
		return "customer-details";
	}

	/* Download the uploaded file */
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) {
		Customer doc = customerService.getFile(fileId).get();
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(doc.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + doc.getFileName() + "\"")
				.body(new ByteArrayResource(doc.getData()));
	}

	/* Display profile data */
	@GetMapping("/myprofile")
	public String customerProfile(Model model, Principal principal) {
		String name = principal.getName();
		Customer customerDetails = customerService.getSingleCustomer(name);
		model.addAttribute("profile", customerDetails);
		return "profile";
	}

	/* Unverified customer details */
	@GetMapping("/verifycustomer")
	public String customerVerify(Model model, Principal principal) {
		List<Customer> customerDetails = customerService.getSingleCustomerVerify();
		model.addAttribute("customerDetails", customerDetails);
		return "verify-customer";
	}

	/* Verify Customer Details */
	@GetMapping("/verify/{custId}")
	public String customerEnable(@PathVariable Integer custId) {
		Customer cust = customerService.getCustomer(custId);
		cust.setAdminEnabled(true);
		customerRepository.save(cust);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(cust.getCustomerEmail());
		mailMessage.setSubject("Account Activated");
		mailMessage.setFrom("balumathi333.com");
		mailMessage.setText("Welcome " + cust.getCustomerName() + "!!!!" + "\nAccount Activated...");
		emailSenderService.sendEmail(mailMessage);
		return "redirect:/verifycustomer";
	}

	/* Delete customer details */
	@GetMapping("/cancel/{custId}")
	public String customerDelete(@PathVariable Integer custId) {
		Customer cust = customerService.getCustomer(custId);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(cust.getCustomerEmail());
		mailMessage.setSubject("Account Denied");
		mailMessage.setFrom("balumathi333.com");
		mailMessage.setText("Document that have submitted is not valid!!!Please try to register with valid Document");
		emailSenderService.sendEmail(mailMessage);
		Customer customer = customerService.deleteCustomer(custId);
		return "redirect:/verifycustomer";
	}

}
