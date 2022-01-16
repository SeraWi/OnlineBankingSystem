package com.sera.banking.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sera.banking.dao.Dao;
import com.sera.banking.domain.AccountInfo;

@Service
public class CreateAccountService {

	private Dao dao;

	@Autowired
	private SqlSessionTemplate template;

	// 계좌번호(8자리)
	private int userAccount;

	// 2. 계좌를 생성한뒤 -> 반환한다.
	public AccountInfo createAccount(String userName) {

		// 1. 계좌번호 랜덤 8자리 생성
		randomAccount();
				
		// 2. 이율 랜덤으로 10%이하 생성
		float rate = (float) ((Math.random()*10)+ 0.1); // 0.1%~10.1%까지의 이자율 랜덤 생성
		rate = Math.min(rate,10); // 최대 10%
		rate = (float)Math.round(rate *10)/10; // 소수 첫째자리까지 표현
		System.out.println(rate);
		
		// 3. 계좌 생성 (insert) 
		dao = template.getMapper(Dao.class);
		int result = dao.insertAccount(userName,userAccount,rate);
		System.out.println(result);
		
		// 4. insert가 성공하면 다시 accountInfo객체를 받아서  반환한다.
		AccountInfo info = null;
		if(result == 1) {
			info = dao.selectAccountInfo2(userAccount);
		}
		
		System.out.println("service : " + info.toString());
		return info;
	}


	
	public int randomAccount() {

		int accountChk = 1;
		while(accountChk == 1){ 
			//계좌 번호 겹치지 않을 때 까지 실행
			
			// 랜덤숫자는 8자리가 아닐경우 sql에서 zerofill로 채워짐
			userAccount = (int) ((Math.random()*100000000)+ 1); 

			// account 있는지 확인하는 메서드 호출
			dao = template.getMapper(Dao.class);
			
			//계좌번호 겹치면 1반환, 겹치지 않으면 0반환
			accountChk = dao.selectAccount(userAccount);
		}
		
//		System.out.println("accountChk : " + accountChk);
//		System.out.println(userAccount);
		
		return userAccount;
	}



}
