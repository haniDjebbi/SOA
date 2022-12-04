package com.moneyconv.conversionRateMS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneyconv.conversionRateMS.repositories.ConversionRateRepository;
import com.moneyconv.conversionRateMS.utils.ResponseMsg;

@RestController
@RequestMapping("/conversion-rate-api")
public class ConversionRateController {

	@Autowired
	ConversionRateRepository crRepo;

	@GetMapping(value = "/get-rate")
	public ResponseMsg getRate(@RequestParam(name = "from") String from, @RequestParam(name = "to") String to) {
		Double rate = 0.0;
		if (crRepo.getRate(from, to).size() > 0) {
			rate = crRepo.getRate(from, to).get(0).getRate();
		}

		return new ResponseMsg(rate);
	}

}
