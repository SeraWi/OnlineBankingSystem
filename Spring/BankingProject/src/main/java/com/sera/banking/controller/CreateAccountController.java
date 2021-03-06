package com.sera.banking.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.UserVo;
import com.sera.banking.service.CreateAccountService;

@Controller
public class CreateAccountController {
	// 계좌 생성
	
	@Autowired
	private CreateAccountService createService;
	
	private static final Logger logger =LoggerFactory.getLogger(CreateAccountController.class);
	
	@RequestMapping("/create")
	public String account(
			HttpServletRequest request,
			Model model
			) {
		
		// 세션에 저장된 userName,userIdx
		String userName = ((UserVo) request.getSession().getAttribute("userVo")).getUserName();
		int userIdx = ((UserVo) request.getSession().getAttribute("userVo")).getUserIdx();
		
		
		// 계좌를 생성하고 계좌 정보를 반환한다.
		AccountInfo accountInfo = createService.createAccount(userName, userIdx);
	
		model.addAttribute("accountInfo", accountInfo);
		return "/openAccount";
	}
	
	
	
}
