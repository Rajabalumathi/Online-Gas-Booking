package com.example.gasbooking.gas.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gasbooking.gas.entity.Gas;
import com.example.gasbooking.gas.model.GasDto;
import com.example.gasbooking.gas.service.GasService;
import org.springframework.data.domain.Page;

@Controller
public class GasController {

	@Autowired
	private GasService gasService;

	@GetMapping("/gasentry")
	public String reg(Map<String, Object> model) {
		model.put("gas", new Gas());
		return "gas-entry";
	}

	@PostMapping("/addnewgas/quantity")
	public String createGas(@RequestParam("val") String val, @Valid @ModelAttribute("gas") GasDto gasDto) {
		for (int i = 0; i < Integer.parseInt(val); i++) {
			gasService.createOrUpdateGas(gasDto);
		}
		return "redirect:/gasentry";
	}

	@GetMapping("/gasstock")
	public String gasStock(Model model) {
		Map gasDetails = gasService.getDetails();
		System.out.println(gasDetails);
		model.addAttribute("gasDetails", gasDetails);
		return "gas-details";
	}
}
