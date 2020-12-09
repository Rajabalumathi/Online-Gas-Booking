package com.example.gasbooking.customer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.gasbooking.booking.entity.Booking;
import com.example.gasbooking.customer.entity.Customer;
import com.example.gasbooking.customer.repository.CustomerRepository;
import com.example.gasbooking.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer createOrUpdateCustomer(Customer customer, MultipartFile files) {
		try {
			String fileName = files.getOriginalFilename();
			customer.setFileName(fileName);
			String fileType = files.getContentType();
			customer.setFileType(fileType);
			byte[] data = files.getBytes();
			customer.setData(data);
			// Customer customer = convertDtoToModel(customerDto);
			return customerRepository.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * public List<Customer> getAllCustomer() { List<Customer> customerList =
	 * customerRepository.findAll(); //List<Customer> customerDetails =
	 * list.stream().map(Customer::new)
	 * //.collect(Collectors.toCollection(ArrayList::new)); return customerList; }
	 **/

	public Optional<Customer> getFile(Integer fileId) {
		return customerRepository.findById(fileId);
	}

	// List<CustomerDTO> customerDetails = list.stream().map(CustomerDTO::new)
	// .collect(Collectors.toCollection(ArrayList::new));
	@Override
	public Customer getSingleCustomer(String name) {
		Customer customerList = customerRepository.findByCustomerName(name);
		return customerList;
	}

	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> getSingleCustomerVerify() {
		List<Customer> customerList = customerRepository.findByIsEnabledAndAdminEnabled(true,false);
		return customerList;
	}

	@Override
	public List<Customer> findByIsEnable() {
		List<Customer> customerList = customerRepository.findByAdminEnabled(true);
		return customerList;
	}

	@Override
	public Customer getCustomer(Integer custId) {
		Customer cust = customerRepository.findByCustomerId(custId);
		return cust;
	}

	@Override
	public Customer deleteCustomer(Integer custId) {
		customerRepository.deleteById(custId);
		return null;
	}

	public long getByCreatedDate(String formattedString) {
		return customerRepository.countByCreatedDate(formattedString);
	}
}
