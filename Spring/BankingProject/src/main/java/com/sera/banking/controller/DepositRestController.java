package com.sera.banking.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.service.DepositService;

@RestController
public class DepositRestController {
	
	@Autowired
	DepositService depoService;
	
	
	//@PostMapping("/afterDeposit")
	public AccountInfo afterDeposit(
			HttpServletRequest request,
			Model model,
			int depositAmount,
			int userAccount
			) {
		System.out.println(depositAmount);
		System.out.println(userAccount);
		
		
		//입금하기
		depoService.deposit(userAccount, depositAmount);
		
		// 입금 후 정보 
		AccountInfo info = depoService.balanceAfterDeposit(userAccount);
		
			
		
		return info;
	}
}
