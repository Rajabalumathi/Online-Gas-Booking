package com.example.gasbooking.delievery.service;

import com.example.gasbooking.delievery.entity.Delievery;

public interface DelieveryService {
	public void createDelievery(Delievery delievery);
	public void delieveryStatus(String val);
}
