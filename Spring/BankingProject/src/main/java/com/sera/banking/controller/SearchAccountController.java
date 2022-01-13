package com.sera.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sera.banking.domain.AccountInfo;
import com.sera.banking.domain.UserVo;
import com.sera.banking.service.SearchAccountService;

@RestController
public class SearchAccountController {
	// user가 가지고 있는 모든 계좌 정보 반환
	//계좌 조회 : User 소유의 전체 계좌에 대한 요약 정보 반환
	
	@Autowired
	private SearchAccountService service;	
	
//	@RequestMapping("/search/account")
//	public String account(
//			HttpServletRequest request,
//			Model model
//			) {
//		
//		// 세션에 저장된 userName 
//		String userName = ((UserVo) request.getSession().getAttribute("userVo")).getUserName();
//		
//		// 전체 계좌 정보를 list로 반환
//		List<AccountInfo> allAccount = service.getAllAcountInfo(userName);
//		
//		model.addAttribute("allAccount", allAccount);
//		return "/searchAccount";
//	}
	
	// 계좌 조회에 사용
	@GetMapping("/search/account")
	public List<AccountInfo> account(
			HttpServletRequest request,
			Model model
			) {
		
		// 세션에 저장된 userName 
		String userName = ((UserVo) request.getSession().getAttribute("userVo")).getUserName();
		
		// 전체 계좌 정보를 list로 반환
		List<AccountInfo> allAccount = service.getAllAcountInfo(userName);
		
		model.addAttribute("allAccount", allAccount);
		return allAccount;
	}
	
	@ResponseBody
	@GetMapping("/checkAccount")
	public int checkAccount(
			int userAccount, String userName
			) {
		return service.checkAccount(userName, userAccount);
	}
	
	
	 @ExceptionHandler(TypeMismatchException.class)
	   public String handleTypeMismatchException(TypeMismatchException e) {
	      
	      //에러 내용 출력
	      e.printStackTrace();
	      
	      return "error/pageNotFound";
	  }
	
}
