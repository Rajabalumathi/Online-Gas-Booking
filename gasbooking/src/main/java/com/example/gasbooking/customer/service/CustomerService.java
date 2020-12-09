package com.example.gasbooking.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.gasbooking.customer.entity.Customer;

public interface CustomerService {
	public Customer createOrUpdateCustomer(Customer customer,MultipartFile files);
	//public List<Customer> getAllCustomer();
	public Optional<Customer> getFile(Integer fileId);
	public Customer getSingleCustomer(String name);
	public void updateCustomer(Customer customerDetails);
	//public List<Customer> getSingleCustomerVerify();
	public List<Customer> findByIsEnable();
	List<Customer> getSingleCustomerVerify();
	public Customer getCustomer(Integer custId);
	public Customer deleteCustomer(Integer custId);
	public long getByCreatedDate(String formattedString);
	
}
