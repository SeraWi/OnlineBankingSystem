package com.sera.banking.controller;

import java.util.List;

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
import com.sera.banking.service.TransferService;

@Controller
public class TransferController {

	
	@Autowired
	SearchAccountService searchService;
	
	@Autowired
	TransferService tService;

	//이체하기 Get방식으로 : 전체 출금 계좌 보여주기
	@RequestMapping("/transfer")
	public String transfer(
			HttpServletRequest request,
			Model model
			) {
		// 세션에 저장된 userName 
		int userIdx = ((UserVo) request.getSession().getAttribute("userVo")).getUserIdx();

		List<AccountInfo> allAccount = searchService.getAllAcountInfo(userIdx);
		model.addAttribute("allAccount", allAccount);

		return "/transfer";
	}
	
	//출금 계좌 선택 후
	@RequestMapping(value="/transfer/{accountIdx}", method = RequestMethod.GET)
	public String transferDetails(
			HttpServletRequest request,
			@PathVariable int accountIdx,
			Model model
			) {

		// 선택한 출금 계좌 정보 하나 반환
		AccountInfo curAccount = searchService.getOneAccount(accountIdx);
		
		model.addAttribute("curAccount", curAccount);
		return "/transferDetails";
	}
	
	
	// 입금 하기버튼 클릭(post)
	@RequestMapping(value="/transfer/{accountIdx}", method = RequestMethod.POST)
	public String afterTransfer(
			HttpServletRequest request,
			TransferDto transferDto,
			Model model
			) {
		
		//입금-> 입금 후 정보 반환
		AccountInfo accountInfo = tService.transfer(transferDto);
		
		model.addAttribute("toInfo", transferDto);
		model.addAttribute("accountInfo", accountInfo);
		
		return "/afterTransfer";
	}

	
	
}
