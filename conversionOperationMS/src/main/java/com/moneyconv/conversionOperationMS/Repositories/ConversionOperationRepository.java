package com.moneyconv.conversionOperationMS.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moneyconv.conversionOperationMS.models.ConversionOperation;

@Repository
public interface ConversionOperationRepository extends JpaRepository<ConversionOperation,Long> {

}
