package com.example.gasbooking.payment.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.gasbooking.booking.entity.Booking;
import com.example.gasbooking.booking.service.BookingService;
import com.example.gasbooking.customer.entity.Customer;
import com.example.gasbooking.customer.service.CustomerService;
import com.example.gasbooking.customer.service.EmailSenderService;
import com.example.gasbooking.delievery.entity.Delievery;
import com.example.gasbooking.delievery.service.DelieveryService;
import com.example.gasbooking.gas.entity.Gas;
import com.example.gasbooking.gas.model.GasDto;
import com.example.gasbooking.gas.service.GasService;
import com.example.gasbooking.payment.entity.Payment;
import com.example.gasbooking.payment.service.PaymentService;

import org.springframework.ui.Model;

@Controller
public class PaymentController {

	LocalDate localDate = LocalDate.now();
	@Autowired
	CustomerService customerService;
	@Autowired
	public EmailSenderService emailSenderService;
	@Autowired
	GasService gasService;

	@Autowired
	BookingService bookingService;

	@Autowired
	PaymentService paymentService;

	@Autowired
	DelieveryService delieveryService;
	
	@GetMapping("/payment")
	public String paymentPage(Model model,@RequestParam("gasdisplay") int gasId) {
		Gas gasDetails = gasService.getSingleGas(gasId);
		model.addAttribute("gasdisplay",gasDetails);
		return "payment";
	}

	@PostMapping("/payment")
	public String payment(@RequestParam("gasId") int gasId, Principal principal,RedirectAttributes redirectAttributes) {
		Gas gasDetails = gasService.getSingleGas(gasId);
		String username = principal.getName();
		Customer customerDetails = customerService.getSingleCustomer(username);

		/* Booking table Entry */
		Booking book = new Booking("booked", localDate, gasDetails, customerDetails);
		bookingService.createBooking(book);

		/* Payment Table Entry */
		Payment pay = new Payment("paid", localDate, gasDetails.getGasAmount(), gasDetails);
		paymentService.createPayment(pay);

		/* Delievery Table Entry */
		Delievery delievery = new Delievery("delievery", localDate.plusDays(2), gasDetails,false);
		delieveryService.createDelievery(delievery);

		/* Gas Status Update */
		gasDetails.setGasStatus(true);
		GasDto gasDto = gasService.convertModelToDto(gasDetails);
		gasService.createOrUpdateGas(gasDto);

		/* Customer Total Cylinder Update */
		customerDetails.setCustomerTotalCylinder(customerDetails.getCustomerTotalCylinder() - 1);
		customerService.updateCustomer(customerDetails);

		/* Booking Confirmation Mail */
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(customerDetails.getCustomerEmail());
		mailMessage.setSubject("Gas Booked");
		mailMessage.setFrom("balumathi333.com");
		mailMessage.setText("Successfully Cylinder has been booked!!! \n" + "Gas Id:" + gasId + "\nCylinder amount:"
				+ gasDetails.getGasAmount() + "\nPayment Status:Paid" + "\nDelievery Date:" + localDate.plusDays(2));
		emailSenderService.sendEmail(mailMessage);
		
	    redirectAttributes.addAttribute("gasId", gasId);
		return "redirect:/feedback";

	}

}
