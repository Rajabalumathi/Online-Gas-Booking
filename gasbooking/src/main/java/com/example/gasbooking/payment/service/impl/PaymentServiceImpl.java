package com.example.gasbooking.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gasbooking.payment.entity.Payment;
import com.example.gasbooking.payment.repository.PaymentRepository;
import com.example.gasbooking.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository paymentRepository;

	public void createPayment(Payment payment) {
		paymentRepository.save(payment);

	}

}
