package com.sera.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.UserVo;
import com.sera.banking.service.SearchAccountService;
import com.sera.banking.service.WithdrawService;

@Controller
public class WithdrawalController {
	// 출금하기

	@Autowired
	SearchAccountService searchService;
	
	@Autowired
	WithdrawService withService;
	
	
	// 출금 할 전체 계좌 보여주기
	@RequestMapping("/withdraw")
	public String withdraw(	
			HttpServletRequest request,
			Model model) {
		
		int userIdx = ((UserVo) request.getSession().getAttribute("userVo")).getUserIdx();

		List<AccountInfo> allAccount = searchService.getAllAcountInfo(userIdx);
		model.addAttribute("allAccount", allAccount);

		return "/withdraw";

	}
	
	// 출금 후 잔액 반환(비동기)
	@PostMapping("/afterWithdraw")
	@ResponseBody
	public AccountInfo afterDeposit(
			HttpServletRequest request,
			Model model,
			int withdrawalAmount,
			int accountIdx
			) {
		
		//출금하기
		withService.withdraw(accountIdx, withdrawalAmount);
		
		//출금 후 정보 
		AccountInfo info = withService.balanceAfterWithdraw(accountIdx);
		
		System.out.println(info);
		return info;
	}

}
