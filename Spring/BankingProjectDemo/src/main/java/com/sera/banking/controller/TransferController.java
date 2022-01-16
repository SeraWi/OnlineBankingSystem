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
	
	//출금 계좌 선택 후
	@RequestMapping("/transfer/{userIdx}")
	public String transferDetails(
			HttpServletRequest request,
			@PathVariable int userIdx,
			Model model
			) {
		System.out.println(userIdx);
		// 세션에 저장된 userName 
		String userName = ((UserVo) request.getSession().getAttribute("userVo")).getUserName();


		// 해당 계좌 정보 하나만
		AccountInfo curAccount = searchService.getOneAccount(userIdx);
		
		model.addAttribute("curAccount", curAccount);

		
		return "/transferDetails";
	}
	
	
	// 입금할 계좌 선택 후 입금 하기버튼 클릭
	@RequestMapping(value="/transfer/{userIdx}", method = RequestMethod.POST)
	public String afterTransfer(
			HttpServletRequest request,
			TransferDto transferDto,
			Model model
			) {
		
		//입금하고 입금 후 정보 반환
		AccountInfo accountInfo = tService.transfer(transferDto);
		
		model.addAttribute("toInfo", transferDto);
		model.addAttribute("accountInfo", accountInfo);
		
		return "/afterTransfer";
	}

	
	
}
