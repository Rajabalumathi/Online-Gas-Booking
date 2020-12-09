package com.example.gasbooking.delievery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gasbooking.delievery.entity.Delievery;
import com.example.gasbooking.delievery.repository.DelieveryRepository;
import com.example.gasbooking.delievery.service.DelieveryService;

@Service
public class DelieveryServiceImpl implements DelieveryService {

	@Autowired
	DelieveryRepository delieveryRepository;

	@Override
	public void createDelievery(Delievery delievery) {
		delieveryRepository.save(delievery);
	}
	
	/*Updating Delievery Status*/
	public void delieveryStatus(String formattedString) {
		List<Delievery> delievery = delieveryRepository.findByDelieveryDate(formattedString);
		for (int i = 0; i < delievery.size(); i++) {
			delievery.get(i).setDelieveryStatus(true);
			delieveryRepository.save(delievery.get(i));
		}
	}
}
