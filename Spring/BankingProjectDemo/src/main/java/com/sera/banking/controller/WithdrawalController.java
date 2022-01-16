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


	@Autowired
	SearchAccountService searchService;
	
	@Autowired
	WithdrawService withService;

	@RequestMapping("/withdraw")
	public String withdraw(	
			HttpServletRequest request,
			Model model) {
		// 세션에 저장된 userName 
		String userName = ((UserVo) request.getSession().getAttribute("userVo")).getUserName();

		// 해당 userName으로 계좌 정보 전부 가져오기
		// 전체 계좌 정보를 list로 반환
		List<AccountInfo> allAccount = searchService.getAllAcountInfo(userName);
		model.addAttribute("allAccount", allAccount);

		return "/withdraw";

	}
	
	// 출금 후 잔액 반환
	@PostMapping("/afterWithdraw")
	@ResponseBody
	public AccountInfo afterDeposit(
			HttpServletRequest request,
			Model model,
			int withdrawalAmount,
			int userIdx
			) {
		
		//출금하기
		withService.withdraw(userIdx, withdrawalAmount);
		
		//출금 후 정보 
		AccountInfo info = withService.balanceAfterWithdraw(userIdx);
		
		System.out.println(info);
		return info;
	}

}
