package com.sera.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.UserVo;
import com.sera.banking.service.SearchAccountService;

@Controller
public class TransferController {


	@Autowired
	SearchAccountService searchService;

	//get방식으로 
	@RequestMapping("/transfer")
	public String transfer(
			HttpServletRequest request,
			Model model
			) {
		// 세션에 저장된 userName 
		String userName = ((UserVo) request.getSession().getAttribute("userVo")).getUserName();


		// 해당 userName으로 계좌 정보 전부 가져오기
		// 전체 계좌 정보를 list로 반환
		List<AccountInfo> allAccount = searchService.getAllAcountInfo(userName);
		model.addAttribute("allAccount", allAccount);

		return "/transfer";
	}
	
	
//	@RequestMapping("/transfer/details/{userAccount}")
//	public String transferDetails(
//			HttpServletRequest request,
//			@PathVariable int userAccount,
//			Model model
//			) {
//		System.out.println(userAccount);
//		
//		
//		return "/transferDetails";
//	}
	
	
}
