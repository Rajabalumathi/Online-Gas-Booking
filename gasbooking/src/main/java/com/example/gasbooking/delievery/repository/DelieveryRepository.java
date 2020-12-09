package com.example.gasbooking.delievery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gasbooking.delievery.entity.Delievery;
import com.example.gasbooking.gas.entity.Gas;

@Repository
public interface DelieveryRepository extends JpaRepository<Delievery,Integer> {

	Delievery findByGas(Gas gas);

	@Query("select d from Delievery d where DATE_FORMAT(d.delieveryDate, '%Y-%m-%d') = :formattedString")
	List<Delievery> findByDelieveryDate(String formattedString);

}
