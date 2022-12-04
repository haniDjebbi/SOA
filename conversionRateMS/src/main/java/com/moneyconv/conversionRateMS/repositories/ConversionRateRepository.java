package com.moneyconv.conversionRateMS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moneyconv.conversionRateMS.models.ConversionRate;

@Repository
public interface ConversionRateRepository extends JpaRepository<ConversionRate, Long> {
	@Query("SELECT c FROM ConversionRate c WHERE c.currencyFrom = ?1 and c.currencyTo = ?2 and c.validiyEndDate > current_date")
	List<ConversionRate> getRate(String from, String to);
}
