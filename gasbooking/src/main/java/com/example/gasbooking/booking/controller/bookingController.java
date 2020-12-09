package com.example.gasbooking.booking.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gasbooking.booking.entity.Booking;
import com.example.gasbooking.booking.service.BookingService;
import com.example.gasbooking.customer.entity.Customer;
import com.example.gasbooking.customer.service.CustomerService;
import com.example.gasbooking.gas.service.GasService;

@Controller
public class bookingController {
	Map<Integer, ArrayList<Object>> bookingDetails = new LinkedHashMap<Integer, ArrayList<Object>>();
	@Autowired
	CustomerService customerService;

	@Autowired
	BookingService bookingService;
	
	@Autowired
	GasService gasService;

	/* Display Booking page */
	@GetMapping("/booking")
	public String customerProfile(Model model, Principal principal,
			@RequestParam(value = "msg", required = false) String msg) {
		String name = principal.getName();
		Customer customerDetails = customerService.getSingleCustomer(name);
		int count=gasService.countGas(customerDetails.getConnectionType());
		model.addAttribute("count",count);
		model.addAttribute("customer", customerDetails);
		model.addAttribute("msg", msg);
		return "booking";
	}

	/* Customer Booking History */
	@GetMapping("/mybooking")
	public String bookingHistory(Model model, Principal principal) {
		Customer customerDetails = customerService.getSingleCustomer(principal.getName());
		Map bookingDetails = bookingService.getBookingDetails(customerDetails);
		model.addAttribute("bookingDetails", bookingDetails);
		return "my-booking";
	}

	/* Single Booking Details */
	@GetMapping("/singlebooking/{bookingId}")
	public String singleBooking(@PathVariable("bookingId") Integer bookingId, Model model) {
		List book = bookingService.getBooking(bookingId);
		model.addAttribute("bookingDetails", book);
		return "booking-details";
	}
}
