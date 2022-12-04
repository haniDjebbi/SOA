package com.moneyconv.conversionOperationMS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneyconv.conversionOperationMS.Repositories.ConversionOperationRepository;
import com.moneyconv.conversionOperationMS.models.ConversionOperation;
import com.moneyconv.conversionOperationMS.utils.ConversionOperationRequest;
import com.moneyconv.conversionOperationMS.utils.ConversionRateProxy;
import com.moneyconv.conversionOperationMS.utils.ConversionRateResponse;

@RestController
@RequestMapping(value = "/conversion-operation")
public class ConversionOperationController {

	@Autowired
	private ConversionOperationRepository corepo;
	
	@Autowired
	private ConversionRateProxy crProxy;
	@PostMapping(value = "")
	public ConversionOperation convert(@RequestBody ConversionOperationRequest req) {
		// get rate from conversionRate MS
		ConversionRateResponse rate = crProxy.getRate(req.getFrom(), req.getTo());
		//calculate new amount
		Double convertedAmount = req.getAmount() * rate.getRate();
		ConversionOperation res = new ConversionOperation();
		res.setCurrencyFrom(req.getFrom());
		res.setConversionRate(rate.getRate());
		res.setCurrencyTo(req.getTo());
		res.setInitialAmount(req.getAmount());
		res.setConvertedAmount(convertedAmount);
		return corepo.save(res);
		
	}
}
