package com.sera.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.UserVo;
import com.sera.banking.service.SearchAccountService;

@Controller
public class SearchAccountController {
	// user가 가지고 있는 모든 계좌 정보 반환
	//계좌 조회 : User 소유의 전체 계좌에 대한 요약 정보 반환
	
	@Autowired
	private SearchAccountService service;	
	
	
	// 전체 계좌 조회
	@RequestMapping("/search")
	public String account(
			HttpServletRequest request,
			Model model
			) {
		
		// 세션에 저장된 userIdx 
		int userIdx = ((UserVo) request.getSession().getAttribute("userVo")).getUserIdx();
		
		// 전체 계좌 정보를 list로 반환
		List<AccountInfo> allAccount = service.getAllAcountInfo(userIdx);
		
		model.addAttribute("allAccount", allAccount);
		
		
		return "/search";
	}
	
	// 비동기 통신으로 userAccount와 userName 존재하는지 체크(이체에 사용)
	@ResponseBody
	@GetMapping("/checkAccount")
	public int checkAccount(
			int userAccount, String userName
			) {
		return service.checkAccount(userName, userAccount);
	}
	
	
}
