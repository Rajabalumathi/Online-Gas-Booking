package com.example.gasbooking.gas.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gasbooking.gas.entity.Gas;
import com.example.gasbooking.gas.model.GasDto;
import com.example.gasbooking.gas.repository.GasRepository;
import com.example.gasbooking.gas.service.GasService;

@Service
public class GasServiceImpl implements GasService {
	HashMap<Integer,ArrayList<Object>> gasStock = new HashMap<Integer,ArrayList<Object>>();
	

	@Autowired
	private GasRepository gasRepository;

	public void createOrUpdateGas(GasDto gasDto) {
		Gas Gas = convertDtoToModel(gasDto);
		gasRepository.save(Gas);
	}

	public List<Gas> getAllGas() {
		List<Gas> gasList = gasRepository.findAll();
		return gasList;
	}

	private Gas convertDtoToModel(GasDto gasDto) {
		Gas gas = new Gas();
		if (gasDto.getGasId() != 0) {
			gas.setGasId(gasDto.getGasId());
		}
		gas.setGasType(gasDto.getGasType());
		gas.setGasAmount(gasDto.getGasAmount());
		gas.setGasStatus(gasDto.getGasStatus());
		return gas;
	}

	public GasDto convertModelToDto(Gas gas) {
		GasDto gasDto = new GasDto();
		if (gas.getGasId() != 0) {
			gasDto.setGasId(gas.getGasId());
		}
		gasDto.setGasType(gas.getGasType());
		gasDto.setGasAmount(gas.getGasAmount());
		gasDto.setGasStatus(gas.getGasStatus());
		return gasDto;
	}

	public Gas getGas(String gasType) {
		Gas details = gasRepository.findByGasType(gasType);
		return details;
	}

	@Override
	public Gas getSingleGas(int gasId) {
		Gas details = gasRepository.findByGasId(gasId);
		return details;
	}

	@Override
	public Map getDetails() {
		for (int i = 0; i < 2; i++) {
			String type = (i==0) ? "Domestic" : "Industry";
			ArrayList<Object> gasStockCount = new ArrayList<Object>();
			gasStockCount.add(type);
			gasStockCount.add(gasRepository.countByGasType(type));
			gasStockCount.add(gasRepository.countByGasTypeAndGasStatus(type, true));
			gasStockCount.add(gasRepository.countByGasTypeAndGasStatus(type, false));
		
			
			gasStock.put(i, gasStockCount);
			
		}
		System.out.println(gasStock);
		return gasStock;
	}

	@Override
	public int countGas(String connectionType) {
		return gasRepository.countByGasTypeAndGasStatus(connectionType, false);
	}

}