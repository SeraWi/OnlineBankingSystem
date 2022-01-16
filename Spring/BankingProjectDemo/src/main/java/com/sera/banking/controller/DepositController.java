package com.sera.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.UserVo;
import com.sera.banking.service.DepositService;
import com.sera.banking.service.SearchAccountService;

@Controller

public class DepositController {
	
	//입금하기
	
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
		
		return "/deposit";
	}
	
	
	// 입금 후 정보 반환 
	@PostMapping("/afterDeposit")
	@ResponseBody
	public AccountInfo afterDeposit(
			HttpServletRequest request,
			Model model,
			int depositAmount,
			int userIdx
			) {
		
		//입금하기
		depoService.deposit(userIdx, depositAmount);
		
		// 입금 후 정보 
		AccountInfo info = searchService.getOneAccount(userIdx);
		return info;
	}
	
}
