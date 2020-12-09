package com.example.gasbooking.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gasbooking.gas.entity.Gas;
import com.example.gasbooking.payment.entity.Payment;

@Repository
public  interface PaymentRepository extends JpaRepository<Payment,Integer> {

	Payment findByGas(Gas gas);

}
