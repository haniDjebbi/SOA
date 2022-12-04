package com.moneyconv.conversionOperationMS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients 
@SpringBootApplication
public class ConversionOperationMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversionOperationMsApplication.class, args);
	}

}
