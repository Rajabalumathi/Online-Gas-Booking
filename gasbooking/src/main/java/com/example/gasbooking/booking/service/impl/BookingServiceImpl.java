package com.example.gasbooking.booking.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gasbooking.booking.entity.Booking;
import com.example.gasbooking.booking.repository.BookingRepository;
import com.example.gasbooking.booking.service.BookingService;
import com.example.gasbooking.customer.entity.Customer;
import com.example.gasbooking.delievery.entity.Delievery;
import com.example.gasbooking.delievery.repository.DelieveryRepository;
import com.example.gasbooking.gas.entity.Gas;
import com.example.gasbooking.gas.repository.GasRepository;
import com.example.gasbooking.payment.entity.Payment;
import com.example.gasbooking.payment.repository.PaymentRepository;

@Service
public class BookingServiceImpl implements BookingService {
	Map<Integer, ArrayList<Object>> bookingDetails = new LinkedHashMap<Integer, ArrayList<Object>>();
	
	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	GasRepository gasRepository;

	@Autowired
	DelieveryRepository delieveryRepository;

	/* Saving Customer Details */
	public void createBooking(Booking booking) {
		bookingRepository.save(booking);
	}

	public Booking findBooking(Gas gas) {
		return bookingRepository.findByGas(gas);
	}

	/* Customer Booking History */
	public Map getBookingDetails(Customer customer) {
		List<Booking> book = bookingRepository.findByCustomer(customer);
		for (int i = 0; i < book.size(); i++) {
			ArrayList<Object> bookingList = new ArrayList<Object>();
			Payment pay = paymentRepository.findByGas(book.get(i).getGas());
			Delievery delievery = delieveryRepository.findByGas(book.get(i).getGas());
			bookingList.add(0, book.get(i).getBookingDate());
			bookingList.add(1, pay.getPaymentDate());
			bookingList.add(2, delievery.getDelieveryDate());
			String result = delievery.isDelieveryStatus() ? "Delieverd" : "on-process";
			bookingList.add(3,result);
			bookingDetails.put(book.get(i).getGas().getGasId(), bookingList);
		}
		return bookingDetails;
	}

	/* Individual Booking Detail */
	public List getBooking(Integer bookingId) {
		Booking book = bookingRepository.getOne(bookingId);
		Payment pay = paymentRepository.findByGas(book.getGas());
		Delievery delievery = delieveryRepository.findByGas(book.getGas());
		ArrayList<Object> bookingList = new ArrayList<Object>();
		bookingList.add(0, book.getCustomer().getCustomerId());
		bookingList.add(1, book.getGas().getGasId());
		bookingList.add(2, book.getBookingDate());
		bookingList.add(3, pay.getPaymentDate());
		bookingList.add(4, delievery.getDelieveryDate());
		String result = delievery.isDelieveryStatus() ? "Delieverd" : "on-process";
		bookingList.add(5,result);
		return bookingList;
	}

}
