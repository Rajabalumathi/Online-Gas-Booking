package com.example.gasbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.gasbooking.delievery.service.DelieveryService;

@Controller
public class WelcomeController {
	@Autowired
	private DelieveryService delieveryService;

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping("/signin")
	public ModelAndView login(ModelAndView modelAndView,@RequestParam(value = "error", required = false) String parameter) {
		modelAndView.addObject("msg",parameter);
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping("/dashboard")
	public ModelAndView adminDashboard() {
		return new ModelAndView("dashboard");
	}

	@RequestMapping("/accessdenied")
	public ModelAndView accessdenied() {
		return new ModelAndView("access-denied");
	}
	

}
