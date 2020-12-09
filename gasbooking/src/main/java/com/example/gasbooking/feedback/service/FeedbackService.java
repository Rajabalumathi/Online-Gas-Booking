package com.example.gasbooking.feedback.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.gasbooking.feedback.entity.Feedback;

public interface FeedbackService {
	public void createFeedback(Feedback feedback);

	//public List<Feedback> getAllFeedback();

	public Feedback deleteFeedback(Integer feedbackId);
	
	Page<Feedback> findAll(Pageable pageable);
}
