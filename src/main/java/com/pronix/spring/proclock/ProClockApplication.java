package com.pronix.spring.proclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pronix.spring.proclock.dao.RefStatusDAO;

@SpringBootApplication
@EnableTransactionManagement
public class ProClockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProClockApplication.class, args);
		
	}

}