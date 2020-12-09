package com.example.gasbooking.booking.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.gasbooking.customer.entity.Customer;
import com.example.gasbooking.entity.AbstractAuditingEntity;
import com.example.gasbooking.gas.entity.Gas;

@Entity
@Table(name = "booking")
public class Booking extends AbstractAuditingEntity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1857458959948052486L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "Integer(5)")
	private int bookingId;

	@Column(name = "booking_title")
	@NotNull
	@NotBlank(message = "bookingtitle is mandatory")
	private String bookingTitle;

	private LocalDate bookingDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gas_id", referencedColumnName = "id")
	private Gas gas;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingTitle() {
		return bookingTitle;
	}

	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Gas getGas() {
		return gas;
	}

	public void setGas(Gas gas) {
		this.gas = gas;
	}

	public Booking(String bookingTitle, LocalDate localDate, Gas gas, Customer customer) {
		super();
		this.bookingTitle = bookingTitle;
		this.bookingDate=localDate;
		this.customer = customer;
		this.gas = gas;
	}
	public Booking(int bookingId, String bookingTitle, LocalDate localDate, Gas gas, Customer customer) {
		super();
		this.bookingId=bookingId;
		this.bookingTitle = bookingTitle;
		this.bookingDate=localDate;
		this.customer = customer;
		this.gas = gas;
	}
	public Booking() {
		
	}

}
