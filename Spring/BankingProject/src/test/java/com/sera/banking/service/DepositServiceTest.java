package com.sera.banking.service;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sera.banking.dao.Dao;


@Service
class DepositServiceTest {
	
	Dao dao;
	@Autowired
	SqlSessionTemplate template;
	
	@Test
	//@Transactional
	public void deposit() {
		// 계좌와 입금액을 파라미터로 받는다.
		
		int userAccount = 18831361;
		int depositAmount = 2000;
		
		
		
		System.out.println(userAccount);
		dao = template.getMapper(Dao.class);
		//dao.updateAfterDeposit(18831361,2000);
		//Assert.assertEquals(result,1); 
		//dao.insertDepositInfo(18831361,2000);
	}

	

}
