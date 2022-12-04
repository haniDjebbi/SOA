package com.moneyconv.conversionOperationMS.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversionOperationRequest {

	private String from;
	private String to;
	private Double amount;
}
