package com.example.gasbooking.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.gasbooking.feedback.entity.Feedback;

@Repository
public interface FeedbackRepository extends PagingAndSortingRepository<Feedback, Integer> {

}
