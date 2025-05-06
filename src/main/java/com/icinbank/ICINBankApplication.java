package com.icinbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.common.annotations.VisibleForTesting;

@SpringBootApplication
public class ICINBankApplication {

	@VisibleForTesting
	public static void main(String[] args) {
		SpringApplication.run(ICINBankApplication.class, args);
		
	}
}
