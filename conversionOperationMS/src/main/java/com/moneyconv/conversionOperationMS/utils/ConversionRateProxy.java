package com.moneyconv.conversionOperationMS.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "conversion-rate",url = "http://localhost:8080/conversion-rate-api")
public interface ConversionRateProxy {

	@RequestMapping(method = RequestMethod.GET, value = "/get-rate")
	ConversionRateResponse getRate(@RequestParam(value = "from")String from,@RequestParam(value = "to")String to);
	
}
 