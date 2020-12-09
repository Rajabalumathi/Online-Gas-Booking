package com.example.gasbooking.gas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gasbooking.gas.entity.Gas;

@Repository
public interface GasRepository extends JpaRepository<Gas, Integer> {
	@Query("select g from Gas g where g.gasId in (select min(p.gasId) from Gas p where p.gasStatus=0 AND p.gasType = :gasType)")
	Gas findByGasType(String gasType);

	Gas findByGasId(int gasId);

	int countByGasType(String Type);

	int countByGasTypeAndGasStatus(String Type, boolean val);
}
