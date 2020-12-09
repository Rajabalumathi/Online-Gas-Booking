package com.example.gasbooking.feedback.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.gasbooking.booking.entity.Booking;
import com.example.gasbooking.entity.AbstractAuditingEntity;

@Entity
@Table(name = "feedback")
public class Feedback extends AbstractAuditingEntity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4920949119000259873L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "Integer(5)")
	private int feedbackId;

	@Column(name = "feedback")
	@NotNull
	@NotBlank(message = "feedback is mandatory")
	private String feedback;

    @OneToOne()
	@JoinColumn(name = "booking_id", referencedColumnName = "id")
	private Booking booking;

	public Feedback() {

	}

	public Feedback(String feedback, Booking booking) {
		super();
		this.feedback = feedback;
		this.booking=booking;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}


}
