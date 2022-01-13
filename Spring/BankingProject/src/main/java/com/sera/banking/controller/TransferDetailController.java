package com.sera.banking.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.TransferDto;
import com.sera.banking.domain.UserVo;
import com.sera.banking.service.SearchAccountService;


@Controller
public class TransferDetailController {

	
	@Autowired
	SearchAccountService searchService;
	
	
	@RequestMapping("/transfer/details/{userAccount}")
	public String transferDetails(
			HttpServletRequest request,
			@PathVariable int userAccount,
			Model model
			) {
		System.out.println(userAccount);
		// 세션에 저장된 userName 
		String userName = ((UserVo) request.getSession().getAttribute("userVo")).getUserName();


		// 해당 계좌 정보 하나만
		AccountInfo curAccount = searchService.getOneAccount(userAccount);
		
		model.addAttribute("curAccount", curAccount);

		
		return "/transferDetails";
	}
	
	
	
	@RequestMapping(value="/transfer/details/{userAccount}", method = RequestMethod.POST)
	public String afterTransfer(
			HttpServletRequest request,
			TransferDto transfer
			) {
		
		System.out.println(transfer.toString());
		
		
		return "/afterTransfer";
	}
}
