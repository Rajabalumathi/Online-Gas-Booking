package com.example.gasbooking.booking.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.gasbooking.booking.service.OTPService;
import com.example.gasbooking.customer.entity.Customer;
import com.example.gasbooking.customer.service.CustomerService;
import com.example.gasbooking.customer.service.EmailSenderService;
import com.example.gasbooking.gas.entity.Gas;
import com.example.gasbooking.gas.service.GasService;

import org.springframework.ui.Model;

@Controller
public class OTPController {

	@Autowired
	public OTPService otpService;

	@Autowired
	public EmailSenderService emailSenderService;

	@Autowired
	public CustomerService customerService;

	@Autowired
	public GasService gasService;

	/*Generating OTP*/
	@GetMapping("/generateOtp")
	public String generateOTP(ModelAndView modelAndView, Principal principal) {

		String username = principal.getName();
		Customer customerDetails = customerService.getSingleCustomer(username);
		int otp = otpService.generateOTP(username);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(customerDetails.getCustomerEmail());
		mailMessage.setSubject("Booking OTP");
		mailMessage.setFrom("balumathi333.com");
		mailMessage.setText("Your OTP for confirming booking:" + otp);
		emailSenderService.sendEmail(mailMessage);
		return "redirect:/booking";
	}

	/*Validating OTP*/
	@PostMapping(value = "/validateOtp/optnum")
	public String validateOtp(@RequestParam("val") String val, Principal principal, Model model,RedirectAttributes redirectAttributes) {
		String username = principal.getName();
		int otpnum = Integer.parseInt(val);
		final String SUCCESS = "Entered Otp is valid";
		final String FAIL = "Entered Otp is NOT valid. Please Retry!";
		String msg;
		if (otpnum >= 0) {
			int serverOtp = otpService.getOtp(username);
			if (serverOtp > 0) {
				if (otpnum == serverOtp) {
					otpService.clearOTP(username);
					Customer customerDetails = customerService.getSingleCustomer(username);
					Gas gasDetails = gasService.getGas(customerDetails.getConnectionType());
					redirectAttributes.addAttribute("gasdisplay", gasDetails);
					return "redirect:/payment";
				} else {
					redirectAttributes.addAttribute("msg", FAIL);
					return "redirect:/booking";
				}
			} else {
				redirectAttributes.addAttribute("msg", FAIL);
				return "redirect:/booking";
			}
		}
		redirectAttributes.addAttribute("msg", FAIL);
		return "redirect:/booking";
	}
}
