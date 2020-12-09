package com.example.gasbooking.configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.gasbooking.customer.repository.CustomerRepository;
import com.example.gasbooking.customer.service.CustomerService;
import com.example.gasbooking.customer.service.EmailSenderService;
import com.example.gasbooking.delievery.entity.Delievery;
import com.example.gasbooking.delievery.repository.DelieveryRepository;
import com.example.gasbooking.delievery.service.DelieveryService;

@Component
public class ScheduledTasks {


	LocalDate localDate = LocalDate.now();
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	String formattedString = localDate.toString();
	@Value("${spring.mail.username}")
	private String adminMail;

	@Autowired
	private EmailSenderService emailSenderService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private DelieveryService delieveryService;
    
	@Scheduled(cron = "0 21 12 ? * ?")
	public void reportCurrentTime() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		long count = customerService.getByCreatedDate(formattedString);
		mailMessage.setTo(adminMail);
		mailMessage.setSubject("Customer Details");
		mailMessage.setFrom("balumathi333.com");
		mailMessage.setText("customer List registered on " + localDate + " : " + count);
		emailSenderService.sendEmail(mailMessage);
	}

	@Scheduled(cron = "0 53 12 ? * ?")
	public void delieveryStatus() {
		delieveryService.delieveryStatus(formattedString);
	}

}
