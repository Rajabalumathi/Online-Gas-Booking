package com.example.gasbooking.booking.service;

import java.util.List;
import java.util.Map;

import com.example.gasbooking.booking.entity.Booking;
import com.example.gasbooking.customer.entity.Customer;
import com.example.gasbooking.gas.entity.Gas;

public interface BookingService {
	public void createBooking(Booking booking);

	public Booking findBooking(Gas gas);

	public Map getBookingDetails(Customer customer);

	public List getBooking(Integer bookingId);
}
