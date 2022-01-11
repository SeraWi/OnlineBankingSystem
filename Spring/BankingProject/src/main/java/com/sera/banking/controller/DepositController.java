package com.sera.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.UserVo;
import com.sera.banking.service.DepositService;
import com.sera.banking.service.SearchAccountService;

@Controller
public class DepositController {
	
	
	
	@Autowired
	DepositService depoService;
	
	@Autowired
	SearchAccountService searchService;

	
	@RequestMapping("/deposit")
	public String deposit(
			HttpServletRequest request,
			Model model
			) {
		
		// 세션에 저장된 userName 
		String userName = ((UserVo) request.getSession().getAttribute("userVo")).getUserName();
		
		
		// 해당 userName으로 계좌 정보 전부 가져오기
		// 전체 계좌 정보를 list로 반환
		List<AccountInfo> allAccount = searchService.getAllAcountInfo(userName);
		model.addAttribute("allAccount", allAccount);
		
		
		depoService.deposit(18831361, 2000);
		
		return "/deposit";
	}
	
	

	
	
}
