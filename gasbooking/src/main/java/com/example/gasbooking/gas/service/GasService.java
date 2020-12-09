package com.example.gasbooking.gas.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.example.gasbooking.gas.entity.Gas;
import com.example.gasbooking.gas.model.GasDto;

public interface GasService {
	public void createOrUpdateGas(GasDto gasDTO);

	public List<Gas> getAllGas();

	//List<Gas> findPaginated(int pageNo, int pageSize);
	
	Gas getGas(String gasType);

	public Gas getSingleGas(int gasId);

	public GasDto convertModelToDto(Gas gasDetails);

	public Map getDetails();

	public int countGas(String connectionType);

}
