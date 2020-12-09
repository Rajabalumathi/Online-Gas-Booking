package com.example.gasbooking.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gasbooking.booking.entity.Booking;
import com.example.gasbooking.customer.entity.Customer;
import com.example.gasbooking.gas.entity.Gas;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	Booking findByGas(Gas gas);

	List<Booking> findByCustomer(Customer customer);
	
	
}
