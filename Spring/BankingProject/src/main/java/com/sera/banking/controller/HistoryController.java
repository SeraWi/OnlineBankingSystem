package com.sera.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.DepositInfo;
import com.sera.banking.domain.TransferInfo;
import com.sera.banking.domain.UserVo;
import com.sera.banking.domain.WithdrawInfo;
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
		// 세션에 저장된 userIdx
		int userIdx = ((UserVo) request.getSession().getAttribute("userVo")).getUserIdx();


		// 해당 userIdx으로 전체 계좌 정보 조회
		List<AccountInfo> allAccount = searchService.getAllAcountInfo(userIdx);
		System.out.println(allAccount.toString());
		model.addAttribute("allAccount", allAccount);

		return "/history";
	}
	
	// 특정 계좌 거래 내역 조회
	@RequestMapping("/history/{accountIdx}")
	public String details(
			 HttpServletRequest request,
			 @PathVariable int accountIdx,
			 Model model
			){
		System.out.println(accountIdx);
		// 조회내역
		List<DepositInfo> depositInfos = service.depositInfos(accountIdx);
		List<WithdrawInfo> withdrawInfos = service.withdrawInfos(accountIdx);
		List<TransferInfo> transferIn = service.transferIn(accountIdx);
		List<TransferInfo> transferOut = service.transferOut(accountIdx);
		
		// 이체 내역, 이체출금, 이체정보
		model.addAttribute("depositInfos", depositInfos);
		model.addAttribute("withdrawInfos", withdrawInfos);
		model.addAttribute("transferIn", transferIn); //이체 입금
		model.addAttribute("transferOut", transferOut);//이체 출금
		
		return "/historyDetails";
	}
	

}
