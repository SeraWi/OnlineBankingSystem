package com.sera.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.DepositHistory;
import com.sera.banking.domain.TransferHistory;
import com.sera.banking.domain.UserVo;
import com.sera.banking.domain.WithdrawHistory;
import com.sera.banking.service.HistoryService;
import com.sera.banking.service.SearchAccountService;

@Controller
public class HistoryController {
	//거래내역 (특정계좌 선택하면 보여준다)
	
	@Autowired
	SearchAccountService searchService;
	
	
	@Autowired
	HistoryService service;

	@RequestMapping("/history")
	public String history(
			HttpServletRequest request,
			Model model
			) {
		// 세션에 저장된 userName 
		String userName = ((UserVo) request.getSession().getAttribute("userVo")).getUserName();


		// 해당 userName으로 계좌 정보 전부 가져오기
		// 전체 계좌 정보를 list로 반환
		List<AccountInfo> allAccount = searchService.getAllAcountInfo(userName);
		model.addAttribute("allAccount", allAccount);


		return "/history";
	}
	
	// 거래 내역 조회
	@RequestMapping("/history/details/{userAccount}")
	public String details(
			 @PathVariable int userAccount,
			 Model model
			){
		
		// 조회내역
		List<DepositHistory> depositInfos = service.depositInfos(userAccount);
		List<WithdrawHistory> withdrawInfos = service.withdrawInfos(userAccount);
		List<TransferHistory> transferInfos = service.transferInfos(userAccount);
		
		model.addAttribute("depositInfos", depositInfos);
		model.addAttribute("withdrawInfos", withdrawInfos);
		model.addAttribute("transferInfos", transferInfos);
		
		return "/details";
	}
	

}
