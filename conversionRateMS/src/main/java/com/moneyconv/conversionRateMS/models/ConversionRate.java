package com.moneyconv.conversionRateMS.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConversionRate {
	@Id
	private Long RateId;
	private String currencyFrom;
	private String currencyTo;
	private Double Rate;
	private Date validiyStartDate;
	private Date validiyEndDate;
	
}
