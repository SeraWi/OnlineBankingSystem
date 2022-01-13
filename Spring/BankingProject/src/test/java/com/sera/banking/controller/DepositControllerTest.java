package com.sera.banking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sera.banking.service.DepositService;

class DepositControllerTest {
	
	
	@Autowired
	DepositService test;
	
	@Test
	void test() {
		test.deposit(18831361,2000);
	}

}
