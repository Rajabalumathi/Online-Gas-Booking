package com.example.gasbooking.feedback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.gasbooking.feedback.entity.Feedback;
import com.example.gasbooking.feedback.repository.FeedbackRepository;
import com.example.gasbooking.feedback.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	FeedbackRepository feedbackRepository;

	@Override
	public void createFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
	}

	
	/**public List<Feedback> getAllFeedback() {
		List<Feedback> feedbackList = feedbackRepository.findAll();
		return feedbackList;
	}**/

	@Override
	public Feedback deleteFeedback(Integer feedbackId) {
		feedbackRepository.deleteById(feedbackId);
		return null;
	}

	@Override
	public Page<Feedback> findAll(Pageable pageable) {
		return feedbackRepository.findAll(pageable);
		
	}

}
