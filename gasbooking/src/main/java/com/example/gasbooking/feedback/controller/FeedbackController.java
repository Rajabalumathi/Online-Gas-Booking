package com.example.gasbooking.feedback.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.gasbooking.booking.entity.Booking;
import com.example.gasbooking.booking.service.BookingService;
import com.example.gasbooking.customer.entity.Customer;
import com.example.gasbooking.customer.service.CustomerService;
import com.example.gasbooking.feedback.entity.Feedback;
import com.example.gasbooking.feedback.service.FeedbackService;
import com.example.gasbooking.gas.entity.Gas;
import com.example.gasbooking.gas.service.GasService;

@Controller
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;

	@Autowired
	CustomerService customerService;

	@Autowired
	BookingService bookingService;

	@Autowired
	GasService gasService;

	/* feedback page display */
	@GetMapping("/feedback")
	public String customerFeedback(Model model, @RequestParam("gasId") Integer gasId, Principal principal) {
		Gas gas = gasService.getSingleGas(gasId);
		Booking book = bookingService.findBooking(gas);
		Feedback customerfeed = new Feedback("", book);
		model.addAttribute("feedbackdetails", customerfeed);
		return "feedback";
	}

	/* Insert feedback into table */
	@PostMapping("/feedpost")
	public String customerFeed(@ModelAttribute("feedbackdetails") Feedback feed) {
		Feedback customerfeed = new Feedback(feed.getFeedback(), feed.getBooking());
		feedbackService.createFeedback(customerfeed);
		return "redirect:/dashboard";
	}

	/* Display feedback details */
	@GetMapping("/feedbackview")
	public String feedView(Model model,Pageable pageable) {
		Page<Feedback> feed=feedbackService.findAll(pageable);
		//List<Feedback> feedbackDetails = feedbackService.getAllFeedback();
		model.addAttribute("number", feed.getNumber());
		model.addAttribute("totalPages", feed.getTotalPages());
		model.addAttribute("totalElements", feed.getTotalElements());
		model.addAttribute("size", feed.getSize());
		model.addAttribute("feedbackDetails", feed.getContent());
		return "feedback-details";
	}

	/* Delete Single Feedback */
	@GetMapping("/singledelete/{feedbackId}")
	public String feedDelete(@PathVariable("feedbackId") Integer feedbackId, Model model) {
		Feedback feed = feedbackService.deleteFeedback(feedbackId);
		return "redirect:/feedbackview?page=0&size=3";
	}

}
