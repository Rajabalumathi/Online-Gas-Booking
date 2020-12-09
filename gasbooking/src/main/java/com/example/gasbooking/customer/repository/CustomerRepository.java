package com.example.gasbooking.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gasbooking.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByCustomerEmailIgnoreCase(String customerEmail);

	@Query("select count(createdDate) from Customer c where DATE_FORMAT(c.createdDate, '%Y-%m-%d') = :localDate")
	long countByCreatedDate(String localDate);

	Customer findByConfirmationToken(String confirmationToken);

	Customer findByCustomerName(String customerName);

	List<Customer> findByIsEnabledAndAdminEnabled(boolean value, boolean val);

	List<Customer> findByAdminEnabled(boolean value);

	Customer findByCustomerId(Integer custId);

}
